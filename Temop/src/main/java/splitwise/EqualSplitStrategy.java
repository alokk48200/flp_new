package splitwise;

import java.util.HashMap;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public HashMap<User, Double> split(List<User> userList, List<Double> quantity, Double amount) {
          HashMap<User, Double> hashMap = new HashMap<>();
          double val = amount / userList.size();
          for(User user :  userList){
              hashMap.put(user, val);
          }
          return hashMap;
    }
}
