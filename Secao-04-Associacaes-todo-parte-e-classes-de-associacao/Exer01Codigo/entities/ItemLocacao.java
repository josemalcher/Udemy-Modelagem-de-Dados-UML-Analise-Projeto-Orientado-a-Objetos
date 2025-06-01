package entities;

public class ItemLocacao {
    private PrecoJogoPlataforma precoJogoPlataforma;  // Contém Jogo, Plataforma e Preço Diário
    private int diasAlugado;

    public ItemLocacao(PrecoJogoPlataforma precoJogoPlataforma, int diasAlugado) {
        this.precoJogoPlataforma = precoJogoPlataforma;
        this.diasAlugado = diasAlugado;
    }

    public PrecoJogoPlataforma getPrecoJogoPlataforma() {
        return precoJogoPlataforma;
    }

    public int getDiasAlugado() {
        return diasAlugado;
    }

    public double calcularSubtotal() {
        return precoJogoPlataforma.getPrecoDiario() * diasAlugado;
    }

    @Override
    public String toString() {
        return "ItemLocacao{" +
                "jogo=" + precoJogoPlataforma.getJogo().getTitulo() +
                ", plataforma=" + precoJogoPlataforma.getPlataforma().getNome() +
                ", precoDiario=" + precoJogoPlataforma.getPrecoDiario() +
                ", diasAlugado=" + diasAlugado +
                '}';
    }
}
