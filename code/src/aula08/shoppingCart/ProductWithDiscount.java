package aula08.shoppingCart;

public class ProductWithDiscount extends GenericProduct implements Product {

    private final int discount;


    public ProductWithDiscount(String name, double price, int quantity, int discount) {
        super(name, price, quantity);
        validateDiscount(discount);
        this.discount = discount;
    }

    public void validateDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
    }

    public double getDiscount() {
        return this.discount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * ((double) (100 - this.discount) / 100);
    }

    @Override
    public String toString() {
        return String.format("%s(%s units): %.2f€(-%s%%) -> %.2f", this.getName(),
            this.getQuantity(),
            this.price, this.getDiscount(),
            this.getPrice());
    }
}