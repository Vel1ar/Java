package myHomework.homework11.task1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path filePath1 = Path.of("src/main/java/myHomework/homework11/task1/resources/player1.json");
        Path filePath2 = Path.of("src/main/java/myHomework/homework11/task1/resources/player2.json");
        Path filePath3 = Path.of("src/main/java/myHomework/homework11/task1/resources/player3.json");
        Path filePath4 = Path.of("src/main/java/myHomework/homework11/task1/resources/player4.json");
        Path filePath5 = Path.of("src/main/java/myHomework/homework11/task1/resources/player5.json");

        PlayerService playerServiceJSON = new PlayerServiceJSON();

        ObjectMapper mapper = new ObjectMapper();

        //Функционал добавления игрока
        try {
            mapper.writeValue(filePath1.toFile(),playerServiceJSON.createPlayer("Andrey"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Добавляем для кейса
        playerServiceJSON.createPlayer("Vlados");
        playerServiceJSON.createPlayer("Kostya");
        //Функционал вывести одного игрока
        try {
            mapper.writeValue(filePath2.toFile(), playerServiceJSON.getPlayerById(1));
        } catch (IOException e) {
            System.out.println("Что то не так с индексами");
        }
        //Функционал вывести всех игроков
        try {
            mapper.writeValue(filePath3.toFile(),playerServiceJSON.getPlayers());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Функционал удаления, записывает удаленного игрока
        try {
            mapper.writeValue(filePath4.toFile(),playerServiceJSON.deletePlayer(1));
        } catch (IOException e) {
            System.out.println("Что то не так с индексами");
        }
        //Функционал добавления очков игроку
        try {
            mapper.writeValue(filePath5.toFile(),playerServiceJSON.addPoints(1,200));
        } catch (IOException e) {
            System.out.println("Что то не так с индексами");
        }
    }
}
