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

public class GrandPrixGruppo4 {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
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
        //stream in append
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/grandprix/gruppo4/Giocatori.txt"))) {
            System.out.println("Inserisci l'username: ");
            String username = scanner.nextLine();
            System.out.println("Inserisci la password: ");
            String password = scanner.nextLine();
            //scrivi nel file
            bw.write(username);
            bw.write(';');
            bw.write(password);
            bw.flush();
            //creazione Giocatore
            Giocatore giocatore = new Giocatore(username);
        } catch (IOException ex) {
            System.out.println("Eccezione nell'input: " + ex);
        }
    }
    public static void accedi() {
        boolean empty = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/grandprix/gruppo4/Giocatori.txt"))) {
            if (br.readLine() == null) {
                empty = true;
            }
        } catch (IOException ex) {
            System.out.println("eccezione: " + ex);
        }

        if (!empty) {
            System.out.println("Inserisci l'username: ");
            String username = scanner.nextLine();
            System.out.println("Inserisci la password: ");
            String password = scanner.nextLine();
        } else {
            System.out.println("Nessun account registrato, avvio procedura di registrazione...");
            registra();
        }
    }

}
