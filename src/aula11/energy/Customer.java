package aula11.energy;

import java.util.List;

public class Customer {

    private int customerId;
    private List<Double> meterReadings;

    public Customer(int customerId, List<Double> meterReadings) {
        this.customerId = customerId;
        this.meterReadings = meterReadings;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Double> getMeterReadings() {
        return meterReadings;
    }

    public void setMeterReadings(List<Double> meterReadings) {
        this.meterReadings = meterReadings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(customerId);
        for (Double reading : meterReadings) {
            sb.append("|").append(Math.round(reading));
        }
        return sb.toString();
    }
}
