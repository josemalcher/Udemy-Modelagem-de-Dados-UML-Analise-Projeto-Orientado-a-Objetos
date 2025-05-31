package exemplo2;

public class Participacao {
    private Filme filme;
    private Artista artista;

    private String personagem;

    public Participacao(Filme filme, Artista artista, String personagem) {
        this.filme = filme;
        this.artista = artista;
        this.personagem = personagem;
    }

    public Filme getFilme() {
        return filme;
    }

    public Artista getArtista() {
        return artista;
    }

    public String getPersonagem() {
        return personagem;
    }

    @Override
    public String toString() {
        return "Participacao no " +
                "Filme: " + filme +
                ", Artista: " + artista +
                ", como Personagem:' " + personagem + '\'' +
                '}';
    }
}
