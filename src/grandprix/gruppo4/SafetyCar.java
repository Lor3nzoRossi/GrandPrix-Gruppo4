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
        while(this.occupata){
            try {
                a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.occupata = true;
        System.out.println("[" + a.modello + "] Entrata safety car...");
        //rallentamento generale della auto per 5 secondi
        int velocitàAuto = Auto.velocita;
        for(int i=0;i<5;i++){
            try {
                this.sleep(1000);
                Auto.velocita-=1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Auto.velocita = velocitàAuto;
        //fine riparazione
        System.out.println("[SafetyCar] Fine riparazione di " + a.modello);
        notifyAll();
        this.occupata = false;
    }
}
