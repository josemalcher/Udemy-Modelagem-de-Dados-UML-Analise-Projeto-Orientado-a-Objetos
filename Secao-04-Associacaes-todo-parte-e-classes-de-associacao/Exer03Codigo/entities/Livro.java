package entities;

public class Livro {
    public String titulo;
    String genero;
    // Editora e numeroPaginas omitidos para simplicidade
    double valorMultaDiaria;
    Colecao colecao;
    boolean emprestado = false;

    public Livro(String titulo, String genero, double valorMultaDiaria) {
        this.titulo = titulo;
        this.genero = genero;
        this.valorMultaDiaria = valorMultaDiaria;
    }
    @Override
    public String toString() {
        return "Livro: " + titulo + (colecao != null ? " (Coleção: " + colecao.nome + ")" : "") + (emprestado ? " [EMPRESTADO]" : "");
    }
}
