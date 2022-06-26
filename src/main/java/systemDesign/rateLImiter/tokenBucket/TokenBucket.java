package systemDesign.rateLImiter.tokenBucket;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import systemDesign.rateLImiter.RateLImiter;

public class TokenBucket implements RateLImiter {
    private int bucketCapacity;
    private int referaceRate;
    private AtomicInteger currentCapacity;
    private AtomicLong lastUpdatedTime;

    public TokenBucket(int bucketCapacity, int referaceRate) {
        this.bucketCapacity = bucketCapacity;
        this.referaceRate = referaceRate;
        currentCapacity = new AtomicInteger(bucketCapacity);
        lastUpdatedTime = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean grantAccess() {
        referaceToken();
        if(currentCapacity.get() > 0){
            currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }
    public void referaceToken(){
        Long currentTime = System.currentTimeMillis();
        Integer additionalToken = (int) ((currentTime - lastUpdatedTime.get()) / 1000 ) * referaceRate;
        Integer currCapacity = Math.min(currentCapacity.get() + additionalToken, bucketCapacity);
        currentCapacity.getAndSet(currCapacity);
        lastUpdatedTime.getAndSet(System.currentTimeMillis());
    }
}
