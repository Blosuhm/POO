package aula08.shoppingCart;

public class ShoppingCartTester {

    public static void main(String[] args) {
        Product p1 = new GenericProduct("Camisolas", 10, 3);
        Product p2 = new GenericProduct("Calças", 30, 1);
        Product p3 = new ProductWithDiscount("Sapatilhas", 50, 2, 50);
        Product p4 = new ProductWithDiscount("Casacos", 100, 1, 10);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(p1, 1);
        shoppingCart.addProduct(p2, 5);
        shoppingCart.addProduct(p3, 2);
        shoppingCart.addProduct(p4, 1);

        shoppingCart.listProducts();
        System.out.printf("Preço total da compra %.2f€\n", shoppingCart.calculateTotal());
    }
}
