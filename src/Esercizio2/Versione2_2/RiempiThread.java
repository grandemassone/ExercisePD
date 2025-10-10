package Esercizio2.Versione2_2;

public class RiempiThread implements Runnable {
    private static final int[] array = new int[1_200_000];

    private final int start;
    private final int end;

    public RiempiThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            array[i] = 42;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        int mid = array.length / 2;
        Thread t1 = new Thread(new RiempiThread(0, mid));
        Thread t2 = new Thread(new RiempiThread(mid, array.length));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time: " + elapsedTime + "ms");
    }
}
