package aula07.date;

// days since 1-1-2000
public class DateND extends Date {

    private int days = 0;

    public DateND(int day, int month, int year) {
        setDate(day, month, year);
    }

    @Override
    public int[] getDate() {
        int currentDays = this.days;
        int year = 2000;
        while ((!isLeapYear(year) && currentDays >= 365) || (isLeapYear(year) && currentDays >= 366)) {
            currentDays -= 365;
            if (isLeapYear(year)) {
                currentDays--;
            }
            year++;
        }

        int month;
        for (month = 1; month <= 12; month++) {
            int monthDays = monthDays(month, year);
            if (currentDays <= monthDays) {
                break;
            }
            currentDays -= monthDays;
        }
        int day = currentDays;
        return new int[] { day, month, year };

    }

    @Override
    public void setDate(int day, int month, int year) {
        validDate(day, month, year);
        int leapYearDays = 0;
        for (int y = 2000; y < year; y++) {
            if (isLeapYear(y)) {
                leapYearDays++;
            }
        }
        int yearDays = (year - 2000) * 365 + leapYearDays;
        int monthDays = 0;
        for (int m = 1; m < month; m++) {
            monthDays += monthDays(m, year);
        }
        this.days = yearDays + monthDays + day;
    }

    private static void validDay(int day, int month, int year) {
        if (day < 1 || day > monthDays(month, year)) {
            throw new IllegalArgumentException("Invalid day");
        }
    }

    private static void validMonth(int month) {
        if (!isMonth(month)) {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    private static void validDate(int day, int month, int year) {
        validDay(day, month, year);
        validMonth(month);
    }

    @Override
    public int getYear() {
        return getDate()[2];
    }

    @Override
    public int getMonth() {
        return getDate()[1];
    }

    @Override
    public int getDay() {
        return getDate()[0];
    }

    @Override
    public void incrementDay() {
        days++;
    }

    @Override
    public void decrementDay() {
        days--;
    }
}
