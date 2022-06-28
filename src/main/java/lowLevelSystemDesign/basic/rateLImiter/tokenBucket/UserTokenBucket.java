package lowLevelSystemDesign.basic.rateLImiter.tokenBucket;

import java.util.HashMap;
import java.util.Map;

public class UserTokenBucket {
    Map<Integer, TokenBucket> map;

    public UserTokenBucket(Integer userId) {
        this.map = new HashMap<>();
        this.map.put(userId,new TokenBucket(5,10));
    }
    public void checkGrant(Integer userId){
        if(map.get(userId).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> Api access grant Successfully!!");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Throttling Error Occurred!!");
        }
    }
}
