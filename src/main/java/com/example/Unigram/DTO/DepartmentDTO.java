package com.example.Unigram.DTO;

import com.example.Unigram.Models.Department;

public class DepartmentDTO {
    private Integer id;
    private String name;
    private String departmentHead;

    private ContactDTO contactDTO;

    public static DepartmentDTO createDepartmentDTO(Department department){
        DepartmentDTO departmentDTO =new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        departmentDTO.setDepartmentHead(department.getDepartmentHead());
        if (department.getContacts()!=null){
            departmentDTO.setContactDTO(ContactDTO.createContactDTO(department.getContacts()));
        }
        return departmentDTO;
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

    public ContactDTO getContactDTO() {
        return contactDTO;
    }

    public void setContactDTO(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
    }
}
