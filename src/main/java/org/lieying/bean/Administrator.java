package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@JsonIgnoreProperties(value = "handler")
@Table(name="administrator")

@Data
public class Administrator implements Serializable {
	@Id
	@Column(name="administrator_id")
	private Integer id;

	@Column(name="administrator_username",length=20,nullable=false,unique=true)
	private String username;

	@Column(name="administrator_password",length=18,nullable=false)
	private String password;

	@OneToMany(mappedBy="administrator",cascade= CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Set<Information> informations;

	@OneToMany(mappedBy="administrator",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Set<Resource> resources;

}
