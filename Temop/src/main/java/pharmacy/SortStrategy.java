package pharmacy;

import java.util.ArrayList;

public interface SortStrategy {

    ArrayList<Doctor> apply(ArrayList<Doctor>doctors);
}
