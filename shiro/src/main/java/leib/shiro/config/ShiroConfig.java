package leib.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/5/7 13:39
 */
@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);


        //添加shiro的内置过滤器
        /*
        *   anno 无需认证
        *   authc 必须认证
        *   user 必须有 记住我 才能用
        *   perms 拥有对某个资源权限才能用
        *   role 拥有某个角色权限才能访问
        */
        //拦截
        Map<String,String> filterMap = new LinkedHashMap<>();
        //授权
        filterMap.put("/level1/1","perms[level]");

        filterMap.put("/level1/1","authc");
        filterMap.put("/level2/1","authc");
        filterMap.put("/level3/1","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录
        bean.setLoginUrl("/toLogin");
        //无权限时的跳转
        bean.setUnauthorizedUrl("/noauth");
        //成功登录时候的跳转
        bean.setSuccessUrl("/index");

        return bean;
    }


    //DefaultWebSecurityManager

    @Bean(name="securityManager")
    public DefaultWebSecurityManager  DefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    //创建 realm 对象
    @Bean(name="userRealm")
    public UserRealm userRealm(){
        return new UserRealm() ;
    }

    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
