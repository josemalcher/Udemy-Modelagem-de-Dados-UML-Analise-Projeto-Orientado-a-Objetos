package entities;

public class ResultadoAvaliacao {
    private Matricula matricula; // Referência à matrícula do aluno
    private Avaliacao avaliacao;
    private double notaObtida;

    public ResultadoAvaliacao(Matricula matricula, Avaliacao avaliacao, double notaObtida) {
        this.matricula = matricula;
        this.avaliacao = avaliacao;
        this.notaObtida = notaObtida;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public double getNotaObtida() {
        return notaObtida;
    }

    @Override
    public String toString() {
        return "ResultadoAvaliacao{" +
                "aluno=" + matricula.getAluno().getNome() +
                ", avaliacao=" + avaliacao.getDescricao() +
                ", notaObtida=" + notaObtida +
                '}';
    }
}
