package rideservice;

import java.util.List;

public class HighestRatingDriverFetching implements DriverFetchingStrategy{
    @Override
    public List<Driver> getRide(List<Driver> drivers, User user, VehicleType vehicleType) {
        return  drivers.stream().sorted((a, b)->Float.compare(b.getRating(), a.getRating())).toList();

    }
}
