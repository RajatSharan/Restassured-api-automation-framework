package helper;

import java.io.File;
import java.util.Date;

public class BaseTestHelper {

    public static void CreateFolder(String path) {
        File file = new File(path);
        if (!file.exists()) {
            boolean created = file.mkdirs();
            if (!created) {
                System.out.println("Failed to create folder: " + path);
            }
        } else {
            System.out.println("Folder already exists");
        }
    }

    public static String Timestamp() {
        Date now = new Date();
        String Timestamp = now.toString().replace(":", "-");
        return Timestamp;
    }

}
