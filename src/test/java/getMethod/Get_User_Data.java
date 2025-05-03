package getMethod;

import core.StatusCode;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get_User_Data {

    @Test
    public void getUserData() {
        given().header("x-api-key", "reqres-free-v1").when().get("https://reqres.in/api/users/2").then().assertThat().statusCode(StatusCode.SUCCESS.code);
    }
}
