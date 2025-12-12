package ridesharing;

public class WeatherFareHandler extends FareHandler{
    @Override
    public double apply(Ride ride, Double fare) {
        if(next != null){
            return next.apply(ride, 20+fare);
        }
        return fare;
    }
}
