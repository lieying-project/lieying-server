package org.lieying.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 关系数据
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelateDTO {
    //用户id
    private Integer useId;
    //业务id
    private Integer moduleId;
    //指数
    private Integer index;


}
