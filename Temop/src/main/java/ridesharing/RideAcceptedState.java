package ridesharing;

public class RideAcceptedState implements Ridestate{
    @Override
    public void accept(Ride ride) {
        ride.notifyObserver("your ride is accepted");
        ride.setRidestate(new StartRideState());


    }

    @Override
    public void start(Ride ride) {

       ride.notifyObserver("can  not start ride without acceptedd");
    }

    @Override
    public void completed(Ride ride) {
         ride.notifyObserver("can not completed without accepeted it");
    }

    @Override
    public void cancel(Ride ride) {
        ride.notifyObserver("can note cancel it with accepeted");
    }
}
