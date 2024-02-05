package myHomework.homework9.task6;

import myHomework.homework9.task1.Player;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Player, Integer> points = new HashMap<>();
        for (int i = 1; i < 11; i++) {
            points.putIfAbsent(new Player(i, "Tinker" + i, true), 0);
        }
        points.put(new Player(4, "Tinker" + 4, true),10);
        points.put(new Player(7, "Tinker" + 7, true),12);
        points.put(new Player(8, "Tinker" + 8, true),11);
        points.put(new Player(9, "Tinker" + 9, true),13);
        points.put(new Player(10, "Tinker" + 10, true),5);


        List<Map.Entry<Player, Integer>> entryList = new ArrayList<>(points.entrySet());
        entryList.sort(Map.Entry.<Player, Integer>comparingByValue().reversed());
        Map<Player, Integer> sortedByValue = new LinkedHashMap<>();

        int endIndex = Math.min(3, entryList.size());
        for (int i = 0; i < endIndex; i++) {
            Map.Entry<Player, Integer> entry = entryList.get(i);
            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Player, Integer> entry : sortedByValue.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
