package ridesharing;

public class PeakHourFareHandler extends FareHandler{
    @Override
    public double apply(Ride ride, Double fare) {
        if(next != null){
            return next.apply(ride, ride.getDistance()*0.7 +fare);
        }
        return fare;
    }
}
