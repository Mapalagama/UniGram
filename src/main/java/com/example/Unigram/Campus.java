package com.example.Unigram;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Campus {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String address;
    private String chancellor;
    private String founder;
    private Date startedDate;
    @Embedded
    private Contacts contacts;
    @OneToMany(mappedBy = "campus")
    private List<Photos> photos;
    @OneToMany(mappedBy = "campus")
    private List<Faculty> faculties;


}
