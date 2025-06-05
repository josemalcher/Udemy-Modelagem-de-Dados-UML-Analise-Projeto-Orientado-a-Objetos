package entities;

import java.util.Objects;

public class Piloto {
    private Pessoa dadosPessoais; // Associação com Pessoa
    private String numeroLicencaVoo;

    public Piloto(Pessoa dadosPessoais, String numeroLicencaVoo) {
        Objects.requireNonNull(dadosPessoais, "Dados pessoais não podem ser nulos para um piloto.");
        this.dadosPessoais = dadosPessoais;
        this.numeroLicencaVoo = numeroLicencaVoo;
    }

    public Pessoa getDadosPessoais() {
        return dadosPessoais;
    }

    public String getNumeroLicencaVoo() {
        return numeroLicencaVoo;
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
        return "Piloto{" +
                "dadosPessoais=" + dadosPessoais +
                ", licenca='" + numeroLicencaVoo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) { // Um piloto é único pela sua licença ou pelos dados pessoais (CPF)
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto piloto = (Piloto) o;
        return Objects.equals(dadosPessoais, piloto.dadosPessoais); // Compara baseado no CPF da Pessoa
    }

    @Override
    public int hashCode() {
        return Objects.hash(dadosPessoais);
    }

}
