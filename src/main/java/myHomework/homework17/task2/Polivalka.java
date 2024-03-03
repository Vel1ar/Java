package myHomework.homework17.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Polivalka {

    public void validation(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            LocalDate parseDate = LocalDate.parse(str, formatter);
            System.out.println("Следующий полив кактуса: " + getDate(parseDate).format(formatter));
        } catch (Exception e) {
            System.out.println("Введите верную дату");
        }
    }

    private static LocalDate getDate(LocalDate date) {
        Sensor sensor = new Sensor();

        if (sensor.getPercent() <= 30) {
            return LocalDate.now();
        } else {
            switch (date.getMonthValue()) {
                case 12, 1, 2:
                    return date.plusMonths(1);
                case 3, 4, 5, 9, 10, 11:
                    return date.plusWeeks(1);
                default:
                    return date.plusDays(2);
            }
        }
    }
}
