package leib.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Leib
 * @Date 2020/6/16 14:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer page;

    private Integer size;

    private Integer totalPage;
}
