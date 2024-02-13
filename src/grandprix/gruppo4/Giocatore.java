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
        System.out.println("Inserisci il nome della gara: ");
        String nomeGara = GrandPrixGruppo4.scanner.nextLine();
        System.out.println("Inserisci il numero di possibili pitstop: ");
        int nPitStop = GrandPrixGruppo4.scanner.nextInt();
        //Creazione elenco di auto
        ArrayList<Auto> elencoAuto = new ArrayList<>();
        System.out.println("Quante auto vuoi far gareggiare?");
        int nAuto = GrandPrixGruppo4.scanner.nextInt();
        System.out.println("nauto: " + nAuto);
        GrandPrixGruppo4.scanner.nextLine();
        for(int i=0;i<nAuto;i++){
            Auto auto = creaAuto();
            if(auto != null){
                elencoAuto.add(auto);
            }else{
                System.out.println("Errore nella creazione dell'auto, riavvio procedura di creazione...");
                auto = creaAuto();
            }
        }
        //Creazione oggetto gara
        Gara gara = new Gara(nomeGara, nPitStop, creaCircuito(), elencoAuto);
    }
    //Creazione del circuito
    public Circuito creaCircuito(){
        //Input lunghezza circuito
        System.out.println("Inserisci la lunghezza del circuito: ");
        int circuit_length = GrandPrixGruppo4.scanner.nextInt();
        GrandPrixGruppo4.scanner.nextLine();
        //Input del numero di giri
        System.out.println("Inserisci il numero di giri da effettuare");
        int nGiri = GrandPrixGruppo4.scanner.nextInt();
        GrandPrixGruppo4.scanner.nextLine();
        //Creazione circuito
        Circuito circuito = new Circuito(circuit_length, nGiri);
        return circuito;
    }
    //creazione automobile
    public Auto creaAuto(){
        System.out.println("Inserisci il modello della nuova auto");
        String modello = GrandPrixGruppo4.scanner.nextLine();
        //scelta pilota
        Pilota pilota;
        System.out.println("Inserisci il nome del Pilota, scegliendo fra i piloti disponibili:\n");
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
                            pilota = new Pilota(nome, anni);
                            return new Auto(modello,pilota);
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
