package ridesharing;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private String phoneNum;
    private Integer rating;
    private Location location;

    public User(String name, Location location) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.location = location;
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
    public void getNotified(String messsage){
        System.out.println("get this message for " + name + " and message "+ messsage);
    }
}
