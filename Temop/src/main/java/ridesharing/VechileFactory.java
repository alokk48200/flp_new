package ridesharing;

public class VechileFactory {
    public static Vehicle getVehicle(VehicleType type, String name, String regnum, Wheeler wheeler, Integer pass){
        return switch (type){
            case CAR -> new Vehicle(name, regnum, wheeler, pass);
            case BIKE -> new Vehicle(name, regnum, wheeler, pass);
            case AUTO -> new Vehicle(name, regnum, wheeler, pass);
            default -> {
                throw new RuntimeException("no such vechile type  is there");
            }
        };
    }
}
