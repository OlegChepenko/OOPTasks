package smartphone;

public class Customer {
    private String fullName;
    //уровень нежности
    private byte gentleRate;
    private GentleSmartphone smartphone;
    private Transformator transformModule;

    public Customer(String fullName, byte gentleRate) {
        this.fullName = fullName;
        this.gentleRate = gentleRate;

    }

    public void setSmartphone(GentleSmartphone smartphone) {
        this.smartphone = smartphone;
    }

    public void setTransformModule(Transformator transformModule) {
        this.transformModule = transformModule;
    }

    public String getFullName() {
        return fullName;
    }

    public byte getGentleRate() {
        return gentleRate;
    }

    public GentleSmartphone getSmartphone() {
        return smartphone;
    }

    public Transformator getTransformModule() {
        return transformModule;
    }
}
