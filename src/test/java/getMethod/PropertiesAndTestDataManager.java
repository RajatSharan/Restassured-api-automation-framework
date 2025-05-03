package getMethod;

import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.JsonReader;
import utils.PropertyReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PropertiesAndTestDataManager {

    @Test
    public void getConfigValue() throws IOException, ParseException {

        String serverAddress = PropertyReader.propertyReader("config.properties", "server");

        String endpoint = JsonReader.getTestData("endpoint");
        String url = serverAddress + endpoint;
        System.out.println(url);
        Response response = given().queryParam("page",2).when().get(url).then().extract().response();


    }
}
