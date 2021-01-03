package org.lieying.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@JsonIgnoreProperties(value = "handler")
@Table(name="administrator")
@Alias("Administrator")
@Data
public class Administrator implements Serializable {
	@Id
	@Column(name="administrator_id")
	private Integer id;

	@Column(name="administrator_username",length=20,nullable=false,unique=true)
	private String username;

	@Column(name="administrator_password",length=18,nullable=false)
	private String password;

	@OneToMany(mappedBy="administrator",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Set<Information> informations;

	@OneToMany(mappedBy="administrator",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Set<Resource> resources;

}
