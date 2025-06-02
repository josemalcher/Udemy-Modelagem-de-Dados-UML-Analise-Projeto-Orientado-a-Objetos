package app;

import entities.Colecao;
import entities.Emprestimo;
import entities.Livro;
import entities.Usuario;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        System.out.println("--- Sistema de Biblioteca (Simplificado) ---");

        // 1. Coleção
        Colecao ficcaoClassica = new Colecao("Ficção Clássica");

        // 2. Livros (3 livros, pelo menos 1 em coleção)
        Livro livroA = new Livro("1984", "Distopia", 0.50);
        Livro livroB = new Livro("Admirável Mundo Novo", "Distopia", 0.60);
        ficcaoClassica.adicionarLivro(livroA); // livroA na coleção
        // ou livroA.colecao = ficcaoClassica;

        Livro livroC = new Livro("O Sol é Para Todos", "Drama", 0.40);

        System.out.println(livroA);
        System.out.println(livroB);
        System.out.println(livroC);
        System.out.println(ficcaoClassica + " contém " + ficcaoClassica.livrosDaColecao.size() + " livro(s).");


        // 3. Usuário (1 usuário)
        Usuario user1 = new Usuario("Maria Leitora");
        System.out.println(user1);

        // 4. Empréstimos (2 empréstimos)
        System.out.println("\n--- Empréstimos ---");
        Emprestimo emp1 = new Emprestimo(livroA, user1);
        if (emp1.livro != null) System.out.println(emp1);


        Emprestimo emp2 = new Emprestimo(livroC, user1);
        if (emp2.livro != null) System.out.println(emp2);

        // Tentativa de emprestar livro já emprestado (livroA)
        System.out.println("\nTentando emprestar '" + livroA.titulo + "' novamente:");
        Emprestimo emp3 = new Emprestimo(livroA, user1);
        if (emp3.livro != null) System.out.println(emp3); // Não deveria mudar estado do livroA
        else System.out.println("Empréstimo de '" + livroA.titulo + "' não pôde ser realizado (já emprestado).");
        System.out.println(livroA); // Verificar status

        // 5. Devoluções e Multas (Simulação)
        System.out.println("\n--- Devoluções ---");

        // Devolvendo o primeiro livro (emp1 - livroA)
        // Para simular atraso, poderíamos manipular a dataDevolucaoReal ou dataPrevistaDevolucao
        // Aqui, vamos simular uma devolução simples hoje.
        if (emp1.livro != null) {
            emp1.registrarDevolucao();
            System.out.println("Multa para emp1: R$" + emp1.calcularMulta());
            System.out.println(livroA); // Verificar status
        }


        // Devolvendo o segundo livro (emp2 - livroC) com simulação de atraso manual para cálculo
        if (emp2.livro != null) {
            // Para forçar a multa, vamos "fingir" que a data prevista era antes
            emp2.dataPrevistaDevolucao = LocalDate.now().minusDays(3); // Fingindo que o prazo já passou 3 dias
            emp2.registrarDevolucao(); // Devolve hoje
            System.out.println("Multa para emp2: R$" + emp2.calcularMulta());
            System.out.println(livroC); // Verificar status
        }
    }
}
