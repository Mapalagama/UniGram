package com.example.Unigram.Models;

import com.example.Unigram.DTO.ContactDTO;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Contacts {
    private String land;
    private String mobile;
    private String fax;
    private String email;

    public static Contacts createContact(ContactDTO contactDTO){
        Contacts contacts = new Contacts();
        contacts.setLand(contactDTO.getLand());
        contacts.setMobile(contactDTO.getLand());
        contacts.setEmail(contactDTO.getEmail());
        contacts.setFax(contactDTO.getFax());
        return contacts;
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
