package rideservice;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DriverService {
    private CopyOnWriteArrayList<Driver> drivers;
    private DriverFetchingStrategy driverFetchingStrategy;

    public DriverService() {
        this.driverFetchingStrategy = null;
    }

    public void onBoardDriver(Driver driver){
        drivers.add(driver);
        System.out.println("this driver is successfullly onboarded " +driver.toString());
    }

    public List<Driver> getRide(User user, VehicleType vehicleType){
        return driverFetchingStrategy.getRide(drivers.stream().toList(), user, vehicleType);
    }

    public void startRide(Driver driver, Ride ride){
      driver.setRideStatus(RideStatus.ONGOING);
      driver.setRide(ride);
    }

    public void endRide(Driver driver, Ride ride){
        driver.setRideStatus(RideStatus.COMPLETED);
        driver.setRide(null);
    }

}
