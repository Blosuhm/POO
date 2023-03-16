package aula05;

import java.util.ArrayList;

public class Calendar {
    private int year = 0;
    private int firstWeekDay = 0;
    private ArrayList<DateYMD> events = new ArrayList<>();
    private int[] firstWeekDayMonth = new int[12];
    private String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };

    public Calendar(int year, int firstWeekDay) {
        if (year < 0) {
            throw new IllegalArgumentException("Invalid year");
        }
        if (firstWeekDay < 0 || firstWeekDay > 6) {
            throw new IllegalArgumentException("Invalid week day");
        }
        this.year = year;
        this.firstWeekDay = firstWeekDay;
        firstWeekDayMonth[0] = firstWeekDay;
        for (int i = 1; i < 12; i++) {
            firstWeekDayMonth[i] = (firstWeekDayMonth[i - 1] + DateYMD.monthDays(i, year)) % 7;
            if (firstWeekDayMonth[i] == 0) {
                firstWeekDayMonth[i] = 7;
            }
        }
    }

    public int getYear() {
        return year;
    }

    public int getFirstWeekDay() {
        return firstWeekDay;
    }

    public void addEvent(DateYMD date) {
        events.add(date);
    }

    public void removeEvent(DateYMD date) {
        events.remove(date);
    }

    public String printMonth(int month) {
        if (!DateYMD.validMonth(month)) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }

        StringBuilder monthRepr = new StringBuilder();
        monthRepr.append(this.year).append(" ").append(monthNames[month - 1]);
        ArrayList<Integer> monthEvents = new ArrayList<>();
        final String weekDays = " Su  Mo  Tu  We  Th  Fr  Sa ";

        int numSpaces = weekDays.length() / 2 - monthRepr.length() / 2;
        String spaces = " ".repeat(numSpaces);
        monthRepr.insert(0, spaces);
        monthRepr.append("\n").append(weekDays).append("\n");

        for (DateYMD event : events) {
            if (event.getMonth() == month) {
                monthEvents.add(event.getDay());
            }
        }
        int firstDay = firstWeekDayMonth[month - 1];
        for (int j = 0; j < firstDay - 1; j++) {
            monthRepr.append("    ");
        }
        for (int i = 1; i <= DateYMD.monthDays(month, this.year); i++) {
            boolean hasEvent = false;
            for (int event : monthEvents) {
                if (event == i) {
                    hasEvent = true;
                    break;
                }
            }
            monthRepr.append((String.format(hasEvent ? "*%02d " : " %02d ", i)));

            if ((i + firstDay - 1) % 7 == 0) {
                monthRepr.append("\n");
            }

        }
        return monthRepr.toString();
    }

    @Override
    public String toString() {
        StringBuilder calendar = new StringBuilder();
        for (int i = 1; i < 12; i++) {
            calendar.append(printMonth(i)).append("\n\n");
        }
        return calendar.toString();
    }

}
