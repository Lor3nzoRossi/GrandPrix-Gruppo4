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
    public int circuit_length; 
    public int nGiri;
    public int pitStop;

    public Gara(int circuit_length, int nGiri, int pitStop) {
        this.circuit_length = circuit_length;
        this.nGiri = nGiri;
        this.pitStop = pitStop;
    }
    
    
}
