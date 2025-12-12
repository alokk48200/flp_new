package ridesharing;

public class Driver extends User{
    private Vehicle vehicle;
    private BookingStatus bookingStatus;
    public Driver(String name, Vehicle vehicle, Location location) {
        super(name, location);
        this.vehicle = vehicle;
        this.bookingStatus = BookingStatus.AVAILABLE;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
