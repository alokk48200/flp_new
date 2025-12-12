package ratelimiter;

public class LeakyBucket extends RateLimiter{
    public LeakyBucket(Integer requests) {
        super(requests);
    }

    @Override
    public boolean isallowed(User user) {
        return false;
    }
}
