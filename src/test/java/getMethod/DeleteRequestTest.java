package getMethod;

import core.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequestTest {

    @Test
    public void deleteRequest() {

        Response response = given().header("x-api-key", "reqres-free-v1").when().delete("https://reqres.in/api/users?page=2").then().extract().response();
        Assert.assertEquals(response.getStatusCode(), StatusCode.NO_Content.code);


    }
}
