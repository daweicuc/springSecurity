package cuc.dawei.springsecuritydemo.config;

import cuc.dawei.springsecuritydemo.service.CustomUserService;
import cuc.dawei.springsecuritydemo.service.KaptchaAuthenticationFilter;
import cuc.dawei.springsecuritydemo.service.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.*;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/19 20:00
 * @Version 1.0
 * /**
 *  * @EnableWebSecurity注解使得SpringMVC集成了Spring Security的web安全支持。
 *  * 另外，WebSecurityConfig配置类同时集成了WebSecurityConfigurerAdapter，重写了其中的特定方法，用于自定义Spring Security配置。
 *  * 整个Spring Security的工作量，其实都是集中在该配置类，不仅仅是这个guides，实际项目中也是如此。
 *  */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
//如果引用其他加密算法，可用此方法调用MyPasswordEncoder()来实现----MD5
    //    @Bean
//    public PasswordEncoder myPasswordEncoder() {
//        return new MyPasswordEncoder();
//    }
    //注册UserDetailsService 的bean
    @Bean
    UserDetailsService customUserService1(){
        return new CustomUserService();
    }
    //user Details Service验证
    @Override
    public void configure(AuthenticationManagerBuilder Auth) throws Exception{
        Auth.userDetailsService(customUserService1()).passwordEncoder(new BCryptPasswordEncoder());
        System.out.println("user Detail验证："+Auth.userDetailsService(customUserService1()).passwordEncoder(new BCryptPasswordEncoder()));
    }
    //auth.userDetailsService(customUserService()); //user Details Service验证
    /**有以下几种形式，使用第3种*/
    //1）.inMemoryAuthentication 从内存中获取
    // auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user1").password(new BCryptPasswordEncoder().encode("123123")).roles("USER");
    //2）.jdbcAuthentication从数据库中获取，但是默认是以security提供的表结构
    //usersByUsernameQuery 指定查询用户SQL
    //authoritiesByUsernameQuery 指定查询权限SQL
    //auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(query);
    //3).注入userDetailsService，需要实现userDetailsService接口

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .addFilterBefore(new KaptchaAuthenticationFilter("/login", "/login?error"), UsernamePasswordAuthenticationFilter.class) //在认证用户名之前认证验证码，如果验证码错误，将不执行用户名和密码的认证
                // 所有用户均可访问的资源
                .authorizeRequests()
                .antMatchers( "/favicon.ico","/css/**","/common/**","/js/**","/images/**","/login/**","/login","/login-error").permitAll()
                .anyRequest().authenticated()//任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()//登录页面用户任意访问
                .and()
                .logout().permitAll();
        http.csrf().disable();
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

        // 范例
       /* http.authorizeRequests()
                //静态资源和一些所有人都能访问的请求
                .antMatchers("/css/**","/staic/**", "/js/**","/images/**").permitAll()
                .antMatchers("/", "/login","/session_expired").permitAll()
                //登录
                .and().formLogin()
                .loginPage("/login")
                .usernameParameter("userId")       //自己要使用的用户名字段
                .passwordParameter("password")     //密码字段
                .defaultSuccessUrl("/index")     //登陆成功后跳转的请求,要自己写一个controller转发
                .failureUrl("/loginAuthtictionFailed")  //验证失败后跳转的url
                //session管理
                .and().sessionManagement()
                .maximumSessions(1)                //系统中同一个账号的登陆数量限制
                .and().and()
                .logout()//登出
                .invalidateHttpSession(true)  //使session失效
                .clearAuthentication(true)    //清除证信息
                .and()
                .httpBasic();*/

    }
}
