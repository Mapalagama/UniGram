package com.example.Unigram;

import com.example.Unigram.DTO.ProgramDTO;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProgramControllerTest {
    Faker faker = new Faker();
    private Integer departmentId=22;
    private Integer programId;

    @BeforeAll
    public static void beforeAll(){
        baseURI="http://localhost:8080";
    }

    @Test
    @Order(1)
    public void test_create_program(){
        ProgramDTO dto =new ProgramDTO();
        dto.setName(faker.educator().course());
        dto.setDuration("3 years");
        dto.setContent(faker.lorem().paragraph());
        dto.setAbout(faker.lorem().paragraph(5));
        dto.setStartingDate(faker.date().future(2, TimeUnit.DAYS));

        Response response = given().contentType(ContentType.JSON)
                .body(dto)
                .when().post("/departments/{id}/programmes",departmentId    )
                .then().statusCode(200).extract().response();
        response.prettyPrint();
        programId=response.jsonPath().getInt("id");
    }
}
