package com.example.Unigram.Repositories;

import com.example.Unigram.Models.Program;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends CrudRepository<Program, Integer> {
}
