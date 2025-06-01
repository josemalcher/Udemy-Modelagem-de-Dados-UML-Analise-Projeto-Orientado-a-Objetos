package entities;

public class Acessorio {
    private String nome; // Ex: Headphone, Controle, Kinect

    public Acessorio(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Acessorio{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
