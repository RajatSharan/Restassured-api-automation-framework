package getMethod;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MultipleHeadersWithMapTest {

    @Test
    public void testMultipleHeadersWithMap() {

        Map<String,String> headers= new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key","reqres-free-v1");

        RestAssured.baseURI = "https://reqres.in/";

        given().headers(headers).when().get().then().statusCode(200);
        System.out.println("Multiple headers with map");

    }
}
