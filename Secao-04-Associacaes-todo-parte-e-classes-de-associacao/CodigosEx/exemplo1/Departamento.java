package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private List<Professor> professores; //agregação

    public Departamento(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
        System.out.println("DEPARTAMENTE de" + this.nome + "criado.");
    }

    public void addProfessor(Professor professor) {
        this.professores.add(professor);
        System.out.println("PROFESSOR ADICIONADO " + professor.getNome() + " ADICIONADO AO DEPARTAMENTO DE " + this.nome);
    }

    public void listarProfessores() {
        System.out.println("PROFESSORES do Departamento de "+ this.nome + ":");
        for (Professor p : professores) {
            System.out.println("- " + p.getNome() + " - Esp.: "+ p.getEspecialidade());
        }
    }
}
