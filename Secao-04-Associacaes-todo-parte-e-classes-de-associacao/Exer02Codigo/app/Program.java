package app;

import entities.*;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        System.out.println("--- Configurando Sistema Acadêmico ---");

        // 1. Curso
        Curso cursoJava = new Curso("Programação Java Avançada", 60, 1200.00, 14.0); // Nota mínima 14 (soma de 2 avaliações)
        System.out.println("\nCurso Criado:");
        System.out.println(cursoJava);

        // 2. Turma
        Turma turmaJava2025A = new Turma(cursoJava, "TJA-2025A", LocalDate.of(2025, 8, 1), 25);
        System.out.println("\nTurma Criada:");
        System.out.println(turmaJava2025A);

        // 3. Alunos
        Aluno aluno1 = new Aluno("Carlos Silva", "111.222.333-44", LocalDate.of(1990, 5, 15));
        Aluno aluno2 = new Aluno("Mariana Costa", "555.666.777-88", LocalDate.of(1992, 10, 20));
        System.out.println("\nAlunos Criados:");
        System.out.println(aluno1);
        System.out.println(aluno2);

        // 4. Matrículas
        System.out.println("\n--- Realizando Matrículas ---");
        boolean mat1Sucesso = turmaJava2025A.adicionarMatricula(aluno1, 3);
        Matricula matriculaAluno1 = null;
        if (mat1Sucesso) {
            // Achar a matrícula para adicionar resultados
            for (Matricula m : turmaJava2025A.getMatriculas()) {
                if (m.getAluno().equals(aluno1)) {
                    matriculaAluno1 = m;
                    break;
                }
            }
            System.out.println("Matrícula de " + aluno1.getNome() + " realizada: " + matriculaAluno1);
        }

        boolean mat2Sucesso = turmaJava2025A.adicionarMatricula(aluno2, 2);
        Matricula matriculaAluno2 = null;
        if (mat2Sucesso) {
            for (Matricula m : turmaJava2025A.getMatriculas()) {
                if (m.getAluno().equals(aluno2)) {
                    matriculaAluno2 = m;
                    break;
                }
            }
            System.out.println("Matrícula de " + aluno2.getNome() + " realizada: " + matriculaAluno2);
        }

        // 5. Avaliações da Turma
        System.out.println("\n--- Criando Avaliações para a Turma ---");
        turmaJava2025A.adicionarAvaliacao("Prova Teórica 1");
        turmaJava2025A.adicionarAvaliacao("Trabalho Prático Final");

        Avaliacao avaliacao1 = turmaJava2025A.getAvaliacoesDaTurma().get(0);
        avaliacao1.setDataRealizacao(LocalDate.of(2025, 9, 10));
        Avaliacao avaliacao2 = turmaJava2025A.getAvaliacoesDaTurma().get(1);
        avaliacao2.setDataRealizacao(LocalDate.of(2025, 10, 15));

        System.out.println(avaliacao1);
        System.out.println(avaliacao2);

        // 6. Resultados das Avaliações
        System.out.println("\n--- Registrando Resultados das Avaliações ---");
        if (matriculaAluno1 != null) {
            matriculaAluno1.adicionarResultadoAvaliacao(avaliacao1, 7.5);
            matriculaAluno1.adicionarResultadoAvaliacao(avaliacao2, 8.0);
            System.out.println("Resultados de " + aluno1.getNome() + ":");
            for (ResultadoAvaliacao ra : matriculaAluno1.getResultadosAvaliacoes()) {
                System.out.println("  -> " + ra.getAvaliacao().getDescricao() + ": " + ra.getNotaObtida());
            }
            System.out.println("  Nota Total: " + matriculaAluno1.calcularNotaTotal() + " | Aprovado: " + matriculaAluno1.isAprovado());
        }

        if (matriculaAluno2 != null) {
            matriculaAluno2.adicionarResultadoAvaliacao(avaliacao1, 6.0);
            matriculaAluno2.adicionarResultadoAvaliacao(avaliacao2, 6.5);
            System.out.println("Resultados de " + aluno2.getNome() + ":");
            for (ResultadoAvaliacao ra : matriculaAluno2.getResultadosAvaliacoes()) {
                System.out.println("  -> " + ra.getAvaliacao().getDescricao() + ": " + ra.getNotaObtida());
            }
            System.out.println("  Nota Total: " + matriculaAluno2.calcularNotaTotal() + " | Aprovado: " + matriculaAluno2.isAprovado());
        }
    }
}
