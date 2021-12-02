package com.example.Unigram.Controllers;

import com.example.Unigram.DTO.CampusDTO;
import com.example.Unigram.DTO.ContactDTO;
import com.example.Unigram.Models.Contacts;
import com.example.Unigram.Services.CampusService;
import com.example.Unigram.Models.Campus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CampusController {

    @Autowired
    private CampusService campusService;

    @PostMapping("/campus")
    public ResponseEntity<CampusDTO> createCampus(@RequestBody CampusDTO campusDTO) {
        Campus campus = Campus.createcampus(campusDTO);
        Campus createdCampus = campusService.createCampus(campus);
        CampusDTO createdCampusDTO = CampusDTO.createCampusDTO(createdCampus);
        return ResponseEntity.ok(createdCampusDTO);


    }
}
