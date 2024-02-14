/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix.gruppo4;

/**
 *
 * @author Studente
 */
public class Auto extends Thread {

    private String modello;
    private int velocita = 10; //valore fisso
    private int distanzaPercorsa;
    private Circuito circuito;
    Pilota pilota;

    public Auto(String modello, Circuito circuito, Pilota pilota) {
        this.modello = modello;
        this.distanzaPercorsa = 0;
        this.circuito = circuito;
        this.pilota = pilota;
    }
    
    //comportamento di ciascuna auto
    @Override
    public void run() {
        int giroCorrente = 1;
        int nGiri = this.circuito.nGiri;
        int distanzaPercorsa = this.distanzaPercorsa;
        while(nGiri>0) {    
            while (distanzaPercorsa < this.circuito.lunghezza) {
                try {
                    // Simula il tempo che passa
                    Thread.sleep(1000);
                    // Aggiorna la distanza percorsa
                    distanzaPercorsa += this.velocita;
                    // Stampa l'aggiornamento
                    System.out.println("["+this.modello+"] ha percorso: "+distanzaPercorsa+"/"+this.circuito.lunghezza);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Auto ha completato il giro
            System.out.println("[**" + this.modello + "**] - Ha completato il "+giroCorrente+"°!");
            distanzaPercorsa = this.distanzaPercorsa; // Reset della distanza percorsa
            giroCorrente++; // incremento giro corrente
            nGiri--; // diminuzione giri da percorrrere
        }

        // Auto ha completato il circuito
        System.out.println("[**" + this.modello + "**] - Ha completato il circuito!");
    }
}
