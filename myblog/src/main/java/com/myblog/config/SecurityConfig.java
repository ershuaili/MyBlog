package com.myblog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myblog.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private ObjectMapper objectMapper;
    /**
     * 定义登陆成功返回信息，返回json 200
     */
    private class AjaxAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
            // 获取用户信息
            String authority = authentication.getAuthorities().iterator().next().getAuthority();
            String name = authentication.getName();
            // 创建token
            String token = JwtUtil.generateToken(authentication.getName(), authority);
            // 返回信息
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("code", 200);
            map.put("message", "登录成功");
            map.put("role",authority);
            map.put("nickname",name);
            map.put("token",token);

            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(objectMapper.writeValueAsString(map));
            out.flush();
            out.close();
        }
    }
    /**
     * 定义登录失败返回信息，返回json 401
     */
    private class AjaxAuthFailHandler extends SimpleUrlAuthenticationFailureHandler {
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter out = response.getWriter();
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("code", 401);
            if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
                log.info("用户名或密码错误");
                map.put("message", "用户名或密码错误");
            } else if (exception instanceof DisabledException) {
                map.put("message", "账户被禁用");
            } else {
                map.put("message", "登录失败!");
            }
            out.write(objectMapper.writeValueAsString(map));
            out.flush();
            out.close();
        }
    }
    /**
     * 定义登出成功返回信息,返回json 200
     */
    private class AjaxLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
        @Override
        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("code", 200);
            map.put("message", "退出成功");
            map.put("data", authentication);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(objectMapper.writeValueAsString(map));
            out.flush();
            out.close();
        }
    }
    /**
     * 定义没有权限，返回json 403
     */
    private class AjaxAccessFailHandler extends SimpleUrlAuthenticationFailureHandler implements AccessDeniedHandler {
        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
            log.info("权限不足");
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = response.getWriter();
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("code", 403);
            map.put("message", "权限不足");
            out.write(objectMapper.writeValueAsString(map));
            out.flush();
            out.close();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 认证
        http.formLogin().usernameParameter("username").passwordParameter("password")
                //自定义登录请求路径(post请求)
                .loginProcessingUrl("/login")
                //登录成功，返回json 200
                .successHandler(new AjaxAuthSuccessHandler())
                //登录失败，返回json 401
                .failureHandler(new AjaxAuthFailHandler())
                //没有权限，返回json
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new AjaxAccessFailHandler())
                //退出成功，返回json
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new AjaxLogoutSuccessHandler())
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
