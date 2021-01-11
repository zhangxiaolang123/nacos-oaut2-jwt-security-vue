package com.zxl.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(-1)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyLogoutSuccessHandler myLogoutSuccessHandler;




    /***
     * 忽略安全拦截的URL
     * @param web
     * @throws Exception
     */

    //@Autowired
   // AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
              //  "/user/login",
                "/user_auth/login",//我自己添加的
                "/user_auth/logout",
              //  "oauth/token",
                "/user_auth/loginSms",
                "/smsCode");
    }

    /***
     * 创建授权管理认证对象
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    /***
     * 采用BCryptPasswordEncoder对密码进行编码
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /****
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.antMatcher("/**").authorizeRequests();
        registry.and().logout().logoutUrl("/logout").logoutSuccessHandler(myLogoutSuccessHandler).deleteCookies("JSESSIONID").permitAll();
        http
                .authorizeRequests().antMatchers(
              //  "/user_auth/loginSms"
        )
                .permitAll().anyRequest().authenticated()
                //禁用跨站伪造
                .and()
                .csrf().disable()

            //    .addFilterBefore(smsCodeValidateFilter, UsernamePasswordAuthenticationFilter.class) //放到用户名密码登录过滤器之前执行


                .httpBasic()        //启用Http基本身份验证
                .and()
                .formLogin()      //启用表单身份验证
             //   .and() //将短信认证的config 加入到主配置文件中
               // .apply(smsCodeSecurityConfig) //将短信认证的config 加入到主配置文件中


                .and()

                .authorizeRequests()    //限制基于Request请求访问
                .anyRequest()
                .authenticated();       //其他请求都需要经过验证

    }
}
