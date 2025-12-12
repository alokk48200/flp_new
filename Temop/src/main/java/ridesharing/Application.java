package ridesharing;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Application {
    private static Application application = null;

    private ConcurrentHashMap<Driver, Ride>driverRideConcurrentHashMap;
    private ArrayList<Driver>drivers;
    private RideService rideService;

    private Application(RideService rideService) {
        this.drivers =new ArrayList<>();
        this.driverRideConcurrentHashMap = new ConcurrentHashMap<>();
        this.rideService = rideService;
    }
    // Sinleton design pattern
    public synchronized static Application getInstance(RideService rideService){
        if(application == null){
            application = new Application(rideService);
        }
        return application;
    }
    public Optional<Driver> getDriver(Passenger passenger, Location location, Wheeler wheeler){
      return   this.rideService.getDriver(passenger, drivers, location, wheeler);
    }

    public void addDriver(Driver driver){
        this.drivers.add(driver);
    }


    public Ride bookride(Passenger passenger, Driver driver, FairStartegy fairStartegy, Location location){
        Ride ride = this.rideService.startRide(driver, passenger, fairStartegy,location);

        driverRideConcurrentHashMap.put(driver, ride);
        ride.startRide();
        return ride;
    }
    public void rideComplete(Driver driver){

       Ride ride = driverRideConcurrentHashMap.get(driver);
       // System.out.println("your charge of the jpurney is going to be" + ride.getFair());
        driver.setBookingStatus(BookingStatus.AVAILABLE);
       // ride.notifyObserver("ride is completed thanks visit again !!");
        double fare = rideService.calculatefare(ride);
        System.out.print("total charge for the ride is going to be " + Math.abs(fare *100.0) / 100.0);
        ride.completeRide();
        driverRideConcurrentHashMap.remove(driver);
        System.out.println("ride compleetd sucessfully");

        return;
    }
}
