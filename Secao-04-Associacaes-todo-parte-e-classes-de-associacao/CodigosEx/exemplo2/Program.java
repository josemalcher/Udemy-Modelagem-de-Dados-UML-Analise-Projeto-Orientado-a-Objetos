package exemplo2;

public class Program {
    public static void main(String[] args) {
        Livro meuLivro = new Livro("JAVA COMO PROGRAMAR E MODELAR");
        meuLivro.adicionarCapitulo("Primeiros passos", 5);
        meuLivro.adicionarCapitulo("Instalação", 2);
        meuLivro.adicionarCapitulo("Oritentação a Obj", 50);
        meuLivro.adicionarCapitulo("Avançado", 100);

        meuLivro.exivirSumario();

    }
}
