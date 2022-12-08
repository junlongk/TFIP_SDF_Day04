package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CookieFile {

    public CookieFile() {

    }

    public String GetRandomCookieFromFile(String fileName) {
        List<String> lines;
        double randomIndex;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
            randomIndex = Math.floor(Math.random() * lines.size());
            return lines.get((int) randomIndex);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: No Cookie Found !";
        }
    }
}