package org.lieying.bean;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table(name = "province")
@Data

public class Province {
    @Id
    @Column(name="province_id")
    private int id;

    @Column(name="province_name")
    private String name;

    @OneToMany(mappedBy="province")
    private Set<City> cities;

    @OneToMany(mappedBy = "province")
    private Set<Position> positions;
}
