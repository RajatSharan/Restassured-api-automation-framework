package getMethod;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FetchResponseHeadersTest {

    @Test
    public void fetchResponseHeaders(){

        RestAssured.baseURI="https://reqres.in/";
        Response response = given().header("x-api-key","reqres-free-v1").when().get("api/users?page=2").then().statusCode(200).extract().response();
        Headers headers = response.getHeaders();
        for(Header header : headers){
            if(header.getName().contains("Cf-Ray")) {
                System.out.println(header.getName() + " : " + header.getValue());
            }

        }

    }
}
