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
public class Gara extends Thread{
    public String nomeGara;
    public Circuito circuito;
    public int nPitstop;

    public Gara(String nomeGara, int nPitstop,Circuito circuito) {
        this.nomeGara = nomeGara;
        this.circuito = circuito;
        this.nPitstop = nPitstop;
    }
    
    
}
