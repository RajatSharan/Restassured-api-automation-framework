package getMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class ContainsMatchValidationTest {
    @Test(groups={"SmokeSuite","RegressionSuite"})
    public void assertContainsMatch(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        Response response = given().when().get("/comments?postId=1");
        List<String> expectedEmails= Arrays.asList("Eliseo@gardner.biz","Jayne_Kuhic@sydney.com","Nikita@garfield.biz","Lew@alysha.tv","Hayden@althea.biz");
        assertThat(response.jsonPath().getList("email"), contains(expectedEmails.toArray(new String[0])));
    }
}
