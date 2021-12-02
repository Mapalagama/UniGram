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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChancellor() {
        return chancellor;
    }

    public void setChancellor(String chancellor) {
        this.chancellor = chancellor;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
