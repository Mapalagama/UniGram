package com.example.Unigram.Models;

import com.example.Unigram.DTO.CampusDTO;
import com.example.Unigram.DTO.FacultyDTO;
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
    private String address;
    private Date startedDate;
    @Embedded
    private Contacts contacts;
    private String photos;
    @ManyToOne
    private Campus campus;
    @OneToMany(mappedBy = "faculty")
    private List<Department> departments;

    public static Faculty createFaculty(FacultyDTO facultyDTO){
        Faculty faculty = new Faculty();
        faculty.setId(facultyDTO.getId());
        faculty.setName(facultyDTO.getName());
        faculty.setAddress(facultyDTO.getAddress());
        faculty.setDean(facultyDTO.getDean());
        faculty.setStartedDate(facultyDTO.getStartedDate());
        if (facultyDTO.getContactDTO()!=null){
            faculty.setContacts(Contacts.createContact(facultyDTO.getContactDTO()));
        }
        return faculty;


    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
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

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
