package getMethod;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetResponseBodyValidationTest {

    @Test(groups = "SmokeSuite")
    public void validateGetReponseBody() {
        //
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        given().when().get("/todos/1").then().assertThat().statusCode(200).body("id", equalTo(1)).body("title", equalTo("delectus aut autem"));
    }
}
