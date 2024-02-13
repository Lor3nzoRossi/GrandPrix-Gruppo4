/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix.gruppo4;

/**
 *
 * @author Studente
 */
public class Auto extends Thread{
    public String modello;
    public int velocita;
    public Pilota pilota;
    
    //costruttore
    public Auto(String modello, Pilota pilota) {
        this.modello = modello;
        this.pilota = pilota;
    }
    
}
