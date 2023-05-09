package aula08.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Prato implements Comparable<Prato> {

    private final List<Alimento> listaAlimentos;
    private int contagemIngredientes;
    private String nome;

    public Prato(String nome) {
        this.nome = nome;
        listaAlimentos = new ArrayList<>();
        contagemIngredientes = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Prato '" + nome + "', composto por " + contagemIngredientes + " Ingredientes";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prato prato = (Prato) o;
        return contagemIngredientes == prato.contagemIngredientes && Objects.equals(
            listaAlimentos, prato.listaAlimentos) && Objects.equals(getNome(),
            prato.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaAlimentos, contagemIngredientes, getNome());
    }

    public boolean addIngrediente(Alimento alim) {
        listaAlimentos.add(alim);
        this.contagemIngredientes++;
        return true;
    }


    @Override
    public int compareTo(Prato p) {
        if (totalCalorias() < p.totalCalorias()) {
            return -1;
        } else if (totalCalorias() > p.totalCalorias()) {
            return 1;
        }
        return 0;
    }


    public String alimentosInfo() {
        String msg = "";

        for (Alimento alimento : listaAlimentos) {
            msg = msg.concat(alimento.toString());
        }
        return msg;
    }


    public double totalPeso() {
        double p = 0;
        for (Alimento alimento : listaAlimentos) {
            p = p + alimento.getPeso();
        }
        return p;
    }


    public double totalCalorias() {
        double parcial;
        double calorias = 0.0;

        for (Alimento alim : listaAlimentos) {
            parcial = alim.getCalorias();
            calorias = calorias + parcial;
        }
        return calorias;
    }


    public double totalProteinas() {
        double parcial = 0, proteinas = 0;
        for (Alimento alim : listaAlimentos) {
            parcial = alim.getCalorias();
            proteinas = proteinas + parcial;
        }
        return proteinas;
    }

}
