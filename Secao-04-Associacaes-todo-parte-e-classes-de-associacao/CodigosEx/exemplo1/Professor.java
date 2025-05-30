package exemplo1;

public class Professor {
    private String nome;
    private String especialidade;

    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "Nome='" + nome + '\'' +
                ", Especialidade='" + especialidade + '\'' +
                '}';
    }
}
