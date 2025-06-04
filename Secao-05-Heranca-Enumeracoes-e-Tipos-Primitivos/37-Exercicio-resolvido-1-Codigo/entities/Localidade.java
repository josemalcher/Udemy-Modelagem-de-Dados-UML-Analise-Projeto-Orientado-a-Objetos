package entities;

public class Localidade {
    private double latitude;
    private double longitude;

    public Localidade(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Localidade{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
