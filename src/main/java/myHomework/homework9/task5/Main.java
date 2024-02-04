package myHomework.homework9.task5;

import myHomework.homework9.task1.Player;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Player> uniquePlayersList = new HashSet<>(10);
        for (int i = 1; i < 11; i++) {
            uniquePlayersList.add(new Player(i,"Tinker"+i, true));
        }
        uniquePlayersList.add(new Player(5,"Tinker5", true));
        System.out.println(uniquePlayersList);
    }
}
