package aula08.food;

import java.util.Objects;

public class Legume extends Alimento {

    private String nome;

    public Legume(String nome, double proteinas, double calorias, double peso) {
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
        return "Legume " + nome + ", " + super.toString();
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
        Legume legume = (Legume) o;
        return Objects.equals(getNome(), legume.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNome());
    }
}
