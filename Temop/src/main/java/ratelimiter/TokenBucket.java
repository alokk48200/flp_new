package ratelimiter;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TokenBucket extends RateLimiter{
    public TokenBucket(Integer requests) {
        super(requests);
    }

    @Override
    public boolean isallowed(User user) {
        ArrayList<LocalDateTime> lists = userArrayListHashMap.getOrDefault(user, new ArrayList<>());
        
        return false;
    }
}
