package aula11.energy;

import java.io.FileNotFoundException;

public class EnergyUsageReport implements IEnergyUsageReport {


    @Override
    public void load(String filepath) throws FileNotFoundException {
    }

    @Override
    public void addCustomer(Customer customer) {
    }

    @Override
    public void removeCustomer(int uid) {
    }

    @Override
    public Customer getCustomer(int uid) {
        return null;
    }

    @Override
    public double calculateTotalUsage(int uid) {
        return 0;
    }

    @Override
    public void generateReport(String filepath) {

    }
}
