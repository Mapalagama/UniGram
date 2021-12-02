package com.example.Unigram.Repositories;

import com.example.Unigram.Models.Campus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends CrudRepository<Campus, Integer> {
}
