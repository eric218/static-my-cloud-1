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

import com.soraka.common.model.domain.UserDO;
import lombok.Data;

import java.util.List;

/**
 * 系统用户信息
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.model.dto
 */
@Data
public class UserInfo extends BaseDTO {
    /**
     * 用户信息
     */
    private UserDO user;

    /**
     * 权限标识集合
     */
    private List<String> permissions;
}
