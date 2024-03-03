package myHomework.homework17.task2;

import java.util.Random;

public class Sensor {
    public int getPercent() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
