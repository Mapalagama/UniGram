package com.example.Unigram.DTO;

import com.example.Unigram.Models.Photos;

public class PhotosDTO {
    private Integer id;
    private String url;

    public static PhotosDTO createPhotoDTO(Photos photos) {
        PhotosDTO photosDTO = new PhotosDTO();
        photosDTO.setId(photos.getId());
        photosDTO.setUrl(photos.getName());
        return photosDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
