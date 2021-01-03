package org.lieying.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties(value = "handler")
@Table(name = "job_hunter_order")
@Data
@Alias("JobHunterOrder")
public class JobHunterOrder implements Serializable {

	@Id
	@Column(name="job_hunter_order_id")
	private Integer id;

	@Column(name="job_hunter_order_state")
	private String state;
	
	@Column(name="job_hunter_order_created_time")
	private Date createdTime;
	
	@Column(name="job_hunter_order_pay_time")
	private Date payTime;

	@ManyToOne(targetEntity=JobHunter.class)
	@JoinColumn(name="job_hunter_id")
	private JobHunter jobHunter;

	@ManyToOne(targetEntity=Resource.class)
	@JoinColumn(name="resource_id")
	private Resource resource;

}
