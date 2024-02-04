package myHomework.homework9.task1;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(1,"Test", true);
        Player player2 = new Player(1,"Test", true);

        System.out.println(player1 == player2);
        System.out.println(player1.equals(player2));
    }
}
