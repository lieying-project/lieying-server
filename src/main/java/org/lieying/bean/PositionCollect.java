package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@JsonIgnoreProperties(value = "handler")
@Table(name = "position_collect")
@Data

public class PositionCollect implements Serializable {

    @Id
    @Column(name = "position_collect_id")
    private Integer id;

    @Column(name = "position_collect_created_time")
    private java.util.Date createdTime;

    @ManyToOne(targetEntity = JobHunter.class)
    @JoinColumn(name = "job_hunter_id")
    private JobHunter jobHunter;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id")
    private Position position;

}
