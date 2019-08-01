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

package com.soraka.admin.service;

import com.soraka.common.model.domain.UserDO;
import com.soraka.common.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import org.springframework.stereotype.Service;

/**
 * 系统用户
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service
 */
@Service
public interface UserService {
    /**
     * 根据主键获取用户信息
     *
     * @param id 主键
     * @return {@link UserDO}
     */
    UserDO get(Long id);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return {@link UserDO}
     */
    UserDO getByUsername(String username);

    /**
     * 根据手机号获取用户
     *
     * @param mobilephone 手机号
     * @return {@link UserDO}
     */
    UserDO getByMobilephone(String mobilephone);

    /**
     * 根据邮箱获取用户
     *
     * @param email 邮箱
     * @return {@link UserDO}
     */
    UserDO getByEmail(String email);

    /**
     * 查询用户列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    Page findPage(QueryParam queryParam);

    /**
     * 生成用户密码加密串
     *
     * @param password 密码
     * @return 加密密码串
     */
    String encryptPassword(String password);

    /**
     * 新增用户
     *
     * @param userDO
     * @return true 成功 false 失败
     */
    boolean save(UserDO userDO);

    /**
     * 更新用户
     *
     * @param userDO
     * @return true 成功 false 失败
     */
    boolean update(UserDO userDO);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return true 成功 false 失败
     */
    boolean delete(Long id);
}
