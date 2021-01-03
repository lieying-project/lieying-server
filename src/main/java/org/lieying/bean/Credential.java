package org.lieying.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
@JsonIgnoreProperties(value = "handler")
@Table(name = "credential")
@Data
@Alias("Credential")
public class Credential implements Serializable {
	@Id
	@Column(name = "credential_id")
	private Integer id;

	@Column(name = "credential_name")
	private String name;

	@Column(name = "credential_photo")
	private String photo;
	
	@ManyToOne(targetEntity=Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
}
