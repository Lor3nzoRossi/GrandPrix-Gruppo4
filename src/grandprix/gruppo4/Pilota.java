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
public class Pilota {
    public String nome;
    public int anni;
    public Giocatore giocatore;
    
    public Pilota(String nome, int anni, Giocatore giocatore) {
        this.nome = nome;
        this.anni = anni;
        this.giocatore = giocatore;
    }
    
    
}
