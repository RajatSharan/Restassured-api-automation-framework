package putMethod;

import core.BaseTest;
import core.StatusCode;
import helper.BaseTestHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.ExtentReport;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.RequestBodyReader.getFileInputStream;

public class PutJsonPayloadReader extends BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        String timestamp = BaseTestHelper.Timestamp();
        String subFolderPath = System.getProperty("user.dir")+"/reports/"+ timestamp;
        BaseTestHelper.CreateFolder(subFolderPath);
        String reportFilePath = subFolderPath + "/API_Automation.html";
        ExtentReport.intializeExtentReport(reportFilePath);
    }

    @Test
    public void putJsonPayload() throws IOException {

        RestAssured.baseURI = "https://reqres.in/api/users/2";
     ExtentReport.extentLog= ExtentReport.extentReport.
     startTest("Test Read Put Json Payload Successfully","Reads JSON payloads for PUT API requests. ");
        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                .body(IOUtils.toString(getFileInputStream("putRequestBody.json"), StandardCharsets.UTF_8))
                .when().put().then()
                .statusCode(StatusCode.SUCCESS.code)
                .extract().response();

        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println(response.getBody().asString());


    }
}
