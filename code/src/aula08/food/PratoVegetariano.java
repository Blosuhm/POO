package aula08.food;

public class PratoVegetariano extends Prato {

    public PratoVegetariano(String nome) {
        super(nome);
    }

    @Override
    public boolean addIngrediente(Alimento a) {
        if (a instanceof Cereal || a instanceof Legume) {
            return super.addIngrediente(a);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " - Vegetariano";
    }
}
