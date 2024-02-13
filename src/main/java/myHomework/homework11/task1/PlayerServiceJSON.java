package myHomework.homework11.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerServiceJSON implements PlayerService{

    Integer nextId = 1;
    List<Player> players = new ArrayList<>();

    @Override
    public Player getPlayerById(int id) {
        return players.get(id-1);
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public int createPlayer(String nickname) {
        Player player = new Player(nextId,nickname,0,false);
        players.add(player);
        this.nextId++;
        return player.getId();
    }

    @Override
    public Player deletePlayer(int id) {
        Player player = players.get(id-1);
        players.remove(id-1);
        return player;
    }

    @Override
    public int addPoints(int playerId, int points) {
        Player player = players.get(playerId-1);
        player.setPoints(points);
        return player.getPoints();
    }

}
