package aula11.energy;

import java.io.FileNotFoundException;

public class EnergyUsageReport implements IEnergyUsageReport {


    @Override
    public EnergyUsageReport load(String filepath) throws FileNotFoundException {
        return null;
    }

    @Override
    public EnergyUsageReport addCustomer(Customer customer) {
        return null;
    }

    @Override
    public EnergyUsageReport removeCustomer(int id) {
        return null;
    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public double calculateTotalUsage() {
        return 0;
    }

    @Override
    public void generateReport(String filepath) {

    }
}
