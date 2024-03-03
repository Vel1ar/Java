package myHomework.homework17.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Polivalka polivalka = new Polivalka();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате: dd.MM.yyyy");
        String str = scanner.nextLine();

        polivalka.validation(str);

        scanner.close();
    }
}
