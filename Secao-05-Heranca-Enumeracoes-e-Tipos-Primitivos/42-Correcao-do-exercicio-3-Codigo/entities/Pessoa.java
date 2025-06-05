package entities;

import java.util.Objects;

public class Pessoa {
    private String cpf;
    private String nome;
    private Sexo sexo;

    public Pessoa(String cpf, String nome, Sexo sexo) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public Sexo getSexo() { return sexo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "PessoaInfo{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}
