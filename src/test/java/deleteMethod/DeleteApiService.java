package deleteMethod;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class DeleteApiService {

    @Test
    public void validateDeleteApi() {

        RestAssured.baseURI = "https://reqres.in/api/users/2";

        Response response = given()
                .header("x-api-key","reqres-free-v1")
                .header("Content-Type","application/json")
                .when().delete().then()
                .statusCode(StatusCode.NO_Content.code)
                .extract().response();

        assertEquals(response.getStatusCode(),StatusCode.NO_Content.code);
        System.out.println(response.getBody().asString());


    }
}
