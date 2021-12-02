package com.example.Unigram.Services;

import com.example.Unigram.Models.Campus;
import com.example.Unigram.Repositories.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public void updateCampus(Campus campus) {
        campusRepository.save(campus);
    }

    public void deleteCampus(Integer campusId) {
        campusRepository.deleteById(campusId);
    }


}
