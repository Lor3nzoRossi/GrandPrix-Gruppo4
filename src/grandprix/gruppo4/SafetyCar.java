/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandprix.gruppo4;

/**
 *
 * @author lorir
 */
public class SafetyCar extends Thread{
    public boolean occupata;
    
    public synchronized void aiuta(Auto a){
        if(!this.occupata){
            this.occupata = true;
            System.out.println("[" + a.modello + "] Entrata safety car...");
            try {
                sleep(5000);//attesa di 5 secondi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Fine riparazione di " + a.modello);
            this.occupata = false;
            notifyAll();
        }
    }
}
