package com.myblog.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>描述: [ security安全管理器 ] </p>
 * <p>创建时间: 2021/11/08 下午 11:12 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private ObjectMapper objectMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 认证
        http.formLogin().usernameParameter("username").passwordParameter("password")
                //自定义登录请求路径(post请求)
                .loginProcessingUrl("/login")
                //登录成功，返回json 200
                .successHandler((request, response, authentication) -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("code", 200);
                    map.put("message", "登录成功");
                    map.put("data", authentication);
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                //登录失败，返回json 401
                .failureHandler((request, response, ex) -> {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    PrintWriter out = response.getWriter();
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("code", 401);
                    if (ex instanceof UsernameNotFoundException || ex instanceof BadCredentialsException) {
                        map.put("message", "用户名或密码错误");
                    } else if (ex instanceof DisabledException) {
                        map.put("message", "账户被禁用");
                    } else {
                        map.put("message", "登录失败!");
                    }
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                //没有权限，返回json
                .and()
                .exceptionHandling()
                .accessDeniedHandler((request, response, ex) -> {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    PrintWriter out = response.getWriter();
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("code", 403);
                    map.put("message", "权限不足");
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                //退出成功，返回json
                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("code", 200);
                    map.put("message", "退出成功");
                    map.put("data", authentication);
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .permitAll();
        // 授权
        http.authorizeRequests()
                // admin界面需要认证后才可以访问
                .antMatchers("/admin/**").authenticated()
                // 其他页面放行
                .anyRequest().permitAll();
        //开启跨域访问   开启模拟请求，比如API POST测试工具的测试，不开启时，API POST为报403错误
        http.cors().and().csrf().disable();
    }

    @Bean("bCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
