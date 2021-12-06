package com.example.Unigram;

import com.example.Unigram.DTO.ContactDTO;
import com.example.Unigram.DTO.DepartmentDTO;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentControllerTest {

    Faker faker = new Faker();
    private static Integer facultyId = 15;
    private static Integer departmentId;

    @BeforeAll
    public static void beforeAll(){
        baseURI="http://localhost:8080";
    }

    @Test
    @Order(1)
    public void test_crate_department() {

        DepartmentDTO dto = new DepartmentDTO();
        dto.setName(faker.university().name());
        dto.setDepartmentHead(faker.name().fullName());
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setLand(faker.phoneNumber().extension());
        contactDTO.setMobile(faker.phoneNumber().cellPhone());
        contactDTO.setFax(faker.phoneNumber().extension());
        contactDTO.setEmail(faker.internet().emailAddress());
        dto.setContactDTO(contactDTO);

        Response response = given().contentType(ContentType.JSON)
                .body(dto)
                .when().post("/faculties/{id}/departments", facultyId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
        departmentId=response.jsonPath().getInt("id");

    }
    @Test
    @Order(2)
    public void test_get_department(){

        Response response = given().when().get("/departments/{id}", departmentId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
    }

    @Test
    @Order(3)
    public void test_put_department(){
        DepartmentDTO dto = new DepartmentDTO();
        dto.setName("testupdatedDepartment");
        dto.setDepartmentHead(faker.name().fullName());
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setLand(faker.phoneNumber().extension());
        contactDTO.setMobile(faker.phoneNumber().cellPhone());
        contactDTO.setFax(faker.phoneNumber().extension());
        contactDTO.setEmail(faker.internet().emailAddress());
        dto.setContactDTO(contactDTO);

        Response response = given().contentType(ContentType.JSON)
                .body(dto)
                .when().put("/departments/{id}", departmentId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
    }

    @Test
    @Order(4)
    public void test_delete_department(){
        Response response = given().when().delete("/departments/{id}", departmentId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
    }

}
