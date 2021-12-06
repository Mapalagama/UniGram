package com.example.Unigram.Controllers;

import com.example.Unigram.DTO.ProgramDTO;
import com.example.Unigram.Models.Department;
import com.example.Unigram.Models.Program;
import com.example.Unigram.Services.DepartmentService;
import com.example.Unigram.Services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgramContoller {

    @Autowired
    private ProgramService programService;
    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/departments/{id}/programmes")
    public ResponseEntity<ProgramDTO> createProgram(@RequestBody ProgramDTO programDTO,
                                                    @PathVariable("id") Integer departmentId){
        Department department = departmentService.getDepartment(departmentId);
        Program program = Program.createProgram(programDTO);
        program.setDepartment(department);
        programService.createProgram(program);
        ProgramDTO programDTO1 = ProgramDTO.createProgramDTO(program);
        return ResponseEntity.ok(programDTO1);

    }
}
