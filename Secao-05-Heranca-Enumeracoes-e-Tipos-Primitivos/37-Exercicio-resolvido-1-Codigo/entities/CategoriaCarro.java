package entities;

public class CategoriaCarro {
    private String nome;
    private double valorDiaria;

    public CategoriaCarro(String nome, double valorDiaria) {
        this.nome = nome;
        this.valorDiaria = valorDiaria;
    }

    public String getNome() {
        return nome;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    @Override
    public String toString() {
        return "CategoriaCarro{" +
                "nome='" + nome + '\'' +
                ", valorDiaria=" + valorDiaria +
                '}';
    }
}
