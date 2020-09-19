import java.util.concurrent.atomic.AtomicInteger;

public class Limiter implements RateLimiter {
    final Object lock = new Object();
    AtomicInteger integer = new AtomicInteger(0);

    @Override
    public void get() throws Exception {
        synchronized(lock){
            if(integer.get() == 500){
                throw  new Exception();
            }
        }
        integer.incrementAndGet();
    }

    @Override
    public void feedBack() {
        integer.decrementAndGet();
    }
}
