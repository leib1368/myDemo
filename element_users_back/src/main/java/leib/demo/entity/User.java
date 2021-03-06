package leib.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author:Leib
 * @Date 2020/5/23 16:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
    private int id;
    private String userName;
    private String password;
//@JsonFormat(pattern = "yyyy-MM-dd")
//    private Date bir;
//    private String sex;
//    private String address;

}