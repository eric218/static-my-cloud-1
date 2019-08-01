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

import com.soraka.common.model.domain.MenuDO;
import com.soraka.admin.model.dto.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单
 *
 * @author yongjie.teng
 * @date 2018/8/15
 * @package com.soraka.admin.dao
 */
public interface MenuDAO {
    /**
     * 通过主键获取菜单
     *
     * @param id 主键
     * @return {@link MenuDO}
     */
    MenuDO get(Long id);

    /**
     * 获取用户菜单
     *
     * @param userId 用户ID
     * @return List<MenuDO>
     */
    List<MenuDO> findByUserId(Long userId);

    /**
     * 查询菜单列表
     *
     * @param param 查询参数
     * @return List<MenuDO>
     */
    List<MenuDO> find(QueryParam param);

    /**
     * 查询菜单列表条数
     *
     * @param param 查询参数
     * @return {@link Integer}
     */
    Integer count(QueryParam param);

    /**
     * 新增菜单
     *
     * @param menuDO
     * @return true 成功 false 失败
     */
    Integer save(MenuDO menuDO);

    /**
     * 更新菜单
     *
     * @param menuDO
     * @return true 成功 false 失败
     */
    Integer update(MenuDO menuDO);

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return true 成功 false 失败
     */
    Integer delete(Long id);

    /**
     * 查询角色菜单
     *
     * @param roleKeys 角色键值
     * @return 菜单列表
     */
    List<MenuDO> getRoleMenu(@Param("roleKeys") List<String> roleKeys);
}
