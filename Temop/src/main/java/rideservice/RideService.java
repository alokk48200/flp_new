package rideservice;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RideService {
    private static RideService instance = null;
    private RiderService riderService;
    private DriverService driverService;

    private RideService(RiderService riderService, DriverService driverService) {
        this.riderService = riderService;
        this.driverService = driverService;
    }

    public static RideService getInstance(RiderService riderService, DriverService driverService){
        if(instance == null){
            synchronized (RiderService.class){
                if(instance == null){
                    instance = new RideService(riderService,driverService);
                }
            }
        }
        return instance;
    }

    public void onBoardDriver(Driver driver){
        driverService.onBoardDriver(driver);
       // System.out.println("this driver is successfullly onboarded " +driver.toString());
    }
    public void onBoardRider(Rider rider){
        riderService.onBoardRider(rider);
       // System.out.println("this rider is successfullly onboarded" + rider.toString());
    }
    private List<Driver> getRide(User user, VehicleType vehicleType){
        return driverService.getRide(user, vehicleType);
    }

    private Ride startRide(Driver driver, Rider rider, Location dst){
        Ride ride = new Ride(driver, rider, rider.getLocation(), dst);
        riderService.startRide(rider, ride);
        driverService.startRide(driver,ride);
        ride.rideUpdate(RideStatus.ONGOING);
        return ride;
    }

    private void  endRide(Ride ride){
        ride.rideUpdate(RideStatus.COMPLETED);
        riderService.endRide(ride.getRider(),ride);
        driverService.endRide(ride.getDriver(), ride);

    }

}
