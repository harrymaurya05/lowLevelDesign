package systemDesign.rateLImiter.slidingWindowbucket;

import java.util.HashMap;
import java.util.Map;
import systemDesign.rateLImiter.leakyBucket.LeakyBucket;

public class UserSlidingWindowBucket {
    Map<Integer, SlidingWindowBucket> map;

    public UserSlidingWindowBucket(Integer userId) {
        this.map = new HashMap<>();
        this.map.put(userId,new SlidingWindowBucket(10,5));
    }
    public void checkGrant(Integer userId){
        if(map.get(userId).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> Api access grant Successfully!!");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Throttling Error Occurred!!");
        }
    }
}
