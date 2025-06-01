package entities;

public class PrecoJogoPlataforma {
    private Jogo jogo;
    private Plataforma plataforma;

    private double precoDiario;

    public PrecoJogoPlataforma(Jogo jogo, Plataforma plataforma, double precoDiario) {
        this.jogo = jogo;
        this.plataforma = plataforma;
        this.precoDiario = precoDiario;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    @Override
    public String toString() {
        return "PrecoJogoPlataforma{" +
                "jogo=" + jogo +
                ", plataforma=" + plataforma +
                ", precoDiario=" + precoDiario +
                '}';
    }
}
