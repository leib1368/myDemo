package leib.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Leib
 * @Date 2020/5/7 15:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id ;
    private String name ;
    private String pwd ;
    private String perms ;
}
