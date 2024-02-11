package myHomework.homework10.task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Copier.copyTextFile("C:\\Users\\swat_\\IdeaProjects\\Java\\src\\main\\java\\myHomework\\homework10\\README1.md",
                    "C:\\Users\\swat_\\IdeaProjects\\Java\\src\\main\\java\\myHomework\\homework10\\README1.md");
        } catch(IOException e) {
            System.out.println("Что-то пошло не так");
        }

    }
}
