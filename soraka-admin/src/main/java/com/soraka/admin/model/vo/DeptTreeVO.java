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

package com.soraka.admin.model.vo;

import com.soraka.common.model.domain.DeptDO;
import com.soraka.admin.model.dto.TreeNode;
import lombok.Data;

import java.util.Date;

/**
 * 部门树
 *
 * @author yongjie.teng
 * @date 2018/10/16
 * @package com.soraka.admin.model.vo
 */
@Data
public class DeptTreeVO extends TreeNode {
    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sequence;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    public DeptTreeVO(DeptDO deptDO) {
        setId(deptDO.getId());
        setParentId(deptDO.getParentId());
        this.code = deptDO.getCode();
        this.name = deptDO.getName();
        this.sequence = deptDO.getSequence();
        this.status = deptDO.getStatus();
        this.createTime = deptDO.getCreateTime();
        this.modifyTime = deptDO.getModifyTime();
    }
}
