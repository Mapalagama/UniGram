package com.example.Unigram.Models;

import com.example.Unigram.DTO.PhotosDTO;
import com.example.Unigram.Models.Campus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Photos {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne
    private Campus campus;

    public static Photos createPhotos(PhotosDTO photosDTO) {
        Photos photos = new Photos();
        photos.setId(photosDTO.getId());
        photos.setName(photosDTO.getUrl());
        return photos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
}
