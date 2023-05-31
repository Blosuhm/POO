package TPTest2;

import java.util.Set;
import java.util.TreeSet;

public class OrderManager {

    private final Set<Order> orders = new TreeSet<>();

    public OrderManager addOrder(Order order) {
        orders.add(order);
        return this;
    }

    public OrderManager removeOrder(int id) {
        orders.removeIf(order -> order.getId() == id);
        return this;
    }

    public Order searchOrder(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
    }

    public double calculateTotalPrice(int id) {
        OrderCostCalculator calculator = new StandardOrderCostCalculator();
        Order order = searchOrder(id);
        if (order == null) {
            return -1;
        }
        return calculator.calculateOrderCost(order);
    }

    public Set<Order> toSet() {
        return orders;
    }

    public void printAllOrders() {
        orders.forEach(System.out::println);
    }
}
