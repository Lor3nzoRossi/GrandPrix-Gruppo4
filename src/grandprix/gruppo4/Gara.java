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
public class Gara extends Thread{
    public String nomeGara;
    public Circuito circuito;
    public int nPitstop;
    public ArrayList<Auto> elencoAuto = new ArrayList<>();

    public Gara(String nomeGara, int nPitstop,Circuito circuito, ArrayList<Auto> macchine) {
        this.nomeGara = nomeGara;
        this.circuito = circuito;
        this.nPitstop = nPitstop;
        this.elencoAuto = macchine;
    }
}
