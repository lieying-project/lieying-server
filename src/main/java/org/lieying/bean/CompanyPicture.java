package org.lieying.bean;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;


@Table(name = "company_picture")
@Data

public class CompanyPicture implements Serializable {
    @Id
    @Column(name = "company_picture_id")
    private Integer id;

    @Column(name = "company_picture_name", length = 15)
    private String name;

    @Column(name = "company_picture_path")
    private String path;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company_id")
    private Company company;

}
