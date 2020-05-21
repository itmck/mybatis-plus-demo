package com.itmck.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Create by it_mck 2020/4/22 23:16
 *
 * @Description:
 * @Version: 1.0
 */
@EnableWebSecurity
@Configuration
public class SwaggerConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()//禁用csrf跨站请求伪造
                .authorizeRequests()//认证请求
                .antMatchers("/swagger-ui.html").authenticated() //这里只认证 /swagger-ui.html
                .anyRequest().permitAll()//其他放行
                .and().httpBasic()//开启basic认证
                .and().formLogin()
                .and().headers().frameOptions().disable();

    }
}
