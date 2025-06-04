package app;

import entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        System.out.println("--- Sistema de Locadora de Carros ---");

        // Criando Sedes
        Sede sedeCentro = new Sede("SD-CTR-01", new Localidade(-18.9187, -48.2769));
        Sede sedeAeroporto = new Sede("SD-AER-01", new Localidade(-18.8823, -48.2614));
        System.out.println("\nSedes criadas:");
        System.out.println(sedeCentro);
        System.out.println(sedeAeroporto);

        // Criando Categorias de Carro
        CategoriaCarro economico = new CategoriaCarro("Econômico", 100.00);
        CategoriaCarro suv = new CategoriaCarro("SUV", 250.00);
        System.out.println("\nCategorias criadas:");
        System.out.println(economico);
        System.out.println(suv);

        // Criando Carros (2 carros)
        Carro carro1 = new Carro("Fiat Mobi", "QWE1234", CorCarro.BRANCO, 2023, LocalDate.of(2023, 1, 10), economico);
        Carro carro2 = new Carro("Jeep Renegade", "RTY5678", CorCarro.CINZA, 2024, LocalDate.of(2024, 3, 15), suv);
        System.out.println("\nCarros criados:");
        System.out.println(carro1);
        System.out.println(carro2);

        // Criando Cliente (1 cliente)
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", "joao.silva@email.com");
        cliente1.adicionarTelefone("34999998888");
        cliente1.adicionarTelefone("3432321111");
        System.out.println("\nCliente criado:");
        System.out.println(cliente1);

        // Lista para armazenar locações
        List<Locacao> locacoes = new ArrayList<>();

        // Criando Locações (3 locações)
        System.out.println("\n--- Realizando Locações ---");
        try {

            // Locação 1: Diária
            LocalDateTime retirada1 = LocalDateTime.of(2024, 5, 10, 10, 0, 0);
            Locacao locacao1 = new LocacaoDiaria(carro1, cliente1, sedeCentro, retirada1, 5);
            locacoes.add(locacao1);
            System.out.println("Locação 1 registrada: " + locacao1);

            // Locação 2: Longo Período
            LocalDateTime retirada2 = LocalDateTime.of(2024, 6, 1, 14, 30, 0);
            // Para a locação de longo período, o carro1 precisa estar disponível de novo.
            // Vamos simular a devolução da locação1 antes.
            locacao1.registrarDevolucao(retirada1.plusDays(4)); // Devolveu 1 dia antes
            System.out.println("Valor da Locação 1 (diária): R$" + String.format("%.2f", locacao1.calcularValorTotal()));


            Locacao locacao2 = new LocacaoLongoPeriodo(carro1, cliente1, sedeAeroporto, retirada2, 0.15); // 15% de desconto
            locacoes.add(locacao2);
            System.out.println("Locação 2 registrada: " + locacao2);

            // Locação 3: Diária com outro carro
            LocalDateTime retirada3 = LocalDateTime.of(2024, 6, 5, 9, 0, 0);
            Locacao locacao3 = new LocacaoDiaria(carro2, cliente1, sedeCentro, retirada3, 3);
            locacoes.add(locacao3);
            System.out.println("Locação 3 registrada: " + locacao3);

            // Simulando devoluções restantes
            System.out.println("\n--- Simulando Devoluções Finais ---");
            locacao2.registrarDevolucao(retirada2.plusMonths(1).plusDays(5)); // Devolveu após 1 mês e 5 dias
            System.out.println("Valor da Locação 2 (longo período): R$" + String.format("%.2f", locacao2.calcularValorTotal()));

            locacao3.registrarDevolucao(retirada3.plusDays(3)); // Devolveu no prazo
            System.out.println("Valor da Locação 3 (diária): R$" + String.format("%.2f", locacao3.calcularValorTotal()));


        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Erro ao processar locação: " + e.getMessage());
        }
        System.out.println("\n--- Status Final dos Carros ---");
        System.out.println(carro1);
        System.out.println(carro2);

        System.out.println("\n--- Todas as Locações Registradas ---");
        for (Locacao loc : locacoes) {
            System.out.println(loc + " | Valor Final: R$" + String.format("%.2f", loc.calcularValorTotal()));
        }
    }
}
