package aula07.date;

public class DateTest {

    public static void main(String[] args) {
        Date date = new DateND(30, 6, 2036);
        System.out.println(date);
        date.incrementDay();
        System.out.println(date);

        date = new DateYMD(30, 6, 2036);
        System.out.println(date);
        date.incrementDay();
        System.out.println(date);
        System.out.println(Date.isLeapYear(2000));
    }

}
