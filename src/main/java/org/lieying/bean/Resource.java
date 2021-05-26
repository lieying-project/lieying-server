package org.lieying.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@JsonIgnoreProperties(value = "handler")
@Table(name = "resource")
@Data

public class Resource implements Serializable {
	@Id
	@Column(name = "resource_id")
	private Integer id;

	@Column(name="resource_name",length=15)
	private String name;

	@Column(name="resource_type",length=20)
	private String type;

	@Column(name="resource_path",length=1024)
	private String path;

	@Column(name="resource_cover",length=256)
	private String cover;

	@ManyToOne(targetEntity=Administrator.class)
	@JoinColumn(name="administrator_id")
	private Administrator administrator;
	
	@OneToMany(mappedBy="resource")
	private Set<JobHunterOrder> jobHunterOrders;

}
