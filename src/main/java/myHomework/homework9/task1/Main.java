package myHomework.homework9.task1;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Player(1,"Test", true) == new Player(1,"Test", true));
        System.out.println(new Player(1,"Test", true).equals(new Player(1,"Test", true)));
    }
}
