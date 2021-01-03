package org.lieying.bean;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.util.Set;

@Table(name = "city")
@Data
@Alias("City")
public class City {
    @Id
    @Column(name="city_id")
    private int id;

    @Column(name="city_name")
    private String name;

    @Column(name = "city_hot")
    private Boolean hot;

    @ManyToOne(targetEntity = Province.class)
    @JoinColumn(name ="province_id")
    private Province province;

    @OneToMany(mappedBy="city")
    private Set<District> districts;

    @OneToMany(mappedBy = "city")
    private Set<Position> positions;


    @OneToMany(mappedBy = "city")
    private Set<Company> companies;




}
