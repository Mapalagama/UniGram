package com.example.Unigram.Controllers;

import com.example.Unigram.DTO.ProgramDTO;
import com.example.Unigram.Models.Department;
import com.example.Unigram.Models.Program;
import com.example.Unigram.Services.DepartmentService;
import com.example.Unigram.Services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProgramContoller {

    @Autowired
    private ProgramService programService;
    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/departments/{id}/programmes")
    public ResponseEntity<ProgramDTO> createProgram(@RequestBody ProgramDTO programDTO,
                                                    @PathVariable("id") Integer departmentId) {
        Department department = departmentService.getDepartment(departmentId);
        Program program = Program.createProgram(programDTO);
        program.setDepartment(department);
        programService.createProgram(program);
        ProgramDTO programDTO1 = ProgramDTO.createProgramDTO(program);
        return ResponseEntity.ok(programDTO1);

    }

    @GetMapping("/programmes/{id}")
    public ResponseEntity<ProgramDTO> getProgram(@PathVariable("id") Integer programId) {
        Program program = programService.getProgram(programId);
        ProgramDTO programDTO = ProgramDTO.createProgramWithAllData(program);
        return ResponseEntity.ok(programDTO);
    }

    @PutMapping("/programmes/{id}")
    public ResponseEntity<ProgramDTO> updateProgram(@RequestBody ProgramDTO programDTO,
                                                    @PathVariable("id") Integer programId) {
        Program program = Program.createProgram(programDTO);
        Program program1 = programService.updateProgram(program, programId);
        ProgramDTO programDTO1 = ProgramDTO.createProgramDTO(program1);
        return ResponseEntity.ok(programDTO1);

    }

    @DeleteMapping("/programmes/{id}")
    public ResponseEntity<String> deleteProgram(@PathVariable("id") Integer programId) {
        programService.deleteProgram(programId);
        return ResponseEntity.ok("Program that you seletected is deleted");
    }
}
