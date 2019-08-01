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

import com.soraka.common.model.domain.RoleDO;
import com.soraka.common.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.common.model.dto.R;
import com.soraka.admin.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author yongjie.teng
 * @date 2018/8/17
 * @package com.soraka.admin.controller
 */
@Api(tags = "角色服务")
@RequestMapping("role")
@RestController
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @GetMapping("{id}")
    @ApiOperation("获取角色详情")
    public R get(@PathVariable("id") Long id) {
        RoleDO role = roleService.get(id);
        R r = R.success();
        r.setData(role);
        return r;
    }

    @GetMapping
    @ApiOperation("查询角色列表")
    public R find(QueryParam queryParam) {
        Page page = roleService.findPage(queryParam);
        R r = R.success();
        r.setData(page);
        return r;
    }

    @PostMapping
    @ApiOperation("添加角色")
    public R save(@Valid @RequestBody RoleDO roleDO) {
        return R.operate(roleService.save(roleDO));
    }

    @PutMapping
    @ApiOperation("更新角色信息")
    public R update(@RequestBody RoleDO roleDO) {
        return R.operate(roleService.update(roleDO));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除角色", notes = "根据角色ID删除")
    public R delete(@PathVariable("id") Long id) {
        return R.operate(roleService.delete(id));
    }
}
