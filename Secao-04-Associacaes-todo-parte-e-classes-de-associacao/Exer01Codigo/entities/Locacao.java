package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Locacao {
    private Cliente cliente;
    private LocalDate dataLocacao;
    private List<ItemLocacao> itensLocados;

    public Locacao(Cliente cliente) {
        this.cliente = cliente;
        this.dataLocacao = LocalDate.now(); // Data atual da locação
        this.itensLocados = new ArrayList<>();
    }

    public void adicionarItem(Jogo jogo, Plataforma plataforma, int dias) {
        // Encontra o PrecoJogoPlataforma correspondente
        PrecoJogoPlataforma precoJogoPlataforma = null;
        for (PrecoJogoPlataforma pjp : jogo.getPrecosPorPlataforma()) {
            if (pjp.getPlataforma().equals(plataforma)) {
                precoJogoPlataforma = pjp;
                break;
            }
        }
        if (precoJogoPlataforma != null) {
            this.itensLocados.add(new ItemLocacao(precoJogoPlataforma, dias));
        } else {
            System.out.println("Erro: Jogo " + jogo.getTitulo() + " não disponível ou sem preço para a plataforma " + plataforma.getNome());
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public List<ItemLocacao> getItensLocados() {
        return itensLocados;
    }

    public double calcularTotalLocacao() {
        double total = 0;
        for (ItemLocacao item : itensLocados) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "cliente=" + cliente.getNome() +
                ", dataLocacao=" + dataLocacao +
                ", numeroDeItens=" + itensLocados.size() +
                '}';
    }
}
