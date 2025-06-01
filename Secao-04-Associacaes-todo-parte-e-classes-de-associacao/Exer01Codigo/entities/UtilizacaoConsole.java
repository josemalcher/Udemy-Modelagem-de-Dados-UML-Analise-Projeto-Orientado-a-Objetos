package entities;

import java.time.LocalDate;

public class UtilizacaoConsole {
    private Cliente cliente;
    private ConsoleVideoGame console;
    private LocalDate dataUtilizacao;
    private double horasUtilizadas; // Ou usar LocalTime para início e fim

    public UtilizacaoConsole(Cliente cliente, ConsoleVideoGame console, double horasUtilizadas) {
        this.cliente = cliente;
        this.console = console;
        this.dataUtilizacao = LocalDate.now();
        this.horasUtilizadas = horasUtilizadas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ConsoleVideoGame getConsole() {
        return console;
    }

    public double getHorasUtilizadas() {
        return horasUtilizadas;
    }

    public double calcularCustoUtilizacao() {
        return console.getPrecoPorHora() * Math.ceil(horasUtilizadas); // Arredonda para cima a fração de hora
    }

    @Override
    public String toString() {
        return "UtilizacaoConsole{" +
                "cliente=" + cliente.getNome() +
                ", console=" + console.getNomeIdentificador() +
                ", data=" + dataUtilizacao +
                ", horas=" + horasUtilizadas +
                '}';
    }
}
