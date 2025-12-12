package splitwise;

import java.util.HashMap;
import java.util.List;

public class ExactStaregy implements SplitStrategy{
    @Override
    public HashMap<User, Double> split(List<User> userList, List<Double> quantity, Double amount) {
        HashMap<User, Double> hashMap = new HashMap<>();
        int i = 0;
        for (User user : userList) {
            hashMap.put(user, quantity.get(i++));
        }
        return hashMap;
    }

}
