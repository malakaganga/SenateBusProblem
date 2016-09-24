public class Rider extends Thread {

    private final long riderID;

    public Rider(long riderID) {
        this.riderID = riderID;
    }

    public long getriderID() {
        return riderID;
    }

    @Override
    public void run() {
        try {
            Util.multiplex.acquire();
            Util.mutex.acquire();
            Util.riders++;
            Util.mutex.release();

            Util.bus.acquire();

            Util.multiplex.release();

            System.out.println("Rider " + this.getriderID() + " Got In");

            Util.riders--;
            if (Util.riders == 0) {
                Util.boardAll.release();
            } else {
                Util.bus.release();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
