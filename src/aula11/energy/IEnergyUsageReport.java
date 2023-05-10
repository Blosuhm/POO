package aula11.energy;

import java.io.FileNotFoundException;

public interface IEnergyUsageReport {

    void load(String filepath) throws FileNotFoundException;

    void addCustomer(Customer customer);

    void removeCustomer(int uid);

    Customer getCustomer(int uid);

    double calculateTotalUsage(int uid);

    void generateReport(String filepath) throws FileNotFoundException;

}
