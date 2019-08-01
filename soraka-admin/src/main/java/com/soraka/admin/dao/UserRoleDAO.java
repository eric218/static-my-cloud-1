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

package com.soraka.admin.dao;

import com.soraka.common.model.domain.UserRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色
 *
 * @author yongjie.teng
 * @date 2018/8/30
 * @package com.soraka.admin.dao
 */
public interface UserRoleDAO {

    /**
     * 获取用户角色ID集合
     *
     * @param userId 用户主键
     * @return List<Long>
     */
    List<Long> findRoleIdsByUserId(Long userId);

    /**
     * 删除用户角色关系
     *
     * @param userId 用户主键
     * @return 受影响行数
     */
    Integer deleteByUserId(Long userId);

    /**
     * 批量保存用户角色关系
     *
     * @param userRoles 用户角色
     * @return 受影响行数
     */
    Integer batchSave(@Param("userRoles") List<UserRoleDO> userRoles);
}
