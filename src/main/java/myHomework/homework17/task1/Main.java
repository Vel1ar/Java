package myHomework.homework17.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zabor zabor = new Zabor();
        System.out.println("Введите длину в сантиметрах: ");
        try {
            int count = scanner.nextInt();
            zabor.getInfo(count);
        } catch (Exception e) {
            System.out.println("Введи число в сантиметрах");
        } finally {
            scanner.close();
        }
    }
}
