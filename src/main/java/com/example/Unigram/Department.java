package com.example.Unigram;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String departmentHead;
    @Embedded
    private Contacts contacts;
    @ManyToOne
    private Faculty faculty;
    @OneToMany(mappedBy = "department")
    private List<Program> programs;

}


