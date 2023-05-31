package TPTest2;

public class StandardOrderCostCalculator implements OrderCostCalculator {

    @Override
    public double calculateOrderCost(Order order) {
        double cost = order.getItemsList().stream().map(Item::getPrice).reduce(0.0, Double::sum);
        if (order.isExpressOrder()) {
            cost *= 1.3;
        }
        return cost;
    }
}
