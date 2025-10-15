package Esercizio1.Versione1_3;

import Esercizio1.Counter;
import Esercizio1.CounterSync;

public class Incrementatore3 {
    //Start static class Task1
    public static class Task1 implements Runnable {
        static CounterSync counter = new CounterSync();
        public Task1(CounterSync counter) {
            Task1.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 15000; i++) {
                counter.increment();
            }
        }
    }

    //Start static class Task2
    public static class Task2 implements Runnable {
        static CounterSync counter = new CounterSync();
        public Task2(CounterSync counter) {
            Task2.counter = counter;
        }
        @Override
        public void run() {
            for(int i = 0; i < 10000; i++) {
                counter.decrement();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterSync counterMain = new CounterSync();
        Thread t1 = new Thread(new Task1(counterMain));
        Thread t2 = new Thread(new Task2(counterMain));

        //Mettiamo in "pronto" i 2 thread
        t1.start();
        t2.start();

        //Attendiamo che terminino tutti e 2 i thread, dopodiché li "raccogliamo"
        t1.join();
        t2.join();

        System.out.println("Valore finale del contatore: " + counterMain.value());
    }
}