package entities;

import java.util.ArrayList;
import java.util.List;

public class Colecao {
    String nome;
    public List<Livro> livrosDaColecao = new ArrayList<>();

    public Colecao(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) {
        if (!this.livrosDaColecao.contains(livro)) {
            this.livrosDaColecao.add(livro);
            livro.colecao = this; // Mantendo bidirecionalidade simples
        }
    }
    @Override
    public String toString() { return "Colecao: " + nome; }
}
