package com.example.Unigram;

import com.example.Unigram.DTO.CampusDTO;
import com.example.Unigram.DTO.ContactDTO;
import com.example.Unigram.Repositories.CampusRepository;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class CampusControllerTest {
    Faker faker = new Faker();

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://localhost:8080";
    }


    @Test
    public void test_create_campus() {
        CampusDTO dto = new CampusDTO();
        String s = faker.name().fullName();
        dto.setName(s);
        dto.setAddress(faker.address().fullAddress());
        dto.setChancellor(faker.name().fullName());
        dto.setFounder(faker.name().fullName());
        dto.setStartedDate(faker.date().past(20, TimeUnit.DAYS));
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setLand(faker.phoneNumber().extension());
        contactDTO.setMobile(faker.phoneNumber().cellPhone());
        contactDTO.setEmail(faker.internet().emailAddress());
        contactDTO.setFax(faker.phoneNumber().extension());
        dto.setContactDTO(contactDTO);

        Response response = given().contentType(ContentType.JSON)
                .body(dto)
                .when().post("/campus")
                .then().statusCode(200).extract().response();
        response.prettyPrint();
    }


}
