package delivery_system;

public class Main {
    public static void main(String[] args) {
        GeoCoordinate coordinate1 = new GeoCoordinate(2,3);
        GeoCoordinate coordinate2 = new GeoCoordinate(5,7);

        double d1 = coordinate1.getDistanceTo(coordinate2);
        //double d2 = GeoCoordinate.getDistanceTo(coordinate1, coordinate2);

    }
}
