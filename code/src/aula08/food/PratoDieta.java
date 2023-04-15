package aula08.food;

public class PratoDieta extends Prato {

    private final double limiteCalorias;

    public PratoDieta(String nome, double limiteCalorias) {
        super(nome);
        this.limiteCalorias = limiteCalorias;
    }

    @Override
    public boolean addIngrediente(Alimento alim) {
        if (totalCalorias() + alim.getCalorias() <= limiteCalorias) {
            return super.addIngrediente(alim);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " - Dieta (" + limiteCalorias + " calorias)";
    }
}
