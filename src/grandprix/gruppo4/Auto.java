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
    public boolean concluso;
    public long tempo;
    public Pilota pilota;
    public String modello;
    private int velocita = 10; //valore fisso
    private int distanzaPercorsa;
    private Circuito circuito;
    private int nPitstop;
    private SafetyCar safetyCar;
    
    
    public Auto(String modello, Circuito circuito, Pilota pilota, SafetyCar safetyCar) {
        this.modello = modello;
        this.distanzaPercorsa = 0;
        this.circuito = circuito;
        this.pilota = pilota;
        this.nPitstop = circuito.nPitstop;
        this.safetyCar = safetyCar;
    }
    
    //comportamento di ciascuna auto
    @Override
    public void run() {
        long timeStart = System.currentTimeMillis();
        int giroCorrente = 1;
        int nGiri = this.circuito.nGiri;
        int distanzaPercorsa = this.distanzaPercorsa;
        while(nGiri>0) {    
            while (distanzaPercorsa < this.circuito.lunghezza) {
                try {
                    // Simula il tempo che passa
                    Thread.sleep(1000);
                    //possibilità di pitstop
                    pitStop();
                    //possibilità rottura
                    possibileRottura();
                    // Aggiorna la distanza percorsa
                    distanzaPercorsa += this.velocita;
                    // Stampa l'aggiornamento
                    System.out.println("["+this.modello+"] ha percorso: "+distanzaPercorsa+"/"+this.circuito.lunghezza);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Auto ha completato il giro
            System.out.println("[**" + this.modello + "**] - Ha completato il "+giroCorrente+"° giro!");
            distanzaPercorsa = this.distanzaPercorsa; // Reset della distanza percorsa
            giroCorrente++; // incremento giro corrente
            nGiri--; // diminuzione giri da percorrrere
        }

        // Auto ha completato il circuito
        System.out.println("[**" + this.modello + "**] - Ha completato il circuito!");
        long timeEnd = System.currentTimeMillis();
        this.tempo = timeEnd - timeStart;
        circuito.nConclusi++;
        circuito.controllaFine();
    }
    
    //Procedura possibile pitstop
    public void pitStop(){
        // Genera un numero casuale tra 1 e 100
        int numeroCasuale = (int) (Math.random() * 100) + 1;

        // Se il numero casuale è minore o uguale a 30(30%)
        if (numeroCasuale <= 30) { 
            System.out.println("["+this.modello+"] entra nel pitstop...");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //Procedura possibile rottura
    public void possibileRottura(){
        // Genera un numero casuale tra 1 e 100
        int numeroCasuale = (int) (Math.random() * 100) + 1;
        
        //Se il numero è minore o uguale a 20(20%)
        if(numeroCasuale<=20){
            System.out.println("[" + this.modello + "] GUASTO");
            safetyCar.aiuta(this);
        }
    }
}
