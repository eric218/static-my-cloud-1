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

import com.soraka.common.model.domain.RoleMenuDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单
 *
 * @author yongjie.teng
 * @date 2018/10/16
 * @package com.soraka.admin.dao
 */
public interface RoleMenuDAO {

    /**
     * 获取角色菜单ID集合
     *
     * @param roleId 角色主键
     * @return List<Long>
     */
    List<Long> findMenuIdsByRoleId(Long roleId);

    /**
     * 删除角色菜单关系
     *
     * @param roleId 角色主键
     * @return 受影响行数
     */
    Integer deleteByRoleId(Long roleId);

    /**
     * 批量保存角色菜单关系
     *
     * @param roleMenus 角色菜单
     * @return 受影响行数
     */
    Integer batchSave(@Param("roleMenus") List<RoleMenuDO> roleMenus);
}
