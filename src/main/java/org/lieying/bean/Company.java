package org.lieying.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties(value = "handler")
@Table(name = "company")
@Data
@Alias("Company")
public class Company implements Serializable {

    @Id
    @Column(name = "company_id")
    private Integer id;

    @Column(name = "company_name", length = 15)
    private String name;

    @Column(name = "company_address", length = 40)
    private String address;

    @Column(name = "company_phone", length = 11)
    private String phone;

    @Column(name = "company_intro", length = 200)
    private String intro;

    @Column(name = "company_culture", length = 200)
    private String culture;

    @Column(name = "company_sign")
    private String sign;

    @Column(name = "company_license")
    private String license;

    @Column(name = "company_representative", length = 20)
    private String representative;

    @Column(name = "company_established")
    private Date established;

    @Column(name = "company_register_capital")
    private String registerCapital;

    @Column(name = "company_business_scope", length = 200)
    private String businessScope;

    @Column(name = "company_employee_welfare", length = 30)
    private String employeeWelfare;

    @Column(name = "company_work_time")
    private Date workTime;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(targetEntity = Industry.class)
    @JoinColumn(name="industry_id")
    private Industry industry;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<CompanyPicture> companyPictures;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Recruiter> recruiters;

    @OneToMany(mappedBy = "company")
    private Set<Position> positions;

    @OneToMany(targetEntity = CompanyScale.class)
    @JoinColumn(name="company_scale_id")
    private CompanyScale companyScale;

    @OneToMany(targetEntity = FinancingStage.class)
    @JoinColumn(name="financing_stage_id")
    private FinancingStage financingStage;
}
