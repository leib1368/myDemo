package leib.travels.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author:Leib
 * @Date 2020/4/30 13:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain=true)
public class Province {
    private String id;
    private String name;
    private String tags;
    private Integer placecounts;

}
