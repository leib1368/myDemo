package leib.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author:Leib
 * @Date 2020/5/16 12:28
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//企业中所有的pojo都会序列化
public class User implements Serializable {
    private String username ;
    private int age ;
}
