/*
*   Counter senza sincronizzazione
*/

package Esercizio1;

public class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int value() {
        return count;
    }
}