package org.lieying.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Alias("CompanyScale")
@Data
public class CompanyScale {
    @Id
    @Column(name="company_scale_id")
    private int id;

    @Column(name="company_scale_name")
    private String name;

    @OneToMany(mappedBy = "companyScale")
    private Set<Company> companies;
}
