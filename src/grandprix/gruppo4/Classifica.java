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
public class Classifica {
    public int nConclusi;
    public int nAuto;
    public ArrayList<Auto> classifica = new ArrayList<>();
    public boolean semaforo;

    public Classifica(int nAuto) {
        this.nAuto = nAuto;
        this.semaforo = true;
    }
    
    public synchronized void addAuto(Auto auto){
        if(this.semaforo){
            //blocca altre auto dall'essere aggiunte
            this.semaforo = false;
            this.classifica.add(auto);
            
            //controllo se gara finita
            if(this.classifica.size()>=this.nAuto){
                System.out.println("CLASSIFICA:");
                for(int i=0;i<this.classifica.size();i++){
                    System.out.println((i+1) + ") "+this.classifica.get(i).pilota.nome + "-" + this.classifica.get(i).modello);
                }
            }
            //rendi possibile l'aggiunta di un'altra auto
            this.semaforo = true;
        }
    }
}
