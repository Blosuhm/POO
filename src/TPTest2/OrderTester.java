package TPTest2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class OrderTester {

    private static final OrderCostCalculator calculator = new StandardOrderCostCalculator();
    private static final OrderManager orderManager = new OrderManager();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
        "yyyy-MM-dd HH:mm");

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Creating First Orders...");
        List<Item> itemsList1 = new ArrayList<>();
        itemsList1.add(new Item("Chair", 30));
        itemsList1.add(new Item("Table", 50));
        itemsList1.add(new Item("Sofa", 100));

        List<Item> itemsList2 = new ArrayList<>();
        itemsList2.add(new Item("Blue Chair", 40));
        itemsList2.add(new Item("Table", 50));
        itemsList2.add(new Item("Lamp", 10));

        List<Item> itemsList3 = new ArrayList<>();
        itemsList3.add(new Item("Computer", 200));
        itemsList3.add(new Item("Keyboard", 50));
        itemsList3.add(new Item("Mouse", 30));

        LocalDateTime date1 = LocalDateTime.parse("2020-03-03 12:00", formatter);
        LocalDateTime date2 = LocalDateTime.parse("2020-04-02 12:00", formatter);
        LocalDateTime date3 = LocalDateTime.parse("2020-05-01 12:00", formatter);

        orderManager.addOrder(new Order("1", "A", date1, itemsList1, true));
        orderManager.addOrder(new Order("2", "B", date2, itemsList2, false));
        orderManager.addOrder(new Order("3", "C", date3, itemsList3, true));
        System.out.println("Showing Orders...");
        orderManager.printAllOrders();

        System.out.println("===========================================");

        System.out.println("Removing order of id 1...");
        orderManager.removeOrder(1);
        System.out.println("Showing Orders...");
        orderManager.printAllOrders();

        System.out.println("===========================================");

        System.out.println("Importing orders from file pedido.txt...");
        readFromFile("src/TPTest2/pedidos.txt");

        System.out.println("Showing Orders...");
        orderManager.printAllOrders();

        System.out.println("===========================================");

        System.out.println("Searching for order of id 13...");
        Order order13 = orderManager.searchOrder(13);
        System.out.println(order13);
        System.out.println("Calculating the cost of the order of id 13...");
        System.out.println(calculator.calculateOrderCost(order13));

        System.out.println("===========================================");

        System.out.println("Calculating the cost for may (month 5)...");
        System.out.println(calculateCostForGivenMonth(5));

        System.out.println("===========================================");

        System.out.println("Writing the orders to pedido2.txt...");
        writeToFile("src/TPTest2/pedidos2.txt");

    }

    public static void readFromFile(String filepath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filepath));

        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(";");
            String clientId = line[0];
            String storeId = line[1];
            String itemsListString = line[2];
            String[] items = itemsListString.split("\\|");
            List<Item> itemsList = new ArrayList<>();
            for (String itemString : items) {
                String[] itemInfo = itemString.split(":");
                String name = itemInfo[0];
                double price = Double.parseDouble(itemInfo[1]);
                Item item = new Item(name, price);
                itemsList.add(item);
            }
            String date = line[3];
            LocalDateTime parsedDate = LocalDateTime.parse(date, formatter);
            String express = line[4];
            boolean parsedExpress = express.equals("express");

            Order order = new Order(clientId, storeId, parsedDate, itemsList, parsedExpress);

            orderManager.addOrder(order);
        }
        sc.close();

    }

    private static double calculateCostForGivenMonth(int month) {
        return orderManager.toSet().stream()
            .filter(o -> o.getOrderDateTime().getMonthValue() == month)
            .map(calculator::calculateOrderCost).reduce(0.0, Double::sum);

    }

    private static void writeToFile(String filepath) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filepath);
        Set<Order> orderSet = orderManager.toSet();
        StringBuilder sb = new StringBuilder();
        for (Order order : orderSet) {
            String clientid = order.getClientId();
            sb.append(clientid).append(";");
            String storeid = order.getStoreId();
            sb.append(storeid).append(";");
            List<Item> itemsList = order.getItemsList();
            for (Item item : itemsList) {
                String name = item.getName();
                sb.append(name).append(":");
                double price = item.getPrice();
                sb.append(price).append("|");
            }
            LocalDateTime date = order.getOrderDateTime();

            String dateString = date.format(formatter);

            sb.append(dateString).append(";");
            boolean express = order.isExpressOrder();
            sb.append(express ? "express" : "normal").append("\n");
            pw.write(sb.toString());
        }
        pw.close();

    }

}
