package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(value = "handler")
@Table(name = "job_hunter_browse")
@Data
@Alias("JobHunterBrowse")
public class JobHunterBrowse {

    @Id
    @Column(name = "job_hunter_browse_id")
    private int id;

    @Column(name = "job_hunter_browse_created_time")
    private Date createdTime;

    @ManyToOne(targetEntity = Recruiter.class)
    @JoinColumn(name="recruiter_id")
    private Recruiter recruiter;

    @ManyToOne(targetEntity = JobHunter.class)
    @JoinColumn(name="job_hunter_id")
    private JobHunter jobHunter;



}
