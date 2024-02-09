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
    private String password;

    public Giocatore(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public void creaGara(){
        System.out.println("["+this.username+"] Avvio procedura di creazione gara..");
        System.out.println("Inserisci il nome della gara: ");
        String nomeGara = GrandPrixGruppo4.scanner.nextLine();
        System.out.println("Inserisci la lunghezza del circuito: ");
        int circuit_length = GrandPrixGruppo4.scanner.nextInt();
        GrandPrixGruppo4.scanner.nextLine();
        System.out.println("Inserisci il numero di possibili pitstop: ");
        int nPitStop = GrandPrixGruppo4.scanner.nextInt();
        GrandPrixGruppo4.scanner.nextLine();
        System.out.println("Inserisci il numero di giri da effettuare");
        int nGiri = GrandPrixGruppo4.scanner.nextInt();
        GrandPrixGruppo4.scanner.nextLine();
        //Creazione circuito
        Circuito circuito = new Circuito(circuit_length, nGiri);
        //Creazione gara
        Gara gara = new Gara(nomeGara, nPitStop, circuito);
    }
    
}
