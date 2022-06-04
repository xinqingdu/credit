package com.itxiaodu.credit.mvc.config;


import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.itxiaodu.credit.exception.AccessFobiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import sun.security.provider.MD5;

@Configuration
@EnableWebSecurity

//全局方法权限控制
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    SpringSecurityConfig() {

    }
    @Autowired
    private UserDetailsService userDetailsService;

//    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("root").password("12345678").roles("role0");
          auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/security/to/login/page.html")
            .permitAll()
            .antMatchers("/bootstrap/**")
            .permitAll()
            .antMatchers("/credit/**")
            .permitAll()
            .antMatchers("/css/**")
            .permitAll()
            .antMatchers("/fonts/**")
            .permitAll()
            .antMatchers("/img/**")
            .permitAll()
            .antMatchers("/jquery/**")
            .permitAll()
            .antMatchers("/layer/**")
            .permitAll()
            .antMatchers("/scrip/**")
            .permitAll()
            .antMatchers("/ztree/**")
            .permitAll()
//            .antMatchers("/security/to/main/page.html")
//            .authenticated()
//            .antMatchers("/menu/to/page.html")
//            .hasRole("经理")
//            .antMatchers()
//            .hasAnyAuthority()
            .anyRequest()
            .authenticated()
//            .and()
//            .exceptionHandling()
//            .accessDeniedHandler(new ADHandler())
            .and()
            .csrf()
            .disable()
            .formLogin()
            .loginPage("/security/to/login/page.html")
            .loginProcessingUrl("/security/do/login.html")
            .defaultSuccessUrl("/security/to/main/page.html")
            .usernameParameter("loginAcct")
            .passwordParameter("userPswd")
            .and()
            .logout()
            .logoutUrl("/security/do/logout.html")
            .logoutSuccessUrl("/security/to/login/page.html")
        ;
    }
}
