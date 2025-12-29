package rideservice;

public enum VehicleType {
    TWO_WHEELER(0),
    THREE_WHEELER(1),
    FOUR_WHEELER(2);

    private final int val;

    VehicleType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
