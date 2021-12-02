package com.example.Unigram.Services;

import com.example.Unigram.Models.Program;
import com.example.Unigram.Repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    public void createProgram(Program program) {
        programRepository.save(program);
    }

    public Program getProgram(Integer programId) {
        return programRepository.findById(programId).orElse(null);
    }

    public void updateProgram(Program program) {
        programRepository.save(program);
    }

    public void deleteProgram(Integer programId) {
        programRepository.deleteById(programId);
    }
}
