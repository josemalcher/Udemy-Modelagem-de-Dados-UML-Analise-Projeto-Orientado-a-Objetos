package exemplo2;

public class ProgramAssociacaoUnica {
    public static void main(String[] args) {
        Filme f1 = new Filme(8010, "The Expendables 2", 2012);
        Filme f2 = new Filme(8011, "Titanic", 1997);
        Artista a1 = new Artista(1001, "Jean-Claude Van Damme");
        Artista a2 = new Artista(1002, "Leonardo DiCaprio");

        SistemaFilmesUnico sistemaFilmesUnico = new SistemaFilmesUnico();
        sistemaFilmesUnico.adicionarParticipacao(f1, a1, "Vilain");
        sistemaFilmesUnico.adicionarParticipacao(f2, a2, "Jack downson");

        // Tentativa de adicionar a mesma participação (deve falhar ou ser ignorada pela lógica da unicidade)
        System.out.println("\nTentando adicionar participação duplicada:");
        sistemaFilmesUnico.adicionarParticipacao(f1, a1, "Outro Personagem"); // Não deveria permitir segundo a regra de unicidade

        System.out.println("\nParticipação de Van Damme em Expendables 2: " + sistemaFilmesUnico.getParticipacao(f1, a1).getPersonagem());
    }
}
