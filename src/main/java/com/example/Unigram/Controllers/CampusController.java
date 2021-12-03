package com.example.Unigram.Controllers;

import com.example.Unigram.DTO.CampusDTO;
import com.example.Unigram.DTO.ContactDTO;
import com.example.Unigram.Models.Contacts;
import com.example.Unigram.Services.CampusService;
import com.example.Unigram.Models.Campus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/campus/{id}")
    public ResponseEntity<CampusDTO> getCampus(@PathVariable("id") Integer campusId) {
        Campus campus = campusService.getCampus(campusId);
        CampusDTO campusDTO = CampusDTO.createCampusDTO(campus);
        return ResponseEntity.ok(campusDTO);
    }

    @PutMapping("/campus/{id}")
    public ResponseEntity<CampusDTO> updateCampus(@PathVariable("id") Integer campusId,
                                                  @RequestBody CampusDTO campusDTO) {
       Campus campus = Campus.createcampus(campusDTO);
       Campus campus1 = campusService.updateCampus(campus,campusId);
       CampusDTO campusDTO1 = CampusDTO.createCampusDTO(campus1);
       return ResponseEntity.ok(campusDTO1);

    }
    @DeleteMapping("/campus/{id}")
    public ResponseEntity<String> deleteCampus(@PathVariable("id") Integer campusId){
        campusService.deleteCampus(campusId);
        return ResponseEntity.ok("Campus deleted");
    }
}
