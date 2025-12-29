package rideservice;

import java.util.concurrent.atomic.AtomicInteger;

public class Driver extends User{
    private Vechile vechile;
    private RideStatus rideStatus;
    private float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Driver(String name, Location location, Vechile vechile) {
        super(name, location);
        this.vechile = vechile;
        this.rideStatus = RideStatus.WAITING;
    }

    public Vechile getVechile() {
        return vechile;
    }

    public void setVechile(Vechile vechile) {
        this.vechile = vechile;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
