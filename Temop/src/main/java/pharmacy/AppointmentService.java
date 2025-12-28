package pharmacy;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class AppointmentService {
    private  final static AppointmentService instance = new AppointmentService();
    private CopyOnWriteArrayList<Patient>patients;
    private ConcurrentHashMap<Specialist, CopyOnWriteArrayList<Doctor>>doctors;


    private AppointmentService(){
        patients = new CopyOnWriteArrayList<>();
        doctors = new ConcurrentHashMap<>();
    }

    public static AppointmentService getInstance(){
        return instance;
    }

    public void registerPatient(Patient patient){
        if(patients.contains(patient) == false){
            patients.add(patient);
            System.out.println(patient.toString() + "  pateint is registered ");
        }
    }

    public void registerDoctor(Doctor doctor){
       CopyOnWriteArrayList<Doctor> doctors1 = doctors.getOrDefault(doctor.getSpecialist(), new CopyOnWriteArrayList<>());
        doctors1.add(doctor);
        doctors.put(doctor.getSpecialist(), doctors1);
        System.out.println(doctor.toString() + "  doctor  is registered ");
    }

    public ArrayList<Doctor> getDoctors(Specialist specialist, Sort sortBy , Float time){
         return SortObjectFactory.getObject(sortBy).apply(new ArrayList<>(doctors.get(specialist).stream().filter(Doctor::isAvailable).toList()));
    }

    public Appointment bookAppointment(Doctor doctor , Patient patient, Float time){
        if(doctor.getAvailability(time)){
            Boolean isBooked = doctor.bookSeat(time, patient);
            if(isBooked) {
                Appointment appointment = new Appointment(UUID.randomUUID().toString(), doctor, patient, time);

                doctor.addAppointment(appointment);
                patient.setAppointment(appointment);
                System.out.println("amount is success full at time "+ time + "with doctor " + doctor);
                return appointment;
            }
            else System.out.println("patient is added to the waiting list");
        }

        System.out.println("  not able  to  book  appointment  ");
        return null;
    }
}
