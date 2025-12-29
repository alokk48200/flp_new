package rideservice;

import java.util.ArrayList;

public class Ride implements Runnable{
    private Rider rider;
    private Driver driver;
    private String id;
    private ArrayList<User>users;
    private Location src;
    private Location dst;

    public Ride(Driver driver, Rider rider, Location src, Location dst) {
        this.driver = driver;
        this.rider = rider;
        this.src = src;
        this.dst = dst;
    }
    public void rideUpdate(RideStatus rideStatus){
        driver.update("the ride staus is " + rideStatus);
        rider.update("the ride staus is " + rideStatus);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public void run() {
        while (src.getLog() != dst.getLog() )

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


    }

    class RideBuilder{
        private Rider rider;
        private Driver driver;
        private String id;
        private ArrayList<User>users;
        private Location src;
        private Location dst;

        public RideBuilder setRider(Rider rider){
            this.rider = rider;
            return this;
        }

        public RideBuilder setDriver(Driver driver){
            this.driver = driver;
            return this;
        }
          public RideBuilder setSrcLocation(Location  location){
            this.src = location;
            return this;
        }

        public RideBuilder setDstLocation(Location location){
            this.dst = location;
            return this;
        }

        public Ride build(){
            Ride ride = new Ride(this.driver, this.rider, this.src, this.dst);
            return ride;
        }
    }
}
