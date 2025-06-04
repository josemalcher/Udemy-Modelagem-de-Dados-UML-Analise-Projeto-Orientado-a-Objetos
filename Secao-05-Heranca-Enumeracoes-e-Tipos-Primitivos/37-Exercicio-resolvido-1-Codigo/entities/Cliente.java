package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private List<String> telefones; // Um cliente pode ter múltiplos telefones

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefones = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
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

    @Override
    public String toString() {
        return "Cliente{" + "nome='" + nome + "', cpf='" + cpf + "', email='" + email + "', telefones=" + telefones + '}';
    }
}
