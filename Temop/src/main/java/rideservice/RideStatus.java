package rideservice;

public enum RideStatus {
    WAITING(0),
    ONGOING(1),
    COMPLETED(2);

    private final int val;

    RideStatus(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
