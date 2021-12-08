package com.example.Unigram.Controllers;

import com.example.Unigram.DTO.FacultyDTO;
import com.example.Unigram.Models.Campus;
import com.example.Unigram.Models.Faculty;
import com.example.Unigram.Services.CampusService;
import com.example.Unigram.Services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private CampusService campusService;

    @PostMapping("/campus/{id}/faculties")
    public ResponseEntity<FacultyDTO> crateFaculty(@PathVariable("id") Integer campusId,
                                                   @RequestBody FacultyDTO facultyDTO) {

        Campus campus = campusService.getCampus(campusId);
        Faculty faculty = Faculty.createFaculty(facultyDTO);
        faculty.setCampus(campus);
        Faculty faculty1 = facultyService.createFaculty(faculty);
        FacultyDTO facultyDTO1 = FacultyDTO.createFacultyDTO(faculty);
        return ResponseEntity.ok(facultyDTO1);


    }

    @GetMapping("/faculties/{id}")
    public ResponseEntity<FacultyDTO> getFaculty(@PathVariable("id") Integer facultyId) {
        Faculty faculty = facultyService.getFaculty(facultyId);
        FacultyDTO facultyDTO = FacultyDTO.createFacultyWithAllData(faculty);
        return ResponseEntity.ok(facultyDTO);
    }

    @PutMapping("/faculties/{id}")
    public ResponseEntity<FacultyDTO> updateFaculty(@PathVariable("id") Integer facultyId,
                                                    @RequestBody FacultyDTO facultyDTO) {
        Faculty faculty = Faculty.createFaculty(facultyDTO);
        Faculty faculty1 = facultyService.updateFaculty(faculty, facultyId);
        FacultyDTO facultyDTO1 = FacultyDTO.createFacultyDTO(faculty1);
        return ResponseEntity.ok(facultyDTO1);
    }
    @DeleteMapping("/faculties{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable("id") Integer facultyId){
        facultyService.deleteFaculty(facultyId);
        return ResponseEntity.ok("faculty that you selected is deleted");
    }
}
