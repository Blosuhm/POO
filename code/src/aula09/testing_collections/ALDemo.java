package aula09.testing_collections;

import aula05.DateYMD;
import aula06.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ALDemo {

    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            c1.add(i);
        }
        System.out.println("Size: " + c1.size());
        for (Integer integer : c1) {
            System.out.println("Elemento: " + integer);
        }
        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);

        ArrayList<String> a1 = new ArrayList<>();
        a1.add("Banana");
        a1.add("Maçã");
        a1.add("Pera");
        a1.add("Laranja");
        a1.add("Banana");
        System.out.println(a1);
        System.out.println(a1.contains("Banana"));
        System.out.println(a1.contains("Bananas"));
        System.out.println(a1.indexOf("Banana"));
        System.out.println(a1.lastIndexOf("Banana"));
        List<String> a2 = a1.subList(1, 5);
        System.out.println(a2);
        a1.set(2, "Melão");
        System.out.println(a1);

        Set<Person> c3 = new HashSet<>();
        Person joao = new Person("João", 35677660, new DateYMD(4137, 6, 13));

        Person maria = new Person("Maria", 45678902, new DateYMD(4137, 6, 13));

        c3.add(joao);
        c3.add(maria);
        c3.add(new Person("Pedro", 12345678, new DateYMD(4743, 6, 13)));
        c3.add(new Person("Ana", 78912377, new DateYMD(4743, 6, 13)));
        c3.add(new Person("Bimbo", 35677345, new DateYMD(4743, 6, 13)));

        for (Person person : c3) {
            System.out.println(person);
        }

        System.out.println(c3);
    }
}
