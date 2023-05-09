package aula09.testing_collections;


import aula07.date.Date;
import aula07.date.DateND;
import aula07.date.DateYMD;
import java.util.Set;
import java.util.TreeSet;


public class ALDemo2 {

    public static void main(String[] args) {
        Set<Date> c4 = new TreeSet<>();
        c4.add(new DateYMD(14, 2, 2000));
        c4.add(new DateYMD(30, 1, 2000));
        c4.add(new DateYMD(10, 5, 2000));
        c4.add(new DateND(3, 3, 2000));
        c4.add(new DateND(23, 10, 2000));

        for (Date d : c4) {
            System.out.println(d);
        }
    }
}
