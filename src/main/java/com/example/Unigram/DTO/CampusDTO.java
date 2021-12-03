package com.example.Unigram.DTO;

import com.example.Unigram.Models.Campus;

import java.util.Date;

public class CampusDTO {
    private Integer id;
    private String name;
    private String address;
    private String chancellor;
    private String founder;
    private Date startedDate;

    private ContactDTO contactDTO;

    public static CampusDTO createCampusDTO(Campus campus){
        CampusDTO campusDTO1 = new CampusDTO();
        campusDTO1.setId(campus.getId());
        campusDTO1.setName(campus.getName());
        campusDTO1.setAddress(campus.getAddress());
        campusDTO1.setChancellor(campus.getChancellor());
        campusDTO1.setFounder(campus.getFounder());
        campusDTO1.setStartedDate(campus.getStartedDate());
        if(campus.getContacts()!=null) {
            campusDTO1.setContactDTO(ContactDTO.createContactDTO(campus.getContacts()));
        }
        return campusDTO1;
    }

    public ContactDTO getContactDTO() {
        return contactDTO;
    }

    public void setContactDTO(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
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
}
