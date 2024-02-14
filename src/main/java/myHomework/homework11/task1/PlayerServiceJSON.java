package myHomework.homework11.task1;

import java.util.*;

public class PlayerServiceJSON implements PlayerService {

    private Integer nextId = 1;
    HashMap<Integer, Player> players = new HashMap<>();
    @Override
    public Player getPlayerById(int id) {
        return players.get(id);
    }

    @Override
    public Collection<Player> getPlayers() {
        return players.values();
    }

    @Override
    public int createPlayer(String nickname) {
        Player player = new Player(nextId, nickname, 0, false);
        players.put(nextId, player);
        this.nextId++;
        return player.getId();
    }

    @Override
    public Player deletePlayer(int id) {
        Player player = players.get(id);
        players.remove(id);
        return player;
    }

    @Override
    public int addPoints(int playerId, int points) {
        Player player = players.get(playerId);
        player.setPoints(player.getPoints()+points);
        return player.getPoints();
    }
}
