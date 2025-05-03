package putMethod;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PutRequest {

    @Test
    public void putRequest() {

        RestAssured.baseURI= "https://reqres.in/api/users/2";

        Response response= given()
                .header("x-api-key","reqres-free-v1")
                .header("Content-Type","application/json")
                .body("{\"name\":\"morpheus\",\"job\":\"zionresident\"}")
                .when().put().then()
                .statusCode(StatusCode.SUCCESS.code)
                .extract().response();

        assertEquals(response.getStatusCode(),StatusCode.SUCCESS.code);
        System.out.println(response.getBody().asString());
    }
}

