package com.example.Unigram.Services;

import com.example.Unigram.Models.Program;
import com.example.Unigram.Repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    public Program getProgram(Integer programId) {
        return programRepository.findById(programId).orElse(null);
    }

    public Program updateProgram(Program program,Integer programId) {

        Optional<Program> program1 = programRepository.findById(programId);
        Program program2 = program1.get();
        program.setId(program2.getId());
        program.setDepartment(program2.getDepartment());
        return programRepository.save(program);
    }

    public void deleteProgram(Integer programId) {
        programRepository.deleteById(programId);
    }
}
