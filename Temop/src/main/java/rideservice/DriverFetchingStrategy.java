package rideservice;

import java.util.List;

public interface DriverFetchingStrategy {
    List<Driver> getRide(List<Driver> drivers, User user, VehicleType vehicleType);
}
