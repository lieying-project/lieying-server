package org.lieying.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务项
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Integer id;
    private String name;
    private String date;
    private String link;

}
