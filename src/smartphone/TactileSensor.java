package smartphone;

public class TactileSensor {
    private byte sensitivity;

    public TactileSensor(byte sensitivity) {
        this.sensitivity = sensitivity;
    }

    public byte getSensitivity() {
        return sensitivity;
    }
}
