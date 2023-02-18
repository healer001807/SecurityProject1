package com.example.securityproject.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @program: SecurityProject
 * @description: 用户权限配置
 * @author: kangwei
 * @create: 2023-02-15 22:16
 **/
//@Configuration
//@EnableWebSecurity
public class DemoUserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        //auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin")
                .roles("ADMIN","USER")
                .and().withUser("kw0001").password("{noop}admin").roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 1.退出
        //        http.logout().logoutUrl("/logout").logoutSuccessUrl("/templates/logout").permitAll();
        //
        //        // 2.配置没有权限访问页面
        //        http.exceptionHandling().accessDeniedPage("/unauth.html");
        //        // 3. 自定义登录
        //        http.formLogin().loginPage("/login.html").loginProcessingUrl("/user/login")
        //                .defaultSuccessUrl("/index.html").permitAll()
        //                .failureUrl("/unauth.html").and().authorizeRequests().
        //                // 以下路径不需要权限可被访问
        //                        antMatchers("/","/user/hello","/user/login").permitAll()
        ////        .antMatchers("/user/admin").hasAuthority("admin");
        ////        .antMatchers("/user/role").hasRole("role")
        //                .anyRequest().authenticated().and().rememberMe().tokenRepository(persistentTokenRepository())
        //                .tokenValiditySeconds(60) //60秒过期
        //                .userDetailsService(userDetailsService);

        // 1.所有资源访问请求
//        http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();

        // 2.角色为admin访问所有，角色为user访问分中心
        http.authorizeRequests().antMatchers("/centerCity/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().and().httpBasic();
    }

    /**
     * 密码加解密
     *
     * @return
     */
//    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    //    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

}
