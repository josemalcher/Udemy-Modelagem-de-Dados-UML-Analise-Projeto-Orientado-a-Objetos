package entities;

import java.time.LocalDateTime;

public class LocacaoDiaria extends Locacao {

    private int numeroDiasPrevistos;

    public LocacaoDiaria(Carro carro, Cliente cliente, Sede sedeRetirada, LocalDateTime dataHoraRetirada, int numeroDiasPrevistos) {
        super(carro, cliente, sedeRetirada, dataHoraRetirada);
        if (numeroDiasPrevistos <= 0) {
            throw new IllegalArgumentException("Número de dias previstos deve ser positivo.");
        }
        this.numeroDiasPrevistos = numeroDiasPrevistos;
    }

    public int getNumeroDiasPrevistos() {
        return numeroDiasPrevistos;
    }

    @Override
    public double calcularValorTotal() {
        if (dataHoraDevolucao == null) {
            // Se não devolvido, pode-se calcular um valor parcial ou esperar devolução
            // Para simplificar, calcularemos com base nos dias previstos se não devolvido.
            // Ou poderia retornar 0 ou lançar exceção se a política for cobrar só na devolução.
            return numeroDiasPrevistos * carro.getCategoria().getValorDiaria();
        }
        // Cálculo considerando os dias efetivamente utilizados.
        // Pode haver regras de negócio para cobrar o previsto ou o utilizado, o que for maior.
        // Aqui, simplificamos para cobrar pelos dias efetivamente utilizados se devolvido.
        long diasUtilizados = java.time.temporal.ChronoUnit.DAYS.between(dataHoraRetirada.toLocalDate(), dataHoraDevolucao.toLocalDate());
        if (diasUtilizados == 0) diasUtilizados = 1; // Mínimo de 1 diária

        return diasUtilizados * carro.getCategoria().getValorDiaria();
    }

    @Override
    public String toString() {
        return super.toString() + " [Tipo: Diária, Previsto: " + numeroDiasPrevistos + " dias]";
    }
}
