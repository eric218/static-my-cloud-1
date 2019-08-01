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

package com.soraka.admin.controller;

import com.soraka.common.model.domain.DeptDO;
import com.soraka.common.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.common.model.dto.R;
import com.soraka.admin.model.vo.DeptTreeVO;
import com.soraka.admin.service.DeptService;
import com.soraka.admin.util.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/8/17
 * @package com.soraka.admin.controller
 */
@Api(tags = "部门服务")
@RequestMapping("dept")
@RestController
public class DeptController extends BaseController {
    @Autowired
    private DeptService deptService;

    @GetMapping("{id}")
    @ApiOperation("获取部门详情")
    public R get(@PathVariable("id") Long id) {
        DeptDO dept = deptService.get(id);
        R r = R.success();
        r.setData(dept);
        return r;
    }

    @GetMapping
    @ApiOperation("查询部门列表")
    public R find(QueryParam queryParam) {
        Page page = deptService.findPage(queryParam);
        R r = R.success();
        r.setData(page);
        return r;
    }

    @PostMapping
    @ApiOperation("添加部门")
    public R save(@Valid @RequestBody DeptDO deptDO) {
        return R.operate(deptService.save(deptDO));
    }

    @PutMapping
    @ApiOperation("更新部门信息")
    public R update(@RequestBody DeptDO deptDO) {
        return R.operate(deptService.update(deptDO));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除部门", notes = "根据部门ID删除")
    public R delete(@PathVariable("id") Long id) {
        return R.operate(deptService.delete(id));
    }

    @GetMapping("tree")
    @ApiOperation("查询部门树")
    public R findDeptTree() {
        R r = R.success();
        List<DeptDO> depts = deptService.findAll();
        List<DeptTreeVO> deptTrees = new ArrayList<>();
        depts.forEach(deptDO -> {
            deptTrees.add(new DeptTreeVO(deptDO));
        });
        Collections.sort(deptTrees, Comparator.comparingInt(DeptTreeVO::getSequence));
        r.setData(TreeUtil.build(deptTrees, 0L));
        return r;
    }
}
