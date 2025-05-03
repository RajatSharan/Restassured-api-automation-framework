package uploadDownloadFiles;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FileUploadTest {

    @Test
    public void fileUploadTest() {

            File file = new File("resources/file.txt");
            Response response = given().multiPart("file", file) // Upload the file
                    .when()
                    .post("https://example.com/upload/");
            System.out.println(response.getBody().asString());
        }
    }

