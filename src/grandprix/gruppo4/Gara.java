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
public class Gara{
    public String nomeGara;
    public int nPitstop;
    public ArrayList<Auto> elencoAuto = new ArrayList<>();

    public Gara(String nomeGara, int nPitstop, ArrayList<Auto> macchine) {
        this.nomeGara = nomeGara;
        this.nPitstop = nPitstop;
        this.elencoAuto = macchine;
    }
    
    //svolgimento della gara
    public void svolgimento(){
        //partenza di ciascuna auto
        for(Auto auto : elencoAuto){
            auto.start(); 
        }
    }
    
}
