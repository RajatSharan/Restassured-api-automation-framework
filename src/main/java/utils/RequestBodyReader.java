package utils;

import java.io.File;
import java.io.FileInputStream;

public class RequestBodyReader {

    public static FileInputStream getFileInputStream(String requestBodyFileName) {
        FileInputStream fileInputStream;
        try{
            fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/resources/TestData/" +requestBodyFileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fileInputStream;
    }
}
