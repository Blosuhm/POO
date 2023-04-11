package aula04;

import java.util.ArrayList;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class CashRegister {
    private ArrayList<Product> products;

    public CashRegister() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getTotalValue();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product          Price    Quantity     Total\n");
        for (int i = 0; i < products.size(); i++) {
            sb.append(String.format("%-16s%7.2f%10d%12.2f%n", products.get(i).getName(), products.get(i).getPrice(),
                    products.get(i).getQuantity(), products.get(i).getTotalValue()));
        }
        sb.append("\nTotal value: ").append(String.format("%.2f", getTotal()));
        return sb.toString();

    }
}

public class CashRegisterDemo {

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));

        System.out.println(cr);

    }
}