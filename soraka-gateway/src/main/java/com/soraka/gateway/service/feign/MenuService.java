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

package com.soraka.gateway.service.feign;

import com.soraka.common.model.domain.MenuDO;
import com.soraka.gateway.service.feign.fallback.MenuServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/10/29
 * @package com.soraka.gateway.service.feign
 */
@FeignClient(name = "soraka-admin", fallback = MenuServiceFallbackImpl.class)
public interface MenuService {
    /**
     * 查询角色菜单
     *
     * @param roleKeys 角色Key
     * @return 菜单列表
     */
    @GetMapping("menu/roleMenu")
    List<MenuDO> findRoleMenu(@RequestParam("roleKeys") List<String> roleKeys);
}
