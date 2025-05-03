package getMethod;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidateMultipleHeaderTest {
    @Test
    public void validatePathParameter(){
        RestAssured.baseURI = "https://ergast.com/";
        String raceSeason="2017";

        Response response = given().pathParams("raceSeason","2017").when().get("api/f1/{raceSeason}/circuits.json")
                .then().statusCode(StatusCode.SUCCESS.code).extract().response();
        //Reponse body in console.
        System.out.println(response.body().asString());

    }
}
