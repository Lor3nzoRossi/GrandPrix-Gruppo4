/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandprix.gruppo4;

/**
 *
 * @author lorir, Bighi, La Mantia, Fahim
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class GrandPrixGruppo4 {
    public static Scanner scanner = new Scanner(System.in);// statico in modo da creare una sola istanza riutilizzabile
    public static ArrayList<Giocatore> elencoGiocatori = new ArrayList<>(); 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        //creazione oggetti Giocatore da Giocatori.txt
        String line;
        try {
            //apertura file in lettura
            BufferedReader br = new BufferedReader(new FileReader("Giocatori.txt"));
            //lettura file riga per riga
            while ((line = br.readLine()) != null){
                String username;
                String password;
                //suddivisione linea in username e password
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ';') {
                        username = line.substring(0, i);
                        password = line.substring(i + 1);
                        //creazione giocatore
                        Giocatore giocatore = new Giocatore(username, password);
                        elencoGiocatori.add(giocatore);
                        break;
                    }
                }
            }
        }catch (FileNotFoundException ex) {
            System.out.println("file non trovato");
        } 
        catch (IOException ex) {
            System.out.println(ex);
        }
        //Login or signup
        System.out.println("Vuoi eseguire l'accesso? Oppure la registrazione?(accesso/registrazione)");
        String LoginOrSignup = scanner.nextLine();
        switch(LoginOrSignup){
            case "accesso":
                accedi();
                break;
            case "registrazione":
                registra();
                break;
        }
    }
    public static void registra(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Giocatori.txt", true))) {
            System.out.println("Inserisci l'username: ");
            String username = scanner.nextLine();
            System.out.println("Inserisci la password: ");
            String password = scanner.nextLine();
            //scrivi nel file
            bw.write(username);
            bw.write(';');
            bw.write(password);
            bw.write('\n');
            bw.flush();
            //creazione Giocatore
            Giocatore giocatore = new Giocatore(username, password);
            //inserimento nell'elenco dei giocatori registrati
            elencoGiocatori.add(giocatore);
            //reindirizzamento a procedura di accesso
            System.out.println("Inizio procedura di accesso");
            //inizio procedura di accesso
            accedi();
        } catch (IOException ex) {
            System.out.println("Eccezione nell'input: " + ex);
        }
    }
    public static void accedi() {
        boolean empty = false;

        try (BufferedReader br = new BufferedReader(new FileReader("Giocatori.txt"))) {
            if (br.readLine() == null) {
                empty = true;
            }
        } catch (IOException ex) {
            System.out.println("eccezione: " + ex);
        }
        //controllo se sono stati creati account
        if (!empty) {
            System.out.println("Inserisci l'username: ");
            String username = scanner.nextLine();
            System.out.println("Inserisci la password: ");
            String password = scanner.nextLine();
            System.out.println(username);
            //*CONTROLLO CREDENZIALI IN Giocatori.txt*
            for(Giocatore giocatore : elencoGiocatori){
                if(giocatore.username.equals(username) ){
                    if(giocatore.getPassword().equals(password)){
                        System.out.println("Accesso completato con successo.");
                        System.out.println("["+username+"]Vuoi creare una gara?");
                        String risposta = scanner.nextLine();
                        if(risposta.equals("si")){
                            giocatore.creaGara();//inizio procedura di creazione gara
                        }
                    }
                }
            }
        } else {
            //se non vi sono presenti account a cui accedere, reindirizzamento a registrazione
            System.out.println("Nessun account registrato, avvio procedura di registrazione...");
            registra();
        }
    }
}
