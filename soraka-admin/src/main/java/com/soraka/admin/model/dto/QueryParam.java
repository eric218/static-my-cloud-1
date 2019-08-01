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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * 查询参数
 *
 * @author yongjie.teng
 * @date 2018/8/17
 * @package com.soraka.admin.model.dto
 */
@Data
public class QueryParam implements Serializable {
    private static final String ORDER_ASC = "ASC";
    private static final String ORDER_DESC = "DESC";
    /**
     * 查询文本
     */
    private String queryText;

    /**
     * 单页大小
     */
    private Integer limit = 10;

    /**
     * 页码
     */
    private Integer page = 1;

    /**
     * 偏移量
     */
    @JsonIgnore
    private Integer offset;

    /**
     * 排序名称
     */
    private String sort;

    /**
     * 正序 ASC 倒叙 DESC
     */
    private String order = ORDER_ASC;

    public void setOrder(String order) {
        if (ORDER_DESC.equals(order)) {
            order = ORDER_DESC;
        }
    }

    public Integer getOffset() {
        return (page - 1) * limit;
    }
}
