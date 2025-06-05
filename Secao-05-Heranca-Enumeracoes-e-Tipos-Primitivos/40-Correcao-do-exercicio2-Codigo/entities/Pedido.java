package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static int proximoNumeroPedido = 1; // Simples gerador de ID de pedido
    private int numeroPedido;
    private Cliente cliente;
    private Endereco enderecoEntrega;
    private LocalDateTime instanteRealizacao;
    private List<ItemPedido> itens;
    private Pagamento pagamento; // Um pedido tem um pagamento associado

    public Pedido(Cliente cliente, Endereco enderecoEntrega) {
        if (enderecoEntrega == null) {
            throw new IllegalArgumentException("Endereço de entrega é obrigatório.");
        }
        if (!cliente.getEnderecos().contains(enderecoEntrega)) {
            // Em um sistema real, pode ser uma referência ou uma cópia do endereço na hora do pedido
            System.out.println("Aviso: Endereço de entrega não está na lista de endereços do cliente, mas será usado.");
        }
        this.numeroPedido = proximoNumeroPedido++;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.instanteRealizacao = LocalDateTime.now();
        this.itens = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public LocalDateTime getInstanteRealizacao() {
        return instanteRealizacao;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(Produto produto, int quantidade, double desconto) {
        // Verifica se o produto já está no pedido para evitar duplicidade de item,
        // ou permitiria adicionar o mesmo produto com descontos diferentes como itens separados.
        // Para este exemplo, permitimos itens distintos do mesmo produto.
        this.itens.add(new ItemPedido(produto, quantidade, desconto));
    }

    public double calcularValorTotalItens() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void setPagamento(Pagamento pagamento) {
        // Garante que o valor do pagamento corresponde ao total do pedido
        if (pagamento.getValorTotalPedido() != calcularValorTotalItens()) {
            throw new IllegalArgumentException("O valor do pagamento (R$" + pagamento.getValorTotalPedido() +
                    ") não corresponde ao total do pedido (R$" + calcularValorTotalItens() + ").");
        }
        this.pagamento = pagamento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    @Override
    public String toString() {
        return "Pedido Nº" + numeroPedido + " [Cliente: " + cliente.getNome() +
                ", Itens: " + itens.size() +
                ", Total: R$" + String.format("%.2f", calcularValorTotalItens()) +
                ", Pagamento: " + (pagamento != null ? pagamento.getEstado() + " - " + pagamento.getDetalhesPagamento() : "N/D") +
                "]";
    }


}
