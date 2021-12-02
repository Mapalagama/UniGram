package com.example.Unigram.Services;

import com.example.Unigram.Models.Subject;
import com.example.Unigram.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public void createSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public Subject getSubject(Integer subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public void updateSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(Integer subjectId) {
        subjectRepository.deleteById(subjectId);
    }

}
