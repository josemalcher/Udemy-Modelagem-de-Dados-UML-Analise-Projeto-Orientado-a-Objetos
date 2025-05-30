package exemplo2;

public class Capitulo {
    private String titulo;
    private int numeroDePaginas;

    public Capitulo(String titulo, int numeroDePaginas) {
        this.titulo = titulo;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Capítulo{" +
                "Titulo='" + titulo + '\'' +
                ", Número de Páginas=" + numeroDePaginas +
                '}';
    }
}
