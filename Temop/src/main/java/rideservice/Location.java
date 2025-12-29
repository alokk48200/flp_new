package rideservice;

public class Location {
    private float lat, log;

    public Location(float lat, float log) {
        this.lat = lat;
        this.log = log;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLog() {
        return log;
    }

    public void setLog(float log) {
        this.log = log;
    }
}
