package org.lieying.bean;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import javax.persistence.*;
import java.util.Date;
@Table(name="internship_experience")
@Data
@Alias("InternshipExperience")
public class InternshipExperience {

    @Id
    @Column(name="internship_experience_id")
    private Integer id;

    @Column(name="internship_experience_company",nullable=false)
    private String company;

    @Column(name="internship_experience_department")
    private String department;

    @Column(name="internship_experience_position_category")
    private String positionCategory;

    @Column(name="internship_experience_industry")
    private String industry;

    @Column(name="internship_experience_technology")
    private String technology;

    @Column(name="internship_experience_position_name")
    private String positionName;

    @Column(name="internship_experience_start_time")
    private Date startTime;

    @Column(name="internship_experience_end_time")
    private Date endTime;

    @Column(name="internship_experience_job_content",length = 1600)
    private String jobContent;

    @Column(name="internship_experience_job_performance",length = 300)
    private String jobPerformance;

    @ManyToOne(targetEntity=Resume.class)
    @JoinColumn(name="resume_id")
    private Resume resume;
}
