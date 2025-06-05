package entities;

public class Reserva {
    private String assento;
    private Voo voo;
    private Passageiro passageiro;

    public Reserva(String assento, Voo voo, Passageiro passageiro) {
        this.assento = assento;
        this.voo = voo;
        this.passageiro = passageiro;
    }

    public String getAssento() { return assento; }
    public Voo getVoo() { return voo; }
    public Passageiro getPassageiro() { return passageiro; }

    @Override
    public String toString() {
        return "Reserva{" +
                "assento='" + assento + '\'' +
                ", passageiro=" + (passageiro != null ? passageiro.getNome() : "N/D") +
                ", voo=" + (voo != null ? voo.getNumeroVoo() : "N/D") +
                '}';
    }
}
