package aula08.shoppingCart;

import java.util.LinkedHashMap;

public class ShoppingCart implements Purchase {

    private final LinkedHashMap<Product, Integer> products = new LinkedHashMap<>();

    @Override
    public void addProduct(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product must be non-null");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > product.getQuantity()) {
            this.products.put(product, product.getQuantity());
            return;
        }
        if (quantity == 0) {
            return;
        }
        if (this.products.containsKey(product)) {
            int currentQuantity = this.products.get(product);
            this.products.put(product, currentQuantity + quantity);
            return;
        }
        this.products.put(product, quantity);

    }

    @Override
    public void listProducts() {
        for (Product product : products.keySet()) {
            System.out.printf("%s(%s units): %.2f€%n", product.getName(),
                this.products.get(product),
                product.getPrice() * this.products.get(product));
        }
    }

    @Override
    public double calculateTotal() {
        double total = 0;
        for (Product product : this.products.keySet()) {
            total += product.getPrice() * this.products.get(product);
        }
        return total;
    }
}
