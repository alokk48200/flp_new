package pharmacy;

import java.util.ArrayList;

public class RatingSortStrategy implements  SortStrategy{

    @Override
    public ArrayList<Doctor> apply(ArrayList<Doctor> doctors) {
        doctors.sort((a, b)->Float.compare(b.getRating(),a.getRating()));
        return doctors;
    }
}
