package exemplo3;

import exemplo2.Artista;
import exemplo2.Filme;

public class ParticipacaoDetalhada {

    private static int proximoId = 1;
    public Integer idParticipacao;
    public Filme filme; // Referência ao filme
    public Artista artista; // Referência ao artista
    public String personagem;

    public ParticipacaoDetalhada(Filme filme, Artista artista, String personagem) {
        this.idParticipacao = proximoId++;
        this.filme = filme;
        this.artista = artista;
        this.personagem = personagem;
    }

    @Override
    public String toString() {
        return "ParticipacaoDetalhada{" + "id=" + idParticipacao + ", filme=" + filme.getTitulo() +
                ", artista=" + artista.getNome() + ", personagem='" + personagem + '\'' + '}';
    }
}
