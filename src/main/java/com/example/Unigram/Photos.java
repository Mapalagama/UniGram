package com.example.Unigram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Photos {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne
    private Campus campus;
}
