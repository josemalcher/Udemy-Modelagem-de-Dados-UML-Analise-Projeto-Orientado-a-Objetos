package exemplo2;

import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String tituloLivro;
    private List<Capitulo> capitulos; // composição

    public Livro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
        this.capitulos = new ArrayList<>();
        System.out.println("-----Livro " + this.tituloLivro + " criado");
    }

    // o LIvro é responsavel pela criação de seus capitulos
    public void adicionarCapitulo(String tituloCapitulo, int numeroPaginas) {
        Capitulo novoCapitulo = new Capitulo(tituloCapitulo, numeroPaginas);
        this.capitulos.add(novoCapitulo);
    }

    public void exivirSumario() {
        System.out.println("Sumário do LIvro: " + this.tituloLivro);
        for (int i = 0; i < this.capitulos.size(); i++) {
            System.out.println((i + 1) + ". " + capitulos.get(i).getTitulo());
        }
//        for (Capitulo c : capitulos) {
//            System.out.println("- " + c.getTitulo());
//        }
    }
    // Quando um objeto Livro é destruído (coletado pelo Garbage Collector, por exemplo),
    // os objetos Capitulo contidos em sua lista 'capitulos' também se tornarão
    // elegíveis para coleta, assumindo que não há outras referências a eles
    // (o que violaria a premissa da composição forte).


}
