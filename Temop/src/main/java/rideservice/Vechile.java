package rideservice;

public class Vechile {
    private VehicleType vehicleType;
    private String regitration;
    private String name;
    private String color;

    public Vechile(VehicleType vehicleType, String regitration) {
        this.vehicleType = vehicleType;
        this.regitration = regitration;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegitration() {
        return regitration;
    }

    public void setRegitration(String regitration) {
        this.regitration = regitration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
