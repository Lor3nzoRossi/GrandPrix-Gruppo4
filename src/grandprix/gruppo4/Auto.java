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
    public String marca;
    public int cilindrata;
    public int potenza;
    public Pilota pilota;//seles
    
    //costruttore
    public Auto(int cilindrata, int potenza, String marca, Pilota p) {
        this.cilindrata = cilindrata;
        this.potenza = potenza;
        this.marca = marca;
        this.pilota = p;
    }
}
