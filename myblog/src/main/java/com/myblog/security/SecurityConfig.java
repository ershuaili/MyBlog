package com.myblog.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myblog.entity.User;
import com.myblog.security.resp.ResponseResult;
import com.myblog.security.resp.ResponseStatusCode;
import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>描述: [SecurityConfig主要用于安全验证] </p>
 * <p>创建时间: 2021/11/08 下午 11:16 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider())
                .httpBasic()
                //未登录时 , 自定义响应结果
                .authenticationEntryPoint((request, response, ex) -> customResponse(response, ResponseStatusCode.NO_AUTHORITY, ex))
                .and()
                .authorizeRequests()
                // 所有请求拦截
                .anyRequest()
                // 拦截特定路径下的请求
                // .mvcMatchers("/admin/**", "/user/**")
                .authenticated()
                .and()
                .exceptionHandling()
                //没有权限，自定义响应结果
                .accessDeniedHandler((request, response, ex) -> customResponse(response, ResponseStatusCode.NO_AUTHORITY, ex))
                .and()
                .logout()
                //退出成功，自定义响应结果
                .logoutSuccessHandler((request, response, authentication) -> customResponse(response, ResponseStatusCode.SUCCESS, authentication)).permitAll()
                //异常处理(权限拒绝、登录失效等)
                .and().exceptionHandling()
                //匿名用户访问无权限资源时的异常处理
                .authenticationEntryPoint((request, response, ex) -> customResponse(response, ResponseStatusCode.NO_AUTHORITY, ex));
        http
                .formLogin()
                //发送Ajax请求的路径
                .loginProcessingUrl("/login")
                //验证失败处理
                .failureHandler((request, response, ex) -> customResponse(response, ResponseStatusCode.LOGIN_FAILED, ex))
                //验证用户名之后逻辑
                .successHandler((request, response, authentication) -> {
                    //登录请求参数封装到对象中
                    User loginUser = new User(request);
                    //UserDetailsService根据username查询的User
                    User dbUser = (User) authentication.getPrincipal();
                    BCryptPasswordEncoder bCryptPasswordEncoder = bCryptPasswordEncoder();
                    System.out.println(bCryptPasswordEncoder.matches(loginUser.getPassword(), dbUser.getPassword()));
                    //todo 验证用户名 密码 验证码... 这里回默认返成功
                    customResponse(response, ResponseStatusCode.SUCCESS, authentication);
                })
                .permitAll();
        //开启跨域访问
        http.cors().disable();
        //开启模拟请求，比如API POST测试工具的测试，不开启时，API POST为报403错误
        http.csrf().disable();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        //对默认的UserDetailsService进行覆盖
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }

    @Bean("bCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    private void customResponse(HttpServletResponse response, ResponseStatusCode rsc, Object e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(rsc.getCode());
        PrintWriter out = response.getWriter();
        out.write(objectMapper.writeValueAsString(new ResponseResult<>(rsc, e)));
        out.flush();
        out.close();
    }
}