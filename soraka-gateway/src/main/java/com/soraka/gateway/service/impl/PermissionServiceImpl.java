/*
 * Apache License
 * Version 2.0, January 2004
 *
 *    Copyright 2018 北有风雪 (yongjie.teng@qq.com)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.soraka.gateway.service.impl;

import com.soraka.common.constant.Constants;
import com.soraka.common.model.domain.MenuDO;
import com.soraka.gateway.service.PermissionService;
import com.soraka.gateway.service.feign.MenuService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/10/25
 * @package com.soraka.gateway.service.impl
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private MenuService menuService;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断请求是否有权限
     *
     * @param request        HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        boolean hasPermissionFalg = false;
        log.info("开始走hasPermission,request:{}",request.getRequestURI());
        printToken(request);
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();

        if (principal == null) {
            return false;
        }
        if (grantedAuthorityList == null || grantedAuthorityList.isEmpty()) {
            log.warn("角色列表为空：{}", authentication.getPrincipal());
            return false;
        }

        // 获取角色权限
        List<String> roleKeys = new ArrayList<>();
        for (SimpleGrantedAuthority authority : grantedAuthorityList) {
            if (!Constants.BASE_ROLE.equalsIgnoreCase(authority.getAuthority())
                && !Constants.ROLE_ANONYMOUS.equalsIgnoreCase(authority.getAuthority())) {
                roleKeys.add(authority.getAuthority());
            }
        }
        if (!roleKeys.isEmpty()) {
            List<MenuDO> menus = menuService.findRoleMenu(roleKeys);
            // 权限校验
            for (MenuDO menu : menus) {
                if (StringUtils.isNotBlank(menu.getUrl())
                    && antPathMatcher.match(menu.getUrl(), request.getRequestURI())
                    && request.getMethod().equalsIgnoreCase(menu.getMethod())) {
                    hasPermissionFalg = true;
                }
            }
        }
        log.info("hasPermission 结束 鉴权:{}",hasPermissionFalg);
        return hasPermissionFalg;
    }

    private void printToken(HttpServletRequest request){
        String authorization = request.getHeader(Constants.TOKEN_HEADER);
        String token = StringUtils.substringAfter(authorization, Constants.TOKEN_BEARER);
        System.out.println("token:"+token);
        String key = Base64.getEncoder().encodeToString(Constants.JWT_SIGN_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        System.out.println("claims:"+claims.toString());
    }
}
