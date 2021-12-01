package com.example.Unigram;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subject {
    @Id
    private String code;
    private String name;
    private Integer credit;
    private String semester;
    @ManyToOne
    private Program program;
}
