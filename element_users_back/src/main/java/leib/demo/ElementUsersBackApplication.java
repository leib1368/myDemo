package leib.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("leib.demo.mapper")
public class ElementUsersBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElementUsersBackApplication.class, args);
    }

}
