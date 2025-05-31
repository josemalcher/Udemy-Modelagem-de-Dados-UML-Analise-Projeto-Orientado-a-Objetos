package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Estudante {
    private String idEstudante;
    private String nome;

    // Opcional: Estudante pode manter uma lista de suas matrículas para facilitar a navegação
    private List<Matricula> matriculas;

    public Estudante(String idEstudante, String nome) {
        this.idEstudante = idEstudante;
        this.nome = nome;
        this.matriculas = new ArrayList<>();
    }

    public String getIdEstudante() {
        return idEstudante;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "idEstudante='" + idEstudante + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
