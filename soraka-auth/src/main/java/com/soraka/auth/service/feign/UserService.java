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

package com.soraka.auth.service.feign;

import com.soraka.auth.service.feign.fallback.UserServiceFallbackImpl;
import com.soraka.common.model.domain.RoleDO;
import com.soraka.common.model.domain.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 用户服务
 *
 * @author yongjie.teng
 * @date 2018/10/19
 * @package com.soraka.auth.service.feign
 */
@FeignClient(name = "soraka-admin", fallback = UserServiceFallbackImpl.class)
public interface UserService {
    /**
     * 根据用户名获取用户详情
     *
     * @param username 用户名
     * @return UserDO
     */
    @GetMapping("user/username/{username}")
    UserDO getByUsername(@PathVariable("username") String username);

    /**
     * 获取用户角色详情
     *
     * @param id 用户ID
     * @return UserDO
     */
    @GetMapping("user/{id}/role")
    List<RoleDO> getUserRole(@PathVariable("id") Long id);
}
