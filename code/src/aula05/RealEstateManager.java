package aula05;

public class RealEstateManager {
    public static void main(String[] args) {
        RealEstate imobiliaria = new RealEstate();
        imobiliaria.newProperty("Glória", 2, 30000);
        imobiliaria.newProperty("Vera Cruz", 1, 25000);
        imobiliaria.newProperty("Santa Joana", 3, 32000);
        imobiliaria.newProperty("Aradas", 2, 24000);
        imobiliaria.newProperty("São Bernardo", 2, 20000);

        imobiliaria.sell(1001);
        imobiliaria.setAuction(1002, new DateYMD(2023, 3, 21), 4);
        imobiliaria.setAuction(1003, new DateYMD(2023, 4, 1), 3);
        imobiliaria.setAuction(1001, new DateYMD(2023, 4, 1), 4);
        imobiliaria.setAuction(1010, new DateYMD(2023, 4, 1), 4);

        System.out.println(imobiliaria);

    }
}
