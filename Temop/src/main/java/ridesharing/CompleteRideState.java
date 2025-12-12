package ridesharing;

public class CompleteRideState implements Ridestate{
    @Override
    public void accept(Ride ride) {

    }

    @Override
    public void start(Ride ride) {

    }

    @Override
    public void completed(Ride ride) {
         ride.cancelRide();
         ride.notifyObserver("ride is completed");
    }

    @Override
    public void cancel(Ride ride) {

    }
}
