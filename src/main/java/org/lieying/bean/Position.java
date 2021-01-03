package org.lieying.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@JsonIgnoreProperties(value = "handler")
@Table(name = "position")
@Data
@Alias("Position")
public class Position implements Serializable {
    @Id
    @Column(name = "position_id")
    private Integer id;

    @Column(name = "position_name", length = 15)
    private String name;

    @Column(name = "position_salary")
    private String salary;

    @Column(name = "position_address", length = 40)
    private String address;

    @Column(name = "position_education", length = 6)
    private String education;

    @Column(name = "position_experience", length = 40)
    private String experience;

    @Column(name = "position_detail", length = 1000)
    private String detail;

    @Column(name="position_publish_time")
    private Date publishTime;

    @ManyToOne(targetEntity = Recruiter.class)
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;


    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(targetEntity = PositionCategory.class)
    @JoinColumn(name = "position_category_id")
    private PositionCategory positionCategory;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(targetEntity = Province.class)
    @JoinColumn(name = "province_id")
    private Province province;

    @ManyToOne(targetEntity = District.class)
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(mappedBy = "position")
    private Set<JobHunterReport> jobHunterReports;

    @OneToMany(mappedBy = "position")
    private Set<PositionCollect> positionCollects;

    @OneToMany(mappedBy = "position")
    private Set<Resume> resumes;

    @OneToMany(mappedBy = "position")
    private Set<PositionBrowse> positionBrowses;
}
