package aula08.shoppingCart;

public class GenericProduct implements Product {

    protected final String name;
    protected final double price;
    protected int quantity;

    public GenericProduct(String name, double price, int quantity) {
        validateProduct(name, price, quantity);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void validateProduct(String name, double price, int quantity) {
        validateName(name);
        validatePrice(price);
        validateQuantity(quantity);
    }

    public void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
    }

    public void validatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
    }

    public void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must be non-empty");
        }

        if (name.length() < 2) {
            throw new IllegalArgumentException("Name must be at least 2 characters long");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void addQuantity(int quantity) {
        validateQuantity(quantity);
        this.quantity += quantity;
    }


    @Override
    public void removeQuantity(int quantity) {
        validateQuantity(quantity);
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return String.format("%s(%s units): %.2f€", this.getName(),
            this.getQuantity(),
            this.getPrice());
    }

}
