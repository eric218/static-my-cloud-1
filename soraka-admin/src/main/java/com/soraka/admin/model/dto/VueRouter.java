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

import com.soraka.common.model.domain.MenuDO;
import lombok.Data;

/**
 * vue router
 *
 * @author yongjie.teng
 * @date 2018/9/25
 * @package com.soraka.admin.model.vo
 */
@Data
public class VueRouter extends TreeNode {
    /**
     * 路由名称
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 重定向地址，在面包屑中点击会重定向去的地址
     * 当设置 noredirect 的时候该路由在面包屑导航中不可被点击
     */
    private String redirect;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 元信息
     */
    private Meta meta;

    public VueRouter() {
    }

    public VueRouter(MenuDO menuDO) {
        setId(menuDO.getId());
        setParentId(menuDO.getParentId());
        this.name = menuDO.getName();
        this.component = menuDO.getComponent();
        this.path = menuDO.getPath();
        this.redirect = menuDO.getRedirect();
        this.sort = menuDO.getSequence();

        Meta meta = new Meta();
        meta.icon = menuDO.getIco();
        meta.title = menuDO.getName();
        this.meta = meta;
    }

    @Data
    class Meta {
        /**
         * 图标
         */
        private String icon;

        /**
         * 路由标题（菜单显示名称）
         */
        private String title;

        /**
         * 不会被 <keep-alive> 缓存
         */
        private boolean noCache;
    }
}
