package myHomework.homework2.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите карту: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        HideCard homework2 = new HideCard(str);
        homework2.hideCard();
    }
}