package exemplo2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Gerenciador para garantir a unicidade da participação (Filme, Artista)
public class SistemaFilmesUnico {

    // Chave composta para garantir unicidade
    static class ParFimeArtista {
        Filme filme;
        Artista artista;

        public ParFimeArtista(Filme filme, Artista artista) {
            this.filme = filme;
            this.artista = artista;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            ParFimeArtista that = (ParFimeArtista) o;
            return Objects.equals(filme, that.filme) && Objects.equals(artista, that.artista);
        }

        @Override
        public int hashCode() {
            return Objects.hash(filme, artista);
        }
    }


    private Map<ParFimeArtista, Participacao> participacoes = new HashMap<>();

    public void adicionarParticipacao(Filme filme, Artista artista, String personagem) {
        ParFimeArtista par = new ParFimeArtista(filme, artista);
        if (participacoes.containsKey(par)) {
            System.out.println("ERRO: " + artista.getNome() + " já tem uma participação em " + filme.getTitulo());
            return;
        }
        Participacao p = new Participacao(filme, artista, personagem);
        participacoes.put(par, p);
        System.out.println("Adicionado: " + p);
    }

    public Participacao getParticipacao(Filme filme, Artista artista) {
        return participacoes.get(new ParFimeArtista(filme, artista));
    }


}
