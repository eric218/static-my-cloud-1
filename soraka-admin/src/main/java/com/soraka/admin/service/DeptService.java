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

import com.soraka.common.model.domain.DeptDO;
import com.soraka.common.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service
 */
@Service
public interface DeptService {
    /**
     * 通过主键获取部门
     *
     * @param id 主键
     * @return {@link DeptDO}
     */
    DeptDO get(Long id);

    /**
     * 查询部门列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    Page findPage(QueryParam queryParam);

    /**
     * 新增部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    boolean save(DeptDO deptDO);

    /**
     * 更新部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    boolean update(DeptDO deptDO);

    /**
     * 删除部门
     *
     * @param id 部门ID
     * @return true 成功 false 失败
     */
    boolean delete(Long id);

    /**
     * 获取所有部门
     *
     * @return List<DeptDO>
     */
    List<DeptDO> findAll();
}
