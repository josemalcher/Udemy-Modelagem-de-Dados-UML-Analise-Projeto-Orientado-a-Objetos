package entities;

public class Curso {
    private String nome;
    private int cargaHoraria; // HORAS
    private double valor;
    private double notaMinimaAprocavao;

    public Curso(String nome, int cargaHoraria, double valor, double notaMinimaAprocavao) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.valor = valor;
        this.notaMinimaAprocavao = notaMinimaAprocavao;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public double getValor() {
        return valor;
    }

    public double getNotaMinimaAprocavao() {
        return notaMinimaAprocavao;
    }

    @Override
    public String toString() {
        return "curso{" +
                "nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", valor=" + valor +
                ", notaMinimaAprocavao=" + notaMinimaAprocavao +
                '}';
    }
}
