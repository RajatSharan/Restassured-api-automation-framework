package getMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class DigestAuthTest {

    @Test
    public void testDigestAuth() {

        RestAssured.baseURI = "https://postman-echo.com";

        Response response= given().auth().digest("postman","password").when().get("/digest-auth").then().extract().response();
        int actual = response.getStatusCode();
        assertEquals(actual, 200);
    }
    //Using TestData file
    @Test
    public void validateTestDataFromJSON() throws IOException, ParseException {
        String username = JsonReader.getTestData("username");
        String password = JsonReader.getTestData("password");
        RestAssured.baseURI = "https://postman-echo.com";
        Response response= given().auth().digest(username,password).when().get("/digest-auth").then().extract().response();
        int actual = response.getStatusCode();
        assertEquals(actual, 200);

    }
}
