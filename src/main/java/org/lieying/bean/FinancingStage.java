package org.lieying.bean;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import java.util.Set;

@Data

public class FinancingStage {

    @Id
    @Column(name = "financing_stage_id")
    private int id;

    @Column(name = "financing_stage_name")
    private String name;

    @Column(name = "financing_stage_intro")
    private String intro;

    @OneToMany(mappedBy = "financingStage")
    private Set<Company> companies;
}
