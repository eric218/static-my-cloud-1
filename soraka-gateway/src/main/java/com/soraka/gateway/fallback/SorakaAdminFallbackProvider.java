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

package com.soraka.gateway.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 模块降级回调
 *
 * @author yongjie.teng
 * @date 2018/10/29
 * @package com.soraka.gateway.fallback
 */
@Component
@Slf4j
public class SorakaAdminFallbackProvider implements FallbackProvider {
    private static final String SERVICE_NAME = "soraka-admin";
    private static final String SERVICE_DISABLE = "soraka-admin服务不可用";
    
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        log.error(SERVICE_DISABLE);
        return new SorakaFallbackResponse(cause, SERVICE_NAME, SERVICE_DISABLE);
    }

    @Override
    public String getRoute() {
        return SERVICE_NAME;
    }
}
