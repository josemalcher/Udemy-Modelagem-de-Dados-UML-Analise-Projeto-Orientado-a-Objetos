package app;

import entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.println("--- Sistema de Pedidos ---");

        // Criando Categorias
        Categoria eletronicos = new Categoria("Eletrônicos");
        Categoria livros = new Categoria("Livros");
        Categoria informatica = new Categoria("Informática");

        // Criando Produtos (3 produtos)
        Produto produto1_notebook = new Produto("Notebook Gamer XYZ", 5500.00);
        produto1_notebook.adicionarCategoria(eletronicos);
        produto1_notebook.adicionarCategoria(informatica);

        Produto produto2_livro = new Produto("A Arte da Guerra", 35.00);
        produto2_livro.adicionarCategoria(livros);

        Produto produto3_mouse = new Produto("Mouse Sem Fio ABC", 120.00);
        produto3_mouse.adicionarCategoria(eletronicos);
        produto3_mouse.adicionarCategoria(informatica);

        System.out.println("\nProdutos disponíveis:");
        System.out.println(produto1_notebook);
        System.out.println(produto2_livro);
        System.out.println(produto3_mouse);

        // Criando Cliente (1 cliente)
        Cliente cliente1 = new Cliente("Empresa Alfa Ltda", "12.345.678/0001-99", "contato@alfa.com");

        Endereco end1Cliente1 = new Endereco("Rua das Palmeiras", "100", "Centro", "São Paulo", "01000-000");
        Endereco end2Cliente1 = new Endereco("Av. Principal", "50B", "Comercial", "São Paulo", "02000-000");

        cliente1.adicionarTelefone("11999998888");
        cliente1.adicionarEndereco(end1Cliente1);
        cliente1.adicionarEndereco(end2Cliente1);
        System.out.println("\nCliente criado: " + cliente1);
        System.out.println("Endereços do cliente: " + cliente1.getEnderecos());

        // Lista para armazenar pedidos
        List<Pedido> todosPedidos = new ArrayList<>();

        // Criando Pedidos (2 pedidos)
        System.out.println("\n--- Criando Pedidos ---");

        // Pedido 1: Mais de um produto, pago com Boleto
        Pedido pedido1 = new Pedido(cliente1, end1Cliente1); // Usando o primeiro endereço do cliente
        pedido1.adicionarItem(produto1_notebook, 1, 0.05); // 5% de desconto no notebook
        pedido1.adicionarItem(produto3_mouse, 2, 0.0);    // Sem desconto no mouse

        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto(pedido1.calcularValorTotalItens(), LocalDate.now().plusDays(7));
        pedido1.setPagamento(pagamentoBoleto);
        todosPedidos.add(pedido1);
        System.out.println("Pedido 1 criado: " + pedido1);
        for (ItemPedido item : pedido1.getItens()) {
            System.out.println("  -> " + item);
        }

        // Simulando pagamento do boleto
        pagamentoBoleto.registrarPagamento(LocalDate.now().plusDays(2));
        System.out.println("Status atualizado Pedido 1: " + pedido1);


        // Pedido 2: Um produto, pago com Cartão de Crédito
        Pedido pedido2 = new Pedido(cliente1, end2Cliente1); // Usando o segundo endereço do cliente
        pedido2.adicionarItem(produto2_livro, 3, 0.10); // 10% de desconto no livro

        PagamentoCartaoCredito pagamentoCartao = new PagamentoCartaoCredito(pedido2.calcularValorTotalItens(), 3); // 3 parcelas
        pedido2.setPagamento(pagamentoCartao);
        todosPedidos.add(pedido2);
        System.out.println("\nPedido 2 criado: " + pedido2);
        for (ItemPedido item : pedido2.getItens()) {
            System.out.println("  -> " + item);
        }

        System.out.println("\n--- Resumo dos Pedidos ---");
        for (Pedido p : todosPedidos) {
            System.out.println(p);
        }

    }
}
