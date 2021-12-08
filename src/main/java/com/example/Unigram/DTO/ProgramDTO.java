package com.example.Unigram.DTO;

import com.example.Unigram.Models.Program;
import com.example.Unigram.Models.Subject;

import javax.swing.plaf.SeparatorUI;
import java.util.ArrayList;
import java.util.Date;

public class ProgramDTO {
    private Integer id;
    private String name;
    private String duration;
    private Date startingDate;
    private String about;
    private String content;

    private ArrayList<SubjectDTO> subjectDTOArrayList;

    public static ProgramDTO createProgramDTO(Program program){
        ProgramDTO programDTO = new ProgramDTO();
        programDTO.setId(program.getId());
        programDTO.setName(program.getName());
        programDTO.setDuration(program.getDuration());
        programDTO.setStartingDate(program.getStartingDate());
        programDTO.setAbout(program.getAbout());
        programDTO.setContent(program.getContent());
        return programDTO;
    }

    public static ProgramDTO createProgramWithAllData(Program program){
        ProgramDTO programDTO = createProgramDTO(program);
        programDTO.setSubjectDTOArrayList(new ArrayList<>());
        for (Subject subject : program.getSubjects()){
            SubjectDTO subjectDTO = SubjectDTO.createSubjectDTO(subject);
            programDTO.getSubjectDTOArrayList().add(subjectDTO);
        }
        return programDTO;
    }


    public ArrayList<SubjectDTO> getSubjectDTOArrayList() {
        return subjectDTOArrayList;
    }

    public void setSubjectDTOArrayList(ArrayList<SubjectDTO> subjectDTOArrayList) {
        this.subjectDTOArrayList = subjectDTOArrayList;
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
}
