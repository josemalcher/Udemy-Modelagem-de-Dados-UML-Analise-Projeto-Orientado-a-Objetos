package entities;

public class Sede {
    private String codigoSede;
    private Localidade localidade;

    public Sede(String codigoSede, Localidade localidade) {
        this.codigoSede = codigoSede;
        this.localidade = localidade;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    @Override
    public String toString() {
        return "Sede{" +
                "codigoSede='" + codigoSede + '\'' +
                ", localidade=" + localidade +
                '}';
    }


}
