package com.example.Unigram.DTO;

import com.example.Unigram.Models.Subject;

import javax.persistence.Column;

public class SubjectDTO {
    private Integer id;
    private String code;
    private String name;
    private Integer credit;
    private String semester;

    public static SubjectDTO createSubjectDTO(Subject subject) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());
        subjectDTO.setName(subject.getName());
        subjectDTO.setCode(subject.getCode());
        subjectDTO.setCredit(subject.getCredit());
        subjectDTO.setSemester(subject.getSemester());
        return subjectDTO;
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
}
