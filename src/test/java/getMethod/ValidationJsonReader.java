package getMethod;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;

import static utils.JsonReader.getJsonArray;

public class ValidationJsonReader {

    @Test
    public void testValidationJsonReader() throws IOException, ParseException {
        JsonReader.getJsonArrayData("getPostmanEcho", 0);
        JSONArray jsonArray=getJsonArray("getPostmanEcho");
        if (jsonArray != null) {
            for (Object o : jsonArray) System.out.println(o);
        } else {
            System.out.println("jsonArray is null. Key 'contact' not found or not an array.");
        }
    }
}
