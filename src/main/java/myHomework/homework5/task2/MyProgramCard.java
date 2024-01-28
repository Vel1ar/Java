package myHomework.homework5.task2;

import java.util.Scanner;

public class MyProgramCard {
    public static void main(String[] args) {

        //Task#1 Маскировка карты 2.0
        Card card = new Card();
        card.setSrkGdn("12/26");
        card.setPinCode(2999);
        card.setNumber("1848 4938 2834 4829");
        card.setCvv("199");

        Scanner scanner = new Scanner(System.in);
        card.hideCard();
        card.enterPinCode(scanner.nextInt());
    }
}
