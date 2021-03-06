package API;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Utils.Utils.initializeLogger;

public class EndpointRequest<T> implements Runnable {

    private Endpoint endpoint;
    private URL requestUrl;
    private Endpoint.RequestMethod requestMethod;
    private Class<T> responseClass;
    private T response;
    private CountDownLatch latch;
    private static Logger logger = initializeLogger(EndpointRequest.class.getName());

    EndpointRequest(Endpoint endpoint, URL requestUrl, Endpoint.RequestMethod requestMethod, Class<T> responseClass) {
        this.endpoint = endpoint;
        this.requestUrl = requestUrl;
        this.requestMethod = requestMethod;
        this.responseClass = responseClass;
        this.response = null;
    }

    @Override
    public void run() {
        logger.info("Sending: " + this.requestUrl.toString());
        try {
            this.response = this.endpoint.send(this.requestUrl, this.requestMethod, this.responseClass);
            this.latch.countDown();
        } catch (RateLimitException rle) {
            logger.warning("Retrying after: " + rle.retryAfterXSeconds);
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.schedule(this, rle.retryAfterXSeconds, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
            this.latch.countDown();
        }
    }

    T getResponse() {
        return this.response;
    }

    void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }
}
