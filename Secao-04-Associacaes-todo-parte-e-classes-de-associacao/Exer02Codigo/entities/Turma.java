package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Curso curso;
    private String numeroTurma;
    private LocalDate dataInicio;
    private int numeroVagas;
    private List<Matricula> matriculas; // Alunos matriculados nesta turma
    private List<Avaliacao> avaliacoesDaTurma; // Avaliações planejadas para esta turma

    public Turma(Curso curso, String numeroTurma, LocalDate dataInicio, int numeroVagas) {
        this.curso = curso;
        this.numeroTurma = numeroTurma;
        this.dataInicio = dataInicio;
        this.numeroVagas = numeroVagas;
        this.matriculas = new ArrayList<>();
        this.avaliacoesDaTurma = new ArrayList<>();
    }

    public Curso getCurso() {
        return curso;
    }

    public String getNumeroTurma() {
        return numeroTurma;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public List<Avaliacao> getAvaliacoesDaTurma() {
        return avaliacoesDaTurma;
    }

    public boolean adicionarMatricula(Aluno aluno, int numeroPrestacoes) {
        if (matriculas.size() < numeroVagas) {
            // Verifica se o aluno já está matriculado nesta turma
            for (Matricula m : matriculas) {
                if (m.getAluno().equals(aluno)) {
                    System.out.println("Erro: Aluno " + aluno.getNome() + " já matriculado nesta turma.");
                    return false;
                }
            }
            Matricula novaMatricula = new Matricula(aluno, this, LocalDate.now(), numeroPrestacoes);
            this.matriculas.add(novaMatricula);
            return true;
        }
        System.out.println("Erro: Turma " + numeroTurma + " lotada.");
        return false;
    }

    public void adicionarAvaliacao(String descricao) {
        Avaliacao novaAvaliacao = new Avaliacao(descricao, this);
        this.avaliacoesDaTurma.add(novaAvaliacao);
    }


    @Override
    public String toString() {
        return "Turma{" +
                "curso=" + curso.getNome() +
                ", numeroTurma='" + numeroTurma + '\'' +
                ", dataInicio=" + dataInicio +
                ", vagas=" + numeroVagas +
                ", matriculados=" + matriculas.size() +
                '}';
    }
}
