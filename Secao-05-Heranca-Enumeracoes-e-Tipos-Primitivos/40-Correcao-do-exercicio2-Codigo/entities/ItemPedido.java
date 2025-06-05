package entities;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double desconto; // Percentual de desconto para este item (ex: 0.1 para 10%)

    public ItemPedido(Produto produto, int quantidade, double desconto) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        if (desconto < 0 || desconto > 1) {
            throw new IllegalArgumentException("Desconto deve estar entre 0.0 e 1.0.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public double calcularSubtotal() {
        double precoBase = produto.getPrecoUnitario() * quantidade;
        double valorDesconto = precoBase * desconto;
        return precoBase - valorDesconto;
    }

    @Override
    public String toString() {
        return produto.getNome() + " (Qtd: " + quantidade + ", Desc: " + (desconto * 100) + "%, Subtotal: " + String.format("%.2f", calcularSubtotal()) + ")";
    }

}
