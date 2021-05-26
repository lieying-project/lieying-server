package org.lieying.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
@JsonIgnoreProperties(value = "handler")
@Table(name = "position_category")
@Data

public class PositionCategory implements Serializable {
    @Id
    @Column(name = "position_category_id")
    private Integer id;

    @Column(name = "position_category_name", length = 15)
    private String name;

    @ManyToOne(targetEntity = PositionCategory.class)
    @JoinColumn(name = "father_position_category_id")
    private PositionCategory fatherPositionCategory;

    @OneToMany(mappedBy="fatherPositionCategory")
    private Set<PositionCategory> sonPositionCategories;

    @OneToMany(mappedBy="positionCategory")
    private List<Position> positions;


}
