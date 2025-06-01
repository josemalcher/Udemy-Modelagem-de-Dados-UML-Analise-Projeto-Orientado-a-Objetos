package entities;

import java.util.ArrayList;
import java.util.List;

public class ConsoleVideoGame {
    private String nomeIdentificador; // Ex: PS5-01, XBOX-SALA2
    private String tipo; // Ex: PlayStation 5, Xbox Series S
    private double precoPorHora;
    private List<Acessorio> acessorios;

    public ConsoleVideoGame(String nomeIdentificador, String tipo, double precoPorHora) {
        this.nomeIdentificador = nomeIdentificador;
        this.tipo = tipo;
        this.precoPorHora = precoPorHora;
        this.acessorios = new ArrayList<>();
    }

    public void adicionarAcessorio(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }

    public String getNomeIdentificador() {
        return nomeIdentificador;
    }

    public double getPrecoPorHora() {
        return precoPorHora;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    @Override
    public String toString() {
        return "ConsoleVideoGame{" +
                "nomeIdentificador='" + nomeIdentificador + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precoPorHora=" + precoPorHora +
                ", acessorios=" + acessorios.size() +
                '}';
    }
}
