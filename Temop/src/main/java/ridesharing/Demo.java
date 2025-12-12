package ridesharing;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Location location = new Location(2,2);
        Passenger passenger = new Passenger("alok",location );
        Driver driver = new Driver("ramesh",
                new Vehicle.VechileBuilder().setName("thar").setreg("xz").setWheeler(Wheeler.TWOWHEELER).setPasssenger(4).build(),
                new Location(3,5));
        Driver driver1 = new Driver("rahul",
                new Vehicle("thar", "bx", Wheeler.THREEWHEELER, 2),
                new Location(1,1));
        Driver driver3 = new Driver("ritik",
                new Vehicle("thar", "bx", Wheeler.FOURWHEELER, 2),
                new Location(10,5));
        RideService rideService = new RideService();

        Application application = Application.getInstance(rideService);
        application.addDriver(driver);
        application.addDriver(driver1);
        application.addDriver(driver3);

        Optional<Driver> driver4 = application.getDriver(passenger,new Location(8, 8), Wheeler.FOURWHEELER);

        Driver driver5 = null ;
        if(driver4.get() != null){
            driver5 = driver4.get();
            System.out.println("we have found a driver " +driver4.get().getName());
        }

        application.bookride(passenger,driver5, new DefaultFairStategy(4), new Location(10,10));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
           throw new RuntimeException(e);
        }
        application.rideComplete(driver5);


    }
}
