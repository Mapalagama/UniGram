package com.example.Unigram.DTO;

import com.example.Unigram.Models.Department;
import com.example.Unigram.Models.Program;

import java.util.ArrayList;

public class DepartmentDTO {
    private Integer id;
    private String name;
    private String departmentHead;

    private ContactDTO contactDTO;
    private ArrayList<ProgramDTO> programDTOArrayList;

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
    public static DepartmentDTO createDepartmentWithALlData(Department department){
        DepartmentDTO departmentDTO = createDepartmentDTO(department);
        departmentDTO.setProgramDTOArrayList(new ArrayList<>());
        for (Program program : department.getPrograms()){
            ProgramDTO programDTO = ProgramDTO.createProgramWithAllData(program);
            departmentDTO.getProgramDTOArrayList().add(programDTO);
        }
        return departmentDTO;
    }

    public ArrayList<ProgramDTO> getProgramDTOArrayList() {
        return programDTOArrayList;
    }

    public void setProgramDTOArrayList(ArrayList<ProgramDTO> programDTOArrayList) {
        this.programDTOArrayList = programDTOArrayList;
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
