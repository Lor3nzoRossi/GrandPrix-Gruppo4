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
import java.util.ArrayList;
import java.util.Collections;
public class Gara extends Thread{
    public String nomeGara;
    public Circuito circuito;
    public ArrayList<Pilota> classifica = new ArrayList<>();
    
    public Gara(String nomeGara, Circuito circuito) {
        this.nomeGara = nomeGara;
        this.circuito = circuito;
    }    

    @Override
    public void run() {
        classifica();
    }
    
    //definizione classifica
    public void classifica(){
        System.out.println("CLASSIFICA: ");
        ArrayList<Long> tempi = new ArrayList<>(); //array tempi
        //riempimento array tempi con il tempo di ciascuna auto 
        for(Auto auto : circuito.elencoAuto){
            tempi.add(auto.tempo);
        }
        //ordinamento array di tempi
        Collections.sort(tempi);
        //riempimento classifica
        for(int i=0;i<circuito.elencoAuto.size();i++){
            classifica.add(circuito.elencoAuto.get(i).pilota);
            System.out.println((i+1) + ")" + circuito.elencoAuto.get(i).pilota.nome);
        }
    }
}
