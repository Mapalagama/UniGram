package com.example.Unigram.Models;

import com.example.Unigram.Models.Campus;
import com.example.Unigram.Models.Contacts;
import com.example.Unigram.Models.Department;

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
