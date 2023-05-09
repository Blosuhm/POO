package aula08.food;

import java.util.Objects;

public class Peixe extends Alimento {

    private TipoPeixe tipo;

    public Peixe(TipoPeixe tipo, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.tipo = tipo;
    }

    public TipoPeixe getTipo() {
        return tipo;
    }

    public void setTipo(TipoPeixe tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Peixe " + tipo + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Peixe peixe = (Peixe) o;
        return getTipo() == peixe.getTipo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTipo());
    }
}
