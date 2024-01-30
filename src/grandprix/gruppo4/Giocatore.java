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
public class Giocatore extends Thread{
    public String username;

    public Giocatore(String username) {
        this.username = username;
    }
}
