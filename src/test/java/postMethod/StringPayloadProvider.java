package postMethod;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ExtentReport;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class StringPayloadProvider {

    @Test
    public void requestPayloadString() {


        RestAssured.baseURI= "https://reqres.in/api/users";

        ExtentReport.extentLog= ExtentReport.extentReport.
                startTest("verifySC200","Validate 200 status code - positive testcase");
        Response response = given()
                .header("x-api-key","reqres-free-v1")
                .header("Content-Type","application/json")
                .body("{\"name\":\"morpheus\",\"job\":\"leader\"}")
                .when().post().then()
                .statusCode(StatusCode.CREATED.code)
                .extract().response();

        assertEquals(response.getStatusCode(),StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());
    }
}
