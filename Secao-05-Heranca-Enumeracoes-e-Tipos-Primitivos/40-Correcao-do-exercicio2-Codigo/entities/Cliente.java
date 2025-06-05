package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String identificadorFiscal; // CPF ou CNPJ
    private String email;
    private List<String> telefones;
    private List<Endereco> enderecos;

    public Cliente(String nome, String identificadorFiscal, String email) {
        this.nome = nome;
        this.identificadorFiscal = identificadorFiscal; // Validar formato de CPF/CNPJ em sistema real
        this.email = email;
        this.telefones = new ArrayList<>();
        this.enderecos = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }

    public String getIdentificadorFiscal() {
        return identificadorFiscal;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void adicionarTelefone(String telefone) {
        this.telefones.add(telefone);
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void adicionarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }
    @Override
    public String toString() {
        return "Cliente{" + "nome='" + nome + "', idFiscal='" + identificadorFiscal + "', email='" + email + "'}";
    }
}
