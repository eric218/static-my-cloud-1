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

import java.util.List;

/**
 * 角色
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.common.model.domain
 */
@Data
public class RoleDO extends BaseDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 角色key
     */
    private String key;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;

    /**
     * 菜单ID集合
     */
    private List<Long> menus;
}
