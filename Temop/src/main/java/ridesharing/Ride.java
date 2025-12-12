package ridesharing;

import java.util.ArrayList;
import java.util.UUID;

public class Ride {
    private Location srcLocation;
    private Location dstLocation;
    private String id;
    private float distance;
    private FairStartegy fairStartegy;
    private Passenger  passengerId;
    private Driver driverId;
    private ArrayList<User>Observer;
    private Ridestate ridestate;

    public Ride(Location srcLocation, Location dstLocation, FairStartegy fairStartegy) {
        this.id = UUID.randomUUID().toString();
        this.srcLocation = srcLocation;
        this.dstLocation = dstLocation;
        this.fairStartegy = fairStartegy;

    }

    public Ride(FairStartegy fairStartegy, Passenger passenger, Driver driver, Location dstLocation) {
        this.dstLocation =dstLocation;
        this.srcLocation =  passenger.getLocation();
        this.fairStartegy = fairStartegy;
        this.passengerId = passenger;
        this.driverId = driver;
        this.id = UUID.randomUUID().toString();
        this.Observer = new ArrayList<>();
        Observer.add(passenger);
        Observer.add(driver);
        ridestate  = new RideAcceptedState();
      //  notifyObserver("ride is started from loc" + passenger.getLocation().toString());
    }

    public Location getDstLocation() {
        return dstLocation;
    }

    public void setDstLocation(Location dstLocation) {
        this.dstLocation = dstLocation;
    }

    public Location getSrcLocation() {
        return srcLocation;
    }

    public void setSrcLocation(Location srcLocation) {
        this.srcLocation = srcLocation;
    }

    public float getDistance() {
        this.distance =  (srcLocation.getX() - dstLocation.getX())*(srcLocation.getX() - dstLocation.getX())
                +  (srcLocation.getY() - dstLocation.getY())*(srcLocation.getY() - dstLocation.getY()) + (float)0 ;
        return (float) Math.sqrt(distance);
    }

    public double getFair(){
        return this.fairStartegy.calculate(this.getDistance());
    }

    public void notifyObserver(String mesaage){
        for(User user : Observer){
            user.getNotified(mesaage);
        }
    }

    public void setRidestate(Ridestate ridestate) {
        this.ridestate = ridestate;
    }

    public Ridestate getRidestate() {
        return ridestate;
    }
    public void acceptRide(){
        ridestate.accept(this);
    }

  public void startRide(){
        ridestate.start(this);
  }
  public void completeRide(){
        ridestate.completed(this);
  }
  public void cancelRide(){
        ridestate.cancel(this);
  }
}
