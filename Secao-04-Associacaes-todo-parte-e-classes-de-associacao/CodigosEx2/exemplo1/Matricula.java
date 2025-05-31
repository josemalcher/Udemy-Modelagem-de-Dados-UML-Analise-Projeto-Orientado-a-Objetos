package exemplo1;

import java.util.Date;

public class Matricula {
    private Estudante estudante;
    private Turma turma;
    private Date dataMaticula;
    private String status;
    private double notaFinal;

    public Matricula(Estudante estudante, Turma turma, Date dataMaticula) {
        this.estudante = estudante;
        this.turma = turma;
        this.dataMaticula = dataMaticula;
        this.status = "CURSANDO"; // STATUS INICIAL

        // Adiciona esta matrícula às listas do estudante e da turma para navegação bidirecional
        estudante.adicionarMatricula(this);
        turma.adicionaMatricula(this);
        System.out.println("Matrícula realizada para " + estudante.getNome() + " na turma " + turma.getCodTurma());
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public Turma getTurma() {
        return turma;
    }

    public Date getDataMaticula() {
        return dataMaticula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String calcularStatusAprovacao() {
        if (notaFinal >= 7.0) {
            return "Aprovado";
        } else if (notaFinal >= 5.0) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "estudante=" + estudante.getNome() +
                ", turma=" + turma.getCodTurma() + " (" + turma.getDisciplina() + ")" +
                ", dataMaticula=" + dataMaticula +
                ", status='" + status + '\'' +
                '}';
    }
}
