
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.test();
    }

    public void test() {
        
        Bus busThread = null;
        Rider riderThread = null;
        long riderID = 1;
        long busID = 1;
        long busTime = System.currentTimeMillis() + Util.getRandomBusTime();
        long riderTime = System.currentTimeMillis() + Util.getRandomRiderTime();
        while (true) {
            if (busTime < System.currentTimeMillis()) {
                busThread = new Bus(busID++);
                busThread.start();
                busTime = System.currentTimeMillis() + Util.getRandomBusTime();
            }
            if (riderTime < System.currentTimeMillis()) {
                riderThread = new Rider(riderID++);
                riderThread.start();
                riderTime = System.currentTimeMillis() + Util.getRandomRiderTime();
            }

        }
    }
}
