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

package com.soraka.admin.service.impl;

import com.soraka.admin.dao.UserRoleDAO;
import com.soraka.common.model.domain.UserRoleDO;
import com.soraka.admin.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户角色
 *
 * @author yongjie.teng
 * @date 2018/8/30
 * @package com.soraka.admin.service.impl
 */
@Transactional(rollbackFor = {RuntimeException.class})
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDAO userRoleDAO;
    /**
     * 获取用户角色ID集合
     *
     * @param userId 用户主键
     * @return List<Long>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<Long> findRoleIdsByUserId(Long userId) {
        return userRoleDAO.findRoleIdsByUserId(userId);
    }

    /**
     * 删除用户角色关系
     *
     * @param userId 用户主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteByUserId(Long userId) {
        return userRoleDAO.deleteByUserId(userId);
    }

    /**
     * 批量保存用户角色关系
     *
     * @param userRoles 用户角色
     * @return 受影响行数
     */
    @Override
    public Integer batchSave(List<UserRoleDO> userRoles) {
        return userRoleDAO.batchSave(userRoles);
    }
}
