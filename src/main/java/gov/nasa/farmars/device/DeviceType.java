package gov.nasa.farmars.device;

public enum DeviceType {
    FAN("Fan"),
    LAMP("Lamp");

    String name;

    DeviceType(String name) {
        this.name = name;
    }
}
