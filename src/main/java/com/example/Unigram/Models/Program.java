package com.example.Unigram.Models;

import com.example.Unigram.DTO.ProgramDTO;

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
    @Column(name = "about", nullable = false,  length = 10000)
    private String about;
    private String content;
    @ManyToOne
    private Department department;
    @OneToMany(mappedBy = "program")
    private List<Subject> subjects;

    public static Program createProgram(ProgramDTO programDTO){
        Program program = new Program();
        program.setId(programDTO.getId());
        program.setName(programDTO.getName());
        program.setAbout(programDTO.getAbout());
        program.setContent(programDTO.getContent());
        program.setDuration(programDTO.getDuration());
        program.setStartingDate(programDTO.getStartingDate());
        return program;

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
