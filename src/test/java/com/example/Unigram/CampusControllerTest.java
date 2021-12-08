package com.example.Unigram;

import com.example.Unigram.DTO.CampusDTO;
import com.example.Unigram.DTO.ContactDTO;
import com.example.Unigram.Models.Campus;
import com.example.Unigram.Repositories.CampusRepository;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CampusControllerTest {

    Faker faker = new Faker();
    public static Integer campusId=26;

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://localhost:8080";
    }


    @Test
    @Order(1)
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
        campusId = response.jsonPath().getInt("id");
    }

    @Test
    @Order(20)
    public void test_get_campus() {
        Response response = given().when().get("/campus/{id}" , 26)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
    }

    @Test
    @Order(21)
    public void test_update_campus() {
        CampusDTO dto = new CampusDTO();
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
        dto.setName("testUpdate");
        Response response = given().contentType(ContentType.JSON)
                .body(dto)
                .when().put("/campus/{id}" ,campusId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
    }
    @Test
    @Order(285)
    public void test_delete_campus(){
        Response response = given().when().delete("/campus/{id}" , campusId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();


    }
    @Test
    @Order(25)
    public void test_upload_image(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("image1.jpg").getFile());

        Response response = given().contentType(ContentType.MULTIPART)
                .multiPart(file)
                .when().post("/campus/{id}/photos",campusId)
                .then().statusCode(200)
                .extract().response();
        response.prettyPrint();
    }


}
