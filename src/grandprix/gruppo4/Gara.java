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
    public static String nomeGara;
    public Circuito circuito;
    public ArrayList<Pilota> classifica = new ArrayList<>();
    
    public Gara(String nomeGara, Circuito circuito) {
        this.nomeGara = nomeGara;
        this.circuito = circuito;
    }    
}
