package com.example.Unigram.Services;

import com.example.Unigram.Models.Campus;
import com.example.Unigram.Repositories.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CampusService {
    @Autowired
    private CampusRepository campusRepository;


    public Campus createCampus(Campus campus) {
        return campusRepository.save(campus);
    }

    public Campus getCampus(Integer campusId) {
        return campusRepository.findById(campusId).orElse(null);
    }

    public Campus updateCampus(Campus campus, Integer campusId) {
        Optional<Campus> campus1 = campusRepository.findById(campusId);
       Campus campus2 = campus1.get();
       campus.setId(campus2.getId());
        campusRepository.save(campus);
        return campus;
    }

    public void deleteCampus(Integer campusId) {
        campusRepository.deleteById(campusId);
    }


}
