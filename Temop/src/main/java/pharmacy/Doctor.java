package pharmacy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Doctor extends User{
    private Callender calendar;
    private Specialist specialist;
    private float rating;
    private CopyOnWriteArrayList<Appointment>appointments;
    private LinkedBlockingQueue<Patient>patients;
    public Doctor(String name, Specialist specialist) {
        super(name);
        this.specialist = specialist;
        this.calendar = new Callender();
        this.appointments =new CopyOnWriteArrayList<>();
        this.patients = new LinkedBlockingQueue<>();
    }

    public Boolean bookSeat(Float val, Patient patient){
        if(this.calendar.getHashMap().getOrDefault(val, false) == false){
             patients.add(patient);
            System.out.println("this pate=ient is waiting list");
            return false;
        }
        this.calendar.bookAppointment(val);
        return true;
    }
    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void addAvailability(float time){
        this.calendar.addAvailability(time);
    }

    public Boolean getAvailability(float time){
        return this.calendar.getHashMap().getOrDefault(time, false);
    }

    public ArrayList<Float> getAvailabilty(){
       return new ArrayList<>(this.calendar.getHashMap().keySet().stream().toList());
    }

    public Callender getCalendar() {
        return calendar;
    }

    public void setCalendar(Callender calendar) {
        this.calendar = calendar;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Boolean isAvailable(){
      return this.calendar.getHashMap().size() > 0 ? true : false;
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }

    public void cancelAppointment(Appointment appointment){
        if(patients.size() > 0){

            Patient patient = patients.poll();
            bookSeat(appointment.getTime(),patient);
            appointment.setPatient(patient);
            patient.addAppointments(appointment);
            return;
        }
        this.calendar.addAvailability(appointment.getTime());
        return;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "calendar=" + calendar.getHashMap().toString() +
                ", specialist=" + specialist +
                ", rating=" + rating +
                '}';
    }
}
