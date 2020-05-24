package leib.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author:Leib
 * @Date 2020/5/24 19:28
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private String name ;
    private int age ;
}
