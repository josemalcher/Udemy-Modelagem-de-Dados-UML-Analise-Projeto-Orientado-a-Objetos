package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Carro {
    private String modelo;
    private String placa;
    private CorCarro cor;
    private int ano;
    private LocalDate dataAquisicao;
    private CategoriaCarro categoria;
    private boolean disponivel; // Controla se o carro está disponível para locação

    public Carro(String modelo, String placa, CorCarro cor, int ano, LocalDate dataAquisicao, CategoriaCarro categoria) {
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.dataAquisicao = dataAquisicao;
        this.categoria = categoria;
        this.disponivel = true; // Por padrão, um carro novo está disponível
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public CorCarro getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public CategoriaCarro getCategoria() {
        return categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Carro{" + "modelo='" + modelo + "', placa='" + placa + "', cor=" + cor +
                ", ano=" + ano + ", categoria=" + categoria.getNome() + ", disponivel=" + disponivel + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(placa, carro.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(placa);
    }
}
