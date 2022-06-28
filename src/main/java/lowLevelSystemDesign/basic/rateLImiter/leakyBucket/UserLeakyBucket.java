package lowLevelSystemDesign.basic.rateLImiter.leakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserLeakyBucket {
    Map<Integer,LeakyBucket> map;

    public UserLeakyBucket(Integer userId) {
        this.map = new HashMap<>();
        this.map.put(userId,new LeakyBucket(10));
    }
    public void checkGrant(Integer userId){
        if(map.get(userId).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> Api access grant Successfully!!");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Throttling Error Occurred!!");
        }
    }
}
