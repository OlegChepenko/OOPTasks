package stream_task;

public class City {
    private String name;
    private String region;
    private String area;
    private int population;
    private int year;


    public City(String name, String region, String area, int population, int year) {
        this.name = name;
        this.region = region;
        this.area = area;
        this.population = population;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getArea() {
        return area;
    }

    public int getPopulation() {
        return population;
    }

    public int getYear() {
        return year;
    }
}
