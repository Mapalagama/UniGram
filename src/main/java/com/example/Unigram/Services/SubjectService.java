package com.example.Unigram.Services;

import com.example.Unigram.Models.Subject;
import com.example.Unigram.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubject(Integer subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public Subject updateSubject(Subject subject,Integer subjectId) {
        Optional<Subject> subject1 = subjectRepository.findById(subjectId);
        Subject subject2 = subject1.get();
        subject.setId(subject2.getId());
        subject.setProgram(subject2.getProgram());
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Integer subjectId) {
        subjectRepository.deleteById(subjectId);
    }

}
