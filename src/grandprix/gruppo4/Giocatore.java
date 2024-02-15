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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    
    //Creazione gara
    public void creaGara(){
        System.out.println("["+this.username+"] Avvio procedura di creazione gara..");
        System.out.println("["+this.username+"]Creazione circuito...");
        Circuito circuito = creaCircuito(); // creazione circuito
        System.out.println("[" + this.username + "] Inserisci il nome della gara: ");
        String nomeGara = GrandPrixGruppo4.scanner.nextLine();
        //creazione Safety Car
        SafetyCar safetyCar = new SafetyCar();
        //creazione auto
        System.out.println("[" + this.username + "] Quante auto vuoi far gareggiare?");
        int nAuto = GrandPrixGruppo4.scanner.nextInt();
        GrandPrixGruppo4.scanner.nextLine();
        for(int i=0;i<nAuto;i++){
            System.out.println("[" + this.username + "] inizio procedura di creazione "+(i+1)+"° auto...");
            Auto auto = creaAuto(circuito, safetyCar);
            circuito.elencoAuto.add(auto);
        }
        //Creazione oggetto gara
        Gara gara = new Gara(nomeGara, circuito);
        System.out.println("Creazione gara con successo.");
        System.out.println("Iniziare la gara?");
        String iniziaGara = GrandPrixGruppo4.scanner.nextLine();
        
        if(iniziaGara.equals("si")){
            System.out.println("||INIZIO GARA||");
            circuito.start();
        }
        //mostra classifica. *PROBLEMA*: far eseguire gara.start() o gara.classifica() dopo la terminazione dei Thread auto chiamati da circuito.start() o circuito.svolgimento()
        //gara.classifica(); //ho provato a rendere gara un Thread e chiamare classifica() nel run() per gestirlo come un Thread
    }
    //Creazione del circuito
    public Circuito creaCircuito(){
        //Input lunghezza circuito
        System.out.println("[" + this.username + "] Inserisci la lunghezza del circuito: ");
        int circuit_length = GrandPrixGruppo4.scanner.nextInt();
        GrandPrixGruppo4.scanner.nextLine();
        //Input del numero di giri
        System.out.println("[" + this.username + "] Inserisci il numero di giri da effettuare");
        int nGiri = GrandPrixGruppo4.scanner.nextInt();
        //Input del numero di pitstop disponibili
        System.out.println("[" + this.username + "] Inserisci il numero di possibili pitstop: ");
        int nPitStop = GrandPrixGruppo4.scanner.nextInt();
        GrandPrixGruppo4.scanner.nextLine();
        //Creazione circuito
        Circuito circuito = new Circuito(circuit_length, nGiri, nPitStop);
        return circuito;
    }
    //creazione automobile
    public Auto creaAuto(Circuito circuito, SafetyCar safetyCar){
        System.out.println("[" + this.username + "] Inserisci il modello della nuova auto");
        String modello = GrandPrixGruppo4.scanner.nextLine();
        //scelta pilota
        Pilota pilota;
        do{
            pilota = creaPilota(modello);
            if(pilota == null){
                System.err.println("[" + this.username + "] Errore nella creazione di "+modello+". Scegli un pilota presente nella lista mostrata.");
            }
        }while(pilota == null);
        System.out.println("[" + this.username + "] Auto " + modello + " creata con successo.");
        return new Auto(modello, circuito, pilota, safetyCar);
    }
    public Pilota creaPilota(String modello){
        System.out.println("[" + this.username + "] Inserisci il nome del Pilota, scegliendo fra i piloti disponibili:\n");
        //Stampa elenco piloti disponibili
        try(BufferedReader br = new BufferedReader(new FileReader("piloti.txt"))){
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line + "\n");
            }
        }catch(IOException ex){
            System.out.println("errore I/O: " + ex);
        }
        //Scelta del pilota dal menu
        String pilotaScelto = GrandPrixGruppo4.scanner.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader("piloti.txt"))) {
            String line;
            while((line = br.readLine())!=null){
                for(int i=0;i<line.length();i++){
                    if(line.charAt(i) == ':'){
                        String nome = line.substring(0, i);
                        int anni = Integer.parseInt(line.substring(i + 2));
                        if(nome.equals(pilotaScelto)){
                            return new Pilota(nome, anni, modello);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("errore I/O: " + ex);
        }
        return null;
    }
}
