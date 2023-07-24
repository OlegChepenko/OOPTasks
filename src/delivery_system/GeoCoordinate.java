package delivery_system;

public class GeoCoordinate {
    private double latitude;
    private double longitude;

    public GeoCoordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getDistanceTo(GeoCoordinate other) {
        return Math.sqrt(Math.pow(latitude - other.latitude, 2) + Math.pow(longitude - other.longitude, 2));
    }

//    public static double getDistanceTo(GeoCoordinate a, GeoCoordinate b) {
//        return 0;
//    }
}
