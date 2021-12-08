package com.example.Unigram.Models;

import com.example.Unigram.DTO.SubjectDTO;
import com.example.Unigram.Models.Program;

import javax.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String code;
    private String name;
    private Integer credit;
    private String semester;
    @ManyToOne
    private Program program;

    public static Subject createSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setId(subjectDTO.getId());
        subject.setName(subjectDTO.getName());
        subject.setCode(subjectDTO.getCode());
        subject.setSemester(subjectDTO.getSemester());
        subject.setCredit(subjectDTO.getCredit());
        return subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
