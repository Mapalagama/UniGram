package com.example.Unigram;

import com.example.Unigram.DTO.UserDTO;
import com.example.Unigram.Models.User;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {
    Faker faker = new Faker();

    @BeforeAll
    public static void beforeAll(){
        RestAssured.baseURI ="http://localhost:8080";
    }
    @Test
    @Order(1)
    public void test_login_user(){
        UserDTO dto = new UserDTO();

        dto.setEmail("kalanamapalagama.com");
        dto.setPassword("123456");

        Response response = given().contentType(ContentType.JSON)
                .body(dto)
                .when().post("/login")
                .then().statusCode(200)
                .extract().response();
        response.prettyPrint();
    }
}
