package com.example.Unigram.DTO;

import com.example.Unigram.Models.Contacts;

public class ContactDTO {
    private String land;
    private String mobile;
    private String fax;
    private String email;

    public static ContactDTO createContactDTO(Contacts contacts){
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setLand(contacts.getLand());
        contactDTO.setMobile(contacts.getMobile());
        contactDTO.setEmail(contacts.getEmail());
        contactDTO.setFax(contacts.getFax());
        return contactDTO;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
