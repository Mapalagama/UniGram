package com.example.Unigram;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Program {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String duration;
    private Date startingDate;
    private String about;
    private String content;
    @ManyToOne
    private Department department;
    @OneToMany(mappedBy = "program")
    private List<Subject> subjects;
}
