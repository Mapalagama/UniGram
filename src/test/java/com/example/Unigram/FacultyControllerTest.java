package com.example.Unigram;

import com.example.Unigram.DTO.ContactDTO;
import com.example.Unigram.DTO.FacultyDTO;
import com.example.Unigram.Models.Campus;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FacultyControllerTest {
    Faker faker = new Faker();

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    public static Integer campusId=26;
    public static Integer facultyId;

    @Test
    @Order(1)
    public void test_create_faculty() {
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setName(faker.university().name());
        facultyDTO.setDean(faker.name().fullName());
        facultyDTO.setStartedDate(faker.date().birthday());
        facultyDTO.setAddress(faker.address().fullAddress());
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setLand(faker.phoneNumber().phoneNumber());
        contactDTO.setMobile(faker.phoneNumber().cellPhone());
        contactDTO.setFax(faker.phoneNumber().phoneNumber());
        contactDTO.setEmail(faker.internet().emailAddress());
        facultyDTO.setContactDTO(contactDTO);


        Response response = given().contentType(ContentType.JSON)
                .body(facultyDTO).when().post("/campus/{id}/faculties", campusId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
        facultyId = response.jsonPath().getInt("id");

    }
    @Test
    @Order(2)
    public void test_get_faculty(){
        Response response = given().header("auth","kalanamapalagama.com").when().get("/faculties/{id}", 30)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
    }
    @Test
    @Order(3)
    public void test_put_faculty(){
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setName("testfacultyUpdate");
        facultyDTO.setDean(faker.name().fullName());
        facultyDTO.setAddress(faker.address().fullAddress());
        facultyDTO.setStartedDate(faker.date().birthday());
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setLand(faker.phoneNumber().extension());
        contactDTO.setMobile(faker.phoneNumber().cellPhone());
        contactDTO.setFax(faker.phoneNumber().extension());
        contactDTO.setEmail(faker.internet().emailAddress());
        facultyDTO.setContactDTO(contactDTO);

        Response response = given().contentType(ContentType.JSON)
                .body(facultyDTO).when().put("/faculties/{id}", facultyId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();

    }
    @Test
    @Order(4)
    public void test_delete_faculty(){
        Response response = given().when().delete("/faculties{id}", facultyId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
    }

}
