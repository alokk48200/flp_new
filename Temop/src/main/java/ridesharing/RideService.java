package ridesharing;

import java.util.ArrayList;
import java.util.Optional;
import java.util.PriorityQueue;

public class RideService {

    FareHandler fareHandler = new BaseFareHandler();

    public RideService() {
        fareHandler.setNext(new WeekendFareHandler())
                .setNext(new PeakHourFareHandler())
                .setNext(new WeatherFareHandler());

    }

    public Optional<Driver> getDriver(Passenger passenger, ArrayList<Driver>drivers, Location location, Wheeler wheeler){
        Driver defaultdriver = null;
//        int a = Integer.MAX_VALUE;
//        for(Driver driver: drivers){
//            if(driver.getBookingStatus().equals(BookingStatus.AVAILABLE)){
//                if(a > findDistance(driver, passenger)){
//                    a = findDistance(driver, passenger);
//                    defaultdriver = driver;
//                }
//            }
//        }
       //return defaultdriver;
        return drivers.stream().filter((d)->(d.getBookingStatus().equals(BookingStatus.AVAILABLE))).filter((d)->d.getVehicle().getWheeler().equals(wheeler)).min((a1,b)->{
            return findDistance(a1, passenger) - findDistance(b, passenger);
        });
    }

    private int findDistance(Driver driver, User user){
        return  (driver.getLocation().getX() - user.getLocation().getX())*(driver.getLocation().getX() - user.getLocation().getX())+
        (driver.getLocation().getY() - user.getLocation().getY())*(driver.getLocation().getY() - user.getLocation().getY());


    }

    public Ride startRide(Driver driver, Passenger user, FairStartegy fairStartegy, Location location){
        Ride ride = new Ride(fairStartegy, user, driver, location);
        ride.acceptRide();
        driver.setBookingStatus(BookingStatus.BOOKED);
        ride.notifyObserver("ride is started ");

        return ride;
    }

    public double calculatefare(Ride ride){
       return fareHandler.apply(ride, (double)0);
    }




}
