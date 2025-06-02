package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private Aluno aluno;
    private Turma turma;
    private LocalDate dataMatricula;
    private int numeroPrestacoes;
    private List<ResultadoAvaliacao> resultadosAvaliacoes; // Notas do aluno nas avaliações da turma

    public Matricula(Aluno aluno, Turma turma, LocalDate dataMatricula, int numeroPrestacoes) {
        this.aluno = aluno;
        this.turma = turma;
        this.dataMatricula = dataMatricula;
        this.numeroPrestacoes = numeroPrestacoes;
        this.resultadosAvaliacoes = new ArrayList<>();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public int getNumeroPrestacoes() {
        return numeroPrestacoes;
    }

    public List<ResultadoAvaliacao> getResultadosAvaliacoes() {
        return resultadosAvaliacoes;
    }

    public void adicionarResultadoAvaliacao(Avaliacao avaliacao, double nota) {
        // Garante que a avaliação pertence à turma da matrícula
        if (turma.getAvaliacoesDaTurma().contains(avaliacao)) {
            // Verifica se já existe um resultado para esta avaliação para este aluno
            for(ResultadoAvaliacao ra : resultadosAvaliacoes){
                if(ra.getAvaliacao().equals(avaliacao)){
                    System.out.println("Erro: Já existe um resultado para o aluno " + aluno.getNome() + " na avaliação " + avaliacao.getDescricao());
                    return;
                }
            }
            this.resultadosAvaliacoes.add(new ResultadoAvaliacao(this, avaliacao, nota));
        } else {
            System.out.println("Erro: Avaliação " + avaliacao.getDescricao() + " não pertence à turma " + turma.getNumeroTurma());
        }
    }

    public double calcularNotaTotal() {
        double somaNotas = 0;
        // Poderia ser uma média ponderada ou soma simples, dependendo da regra de negócio
        // Para este exemplo, faremos uma soma simples.
        for (ResultadoAvaliacao resultado : resultadosAvaliacoes) {
            somaNotas += resultado.getNotaObtida();
        }
        // Se não houver avaliações, a nota total é 0.
        // Se houver, e a regra fosse média, seria somaNotas / resultadosAvaliacoes.size();
        return somaNotas;
    }

    public boolean isAprovado() {
        return calcularNotaTotal() >= turma.getCurso().getNotaMinimaAprocavao();
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "aluno=" + aluno.getNome() +
                ", turma=" + turma.getNumeroTurma() +
                ", dataMatricula=" + dataMatricula +
                '}';
    }
}
