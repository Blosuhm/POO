package aula07.date;

public abstract class Date implements Comparable<Date> {


    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static boolean isMonth(int month) {
        return 1 <= month && month <= 12;
    }

    public static int monthDays(int month, int year) {
        if (!isMonth(month)) {
            return -1;
        }
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    @Override
    public int compareTo(Date other) {
        int[] date1 = getDate();
        int[] date2 = other.getDate();
        for (int i = 2; i >= 0; i--) {
            if (date1[i] > date2[i]) {
                return 1;
            } else if (date1[i] < date2[i]) {
                return -1;
            }
        }
        return 0;
    }

    protected abstract int[] getDate();

    protected abstract void setDate(int day, int month, int year);

    protected abstract int getYear();

    protected abstract int getMonth();

    protected abstract int getDay();

    protected abstract void incrementDay();

    protected abstract void decrementDay();

    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", getDay(), getMonth(), getYear());
    }
}
