package exemplo2;

import java.util.Objects;

public class Filme {

    private Integer idFilme;
    private String titulo;
    private Integer ano;

    public Filme(Integer idFilme, String titulo, Integer ano) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.ano = ano;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "idFilme=" + idFilme +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(idFilme, filme.idFilme);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idFilme);
    }
}
