package rideservice;

import pharmacy.RatingSortStrategy;

public class DriverStrategyFetchingFactoryObject {
    public static DriverFetchingStrategy getObject(String enum1) throws Exception {
       switch (enum1.toLowerCase()){
            case "nesrest" : return new SortDistanceStartegy();
            case "primium" : return new HighestRatingDriverFetching();
            default:
                throw new Exception("shown no find");
        }

    }
}
