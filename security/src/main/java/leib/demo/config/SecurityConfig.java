package leib.demo.config;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author:Leib
 * @Date 2020/5/7 11:18
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应权限的人才能访问
        //super.configure(http);
        //请求授权规则 底层使用了AOP
        http.authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限的话 默认到登录界面
        //------> /login
        http.formLogin().loginPage("/login");

        //开启注销
        http.csrf().disable();//关闭跨站脚本
        http.logout().logoutSuccessUrl("/index");

        http.rememberMe().rememberMeParameter("remember");
    }

    //认证
    //密码编码:PasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //需要进行加密(如果不进行加密的话 会报错)
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("leib").password(new BCryptPasswordEncoder().encode("123")).roles("vip1")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("0000") ).roles("vip1","vip2","vip3");
    }
}
