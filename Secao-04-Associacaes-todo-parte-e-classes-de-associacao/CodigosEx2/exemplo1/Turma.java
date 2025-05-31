package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codTurma;
    private String disciplina;

    //Opcional: TUrma pode manter uma lista de suas matriculas
    protected List<Matricula> matriculas;

    public Turma(String codTurma, String disciplina) {
        this.codTurma = codTurma;
        this.disciplina = disciplina;
        this.matriculas = new ArrayList<>();
    }

    public String getCodTurma() {
        return codTurma;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void adicionaMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "codTurma='" + codTurma + '\'' +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}

