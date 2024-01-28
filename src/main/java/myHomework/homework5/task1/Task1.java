package myHomework.homework5.task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

//    private static final String PASSWORD_PATTERN =
//            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
//    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);


    public void getIf() {
        int balance;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        balance = scanner.nextInt();
        if (balance == 10) {
            System.out.println("Десятка");
        } else {
            System.out.println(balance);
        }
    }

    public void checkUrl(String url) {
        if (url.startsWith("https")) {
            System.out.println("Соединение безопасное");
        } else {
            System.out.println("Небезопано.Не указывайте логины,пароли и данные банковских карт");
        }
    }

    public void getChetnoe(int a) {
        if (a % 4 == 0) {
            System.out.println("Число четное. Кратно четырем");
        } else {
            if (a % 3 == 0) {
                System.out.println("Число нечетное. Кратное трем");
            } else {
                if (a % 2 == 0) {
                    System.out.println("Число четное");
                }
            }
        }
    }

    public void validatePassword(String password) {
        // Требования к паролю.
        int minLength = 8;
        String specialCharacters = "[!@#$%^&*№]";

        // Проверка длины пароля.
        if (password.length() < minLength) {
            System.out.println("Пароль не менее " + minLength + " символов");
        } else {

            // Проверка наличия цифры в пароле.
            if (!password.matches(".*[0-9].*")) {
                System.out.println("Пароль должен содержать минимум 1 цифру");
            } else {

                // Проверка наличия специального символа в пароле.
                if (!password.matches(".*" + specialCharacters + ".*")) {
                    System.out.println("Пароль должен содержать минимум 1 спецсимвол");
                } else {
                    System.out.println("Пароль принят");
                }
            }
        }
    }

    public void equalsPassword(String str) {

        if (str.equals("Qwerty0987654321")) {
            System.out.println("Доступ разрешен");
        } else {
            System.out.println("Доступ запрещен");
        }
    }

    public void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    if (i % 3 == 0) {
                        System.out.println("Fizz");
                    } else {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
