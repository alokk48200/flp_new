package rideservice;

import java.util.concurrent.CopyOnWriteArrayList;

public class RiderService {
    private CopyOnWriteArrayList<Rider> riders;

    public void onBoardRider(Rider rider){
        riders.add(rider);
        System.out.println("this rider is successfullly onboarded" + rider.toString());
    }

    public void startRide(Rider rider, Ride ride){
        rider.setRide(ride);
    }
    public void endRide(Rider rider, Ride ride){
        rider.setRide(null);
    }
}
