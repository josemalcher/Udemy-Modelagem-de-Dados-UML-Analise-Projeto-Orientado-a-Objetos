package entities;

import java.time.LocalDate;

public class PagamentoBoleto extends Pagamento {
    private LocalDate dataVencimento;
    private LocalDate dataPagamento; // Será null até o pagamento

    public PagamentoBoleto(double valorTotalPedido, LocalDate dataVencimento) {
        super(valorTotalPedido);
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void registrarPagamento(LocalDate dataPagamento) {
        if (this.estado == EstadoPagamento.PENDENTE) {
            this.dataPagamento = dataPagamento;
            this.setEstado(EstadoPagamento.QUITADO);
            System.out.println("Boleto pago em: " + dataPagamento);
        } else {
            System.out.println("Boleto já está " + this.estado);
        }
    }

    @Override
    public String getDetalhesPagamento() {
        return "Boleto - Vencimento: " + dataVencimento + (dataPagamento != null ? ", Pago em: " + dataPagamento : "");
    }
}
