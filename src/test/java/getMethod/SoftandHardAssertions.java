package getMethod;

import core.StatusCode;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.JsonReader;
import utils.PropertyReader;
import utils.SoftAssertionUtill;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SoftandHardAssertions {

    //SoftAssertionUtill utill = new SoftAssertionUtill();
    @Test
    public void validateHardAssertions() {
        System.out.println("Hard Assertion");
        Assert.assertTrue(true);
        System.out.println("Hard Assertion Passed");

    }

    @Test
    public void validateSoftAssertions() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Soft Assertion");
        softAssert.assertTrue(false);
        System.out.println("Soft Assertion Passed");
        softAssert.assertTrue(true);
        System.out.println("Soft Assertion Passed");
        softAssert.assertAll();

    }
    // Using SoftAssert Utill class which is in Utill

    @Test
    public void validateSoftAssertionsUtill() throws IOException, ParseException {

        String serverAddress = PropertyReader.propertyReader("config.properties", "server");
        String endpoint = JsonReader.getTestData("endpoint");
        String url= serverAddress + endpoint;
        System.out.println(url);
        Response response = given().header("x-api-key", "reqres-free-v1").queryParam("page",2)
                .when().get(url).
                then().statusCode(200)
                .extract().response();

        SoftAssertionUtill.getInstance().assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code, "Status code is 200");
        SoftAssertionUtill.getInstance().assertAll();
        System.out.println("Soft Assertion Utill Passed");

    }

}

