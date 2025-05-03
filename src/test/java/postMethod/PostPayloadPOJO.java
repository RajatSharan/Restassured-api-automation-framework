package postMethod;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.cityRequest;
import pojo.postRequestBody;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class PostPayloadPOJO{

    @Test
    public void validatePostWithPojo() {

        // ExtentReport.extentLog= ExtentReport.extentReport.
        //         startTest("testReadPostJsonPayloadSuccessfully ","Reads JSON payloads for POST API requests.");
        postRequestBody postRequest = new postRequestBody();
        postRequest.setName("morpheus");
        postRequest.setJob("leader");

        RestAssured.baseURI = "https://reqres.in/api/users/";
        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                .body(postRequest)
                .when().post().then()
                .statusCode(StatusCode.CREATED.code)
                .extract().response();

        assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());

    }

    @Test
    public void validatePostWithPojoList() {

//        ExtentReport.extentLog= ExtentReport.extentReport.
//                startTest("testReadPostJsonPayloadSuccessfully ","Reads JSON payloads for POST API requests.");
        List<String> listLanguage = new ArrayList<>();
        listLanguage.add("Java");
        listLanguage.add("Python");

        cityRequest cityRequest1 = new cityRequest();
        cityRequest1.setName("Jaipur");
        cityRequest1.setName("39.5");
        cityRequest cityRequest2 = new cityRequest();
        cityRequest2.setName("Delhi");
        cityRequest2.setName("34");

        List<cityRequest> cityRequestList = new ArrayList<>();
        cityRequestList.add(cityRequest1);
        cityRequestList.add(cityRequest2);


        postRequestBody postRequest = new postRequestBody();
        postRequest.setName("morpheus");
        postRequest.setJob("leader");
        postRequest.setLanguages(listLanguage);
        postRequest.setCityRequests(cityRequestList);

        RestAssured.baseURI = "https://reqres.in/api/users/";
        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                .body(postRequest)
                .when().post().then()
                .statusCode(StatusCode.CREATED.code)
                .extract().response();

        assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());

    }

    @Test
    public void ValidatePostWithPojoDeserialization() {

        postRequestBody postRequest = new postRequestBody();
        postRequest.setName("morpheus");
        postRequest.setJob("leader");

        RestAssured.baseURI = "https://reqres.in/api/users/";
        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                .body(postRequest)
                .when().post();

        postRequestBody reponseBody = response.as(postRequestBody.class);
        System.out.println(reponseBody.getJob());

        assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());


    }
}

