public interface RateLimiter {
    void get() throws Exception;
    void feedBack();
}


