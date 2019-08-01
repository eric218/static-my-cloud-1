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

package com.soraka.common.model.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色菜单
 *
 * @author yongjie.teng
 * @date 2018/10/16
 * @package com.soraka.common.model.domain
 */
@Data
public class RoleMenuDO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 角色ID
     */
    private Long roleId;
}
