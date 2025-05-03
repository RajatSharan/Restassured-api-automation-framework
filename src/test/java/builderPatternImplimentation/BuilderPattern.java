package builderPatternImplimentation;

import core.StatusCode;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class BuilderPattern {

    String serverAddress = PropertyReader.propertyReader("config.properties", "server");
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @Test
    public void testBuilderPatternApproch() {

        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .param("page", "2")
                .header("Content-Type", "application/json")
                .when().get(serverAddress).then()
                .statusCode(StatusCode.SUCCESS.code)
                .extract().response();

        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println(response.getBody().asString());

    }


    @Test
    public void testBuilderPatternApprochImpelentation() {

        requestSpecification = getRequestSpecification("2","application/json","reqres-free-v1");

        given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .spec(getResponseSpecification(StatusCode.SUCCESS.code, "application/json"));
    }

    private RequestSpecification getRequestSpecification(String queryParam, String contentType, String header) {

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(serverAddress)
                .setContentType(contentType)
                .addQueryParam("page", queryParam)
                .addHeader("x-api-key", header)
                .build();

        return requestSpecification;

    }

    private ResponseSpecification getResponseSpecification(int statusCode, String contentType) {
         responseSpecification= new ResponseSpecBuilder()
                                .expectStatusCode(statusCode)
                                .expectContentType(contentType)
                                .build();
        return responseSpecification;
    }


}
