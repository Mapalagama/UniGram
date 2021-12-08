package com.example.Unigram;
import com.example.Unigram.DTO.SubjectDTO;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SubjectControllerTest {
    Faker faker = new Faker();

    private static Integer subjectId;
    private static Integer programId=32;

    @BeforeAll
    public static void beforeAll(){
        baseURI="http://localhost:8080";
    }
    @Test
    @Order(1)
    public void test_create_subject(){
        SubjectDTO dto = new SubjectDTO();
        dto.setName(faker.country().name());
        dto.setCode(faker.code().asin());
        dto.setCredit(faker.number().numberBetween(1,10));
        dto.setSemester("semester2");

        Response response = given().contentType(ContentType.JSON)
                .body(dto)
                .when().post("/programmes/{id}/subjects", programId)
                .then().statusCode(200)
                .extract().response();
        response.prettyPrint();
        subjectId=response.jsonPath().getInt("id");

    }
    @Test
    @Order(2)
    public void test_get_subject(){
        Response response = given().when().get("/subjects/{id}",subjectId)
                .then().statusCode(200)
                .extract().response();
        response.prettyPrint();
    }

    @Test
    @Order(3)
    public void test_put_subject(){
        SubjectDTO dto = new SubjectDTO();
        dto.setName("testUpdatedSubject");
        dto.setCredit(faker.number().numberBetween(1,10));
        dto.setCode(faker.code().asin());
        dto.setSemester("semester 6");

        Response response = given().contentType(ContentType.JSON)
                .body(dto)
                .when().put("/subjects/{id}", subjectId)
                .then().statusCode(200)
                .extract().response();
        response.prettyPrint();
    }

    @Test
    @Order(4)
    public void test_delete_subject(){
        Response response = given().when().delete("/subjects/{id}", subjectId)
                .then().statusCode(200).extract().response();
        response.prettyPrint();
    }
}
