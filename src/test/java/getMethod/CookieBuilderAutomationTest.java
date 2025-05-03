package getMethod;

import io.restassured.http.Cookie;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CookieBuilderAutomationTest {

    @Test
    public void testUseCookie() {
        Cookie cookie = new Cookie.Builder("cookieKey1", "cookieValue1").setComment("using cookie").build();

        given().cookie(cookie).when().get("https://reqres.in/api/users?page=2").then().assertThat().statusCode(200);

    }
}
