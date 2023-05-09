package aula08.food;

import java.util.Objects;

public class Alimento {

    private double proteinas;
    private double calorias;
    private double peso;


    public Alimento(double proteinas, double calorias, double peso) {
        if (proteinas < 0 || calorias < 0 || peso < 0) {
            throw new IllegalArgumentException("Valores negativos não são permitidos");
        }
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Proteinas " + this.proteinas + ", Calorias " + this.calorias + ", Peso " + this.peso
            ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Alimento alimento = (Alimento) o;
        return Double.compare(alimento.getProteinas(), getProteinas()) == 0
            && Double.compare(alimento.getCalorias(), getCalorias()) == 0
            && Double.compare(alimento.getPeso(), getPeso()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProteinas(), getCalorias(), getPeso());
    }
}
