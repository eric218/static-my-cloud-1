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

package com.soraka.auth.userdetails;

import com.soraka.common.constant.Constants;
import com.soraka.common.model.domain.RoleDO;
import com.soraka.common.model.domain.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户
 * @author yongjie.teng
 * @date 2018/10/19
 * @package com.soraka.auth.userdetails
 */
@Slf4j
public class UserDetailsImpl implements UserDetails {
    private Long userId;
    private String username;
    private String password;
    private Integer status;
    List<RoleDO> roles;

    public UserDetailsImpl(UserDO userDO, List<RoleDO> roles) {
        log.info("Auth UserDetails:A");
        this.userId = userDO.getId();
        this.username = userDO.getUsername();
        this.password = userDO.getPassword();
        this.status = userDO.getStatus();
        this.roles = roles;
    }

    /**
     * 返回分配给用户的角色列表
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleDO role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getKey()));
        }
        authorities.add(new SimpleGrantedAuthority(Constants.BASE_ROLE));
        return authorities;
    }

    /**
     * 返回密码
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * 返回帐号
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 账户是否未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return Constants.USER_STATUS_NORMAL == this.status;
    }

    /**
     * 密码是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     */
    @Override
    public boolean isEnabled() {
        return Constants.USER_STATUS_NORMAL == this.status;
    }
}
