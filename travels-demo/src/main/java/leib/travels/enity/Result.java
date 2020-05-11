package leib.travels.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author:Leib
 * @Date 2020/4/28 23:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Result {
    private Boolean state = true;
    private String msg;
    private String userId;
}

