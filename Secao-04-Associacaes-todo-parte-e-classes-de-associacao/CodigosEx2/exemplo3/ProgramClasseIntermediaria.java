package exemplo3;

import exemplo2.Artista;
import exemplo2.Filme;

public class ProgramClasseIntermediaria {
    public static void main(String[] args) {

        Filme filmeDI = new Filme(8010, "Double Impact", 1991);
        Artista artistaJCVD = new Artista(1001, "Jean-Claude Van Damme");

        SistemaFilmesMultipla sistemaFilmesMultipla = new SistemaFilmesMultipla();

        sistemaFilmesMultipla.adicionarParticipacao(filmeDI, artistaJCVD, "Alex Wagner");
        sistemaFilmesMultipla.adicionarParticipacao(filmeDI, artistaJCVD, "Chad Wagner");

        sistemaFilmesMultipla.listarParticipacoesPorFilme(filmeDI);

    }
}
