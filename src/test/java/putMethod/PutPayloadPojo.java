package putMethod;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.postRequestBody;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PutPayloadPojo {

    @Test
    public void putPayloadPojo() {

        List<String> language = new ArrayList<>();
        language.add("Java");
        language.add("Javascript");
        postRequestBody putRequest = new postRequestBody();
        putRequest.setName("Rajat");
        putRequest.setJob("LeadSDET");
        putRequest.setLanguages(language);

        RestAssured.baseURI = "https://reqres.in/api/users/2";
        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                .body(putRequest)
                .when().patch().then()
                .statusCode(StatusCode.SUCCESS.code)
                .extract().response();

        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println(response.getBody().asString());

    }
}
