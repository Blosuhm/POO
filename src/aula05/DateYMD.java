package aula05;

class DateYMD {
    private int year;
    private int month;
    private int day;

    public DateYMD(int year, int month, int day) {
        if (!validDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static boolean validMonth(int month) {
        return month >= 1 && month <= 12;
    }

    public static int monthDays(int month, int year) {
        if (!validMonth(month)) {
            return -1;
        }
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static boolean validDate(int day, int month, int year) {
        return day >= 1 && day <= monthDays(month, year) && validMonth(month);

    }

    public void setDate(int day, int month, int year) {
        if (!validDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void incrementDay() {
        day++;
        if (day > monthDays(month, year)) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public void decrementDay() {
        day--;
        if (day < 1) {
            month--;
            if (month < 1) {
                month = 12;
                year--;
            }
            day = monthDays(month, year);
        }
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}