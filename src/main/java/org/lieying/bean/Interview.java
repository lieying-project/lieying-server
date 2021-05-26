package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(value = "handler")
@Table(name = "interview")
@Data

public class Interview {

    @Id
    @Column(name = "interview_id")
    private int id;

    @Column(name = "interview_start_time")
    private Date startTime;

    @Column(name = "interview_end_time")
    private Date endTime;

    @ManyToOne(targetEntity = Recruiter.class)
    @JoinColumn(name="recruiter_id")
    private Recruiter recruiter;

    @ManyToOne(targetEntity = JobHunter.class)
    @JoinColumn(name = "job_hunter_id")
    private JobHunter jobHunter;



}
