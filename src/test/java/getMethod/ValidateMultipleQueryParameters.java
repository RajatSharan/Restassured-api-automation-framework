package getMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ValidateMultipleQueryParameters {

    public void validateMultipleQueryParameters(){

        RestAssured.baseURI = "https://reqres.in";
        Response response=given().queryParam("page","2").queryParam("per_page","3").when().get().then().statusCode(200).extract().response();
    }
}
