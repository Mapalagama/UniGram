package com.example.Unigram.Controllers;

import com.example.Unigram.DTO.DepartmentDTO;
import com.example.Unigram.Models.Department;
import com.example.Unigram.Models.Faculty;
import com.example.Unigram.Services.DepartmentService;
import com.example.Unigram.Services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/faculties/{id}/departments")
    public ResponseEntity<DepartmentDTO> createDepartment(@PathVariable("id") Integer facultyId,
                                                          @RequestBody DepartmentDTO departmentDTO) {
        Faculty faculty = facultyService.getFaculty(facultyId);
        Department department = Department.createDepartment(departmentDTO);
        department.setFaculty(faculty);
        Department department1 = departmentService.createDepartment(department);
        DepartmentDTO departmentDTO1 = DepartmentDTO.createDepartmentDTO(department1);
        return ResponseEntity.ok(departmentDTO1);

    }
    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("id") Integer departmentId){
        Department department = departmentService.getDepartment(departmentId);
        DepartmentDTO departmentDTO = DepartmentDTO.createDepartmentDTO(department);
        return ResponseEntity.ok(departmentDTO);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO ,
                                                          @PathVariable("id") Integer departmentId){
       Department department = Department.createDepartment(departmentDTO);
       Department department1 = departmentService.updateDepartment(department,departmentId);
       DepartmentDTO departmentDTO1 = DepartmentDTO.createDepartmentDTO(department1);
       return ResponseEntity.ok(departmentDTO1);


    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id")Integer departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department that you selected is deleted");
    }

}
