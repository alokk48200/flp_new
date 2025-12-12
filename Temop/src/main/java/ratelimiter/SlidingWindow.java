package ratelimiter;

public class SlidingWindow extends RateLimiter{
    public SlidingWindow(Integer requests) {
        super(requests);
    }

    @Override
    public boolean isallowed(User user) {
        return false;
    }
}
