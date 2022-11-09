package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Random;

public class D01_CreateNewBoard {

    // Step1 : I'm authenticated user
    @Given("I am an authenticated user")
    public void getToken(){
        // Rest Assured Non-BDD
        RestAssured.baseURI="https://simple-books-api.glitch.me/api-clients";

        RequestSpecification request=RestAssured.given();

        request.contentType("application/json");

        request.body("{\"clientName\": \"Postman\",\"clientEmail\": \"shady2@example.com\"}");

        Response response=request.post();

        JsonPath path=response.jsonPath();

        String token= path.getString("accessToken");

        //print token
        System.out.println(token);
    }

    // Step2 : Select available book and get id
    @When("select available book and get id")
    public void selectAvailableBookAndGetId() {
        // Rest Assured BDD
        Response response=RestAssured.given().baseUri("https://simple-books-api.glitch.me")
                .basePath("books")
                .when().get();

        // select random available book
        // 1- filter all available books
        JsonPath path=response.jsonPath();
        List<Integer> booksId =path.getList("findAll{it.available == true}.id");

        System.out.println(booksId);

        Random rand=new Random();

        int bookId=booksId.get(rand.nextInt(booksId.size()));

        System.out.println(bookId);

    }
    // Step3 : submit valid order on selected book
    @Then("Submit valid order on selected book")
    public void submitValidOrderOnSelectedBook() {

    }

}
