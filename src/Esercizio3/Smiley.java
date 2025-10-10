package Esercizio3;

/*
Scrivere un programma che usi solo i metodi indicati per stampare solo smiley “:-)”.
Utilizzare il codice sottostante e inserire il proprio codice solo dove indicato.
*/

public class Smiley extends Thread {
    public void run() {
        while (true) {
            try {
                synchronized (Smiley.class) { // blocco sincronizzato su tutta la classe
                    printDuePunti();
                    printTrattino();
                    printParentesi();
                    System.out.println(); // va a capo dopo ogni smiley
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printParentesi() throws InterruptedException {
        System.out.print("("); Thread.sleep(100);
    }

    private void printTrattino() throws InterruptedException {
        System.out.print("-"); Thread.sleep(100);
    }

    private void printDuePunti() throws InterruptedException {
        System.out.print(":"); Thread.sleep(100);
    }

    public static void main(String[] args) {
        new Smiley().start(); //Thread che comprende l'intera classe
        new Smiley().start();
    }
}
