package myHomework.homework10.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Copier {
    public static void copyTextFile(String pathOut, String pathIn) throws IOException {
        Files.writeString(Path.of(pathIn), Files.readAllLines(Path.of(pathOut)).toString());
    }
}
