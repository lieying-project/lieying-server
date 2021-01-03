package org.lieying.bean;


		import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
		import lombok.Data;
		import org.apache.ibatis.type.Alias;

		import javax.persistence.*;
		import java.io.Serializable;
		import java.util.Date;
@JsonIgnoreProperties(value = "handler")
@Table(name = "information")
@Data
@Alias("Information")
public class Information implements Serializable {
	@Id
	@Column(name = "information_id")
	private Integer id;

	@Column(name = "information_title", length = 40)
	private String title;

	@Column(name = "information_content", columnDefinition = "text")
	private String content;

	@Column(name = "information_created_time")
	private Date createdTime;

	@Column(name = "information_type", length = 20)
	private String type;

	@ManyToOne(targetEntity=Administrator.class)
	@JoinColumn(name="administrator_id")
	private Administrator administrator;


}
