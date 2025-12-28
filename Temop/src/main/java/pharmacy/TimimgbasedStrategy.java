package pharmacy;

import java.util.ArrayList;

public class TimimgbasedStrategy implements SortStrategy{
    @Override
    public ArrayList<Doctor> apply(ArrayList<Doctor> doctors) {
        doctors.sort((a, b)->{
            float t1 = a.getAvailabilty().stream().min(Float::compare).orElse(Float.MAX_VALUE);
            float t2 = b.getAvailabilty().stream().min(Float::compare).orElse(Float.MAX_VALUE);
            return Float.compare(t1, t2);
        });
        return doctors;
    }
}
