package com.example.Unigram.DTO;

import com.example.Unigram.Models.Faculty;

import java.util.Date;

public class FacultyDTO {
    private Integer id;
    private String name;
    private String dean;
    private Date startedDate;
    private String address;

    private ContactDTO contactDTO;

    public static FacultyDTO createFacultyDTO(Faculty faculty) {

        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setId(faculty.getId());
        facultyDTO.setName(faculty.getName());
        facultyDTO.setDean(faculty.getDean());
        facultyDTO.setStartedDate(faculty.getStartedDate());
        if (faculty.getContacts()!=null){
            facultyDTO.setContactDTO(ContactDTO.createContactDTO(faculty.getContacts()));
        }
        return facultyDTO;
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

    public ContactDTO getContactDTO() {
        return contactDTO;
    }

    public void setContactDTO(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
    }
}
