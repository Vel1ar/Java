package myHomework.homework9.task6;

import myHomework.homework9.task1.Player;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Player, Integer> points = new HashMap<>();
        for (int i = 1; i < 11; i++) {
            points.put(new Player(i, "Tinker" + i, true), 0);
        }
    }
}
