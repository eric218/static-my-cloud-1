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
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 服务降级提示
 *
 * @author yongjie.teng
 * @date 2018/10/29
 * @package com.soraka.gateway.fallback
 */
@Slf4j
public class SorakaFallbackResponse implements ClientHttpResponse {
    private Throwable cause;
    private String service;
    private String message;

    public SorakaFallbackResponse(Throwable cause, String service, String message) {
        this.cause = cause;
        this.service = service;
        this.message = message;
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        return HttpStatus.SERVICE_UNAVAILABLE;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return HttpStatus.SERVICE_UNAVAILABLE.value();
    }

    @Override
    public String getStatusText() throws IOException {
        return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
    }

    @Override
    public void close() {
    }

    @Override
    public InputStream getBody() {
        if (cause != null && cause.getMessage() != null) {
            log.error("调用:{} 异常：{}", service, cause.getMessage());
            return new ByteArrayInputStream(("service:"+service+" 异常:"+cause.getMessage()).getBytes());
        } else {
            log.error("调用:{} 异常：{}", service, message);
            return new ByteArrayInputStream(("service:"+service+" 异常:"+message).getBytes());
        }
    }

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
