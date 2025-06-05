package entities;

public class PagamentoCartaoCredito extends Pagamento{
    private int numeroParcelas;

    public PagamentoCartaoCredito(double valorTotalPedido, int numeroParcelas) {
        super(valorTotalPedido);
        if (numeroParcelas <= 0) {
            throw new IllegalArgumentException("Número de parcelas deve ser positivo.");
        }
        this.numeroParcelas = numeroParcelas;
        // Em um sistema real, a aprovação do cartão mudaria o estado para QUITADO.
        // Para simplificar, vamos assumir que é quitado se o número de parcelas é definido.
        this.setEstado(EstadoPagamento.QUITADO);
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    @Override
    public String getDetalhesPagamento() {
        return "Cartão de Crédito - Parcelas: " + numeroParcelas;
    }
}
