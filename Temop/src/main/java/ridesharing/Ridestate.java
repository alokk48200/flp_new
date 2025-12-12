package ridesharing;

public interface Ridestate {
    void accept(Ride ride);
    void start(Ride ride);
    void completed(Ride ride);
    void cancel(Ride ride);
}
