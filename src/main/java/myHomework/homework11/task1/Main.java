package myHomework.homework11.task1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        final String path = "src/main/java/myHomework/homework11/task1/resources/";
        Path filePath1 = Path.of(path + "player1.json");
        Path filePath2 = Path.of(path + "player2.json");
        Path filePath3 = Path.of(path + "player3.json");

        PlayerService service = new PlayerServiceJSON();

        ObjectMapper mapper = new ObjectMapper();

        int playerId1 = service.createPlayer("Andrey");
        int playerId2 = service.createPlayer("Vlados");
        int playerId3 = service.createPlayer("Yarik");

        //Функционал удаления
        try {
            mapper.writeValue(filePath1.toFile(), service.addPoints(playerId1,200));
            mapper.writeValue(filePath1.toFile(), service.deletePlayer(playerId2));
            mapper.writeValue(filePath2.toFile(), service.getPlayerById(playerId3));
            mapper.writeValue(filePath3.toFile(), service.getPlayers());
        } catch (IOException e) {
            System.out.println("Что то не так с индексами");
        }

    }
}
