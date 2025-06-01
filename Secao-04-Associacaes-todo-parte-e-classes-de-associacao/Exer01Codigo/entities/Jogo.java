package entities;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private String titulo;
    // Um jogo pode estar disponível em várias plataformas com preços diferentes
    private List<PrecoJogoPlataforma> precosPorPlataforma;

    public Jogo(String titulo) {
        this.titulo = titulo;
        this.precosPorPlataforma = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void adicionarPrecoPlataforma(Plataforma plataforma, double precoDiario) {
        this.precosPorPlataforma.add(new PrecoJogoPlataforma(this, plataforma, precoDiario));
    }

    public double getPrecoDiario(Plataforma plataforma) {
        for (PrecoJogoPlataforma pjp : precosPorPlataforma) {
            if (pjp.getPlataforma().equals(plataforma)) {
                return pjp.getPrecoDiario();
            }
        }
        return -1; // Ou lançar uma exceção indicando que o jogo não está disponível nessa plataforma ou sem preço
    }

    public List<PrecoJogoPlataforma> getPrecosPorPlataforma() {
        return precosPorPlataforma;
    }

    @Override
    public String toString() {
        return "Jogo{" + "titulo='" + titulo + '\'' + '}';
    }

}
