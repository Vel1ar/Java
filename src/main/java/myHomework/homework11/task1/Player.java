package myHomework.homework11.task1;

import java.util.Objects;

public class Player {
    private int id;
    private String nick;
    private int points;
    private boolean isOnline;

    public Player(int id, String nick, int points, boolean isOnline) {
        this.id = id;
        this.nick = nick;
        this.points =points;
        this.isOnline = isOnline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && points == player.points && isOnline == player.isOnline && Objects.equals(nick, player.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nick, points, isOnline);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", points=" + points +
                ", isOnline=" + isOnline +
                '}';
    }
}
