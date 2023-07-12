package smartphone;

public class GentleSmartphone {
    private int serialNumber;
    //чувствительность датчика
    private TactileSensor tactileSensor;

    public GentleSmartphone(int serialNumber, TactileSensor tactileSensor) {
        this.serialNumber = serialNumber;
        this.tactileSensor = tactileSensor;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public TactileSensor getTactileSensor() {
        return tactileSensor;
    }
}
