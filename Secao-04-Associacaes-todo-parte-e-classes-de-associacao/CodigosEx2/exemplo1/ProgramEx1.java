package exemplo1;

import java.util.Date;

public class ProgramEx1 {
    public static void main(String[] args) {
        Estudante aluno1 = new Estudante("E001", "Ana Clara");
        Estudante aluno2 = new Estudante("E002", "Jose Malcher Jr.");

        Turma turmaADS = new Turma("T01", "Analise e dese. de sistemas");
        Turma turmaLogica = new Turma("L01", "Lógica de programação");

        //Instancias da classe de associação
        Matricula matricula01 = new Matricula(aluno1, turmaADS, new Date());
        matricula01.setNotaFinal(8.5);
        matricula01.setStatus(matricula01.calcularStatusAprovacao());

        Matricula matricula02 = new Matricula(aluno2, turmaLogica, new Date());
        matricula02.setNotaFinal(5.5);
        matricula02.setStatus(matricula02.calcularStatusAprovacao());

        Matricula matricula03 = new Matricula(aluno2, turmaADS, new Date());
        matricula03.setNotaFinal(10);
        matricula03.setStatus(matricula03.calcularStatusAprovacao());

        System.out.println(" DETALES DAS MATRICULAS");
        System.out.println(matricula01);
        System.out.println(matricula02);
        System.out.println(matricula03);

        System.out.println();

        System.out.println("Matrículas de " + aluno2.getNome() + ":");
        for (Matricula m : aluno2.getMatriculas()) {
            System.out.println("- Turma: " + m.getTurma().getDisciplina() + ", Nota: " + m.getNotaFinal() + ", Status: " + m.getStatus());
        }
    }
}
