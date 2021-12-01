package com.example.Unigram;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String dean;
    private Date startedDate;
    @Embedded
    private Contacts contacts;
    private String photos;
    @ManyToOne
    private Campus campus;
    @OneToMany(mappedBy = "faculty")
    private List<Department> departments;

}
