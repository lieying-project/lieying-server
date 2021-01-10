package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties(value = "handler")
@Table(name = "position_browse")
@Data
@Alias("PositionBrowse")
public class PositionBrowse implements Serializable {

    @Id
    @Column(name = "position_browse_id")
    private int id;

    @Column(name = "position_browse_created_time")
    private Date createdTime;

    @ManyToOne(targetEntity = JobHunter.class)
    @JoinColumn(name="job_hunter_id")
    private JobHunter jobHunter;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name="position_id")
    private Position position;


    //指数
    private Integer index;

    private Integer jobHunterId;
    private Integer positionId;
}
