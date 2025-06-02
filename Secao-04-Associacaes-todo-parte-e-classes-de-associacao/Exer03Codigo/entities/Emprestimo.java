package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    public Livro livro;
    Usuario usuario;
    LocalDate dataEmprestimo;
    public LocalDate dataPrevistaDevolucao;
    LocalDate dataDevolucaoReal;
    static final int PRAZO_DIAS = 2;

    public Emprestimo(Livro livro, Usuario usuario) {
        if (livro.emprestado) {
            System.out.println("ALERTA: Livro '" + livro.titulo + "' já emprestado!");
            // Em um sistema real, lançaríamos uma exceção ou retornaríamos null/false
            // Para simplificar, vamos permitir, mas o estado do livro não mudará se já emprestado.
        } else {
            this.livro = livro;
            this.usuario = usuario;
            this.dataEmprestimo = LocalDate.now();
            this.dataPrevistaDevolucao = this.dataEmprestimo.plusDays(PRAZO_DIAS);
            this.livro.emprestado = true;
        }
    }

    public void registrarDevolucao() {
        if (this.livro == null) return; // Empréstimo não efetivado
        this.dataDevolucaoReal = LocalDate.now();
        this.livro.emprestado = false;
        System.out.println("Livro '" + this.livro.titulo + "' devolvido em " + this.dataDevolucaoReal);
    }

    public double calcularMulta() {
        if (this.livro == null || dataDevolucaoReal == null) return 0.0;

        if (dataDevolucaoReal.isAfter(dataPrevistaDevolucao)) {
            long diasAtraso = ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevolucaoReal);
            return diasAtraso * livro.valorMultaDiaria;
        }
        return 0.0;
    }
    @Override
    public String toString() {
        if (this.livro == null) return "Emprestimo Falhou";
        return "Emprestimo de '" + livro.titulo + "' para " + usuario.nome +
                ", Previsto: " + dataPrevistaDevolucao +
                (dataDevolucaoReal != null ? ", Devolvido: " + dataDevolucaoReal : " [PENDENTE]");
    }

}
