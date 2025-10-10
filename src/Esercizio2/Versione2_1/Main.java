/*
Scrivere un programma Java per inizializzare un array di 1200000 interi al valore 42. Il
programma deve misurare il tempo di esecuzione e stamparlo. Implementare tre versioni:
1. Senza creare nuovi thread (ovvero, con il solo main thread).
2. Con 2 thread.
3. Con 4 thread.
Calcolare lo speedup del programma con 4 thread.
*/

package Esercizio2.Versione2_1;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] riempiArray = new int[1200000];

        for (int i = 0; i < riempiArray.length; i++) {
            riempiArray[i] = 42;
        }

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        System.out.println("Tempo di esecuzione: " + executionTime + "ms.\n");
    }
}
