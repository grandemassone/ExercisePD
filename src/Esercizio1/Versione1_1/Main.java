/*
Scrivere un programma che incrementi un contatore intero per 40.000.
Creare una classe Counter e una classe Incrementatore con il main che istanzia e usa
Counter, verificando poi
il valore di Counter stampandolo su console. Implementare tre versioni:
1. Senza creare nuovi thread (ovvero, con il solo main thread).
2. Creando 4 thread che tutti insieme incrementano di 10000 volte il contatore, SENZA
curarsi della race condition, e vedere il risultato.
3. Creando 4 thread, curandosi della race condition, e verificare il risultato.
* */

package Esercizio1.Versione1_1;

import Esercizio1.Counter;

public class Main {
    public static void main(String[] args) {
        Counter c = new Counter();
        for(int i = 0; i < 40_000; i++) {
            c.increment();
        }

        System.out.println(c.value());
    }
}
