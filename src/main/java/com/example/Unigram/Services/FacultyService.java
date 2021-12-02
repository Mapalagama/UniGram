package com.example.Unigram.Services;

import com.example.Unigram.Models.Faculty;
import com.example.Unigram.Repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public void createFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Integer facultyId) {
        return facultyRepository.findById(facultyId).orElse(null);
    }

    public void updateFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public void deleteFaculty(Integer facultyId) {
        facultyRepository.deleteById(facultyId);
    }
}
