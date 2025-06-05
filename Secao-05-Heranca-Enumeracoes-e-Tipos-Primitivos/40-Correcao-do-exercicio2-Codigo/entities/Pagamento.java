package entities;

public abstract class Pagamento{
    protected EstadoPagamento estado;
    protected double valorTotalPedido; // O valor que este pagamento precisa cobrir

    public Pagamento(double valorTotalPedido) {
        this.estado = EstadoPagamento.PENDENTE; // Todo pagamento começa como pendente
        this.valorTotalPedido = valorTotalPedido;
    }

    public EstadoPagamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado;
    }

    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    // Método a ser implementado pelas subclasses para detalhar o pagamento
    public abstract String getDetalhesPagamento();

    @Override
    public String toString() {
        return "Pagamento{estado=" + estado + ", valorCobrado=" + String.format("%.2f", valorTotalPedido) + "}";
    }


}
