package rideservice;

import java.util.List;

public class SortDistanceStartegy implements DriverFetchingStrategy{
    @Override
    public List<Driver> getRide(List<Driver> drivers, User user, VehicleType vehicleType) {
        List<Driver> list = drivers.stream().filter((d)->(d.getVechile()
                .getVehicleType().equals(vehicleType))).filter(
                (d)->d.getRideStatus().equals(RideStatus.WAITING)).toList();
        list.sort((a,b)->Double.compare(getDistance(user, b) ,getDistance(user, a)));
        return list;

    }
    private Double getDistance(User user , Driver b){
        return (double)(((b.getLocation().getLat()  - user.getLocation().getLat())
                * (b.getLocation().getLat()  - user.getLocation().getLat()))
                + ((b.getLocation().getLog()  - user.getLocation().getLog())
                * (b.getLocation().getLog()  - user.getLocation().getLog())));

    }
}
