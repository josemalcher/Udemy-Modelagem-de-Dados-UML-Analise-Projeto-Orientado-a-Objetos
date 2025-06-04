package entities;

import java.time.LocalDateTime;

public class LocacaoLongoPeriodo extends Locacao {

    private double percentualDesconto; // Ex: 0.1 para 10% de desconto

    public LocacaoLongoPeriodo(Carro carro, Cliente cliente, Sede sedeRetirada, LocalDateTime dataHoraRetirada, double percentualDesconto) {
        super(carro, cliente, sedeRetirada, dataHoraRetirada);
        if (percentualDesconto < 0 || percentualDesconto > 1) {
            throw new IllegalArgumentException("Percentual de desconto deve estar entre 0.0 e 1.0.");
        }
        this.percentualDesconto = percentualDesconto;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    @Override
    public double calcularValorTotal() {
        if (dataHoraDevolucao == null) {
            // Política para cálculo pendente (pode ser complexa, ex: cobrar por mês fechado)
            // Para simplificar, se não devolvido, não calculamos valor final.
            // Em um sistema real, poderia haver faturamento mensal.
            System.out.println("Cálculo de valor para longo período pendente até devolução.");
            return 0.0; // Ou lançar exceção
        }
        long diasUtilizados = java.time.temporal.ChronoUnit.DAYS.between(dataHoraRetirada.toLocalDate(), dataHoraDevolucao.toLocalDate());
        if (diasUtilizados == 0) diasUtilizados = 1; // Mínimo

        double valorBase = diasUtilizados * carro.getCategoria().getValorDiaria();
        double desconto = valorBase * percentualDesconto;
        return valorBase - desconto;
    }

    @Override
    public String toString() {
        return super.toString() + " [Tipo: Longo Período, Desconto: " + (percentualDesconto * 100) + "%]";
    }

}
