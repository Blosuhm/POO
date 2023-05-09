package aula08.shoppingCart;

public interface Product {

    String getName();

    double getPrice();

    int getQuantity();

    void addQuantity(int quantity);

    void removeQuantity(int quantity);
}