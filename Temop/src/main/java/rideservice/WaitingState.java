package rideservice;

public class WaitingState implements RideState{
    @Override
    public void acceptRide(Ride ride) {
        System.out.println("ride is aceepted");
        ride.rideUpdate(RideStatus.ONGOING);
    }

    @Override
    public void startRide(Ride ride) {
        System.out.println("ride is strted");
        ride.rideUpdate(RideStatus.COMPLETED);
    }

    @Override
    public void completeRide(Ride ride) {

    }

    @Override
    public void cancelRide(Ride ride) {

    }

    @Override
    public String getState() {
        return "";
    }
}
