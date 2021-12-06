package com.example.Unigram.Models;

import com.example.Unigram.DTO.DepartmentDTO;

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

    public static Department createDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setDepartmentHead(departmentDTO.getDepartmentHead());
        if (departmentDTO.getContactDTO()!=null){
            department.setContacts(Contacts.createContact(departmentDTO.getContactDTO()));
        }
        return department;
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

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }
}


