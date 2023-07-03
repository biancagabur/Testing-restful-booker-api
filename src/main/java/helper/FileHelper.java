package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {
    public static String readFromFile(String fileName) throws IOException{
        String path = "src/test/resources/requests/" + fileName;
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
