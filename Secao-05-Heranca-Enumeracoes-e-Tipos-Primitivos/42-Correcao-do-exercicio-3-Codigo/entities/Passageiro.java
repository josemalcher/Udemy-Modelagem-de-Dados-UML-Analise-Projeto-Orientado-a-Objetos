package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Passageiro {
    private Pessoa dadosPessoais; // Associação com Pessoa
    private LocalDate dataNascimento;
    private List<Telefone> telefones;

    public Passageiro(Pessoa dadosPessoais, LocalDate dataNascimento) {
        Objects.requireNonNull(dadosPessoais, "Dados pessoais não podem ser nulos para um passageiro.");
        this.dadosPessoais = dadosPessoais;
        this.dataNascimento = dataNascimento;
        this.telefones = new ArrayList<>();
    }

    public Pessoa getDadosPessoais() {
        return dadosPessoais;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void adicionarTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }

    public void adicionarTelefone(String numeroTelefone) {
        this.telefones.add(new Telefone(numeroTelefone));
    }

    public String getCpf() {
        return dadosPessoais.getCpf();
    }

    public String getNome() {
        return dadosPessoais.getNome();
    }

    public Sexo getSexo() {
        return dadosPessoais.getSexo();
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "dadosPessoais=" + dadosPessoais +
                ", nascimento=" + dataNascimento +
                ", telefones=" + telefones +
                '}';
    }

    @Override
    public boolean equals(Object o) { // Um passageiro é único pelos seus dados pessoais (CPF)
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passageiro that = (Passageiro) o;
        return Objects.equals(dadosPessoais, that.dadosPessoais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dadosPessoais);
    }


}
