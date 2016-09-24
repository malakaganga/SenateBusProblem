
public class Bus extends Thread {

    private final long busID;

    public Bus(long busID) {
        this.busID = busID;
    }

    public long getBusID() {
        return busID;
    }

    @Override
    public void run() {
        try {
            Util.mutex.acquire();
            if (Util.riders > 0) {
                System.out.println("Bus " + this.getBusID() + " Arrived when waiting riders = " + Util.riders);
                Util.bus.release();
                Util.boardAll.acquire();
                System.out.println("Bus " + this.getBusID() + " Departed when waiting riders = " + Util.riders);
            }
            Util.mutex.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
