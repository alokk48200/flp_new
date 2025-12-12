package ridesharing;

public class StartRideState implements Ridestate{
    @Override
    public void accept(Ride ride) {
        ride.notifyObserver("already in another ride so can not satrt ride");
    }

    @Override
    public void start(Ride ride) {
        ride.notifyObserver("ride is started");
        ride.setRidestate(new CompleteRideState());

    }

    @Override
    public void completed(Ride ride) {
       ride.notifyObserver("ride is completed");
    }

    @Override
    public void cancel(Ride ride) {
       ride.notifyObserver("can not be cancelses");
    }
}
