package systemDesign.rateLImiter.leakyBucket;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import systemDesign.rateLImiter.RateLImiter;

public class LeakyBucket implements RateLImiter {
    BlockingDeque<Integer> quque ;
    public LeakyBucket(Integer capacity) {
        this.quque = new LinkedBlockingDeque<>(capacity);
    }

    @Override
    public boolean grantAccess(){
        if(quque.remainingCapacity() > 0){
            quque.add(1);
            return true;
        } else {
            return false;
        }
    }
}
