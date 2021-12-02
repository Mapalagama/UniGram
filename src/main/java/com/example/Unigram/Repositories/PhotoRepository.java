package com.example.Unigram.Repositories;

import com.example.Unigram.Models.Photos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photos, Integer> {
}
