package Esercizio2.Versione2_3;



public class RiempiThread4 implements Runnable {
    private static final int[] array = new int[100_200_000];

    private final int start;
    private final int end; // esclusivo

    public RiempiThread4(int start, int end) {
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
        long startTime = System.nanoTime();

        int n = array.length;
        int q1 = n / 4;
        int q2 = n / 2;
        int q3 = (3 * n) / 4;

        Thread t1 = new Thread(new RiempiThread4(0,  q1));
        Thread t2 = new Thread(new RiempiThread4(q1, q2));
        Thread t3 = new Thread(new RiempiThread4(q2, q3));
        Thread t4 = new Thread(new RiempiThread4(q3, n));

        t1.start(); t2.start(); t3.start(); t4.start();
        t1.join();  t2.join();  t3.join();  t4.join();

        long elapsedMs = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("Elapsed time: " + elapsedMs + " ms");
    }
}
