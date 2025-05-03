package schemaJsonValidation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JsonSchemaValidation {

    @Test
    public void jsonSchemaValidation() {
        File schemaFile = new File("resources/ExpectedSchema.json");
        given()
                .header("x-api-key", "reqres-free-v1")
                .when().get("https://reqres.in/api/users?page=2")
                .then().assertThat().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));


    }
}
