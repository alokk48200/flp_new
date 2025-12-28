package pharmacy;

import javax.print.Doc;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Doctor doctor3 = new Doctor("ritika", Specialist.CARDIOLOGIST);
        Doctor doctor1 = new Doctor("shivani", Specialist.CARDIOLOGIST);
        Doctor doctor2 = new Doctor("ramesh", Specialist.CARDIOLOGIST);
        Doctor doctor4 = new Doctor("rahul ", Specialist.DERMATOLOGIST);
        Doctor doctor5 = new Doctor("ramesh", Specialist.DERMATOLOGIST);
        Doctor doctor6 = new Doctor("rakul", Specialist.DERMATOLOGIST);
        Doctor doctor7 = new Doctor("ritik sharma", Specialist.ORTHOPEDIC);
        Doctor doctor8 = new Doctor("shivani arora", Specialist.ORTHOPEDIC);
        Doctor doctor9 = new Doctor("ramesh yadav", Specialist.ORTHOPEDIC);
        Doctor doctor11 = new Doctor("rahul  yadav", Specialist.GENERALPHYSICIAN);
        Doctor doctor12 = new Doctor("ramesh shakya", Specialist.GENERALPHYSICIAN);
        Doctor doctor13 = new Doctor("sahukesh  saxsena", Specialist.GENERALPHYSICIAN);
        Doctor doctor14 = new Doctor("shyam saxsena", Specialist.GENERALPHYSICIAN);
        Doctor doctor15 = new Doctor("ram saxsena", Specialist.GENERALPHYSICIAN);


        doctor1.setRating((float) 4.2);
        doctor2.setRating((float) 3.5);
        doctor3.setRating((float) 2.5);
        doctor1.addAvailability((float) 11);
        doctor2.addAvailability((float) 12.30);
        doctor3.addAvailability((float) 10.30);

        AppointmentService appointmentService = AppointmentService.getInstance();

        appointmentService.registerDoctor(doctor1);
        appointmentService.registerDoctor(doctor2);
        appointmentService.registerDoctor(doctor3);


        appointmentService.registerDoctor(doctor4);
        appointmentService.registerDoctor(doctor5);
        appointmentService.registerDoctor(doctor6);

        appointmentService.registerDoctor(doctor7);
        appointmentService.registerDoctor(doctor8);
        appointmentService.registerDoctor(doctor9);


        appointmentService.registerDoctor(doctor11);
        appointmentService.registerDoctor(doctor12);
        appointmentService.registerDoctor(doctor13);

        ArrayList<Doctor>doctors = appointmentService.getDoctors(Specialist.CARDIOLOGIST, Sort.RATING, (float) 9.0 );

        for( Doctor doctor : doctors){
            System.out.println(doctor.toString());
        }

        ArrayList<Doctor>doctors1 = appointmentService.getDoctors(Specialist.CARDIOLOGIST, Sort.TIME, (float) 9.0 );
        Patient patient = new Patient("alok");

        Appointment appointment = appointmentService.bookAppointment(doctor1, patient, (float)9.0) ;
        patient.setAppointment(appointment);

        if( appointment == null){
            System.out.println("appointment is successfull");
        }

        Patient patient1 = new Patient("rohit1");

        appointmentService.bookAppointment(doctor2, patient,(float) 11.0 );

         patient1.getAppointment();

    }
}
