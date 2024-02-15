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
    public static int nConclusi;
    public int lunghezza;
    public int nGiri;
    public int nPitstop;
    public ArrayList<Auto> elencoAuto = new ArrayList<>();
    public ArrayList<Pilota> classifica = new ArrayList<>();


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
        //partenza di ciascuna auto
        for(Auto auto : this.elencoAuto){
            auto.start(); 
        }
    }
    public void addAuto(Auto a){
        elencoAuto.add(a);
    }
}
