package pharmacy;

import java.util.HashMap;

public class Callender {
    private HashMap<Float, Boolean>hashMap ;

    public Callender() {
        this.hashMap =  new HashMap<>();
    }

    public void addAvailability(Float val){
      hashMap.put(val, true);
    }

    public void bookAppointment(float val){
       hashMap.remove(val);
    }

    public HashMap<Float, Boolean> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<Float, Boolean> hashMap) {
        this.hashMap = hashMap;
    }
}
