package app;

import entities.*;

public class LocadoraDigital {
    public static void main(String[] args) {
        System.out.println("--- Configurando Locadora Digital ---");

        // 1. Plataformas
        Plataforma pc = new Plataforma("PC");
        Plataforma ps5 = new Plataforma("PlayStation 5");
        Plataforma xboxSeriesX = new Plataforma("Xbox Series X");
        System.out.println("\nPlataformas Criadas:");
        System.out.println(pc);
        System.out.println(ps5);
        System.out.println(xboxSeriesX);


        // 2. Jogos e seus preços por plataforma
        Jogo jogoA = new Jogo("Cyberpunk 2077");
        jogoA.adicionarPrecoPlataforma(pc, 5.00);
        jogoA.adicionarPrecoPlataforma(ps5, 6.50);

        Jogo jogoB = new Jogo("Elden Ring");
        jogoB.adicionarPrecoPlataforma(pc, 5.50);
        jogoB.adicionarPrecoPlataforma(ps5, 7.00);

        Jogo jogoC = new Jogo("Forza Horizon 5");
        jogoC.adicionarPrecoPlataforma(pc, 4.50);
        jogoC.adicionarPrecoPlataforma(xboxSeriesX, 6.00);

        Jogo jogoD = new Jogo("Starfield");
        jogoD.adicionarPrecoPlataforma(pc, 6.00);
        jogoD.adicionarPrecoPlataforma(xboxSeriesX, 7.50);

        System.out.println("\nJogos Criados e Preços por Plataforma:");
        System.out.println(jogoA + " | PC: " + jogoA.getPrecoDiario(pc) + " | PS5: " + jogoA.getPrecoDiario(ps5));
        System.out.println(jogoB + " | PC: " + jogoB.getPrecoDiario(pc) + " | PS5: " + jogoB.getPrecoDiario(ps5));
        System.out.println(jogoC + " | PC: " + jogoC.getPrecoDiario(pc) + " | Xbox: " + jogoC.getPrecoDiario(xboxSeriesX));
        System.out.println(jogoD + " | PC: " + jogoD.getPrecoDiario(pc) + " | Xbox: " + jogoD.getPrecoDiario(xboxSeriesX));


        // 3. Clientes
        Cliente cliente1 = new Cliente("Ana Silva", "ana@email.com", "111-1111", "senha123");
        Cliente cliente2 = new Cliente("Bruno Costa", "bruno@email.com", "222-2222", "senha456");
        System.out.println("\nClientes Criados:");
        System.out.println(cliente1);
        System.out.println(cliente2);


        // 4. Locações e Itens de Locação
        System.out.println("\n--- Realizando Locações ---");
        Locacao locacao1 = new Locacao(cliente1);
        locacao1.adicionarItem(jogoA, pc, 3); // Cyberpunk PC por 3 dias
        locacao1.adicionarItem(jogoB, ps5, 5); // Elden Ring PS5 por 5 dias
        System.out.println(locacao1 + " | Total: R$" + String.format("%.2f", locacao1.calcularTotalLocacao()));
        for(ItemLocacao item : locacao1.getItensLocados()){
            System.out.println("  -> " + item);
        }


        Locacao locacao2 = new Locacao(cliente2);
        locacao2.adicionarItem(jogoC, xboxSeriesX, 7); // Forza Xbox por 7 dias
        locacao2.adicionarItem(jogoD, pc, 2); // Starfield PC por 2 dias
        System.out.println(locacao2 + " | Total: R$" + String.format("%.2f", locacao2.calcularTotalLocacao()));
        for(ItemLocacao item : locacao2.getItensLocados()){
            System.out.println("  -> " + item);
        }


        // 5. Consoles e Acessórios
        Acessorio controleExtra = new Acessorio("Controle Extra DualSense");
        Acessorio headphoneGamer = new Acessorio("Headphone Gamer Pulse 3D");
        Acessorio kinect = new Acessorio("Kinect Sensor");
        Acessorio controleXbox = new Acessorio("Controle Xbox Wireless");

        ConsoleVideoGame consolePS5_01 = new ConsoleVideoGame("PS5-SALA1", "PlayStation 5", 15.00);
        consolePS5_01.adicionarAcessorio(controleExtra);
        consolePS5_01.adicionarAcessorio(headphoneGamer);

        ConsoleVideoGame consoleXbox_01 = new ConsoleVideoGame("XBSX-SALA2", "Xbox Series X", 12.50);
        consoleXbox_01.adicionarAcessorio(controleXbox);
        // consoleXbox_01.adicionarAcessorio(kinect); // Exemplo se tivesse kinect

        System.out.println("\nConsoles Criados:");
        System.out.println(consolePS5_01 + " com acessórios: " + consolePS5_01.getAcessorios());
        System.out.println(consoleXbox_01 + " com acessórios: " + consoleXbox_01.getAcessorios());


        // 6. Utilização de Consoles
        System.out.println("\n--- Utilização de Consoles ---");
        UtilizacaoConsole uso1Cliente1 = new UtilizacaoConsole(cliente1, consolePS5_01, 2.5); // Ana usa PS5 por 2.5 horas
        UtilizacaoConsole uso2Cliente1 = new UtilizacaoConsole(cliente1, consoleXbox_01, 1.0); // Ana usa Xbox por 1 hora
        UtilizacaoConsole uso1Cliente2 = new UtilizacaoConsole(cliente2, consolePS5_01, 3.0); // Bruno usa PS5 por 3 horas

        System.out.println(uso1Cliente1 + " | Custo: R$" + String.format("%.2f", uso1Cliente1.calcularCustoUtilizacao()));
        System.out.println(uso2Cliente1 + " | Custo: R$" + String.format("%.2f", uso2Cliente1.calcularCustoUtilizacao()));
        System.out.println(uso1Cliente2 + " | Custo: R$" + String.format("%.2f", uso1Cliente2.calcularCustoUtilizacao()));
    }
}
