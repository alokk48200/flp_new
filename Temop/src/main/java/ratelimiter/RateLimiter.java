package ratelimiter;

import java.lang.module.Configuration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class RateLimiter {
    protected HashMap<User, ArrayList<LocalDateTime>>userArrayListHashMap;
    protected Integer requests ;

    public RateLimiter(Integer requests) {
        this.userArrayListHashMap = new HashMap<>();
        this.requests = requests;
    }

    public abstract boolean isallowed(User user);
}
