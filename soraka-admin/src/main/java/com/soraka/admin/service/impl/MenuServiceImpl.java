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

import com.soraka.admin.dao.MenuDAO;
import com.soraka.common.model.domain.MenuDO;
import com.soraka.common.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service.impl
 */
@Transactional(rollbackFor = {RuntimeException.class})
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;

    /**
     * 根据主键获取菜单
     *
     * @param id 主键
     * @return {@link MenuDO}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public MenuDO get(Long id) {
        return menuDAO.get(id);
    }

    /**
     * 获取用户菜单
     *
     * @param userId 用户ID
     * @return List<MenuDO>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<MenuDO> findByUserId(Long userId) {
        return menuDAO.findByUserId(userId);
    }

    /**
     * 获取用户权限集合
     *
     * @param userId 用户ID
     * @return List<MenuDO>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<String> getUserPermission(Long userId) {
        List<MenuDO> menus = findByUserId(userId);
        List<String> perms = new ArrayList<>();
        for (MenuDO menu : menus) {
            if (!StringUtils.isEmpty(menu.getPermission())) {
                perms.add(menu.getPermission());
            }
        }
        return perms;
    }

    /**
     * 获取所有菜单
     *
     * @return List<MenuDO>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<MenuDO> findAll() {
        return menuDAO.find(null);
    }

    /**
     * 查询菜单列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public Page findPage(QueryParam queryParam) {
        Page page = new Page();
        List<MenuDO> menus;
        int total = menuDAO.count(queryParam);
        page.setTotal(total);
        if (total > 0) {
            menus = menuDAO.find(queryParam);
            page.setRows(menus);
        } else {
            page.setRows(new ArrayList<>());
        }
        return page;
    }

    /**
     * 新增菜单
     *
     * @param menuDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean save(MenuDO menuDO) {
        return menuDAO.save(menuDO) > 0;
    }

    /**
     * 更新菜单
     *
     * @param menuDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean update(MenuDO menuDO) {
        return menuDAO.update(menuDO) > 0;
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return true 成功 false 失败
     */
    @Override
    public boolean delete(Long id) {
        return menuDAO.delete(id) > 0;
    }

    /**
     * 查询角色菜单
     *
     * @param roleKeys 角色键值
     * @return 菜单列表
     */
    @Override
    public List<MenuDO> getRoleMenu(List<String> roleKeys) {
        return menuDAO.getRoleMenu(roleKeys);
    }
}
