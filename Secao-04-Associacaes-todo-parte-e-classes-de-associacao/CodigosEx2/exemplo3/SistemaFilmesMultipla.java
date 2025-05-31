package exemplo3;

import exemplo2.Artista;
import exemplo2.Filme;

import java.util.ArrayList;
import java.util.List;

public class SistemaFilmesMultipla {

    private List<ParticipacaoDetalhada> todasParticipacoes = new ArrayList<>();

    public void adicionarParticipacao(Filme filme, Artista artista, String personagem) {
        ParticipacaoDetalhada p = new ParticipacaoDetalhada(filme, artista, personagem);
        todasParticipacoes.add(p);
        System.out.println("Adicionado: " + p);
    }

    public void listarParticipacoesPorFilme(Filme filme) {
        System.out.println("Participações em " + filme.getTitulo());
        for (ParticipacaoDetalhada p : todasParticipacoes) {
            if (p.filme.equals(filme)) {
                System.out.println("- " + p.artista + " com " + p.personagem);
            }
        }
    }



}
