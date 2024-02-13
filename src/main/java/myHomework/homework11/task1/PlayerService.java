package myHomework.homework11.task1;

import java.util.Collection;

public interface PlayerService {
    // Получить игрока по id
    Player getPlayerById(int id);

    // Получить список игроков
    Collection<Player> getPlayers();

    // Создать игрока (возвращает id нового игрока)
    int createPlayer(String nickname);

    // Удалить игрока по id'шнику, вернет удаленного игрока
    Player deletePlayer(int id);

    // Добавить очков игроку. Возвращает обновленный счет
    int addPoints(int playerId, int points);
}
