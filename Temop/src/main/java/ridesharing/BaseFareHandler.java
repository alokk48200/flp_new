package ridesharing;

public class BaseFareHandler extends FareHandler{
    @Override
    public double apply(Ride ride, Double fare) {
        System.out.println("in base handler the fare is " + fare + " and the ride distance is " + ride.getDistance());
        if(next != null){
            return next.apply(ride, ride.getDistance()*3 + fare);
        }
        return fare;
    }
}
