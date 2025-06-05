package entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Voo e Reserva permanecem estruturalmente similares, mas agora referenciam Piloto e Passageiro
// que por sua vez contêm Pessoa.
public class Voo {
    private String numeroVoo;
    private LocalDateTime dataHoraPartida;

    private Piloto pilotoResponsavel; // Voo tem um Piloto
    private List<Reserva> reservas;

    public Voo(String numeroVoo, LocalDateTime dataHoraPartida, Piloto pilotoResponsavel) {
        this.numeroVoo = numeroVoo;
        this.dataHoraPartida = dataHoraPartida;
        this.pilotoResponsavel = pilotoResponsavel;
        this.reservas = new ArrayList<>();
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public LocalDateTime getDataHoraPartida() {
        return dataHoraPartida;
    }

    public Piloto getPilotoResponsavel() {
        return pilotoResponsavel;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void adicionarReserva(Passageiro passageiro, String assento) {
        // Verifica se o passageiro já está neste voo
        for (Reserva reservaExistente : reservas) {
            if (reservaExistente.getPassageiro().equals(passageiro)) {
                System.out.println("Aviso: Passageiro " + passageiro.getNome() + " já possui reserva neste voo (" + this.numeroVoo + ").");
                return;
            }
        }
        this.reservas.add(new Reserva(assento, this, passageiro));
    }

    @Override
    public String toString() {
        return "Voo{" +
                "numero='" + numeroVoo + '\'' +
                ", partida=" + dataHoraPartida +
                ", piloto=" + (pilotoResponsavel != null ? pilotoResponsavel.getNome() : "N/D") +
                ", reservas=" + reservas.size() +
                '}';
    }

}
