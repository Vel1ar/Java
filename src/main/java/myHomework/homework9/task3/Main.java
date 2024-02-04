package myHomework.homework9.task3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList <Movie> list = new ArrayList<>();
        list.add(new Movie("Film1",8, "Horror", "France", "Yes"));
        list.add(new Movie("Film2",7, "Horror", "France", "Yes"));
        list.add(new Movie("Film3",6, "Horror", "France", "No"));

        System.out.println(list.get(1));
    }
}
