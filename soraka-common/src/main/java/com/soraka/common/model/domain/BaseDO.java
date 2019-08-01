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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础领域模型
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.common.model.domain
 */
@Data
public abstract class BaseDO implements Serializable {

    /**
     * 创建人ID
     */
    private Long createUser;

    /**
     * 修改人ID
     */
    private Long modifyUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "字符串日期", example = "2018-05-09 12:00:00")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "字符串日期", example = "2018-05-09 12:00:00")
    private Date modifyTime;
}
