package delivery_system;

public class GeoCoordinate {
    private double latitude;
    private double longitude;

    public GeoCoordinate(double latitude, double longitude) {
        this.latitude = latitude;//широта
        this.longitude = longitude;//долгота
    }

    public double getDistanceTo(GeoCoordinate other) {
        return Math.sqrt(Math.pow(latitude - other.latitude, 2) + Math.pow(longitude - other.longitude, 2));
    }

    public double hypotenuse() {

        return Math.sqrt(Math.pow(latitude, 2)+Math.pow(longitude, 2));
    }
}
