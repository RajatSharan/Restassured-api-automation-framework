package chainingMethod;

import core.BaseTest;
import core.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ExtentReport;

import static io.restassured.RestAssured.given;

public class APIChaining extends BaseTest {


    public String genrateAuthToken() {

        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"userName\":\"rajat sharan\",\"password\":\"rajat@123\"}")
                .when()
                .post("https://bookstore.toolsqa.com/Account/v1/GenerateToken")
                .then()
                .statusCode(StatusCode.SUCCESS.code)
                .extract()
                .response();

        String authToken = response.path("token");
        return authToken;


    }

    @Test
    public void verifyBookstoreAddBook(){
        ExtentReport.extentLog= ExtentReport.extentReport.
                startTest("testReadPostJsonPayloadSuccessfully ","Chain validation working successfully.");
         String authToken =  genrateAuthToken();
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ authToken)
                .body("{\"userId\":\"1aa3e58f-0034-4a15-b62c-5b75098ab3ea\",\"collectionOfIsbns\":[{\"isbn\":\"9781449365035\"}]}")
                .when().post("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .then().statusCode(StatusCode.CREATED.code).extract().response();
    }

}
