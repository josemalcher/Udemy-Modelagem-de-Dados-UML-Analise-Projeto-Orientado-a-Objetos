package app;

import entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {

        System.out.println("--- Sistema de Companhia Aérea (com Associação para Pessoa) ---");

        // Criando dados base de Pessoas
        Pessoa pessoaAna = new Pessoa("111.111.111-11", "Ana Silva", Sexo.FEMININO);
        Pessoa pessoaBruno = new Pessoa("222.222.222-22", "Bruno Costa", Sexo.MASCULINO);
        Pessoa pessoaCarlos = new Pessoa("333.333.333-33", "Carlos Dias", Sexo.MASCULINO);
        Pessoa pessoaFernanda = new Pessoa("444.444.444-44", "Fernanda Lima", Sexo.FEMININO);

        // Criando Pilotos (associados a uma Pessoa)
        Piloto piloto1 = new Piloto(pessoaAna, "PL12345");
        Piloto piloto2 = new Piloto(pessoaBruno, "PL67890");
        System.out.println("\nPilotos Criados:");
        System.out.println(piloto1);
        System.out.println(piloto2);

        // Criando Passageiros (associados a uma Pessoa)
        Passageiro passageiro1 = new Passageiro(pessoaCarlos, LocalDate.of(1990, 5, 15));
        passageiro1.adicionarTelefone("11987654321");
        passageiro1.adicionarTelefone(new Telefone("1133334444"));

        Passageiro passageiro2 = new Passageiro(pessoaFernanda, LocalDate.of(1985, 10, 20));
        passageiro2.adicionarTelefone("21912345678");

        // Piloto1 (Ana Silva) também será passageira em um voo.
        // Ela já tem seus dados em 'pessoaAna'.
        Passageiro pilotoComoPassageiro = new Passageiro(pessoaAna, LocalDate.of(1980, 1, 1)); // Usamos os mesmos dados de pessoaAna
        pilotoComoPassageiro.adicionarTelefone("31999990000");

        System.out.println("\nPassageiros Criados:");
        System.out.println(passageiro1);
        System.out.println(passageiro2);
        System.out.println("Piloto como Passageiro: " + pilotoComoPassageiro + " (CPF: " + pilotoComoPassageiro.getCpf() + ")");

        // Criando Voos
        System.out.println("\n--- Criando Voos e Adicionando Passageiros ---");
        Voo voo1 = new Voo("G3-101", LocalDateTime.of(2025, 8, 10, 10, 0), piloto1);
        voo1.adicionarReserva(passageiro1, "12A");
        voo1.adicionarReserva(passageiro2, "12B"); // Voo com mais de um passageiro
        System.out.println("Voo 1 criado: " + voo1);
        for(Reserva r : voo1.getReservas()) System.out.println("  -> " + r);

        Voo voo2 = new Voo("AD-202", LocalDateTime.of(2025, 8, 11, 15, 30), piloto2);
        // Adicionando o Piloto1 (Ana Silva, representada por pilotoComoPassageiro) como passageiro no voo2
        voo2.adicionarReserva(pilotoComoPassageiro, "7F");
        System.out.println("\nVoo 2 criado: " + voo2);
        for(Reserva r : voo2.getReservas()) System.out.println("  -> " + r);


        System.out.println("\n--- Verificações Finais ---");
        System.out.println("Detalhes do Voo G3-101:");
        System.out.println("  Piloto: " + voo1.getPilotoResponsavel().getNome());
        System.out.println("  Passageiros:");
        for (Reserva reserva : voo1.getReservas()) {
            System.out.println("    - " + reserva.getPassageiro().getNome() + " (CPF: " + reserva.getPassageiro().getCpf() + ") no assento " + reserva.getAssento());
        }

        System.out.println("\nDetalhes do Voo AD-202:");
        System.out.println("  Piloto: " + voo2.getPilotoResponsavel().getNome());
        System.out.println("  Passageiros:");
        for (Reserva reserva : voo2.getReservas()) {
            System.out.println("    - " + reserva.getPassageiro().getNome() + " (CPF: " + reserva.getPassageiro().getCpf() + ") no assento " + reserva.getAssento());
        }

    }
}
