
import java.util.concurrent.Semaphore;

public class Util {

    protected static int riders;
    private static final int MAX_PASSENGERS = 50;
    protected static final Semaphore mutex = new Semaphore(1);
    protected static final Semaphore bus = new Semaphore(0);
    protected static final Semaphore boardAll = new Semaphore(0);
    protected static final Semaphore multiplex = new Semaphore(MAX_PASSENGERS);

    public static long getRandomBusTime() {
        return (long) (-Math.log(Math.random()) * 1200000)/1000;
    }

    public static long getRandomRiderTime() {
        return (long) (-Math.log(Math.random()) * 30000)/1000;
    }
}
