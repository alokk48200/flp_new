package splitwise;

import java.util.HashMap;
import java.util.List;

public interface SplitStrategy {
    HashMap<User, Double> split(List<User> userList, List<Double>quantity, Double amount);
}
