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

package com.soraka.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

/**
 * 网关做资源服务器
 *
 * @author yongjie.teng
 * @date 2018/10/22
 * @package com.soraka.gateway.config
 */

@Configuration
@EnableResourceServer
public class SorakaResourceConfigurerAdapter extends ResourceServerConfigurerAdapter {
    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http
            .authorizeRequests()
            .antMatchers("/auth/oauth/token_key").denyAll()
            //以下配置不会去hasPermission方法，但是都会需要登陆token验证，
            //如果不需要登陆token验证则再SorakaSecurityConfigurerAdapter里配置
            .antMatchers(
                "/auth/**",
                "/admin/user/info",
                "/admin/menu/userMenu",
                "/*/swagger-ui.html",
                "/*/swagger-resources/**",
                "/*/v2/api-docs",
                "/*/swagger/api-docs",
                "/*/webjars/**",
                "/mp/hello",
                "/favicon.ico"
                ).permitAll()
            .anyRequest()
            .access("@permissionService.hasPermission(request, authentication)");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.expressionHandler(expressionHandler);
    }

    /**
     * 异常问题
     * #oauth2.throwOnError(@permissionService.hasPermission(request, authentication))
     * https://github.com/spring-projects/spring-security-oauth/issues/730
     *
     * @param applicationContext ApplicationContext
     * @return OAuth2WebSecurityExpressionHandler
     */
    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }
}
