package aula08.shoppingCart;

public interface Purchase {

    void addProduct(Product product, int quantity);

    void listProducts();

    double calculateTotal();
}