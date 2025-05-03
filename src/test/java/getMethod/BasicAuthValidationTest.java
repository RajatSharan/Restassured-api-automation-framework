package getMethod;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicAuthValidationTest {

    @Test
    public void validateBasicAuthentication() {

        Response response = given()
                .auth()
                .basic("postman", "password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().extract().response();
    }
}
