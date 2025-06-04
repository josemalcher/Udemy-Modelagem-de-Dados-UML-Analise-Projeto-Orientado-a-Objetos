package entities;

import java.time.LocalDateTime;

// Superclasse abstrata para Locacao, utilizando o padrão Template Method para cálculo de valor (ideia)
public abstract class Locacao {
    protected Carro carro;
    protected Cliente cliente;
    protected Sede sedeRetirada;
    protected LocalDateTime dataHoraRetirada;
    protected LocalDateTime dataHoraDevolucao; // Será null até a devolução

    public Locacao(Carro carro, Cliente cliente, Sede sedeRetirada, LocalDateTime dataHoraRetirada) {
        if (!carro.isDisponivel()) {
            throw new IllegalStateException("Carro " + carro.getPlaca() + " não está disponível para locação.");
        }
        this.carro = carro;
        this.cliente = cliente;
        this.sedeRetirada = sedeRetirada;
        this.dataHoraRetirada = dataHoraRetirada;
        this.carro.setDisponivel(false); // Marca o carro como indisponível
    }

    public Carro getCarro() {
        return carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Sede getSedeRetirada() {
        return sedeRetirada;
    }

    public LocalDateTime getDataHoraRetirada() {
        return dataHoraRetirada;
    }

    public LocalDateTime getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void registrarDevolucao(LocalDateTime dataHoraDevolucao) {
        if (this.dataHoraDevolucao != null) {
            System.out.println("Devolução já registrada para o carro " + carro.getPlaca() + " em " + this.dataHoraDevolucao);
            return;
        }
        if (dataHoraDevolucao.isBefore(this.dataHoraRetirada)) {
            throw new IllegalArgumentException("Data de devolução não pode ser anterior à data de retirada.");
        }
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.carro.setDisponivel(true); // Marca o carro como disponível novamente
        System.out.println("Carro " + carro.getPlaca() + " devolvido em " + this.dataHoraDevolucao + ".");
    }

    // Método abstrato para cálculo do valor, a ser implementado pelas subclasses
    public abstract double calcularValorTotal();

    @Override
    public String toString() {
        return "Locacao{" +
                "carro=" + carro.getPlaca() +
                ", cliente=" + cliente.getNome() +
                ", sedeRetirada=" + sedeRetirada.getCodigoSede() +
                ", retirada=" + dataHoraRetirada +
                ", devolucao=" + (dataHoraDevolucao == null ? "Pendente" : dataHoraDevolucao) +
                '}';
    }

}
