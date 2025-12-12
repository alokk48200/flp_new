package ratelimiter;

import java.util.HashMap;

public class RateLimiterService {
    private static RateLimiterService instance;
    private HashMap<UserTier, RateLimiter>userRateLimiterHashMap;

    private RateLimiterService(){
        this.userRateLimiterHashMap = new HashMap<>();
    }

    public static RateLimiterService getInstance(){
        if(instance == null){
            synchronized (RateLimiterService.class){
                if(instance == null){
                    instance = new RateLimiterService();
                }
            }
        }
        return instance;
    }

    public boolean allowUser(User user){
       return userRateLimiterHashMap.get(UserTier.NORMAL).isallowed(user);
    }
}
