package postMethod;

import core.BaseTest;
import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import utils.ExtentReport;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.RequestBodyReader.getFileInputStream;

public class PostJsonPayloadReader extends BaseTest {

    @Test
    public void jsonPayloadReader() throws IOException  {

        RestAssured.baseURI = "https://reqres.in/api/users";
        ExtentReport.extentLog= ExtentReport.extentReport.
                startTest("testReadPostJsonPayloadSuccessfully ","Reads JSON payloads for POST API requests.");
        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                .body(IOUtils.toString(getFileInputStream("postRequestBody.json"),StandardCharsets.UTF_8))
                .when().post().then()
                .statusCode(StatusCode.CREATED.code)
                .extract().response();

        assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());
    }
}

