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

import com.soraka.admin.dao.DeptDAO;
import com.soraka.common.model.domain.DeptDO;
import com.soraka.common.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.admin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service.impl
 */
@Transactional(rollbackFor = {RuntimeException.class})
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDAO deptDAO;

    /**
     * 通过主键获取部门
     *
     * @param id 主键
     * @return {@link DeptDO}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public DeptDO get(Long id) {
        return deptDAO.get(id);
    }

    /**
     * 查询部门列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public Page findPage(QueryParam queryParam) {
        Page page = new Page();
        List<DeptDO> depts;
        int total = deptDAO.count(queryParam);
        page.setTotal(total);
        if (total > 0) {
            depts = deptDAO.find(queryParam);
            page.setRows(depts);
        } else {
            page.setRows(new ArrayList<>());
        }
        return page;
    }

    /**
     * 新增部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean save(DeptDO deptDO) {
        return deptDAO.save(deptDO) > 0;
    }

    /**
     * 更新部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean update(DeptDO deptDO) {
        return deptDAO.update(deptDO) > 0;
    }

    /**
     * 删除部门
     *
     * @param id 部门ID
     * @return true 成功 false 失败
     */
    @Override
    public boolean delete(Long id) {
        return deptDAO.delete(id) > 0;
    }

    /**
     * 获取所有部门
     *
     * @return List<DeptDO>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<DeptDO> findAll() {
        return deptDAO.find(new QueryParam());
    }
}
