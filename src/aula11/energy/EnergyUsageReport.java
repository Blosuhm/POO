package aula11.energy;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EnergyUsageReport implements IEnergyUsageReport {

    private final Set<Customer> customers;


    public EnergyUsageReport() {
        this.customers = new HashSet<>();
    }


    @Override
    public void load(String filepath) throws FileNotFoundException {
        Scanner sc = new Scanner(new java.io.File(filepath));
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\|");
            int uid = Integer.parseInt(line[0]);
            List<Double> readings = new ArrayList<>();
            for (int i = 1; i < line.length; i++) {
                readings.add(Double.parseDouble(line[i]));
            }
            customers.add(new Customer(uid, readings));
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        if (customer != null) {
            customers.add(customer);
        } else {
            throw new IllegalArgumentException("Customer cannot be null");
        }
    }

    @Override
    public void removeCustomer(int uid) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == uid) {
                customers.remove(customer);
                break;
            }
        }
    }

    @Override
    public Customer getCustomer(int uid) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == uid) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public double calculateTotalUsage(int uid) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == uid) {
                double sum = 0;
                for (double usage : customer.getMeterReadings()) {
                    sum += usage;
                }
                return sum;
            }
        }
        return -1;
    }

    @Override
    public void generateReport(String filepath) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filepath);
        for (Customer customer : customers) {
            pw.println(customer);
        }
        pw.close();
    }
}
