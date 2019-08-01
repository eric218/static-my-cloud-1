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

package com.soraka.admin.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 *
 * @author yongjie.teng
 * @date 2018/9/27
 * @package com.soraka.admin.model.dto
 */
@Data
public class TreeNode implements Serializable {
    private long id;
    private long parentId;
    /**
     * 子节点
     */
    private List<TreeNode> children = new ArrayList<>();

    public void addChild(TreeNode node) {
        children.add(node);
    }
}
