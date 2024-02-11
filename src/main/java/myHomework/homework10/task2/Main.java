package myHomework.homework10.task2;

import java.time.LocalDateTime;;

public class Main {
    public static void main(String[] args) {
//        //Данное решение, которое указано в задании неправильное
//        //На проверке граничных значений будет видно ошибку
//        LocalDate publishDate = LocalDate.now().minusDays(1);
//        LocalTime publishTime = LocalTime.now().minusHours(5);
//        LocalDateTime eventTimestamp1 = LocalDateTime.of(publishDate, publishTime);
//        System.out.println(publishDate);
//        System.out.println(publishTime);
//        System.out.println(eventTimestamp1);

        //Вычитать дату и время правильно, если хотите, чтоб был timestamp
        LocalDateTime eventTimestamp = LocalDateTime.now().minusDays(0).minusMinutes(111); //перейдет в час

        ReadableTimestamp date = new ReadableTimestamp();

        System.out.println(date.getTimestamp(eventTimestamp));
    }
}
