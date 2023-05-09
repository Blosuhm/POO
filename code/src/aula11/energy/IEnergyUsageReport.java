package aula11.energy;

import java.io.FileNotFoundException;

public interface IEnergyUsageReport {

    EnergyUsageReport load(String filepath) throws FileNotFoundException;

    EnergyUsageReport addCustomer(Customer customer);

    EnergyUsageReport removeCustomer(int id);

    Customer getCustomer(int id);

    double calculateTotalUsage();

    void generateReport(String filepath);
}
