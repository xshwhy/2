package com.iotmars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author: xsh
 * @date: 2020/11/27 16:52
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true)
public class OauthSourceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * token 持久化策略
     * InMemoryTokenStore 表示将token存储在内存
     * RedisTokenStore 表示将token存储在redis
     * JdbcTokenStore 表示将token存储在数据库
     *
     * @return
     */
    @Bean
    public TokenStore JdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                // 指定当前资源的id
                .resourceId("product_api")
                // 指定保存token的方式
                .tokenStore(JdbcTokenStore());


    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable().authorizeRequests()
                //指定不同请求方式访问资源所需要的权限，一般查询是read，其余是write。
                .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('write')")
                .and()
                .headers().addHeaderWriter((request, response) -> {
                response.addHeader("Access-Control-Allow-Origin", "*");
            //允许跨域
            if (request.getMethod().equals("OPTIONS")) {
                //如果是跨域的预检请求，则原封不动向下传达请 求头信息
                response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Request-Method"));
                response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
            }
        });
    }


}
