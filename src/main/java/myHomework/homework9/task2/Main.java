package myHomework.homework9.task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            list1.add("Дело " + i);
        }
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("Задача " + (i+1) +": " + list1.get(i));;
        }
    }
}
