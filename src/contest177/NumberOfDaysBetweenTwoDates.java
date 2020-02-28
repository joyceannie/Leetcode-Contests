package contest177;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/*
 * Write a program to count the number of days between two dates.
 * 
 *The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
 * Input: date1 = "2019-06-29", date2 = "2019-06-30"
 *
 *Output: 1
 * Input: date1 = "2019-06-29", date2 = "2019-06-30"
 * Output: 1
 * 
 * Input: date1 = "2020-01-15", date2 = "2019-12-31"
 * Output: 15
 */
class NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate dateBefore = LocalDate.parse(date1);
        LocalDate dateAfter = LocalDate.parse(date2);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        return Math.abs((int)noOfDaysBetween);
    }
}