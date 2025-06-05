package entities;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private double precoUnitario;
    private List<Categoria> categorias; // Um produto pode pertencer a várias categorias

    public Produto(String nome, double precoUnitario) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.categorias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void adicionarCategoria(Categoria categoria) {
        if (!this.categorias.contains(categoria)) {
            this.categorias.add(categoria);
        }
    }

    @Override
    public String toString() {
        return "Produto{" + "nome='" + nome + "', precoUnitario=" + precoUnitario + ", categorias=" + categorias.size() + '}';
    }
}
