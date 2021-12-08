package com.example.Unigram.DTO;

import com.example.Unigram.Models.Campus;
import com.example.Unigram.Models.Department;
import com.example.Unigram.Models.Faculty;
import com.example.Unigram.Models.Photos;

import java.util.ArrayList;
import java.util.Date;

public class CampusDTO {
    private Integer id;
    private String name;
    private String address;
    private String chancellor;
    private String founder;
    private Date startedDate;

    private ContactDTO contactDTO;
    private ArrayList<PhotosDTO> photosDTOArrayList;
    private ArrayList<FacultyDTO> facultyDTOArrayList;


    public static CampusDTO createCampusDTO(Campus campus) {
        CampusDTO campusDTO1 = new CampusDTO();
        campusDTO1.setId(campus.getId());
        campusDTO1.setName(campus.getName());
        campusDTO1.setAddress(campus.getAddress());
        campusDTO1.setChancellor(campus.getChancellor());
        campusDTO1.setFounder(campus.getFounder());
        campusDTO1.setStartedDate(campus.getStartedDate());
        if (campus.getContacts() != null) {
            campusDTO1.setContactDTO(ContactDTO.createContactDTO(campus.getContacts()));
        }
        if (campus.getPhotos() != null) {
            campusDTO1.setPhotosDTOArrayList(new ArrayList<>());
            for (Photos photos : campus.getPhotos()) {
                PhotosDTO photosDTO = PhotosDTO.createPhotoDTO(photos);
                campusDTO1.getPhotosDTOArrayList().add(photosDTO);

            }

        }
        return campusDTO1;
    }

    public static CampusDTO createCampusWithAllDate(Campus campus){
        CampusDTO campusDTO =createCampusDTO(campus);
        campusDTO.setFacultyDTOArrayList(new ArrayList<>());
        for (Faculty faculty: campus.getFaculties()){
            FacultyDTO facultyDTO = FacultyDTO.createFacultyWithAllData(faculty);
            campusDTO.getFacultyDTOArrayList().add(facultyDTO);
        }
        return campusDTO;
    }

    public ArrayList<FacultyDTO> getFacultyDTOArrayList() {
        return facultyDTOArrayList;
    }

    public void setFacultyDTOArrayList(ArrayList<FacultyDTO> facultyDTOArrayList) {
        this.facultyDTOArrayList = facultyDTOArrayList;
    }

    public ArrayList<PhotosDTO> getPhotosDTOArrayList() {
        return photosDTOArrayList;
    }

    public void setPhotosDTOArrayList(ArrayList<PhotosDTO> photosDTOArrayList) {
        this.photosDTOArrayList = photosDTOArrayList;
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
