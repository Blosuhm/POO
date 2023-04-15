package aula08.food;

import java.time.LocalDateTime;

public class Ementa {

    public static final int NR_PRATOS_NA_EMENTA = 7;
    private final Prato[] pratos;
    private final java.time.LocalDateTime dia;
    private String nome;
    private String local;
    private int nrPratosAdicionados;


    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        this.dia = LocalDateTime.now();
        pratos = new Prato[NR_PRATOS_NA_EMENTA];
        nrPratosAdicionados = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nrPratosAdicionados; i++) {
            builder.append(pratos[i]).append(", dia ").append(DiaSemana.values()[i]).append("\n");
        }
        return builder.toString();

    }

    public void addPrato(Prato prato, DiaSemana diaSemana) {
        pratos[nrPratosAdicionados] = prato;
        nrPratosAdicionados++;
    }

    public Prato listarPrato(int ordem) {
        return pratos[ordem];
    }


}
