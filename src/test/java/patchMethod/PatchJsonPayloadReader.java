package patchMethod;

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

public class PatchJsonPayloadReader extends BaseTest {

    @Test
    public void patchJsonPayload() throws IOException {


        RestAssured.baseURI = "https://reqres.in/api/users/2";

        ExtentReport.extentLog = ExtentReport.extentReport.
                startTest("Test Read Patch Json Payload Successfully ", "Reads JSON payloads for PATCH API requests.");
        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                .body(IOUtils.toString(getFileInputStream("patchRequestBody.json"), StandardCharsets.UTF_8))
                .when().patch().then()
                .statusCode(StatusCode.SUCCESS.code)
                .extract().response();

        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println(response.getBody().asString());
    }
}

