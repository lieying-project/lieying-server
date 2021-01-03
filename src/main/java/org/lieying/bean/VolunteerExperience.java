package org.lieying.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.util.Date;

@Table(name="volunteer_experience")
@Data
@Alias("VolunteerExperience")
public class VolunteerExperience {

    @Id
    @Column(name="volunteer_experience_id")
    private Integer id;

    @Column(name="volunteer_experience_name",nullable=false)
    private String name;

    @Column(name="volunteer_experience_duration")
    private String duration;

    @Column(name="volunteer_experience_start_time")
    private Date startTime;

    @Column(name="volunteer_experience_end_time")
    private Date endTime;

    @Column(name="volunteer_experience_description",length = 1600)
    private String description;

    @ManyToOne(targetEntity=Resume.class)
    @JoinColumn(name="resume_id")
    private Resume resume;
}
