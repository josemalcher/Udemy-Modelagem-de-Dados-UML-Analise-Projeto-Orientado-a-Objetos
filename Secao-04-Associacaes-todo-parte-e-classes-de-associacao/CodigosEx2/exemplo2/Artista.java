package exemplo2;

import java.util.Objects;

public class Artista {
    private Integer idArtista;
    private String nome;

    public Artista(Integer idArtista, String nome) {
        this.idArtista = idArtista;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "idArtista=" + idArtista +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(idArtista, artista.idArtista);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idArtista);
    }
}
