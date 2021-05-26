package org.lieying.bean;


import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data


public class Industry {
    @Id
    @Column(name = "industry_id")
    private int id;

    @Column(name = "industry_name")
    private String name;

    @Column(name = "industry_intro")
    private String intro;

    @OneToMany(mappedBy = "industry")
    private Set<Company> companies;

}
