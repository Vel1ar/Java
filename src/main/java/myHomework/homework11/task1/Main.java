package myHomework.homework11.task1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path filePath = Path.of("src/main/java/myHomework/homework11/task1/resources/player.json");

        PlayerService playerServiceJSON = new PlayerServiceJSON();

        //Функционал добавления
        playerServiceJSON.createPlayer("Vlados");
        playerServiceJSON.createPlayer("Kostya");
        playerServiceJSON.createPlayer("Andrey");
        //Функционал изменения
        playerServiceJSON.addPoints(3, 334);
        //Функционал увелечения очков (итого 434)
        playerServiceJSON.getPlayerById(3).setPoints(100);
        //Функционал удаления
        playerServiceJSON.deletePlayer(2);

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(filePath.toFile(),playerServiceJSON.getPlayers());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
