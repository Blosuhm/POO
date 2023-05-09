package aula08.food;

import java.util.Objects;

public class Cereal extends Alimento {

    private String nome;

    public Cereal(String nome, double proteinas, double calorias, double peso) {
        super(proteinas, calorias, peso);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cereal " + nome + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cereal cereal = (Cereal) o;
        return Objects.equals(getNome(), cereal.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }
}
