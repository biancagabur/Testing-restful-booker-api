package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {
    private final String filePath;

    public FileHelper(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public String readFromFile(String filePath) throws IOException{
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
