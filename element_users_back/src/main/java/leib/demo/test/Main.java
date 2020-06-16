package leib.demo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author:Leib
 * @Date 2020/6/5 9:05
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user.hashCode());
        context.close();
    }
}