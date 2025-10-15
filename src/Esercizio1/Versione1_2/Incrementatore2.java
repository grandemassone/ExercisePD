/*
    Creando 4 thread che tutti insieme incrementano di 10000 volte il contatore, SENZA
curarsi della race condition, e vedere il risultato.
*/

package Esercizio1.Versione1_2;
import Esercizio1.Counter;

public class Incrementatore2 implements Runnable {
    static public  Counter c = new Counter();

    public Incrementatore2(Counter c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            c.increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Incrementatore2(c));
        Thread t2 = new Thread(new Incrementatore2(c));
        Thread t3 = new Thread(new Incrementatore2(c));
        Thread t4 = new Thread(new Incrementatore2(c));

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
