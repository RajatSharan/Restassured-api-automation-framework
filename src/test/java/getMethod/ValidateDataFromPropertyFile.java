package getMethod;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PropertyReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ValidateDataFromPropertyFile {

    @Test(groups = {"SmokeSuite","RegressionSuite"})
    public void validateDataFromPropertyFile() throws IOException {

        String serverAddress = PropertyReader.propertyReader("config.properties", "server");
        System.out.println(serverAddress);
        Response response = given().header("x-api-key", "reqres-free-v1").when().get(serverAddress).then().extract().response();


    }
}