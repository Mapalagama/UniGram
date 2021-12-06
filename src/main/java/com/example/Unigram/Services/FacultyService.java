package com.example.Unigram.Services;

import com.example.Unigram.Models.Faculty;
import com.example.Unigram.Repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Integer facultyId) {
        return facultyRepository.findById(facultyId).orElse(null);
    }

    public Faculty updateFaculty(Faculty faculty,Integer facultyId) {
        Optional<Faculty> faculty1 = facultyRepository.findById(facultyId);
        Faculty faculty2 = faculty1.get();
        faculty.setId(faculty2.getId());
        faculty.setCampus(faculty2.getCampus());
        facultyRepository.save(faculty);
        return faculty;

    }

    public void deleteFaculty(Integer facultyId) {
        facultyRepository.deleteById(facultyId);
    }
}
