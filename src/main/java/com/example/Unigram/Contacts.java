package com.example.Unigram;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Contacts {
    private String land;
    private String mobile;
    private String fax;
    private String email;
    }
