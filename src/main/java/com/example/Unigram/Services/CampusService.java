package com.example.Unigram.Services;

import com.example.Unigram.Models.Campus;
import com.example.Unigram.Models.Photos;
import com.example.Unigram.Repositories.CampusRepository;
import com.example.Unigram.Repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Component
public class CampusService {
    @Autowired
    private CampusRepository campusRepository;
    @Autowired
    private PhotoRepository photoRepository;

    private static String uploadDir = "C:\\Users\\Miner\\Documents\\UniGram\\uploads";

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

    public Campus addfile(Integer campusId, MultipartFile image) {
//        generate random filename
        String fileName = UUID.randomUUID().toString() + ".jpg";
//        set path
        Path filepath = Paths.get(uploadDir, fileName);
        try {
//            tranfer the image to file path
            image.transferTo(filepath);
        } catch (IOException e) {
//            print error
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        Campus campus = getCampus(campusId);
        Photos photos = new Photos();
        photos.setName(fileName);
        photos.setCampus(campus);
        photoRepository.save(photos);
        Campus campus1 = getCampus(campusId);
        return campus1;

    }


}
