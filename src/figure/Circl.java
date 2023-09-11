package figure;

public class Circl extends Figure {
    double p = 3.14;
    double r;

    public Circl(double r) {
        this.r = r;
    }


    @Override
    public double calcArea() {
        double area = Math.PI*Math.pow(r,2);
        return area;
    }
}
