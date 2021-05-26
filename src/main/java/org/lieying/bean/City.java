package org.lieying.bean;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table(name = "city")
@Data
@NoArgsConstructor
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
