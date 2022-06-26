
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import systemDesign.rateLImiter.leakyBucket.UserLeakyBucket;
import systemDesign.rateLImiter.slidingWindowbucket.UserSlidingWindowBucket;
import systemDesign.rateLImiter.tokenBucket.UserTokenBucket;

/**
 * Unit test for simple App.
 */
public class TestRateLimitor
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public  void testLeakyBucket(){
        UserLeakyBucket userBucket = new UserLeakyBucket(1);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<12; i++){
            executorService.execute(()->userBucket.checkGrant(1));
        }
    }

    @Test
    public  void testTokenBucket() throws InterruptedException {
        UserTokenBucket userBucket = new UserTokenBucket(1);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<12; i++){
            Thread.sleep(800);
            executorService.execute(()->userBucket.checkGrant(1));
        }
    }
    @Test
    public  void testSlidingWindowBucket() throws InterruptedException {
        UserSlidingWindowBucket userBucket = new UserSlidingWindowBucket(1);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<12; i++){
            Thread.sleep(1000);
            executorService.execute(()->userBucket.checkGrant(1));
        }
    }

}
