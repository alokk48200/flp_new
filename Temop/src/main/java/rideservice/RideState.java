package rideservice;

public interface RideState {
    void acceptRide(Ride ride);
    void startRide(Ride ride);
    void completeRide(Ride ride);
    void cancelRide(Ride ride);

    String getState();
}
