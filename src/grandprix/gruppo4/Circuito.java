/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandprix.gruppo4;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lorir
 */
public class Circuito extends Thread{
    public int lunghezza;
    public int nGiri;
    public int nPitstop;
    public Classifica classifica;
    public ArrayList<Auto> elencoAuto = new ArrayList<>();


    public Circuito(int lunghezza, int nGiri, int nPitstop) {
        this.lunghezza = lunghezza;
        this.nGiri = nGiri;
        this.nPitstop = nPitstop;
    }

    @Override
    public void run() {
        svolgimento();
    }
    
    //svolgimento della gara
    public void svolgimento(){
        classifica = new Classifica(this.elencoAuto.size());
        //countdown
        for(int i=1;i<=3;i++){
            System.out.println(i + "!");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("||INIZIO GARA||");
        //partenza di ciascuna auto
        for(Auto auto : this.elencoAuto){
            auto.start(); 
        }
    }
}
