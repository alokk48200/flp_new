package ridesharing;

public class WeekendFareHandler extends FareHandler{
    @Override
    public double apply(Ride ride, Double fare) {
        if(next != null){
            return next.apply(ride, ride.getDistance()*025 +fare);
        }
        return fare;
    }
}
