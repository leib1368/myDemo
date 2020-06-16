package leib.demo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:Leib
 * @Date 2020/6/5 9:05
 */
@Configuration
public class AppConfig {

    @Bean
    public User user() {
        System.out.println("1111");
        return new User();
    }

    @Bean
    public String name(User user) {
        System.out.println("name bean1:" + user.hashCode());
        System.out.println("name bean2:" + user().hashCode());
        return "123";
    }

    @Bean
    public String name1(User user) {
        System.out.println("name bean233:" + user.hashCode());
        System.out.println("name bean233:" + user().hashCode());
        return "123";
    }

}
