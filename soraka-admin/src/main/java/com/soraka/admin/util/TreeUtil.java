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

package com.soraka.admin.util;

import com.soraka.admin.model.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树工具类
 *
 * @author yongjie.teng
 * @date 2018/9/27
 * @package com.soraka.admin.util
 */
public class TreeUtil {
    /**
     * 两层循环实现
     *
     * @param treeNodes 节点列表
     * @param root 根节点ID
     * @return
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();

        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }

            for (T it : treeNodes) {
                if (it.getParentId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.addChild(it);
                }
            }
        }
        return trees;
    }
}
