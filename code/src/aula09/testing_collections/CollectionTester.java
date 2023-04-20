package aula09.testing_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class CollectionTester {

    public static void main(String[] args) {
        int DIM = 5000;
        Collection<Integer> col = new ArrayList<>();
        checkPerformanceTable();
        checkPerformance(col, DIM);

    }

    private static void checkPerformanceTable() {
        System.out.printf("%-12s%8d%8d%8d%8d%8d%8d%n", "Collection", 1000, 5000, 10000, 20000, 40000
            , 100000);

        printPerformance("ArrayList", new ArrayList<>());
        printPerformance("LinkedList", new LinkedList<>());
        printPerformance("HashSet", new HashSet<>());
        printPerformance("TreeSet", new TreeSet<>());


    }

    public static void printPerformance(String name, Collection<Integer> collection) {
        int[] DIMS = {1000, 5000, 10000, 20000, 40000, 100000};
        String[] METHODS = {"add", "search", "remove"};
        ArrayList<ArrayList<Double>> table = new ArrayList<>();

        System.out.println(name);
        for (int DIM : DIMS) {
            table.add(checkPerformance(collection, DIM));
        }

        for (int i = 0; i < METHODS.length; i++) {
            System.out.printf("%-12s", METHODS[i]);
            printRowTimes(table, i);
            System.out.println();
        }

    }

    public static void printRowTimes(ArrayList<ArrayList<Double>> table, int i) {
        for (ArrayList<Double> doubles : table) {
            System.out.printf("%8.1f", doubles.get(i));
        }
    }

    private static ArrayList<Double> checkPerformance(Collection<Integer> col, int DIM) {
        double start, stop, delta;
        ArrayList<Double> times = new ArrayList<>();
// Add
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++) {
            col.add(i);
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert to milliseconds
        times.add(delta);

// Search
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++) {
            int n = (int) (Math.random() * DIM);
            if (!col.contains(n)) {
                System.out.println("Not found???" + n);
            }
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        times.add(delta);

// Remove
        start = System.nanoTime(); // clock snapshot before
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        times.add(delta);

        return times;
    }
}