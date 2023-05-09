package aula08.food;

import java.util.Objects;

public class Carne extends Alimento {

    private VariedadeCarne variedade;

    public Carne(VariedadeCarne variedade, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.variedade = variedade;
    }

    public VariedadeCarne getVariedade() {
        return variedade;
    }

    public void setVariedade(VariedadeCarne variedade) {
        this.variedade = variedade;
    }

    @Override
    public String toString() {
        return "Carne " + this.variedade + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carne carne = (Carne) o;
        return getVariedade() == carne.getVariedade();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVariedade());
    }
}
