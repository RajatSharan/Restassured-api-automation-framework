package getMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

public class SaveResponseAndGetBody {
    //This method saves the API response locally and extracts the content
    //for further processing/validation. Useful for debugging or reusing data.
    @Test
    public void saveResponseAndGetBody() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        Response response = given().when().get("/posts")
                .then()
                .extract().response(); //Saving the response
        assertThat(response.jsonPath().getList("title"), hasItems("qui est esse", "dolorem eum magni eos aperiam quia"));
    }
}
