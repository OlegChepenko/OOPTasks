package smartphone;
/*
* класс Transformator, имеет серийный номер и показатель того,
*  повышает он чувствительность датчика или понижает (перечисление)
* */
public class Transformator {
    private int serialNumber;
    private TransformatorType transformatorType;

    public Transformator(int serialNumber, TransformatorType transformatorType) {
        this.serialNumber = serialNumber;
        this.transformatorType = transformatorType;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public TransformatorType getTransformatorType() {
        return transformatorType;
    }
}
