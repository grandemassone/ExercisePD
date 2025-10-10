package Esercizio1.Versione1_3;

import Esercizio1.CounterSync;

public class Incrementatore3 implements Runnable {
    static public CounterSync c = new CounterSync();

    public Incrementatore3(CounterSync c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            c.increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Incrementatore3(c));
        Thread t2 = new Thread(new Incrementatore3(c));
        Thread t3 = new Thread(new Incrementatore3(c));
        Thread t4 = new Thread(new Incrementatore3(c));

        //Mettiamo in "pronto" i 4 thread
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //Attendiamo che terminino tutti e 4 i thread, dopodiché li "raccogliamo"
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Valore finale del contatore: " + c.value());
    }
}