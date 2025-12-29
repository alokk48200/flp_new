package rideservice;

public class User {
    private String id;
    private String name;
    private String email;
    private String phoneNumb;
    private Location location;
    private Ride ride;

    public User(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public void update(String message){
        System.out.println("this user is being notified that u are going to use");
        return;
    }

    public String getId() {
        return id;
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumb='" + phoneNumb + '\'' +
                ", location=" + location +
                '}';
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }


}
