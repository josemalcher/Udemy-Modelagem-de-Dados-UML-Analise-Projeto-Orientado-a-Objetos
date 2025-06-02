package entities;

public class Usuario {
    String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() { return "Usuario: " + nome; }
}
