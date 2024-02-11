package myHomework.homework10.task2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ReadableTimestamp implements HumanReadableTimestamp {

    @Override
    public String getTimestamp(LocalDateTime eventTimestamp) {
        //Разница старой даты и времени от новой
        Duration duration = Duration.between(eventTimestamp, LocalDateTime.now());

        // Получение разницы в секундах, минутах, часах, днях и т.д.
        long minutesDifference = duration.toMinutes();
        long hoursDifference = duration.toHours();
        long daysDifference = duration.toDays();

        //Список для проверки остатка на 2,3,4
        List<Integer> list234 = Arrays.asList(2, 3, 4);
        if (daysDifference > 0) {
            if (daysDifference == 1) {
                return "опубликовано вчера";
            } else if (daysDifference % 10 == 1 && daysDifference > 20) {
                return "опубликовано " + daysDifference + " день назад";
            } else if ((list234.contains((int) daysDifference % 10) && daysDifference > 20) || list234.contains((int) daysDifference)) {
                return "опубликовано " + daysDifference + " дня назад";
            } else {
                return "опубликовано " + daysDifference + " дней назад";
            }
        } else if (hoursDifference > 0) {
            if (hoursDifference == 1 || (hoursDifference % 10 == 1 && hoursDifference > 20)) {
                return "опубликовано " + hoursDifference + " час назад";
            } else if ((list234.contains((int) hoursDifference % 10) && hoursDifference > 20) || list234.contains((int) hoursDifference)) {
                return "опубликовано " + hoursDifference + " часа назад";
            } else {
                return "опубликовано " + hoursDifference + " часов назад";
            }
        } else if (minutesDifference > 0) {
            if (minutesDifference == 1 || (minutesDifference % 10 == 1 && minutesDifference > 20)) {
                return "опубликовано " + minutesDifference + " минуту назад";
            } else if ((list234.contains((int) minutesDifference % 10) && minutesDifference > 20) || list234.contains((int) minutesDifference)) {
                return "опубликовано " + minutesDifference + " минуты назад";
            } else {
                return "опубликовано " + minutesDifference + " минут назад";
            }
        }
        return "опубликовано только что";
    }
}