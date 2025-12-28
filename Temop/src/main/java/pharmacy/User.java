package pharmacy;


import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    protected String id;
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected Callender calendar;
    protected CopyOnWriteArrayList<Appointment> appointments;

    public User(String name) {
        this.name = name;
        this.calendar = new Callender();
        this.appointments = new CopyOnWriteArrayList<>();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", calendar=" + calendar +
                '}';
    }

    public ArrayList<Appointment> getAppointment() {
        return new ArrayList<>(appointments.stream().toList());
    }

    public void setAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void addAppointments(Appointment appointment){
        appointments.add(appointment);
    }

    public void removeAppointments(Appointment appointment){
        if(appointments.contains(appointment)){
            appointments.remove(appointment);
            System.out.println("this appointe met success cancelled" + appointment.toString());
        }
        System.out.println(" did not find any apppointments int  the list ");
    }
}
