package getMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class ValidateResponseSize {
    //Asserts that the collection has the expected size
    @Test
    public void assertHasSize(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        Response response = given().when().get("/comments");
        assertThat(response.jsonPath().getList(""),hasSize(500));
    }
}
