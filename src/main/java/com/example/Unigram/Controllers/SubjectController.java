package com.example.Unigram.Controllers;

import com.example.Unigram.DTO.SubjectDTO;
import com.example.Unigram.Models.Program;
import com.example.Unigram.Models.Subject;
import com.example.Unigram.Services.ProgramService;
import com.example.Unigram.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ProgramService programService;

    @PostMapping("/programmes/{id}/subjects")
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO subjectDTO,
                                                    @PathVariable("id") Integer programId){
        Program program = programService.getProgram(programId);
        Subject subject = Subject.createSubject(subjectDTO);
        subject.setProgram(program);
        Subject subject1 = subjectService.createSubject(subject);
        SubjectDTO subjectDTO1 = SubjectDTO.createSubjectDTO(subject);
        return ResponseEntity.ok(subjectDTO1);
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<SubjectDTO> getSubject(@PathVariable("id") Integer subjectId){
        Subject subject = subjectService.getSubject(subjectId);
        SubjectDTO subjectDTO = SubjectDTO.createSubjectDTO(subject);
        return ResponseEntity.ok(subjectDTO);

    }

    @PutMapping("/subjects/{id}")
    public ResponseEntity<SubjectDTO> updateSubject(@RequestBody SubjectDTO subjectDTO ,
                                                    @PathVariable("id") Integer subjectId){
        Subject subject = Subject.createSubject(subjectDTO);
        Subject subject1 = subjectService.updateSubject(subject,subjectId);
        SubjectDTO subjectDTO1 = SubjectDTO.createSubjectDTO(subject1);
        return ResponseEntity.ok(subjectDTO1);
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") Integer subjectId){
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok("Subject that you selected is deleted");
    }

}
