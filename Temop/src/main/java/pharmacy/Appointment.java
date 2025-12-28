package pharmacy;

import java.util.PriorityQueue;

public class Appointment {
    private String name;
    private Patient patient;
    private Doctor doctor;
    private Float time;

    public Appointment(String name, Doctor doctor, Patient patient, Float time) {
        this.name = name;
        this.doctor = doctor;
        this.patient = patient;
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }
}
