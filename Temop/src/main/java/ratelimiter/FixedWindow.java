package ratelimiter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class FixedWindow extends RateLimiter{
    public FixedWindow(Integer requests) {
        super( requests);
    }

    @Override
    public boolean isallowed(User user) {
        return false;
    }
}
