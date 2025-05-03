package getMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class TestDataProvider {
    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {"1"},
                {"2"},
                {"3"},
        };
    }

    @Test(dataProvider = "testData")

    public void testEndpoint(String id) {
        given()
                .queryParam("id", id)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get("https://reqres.in/api/users" + id)
                .then()
                .statusCode(200);

    }
}



