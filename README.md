GrandPrix-Gruppo4 README.md
Titolo: Grand Prix

Descrizione:

Questo programma permette di creare simulazioni personalizzate di gare di automobili da corsa, sfruttando
la tecnologia Thread che Java fornisce.

Funzionalità:

Personalizzazione

-Auto(esistenti o di propria invenzione)
-Pilota(viene fornito un menù da cui scegliere)
-Circuito(lunghezza, numero di possibili pitstop e numero di giri)

Per clonare il repository: git clone https://github.com/Lor3nzoRossi/GrandPrix-Gruppo4.git

Esecuzione:

L'esecuzione della gara avverrà mostrando, ogni secondo, al Giocatore la progressione di ciascuna auto rispetto allo
spazio rimanente per completare il giro.
Durante la gara le auto potrebbero fermarsi per fare un pit stop, che le bloccherà per 2 secondi,
oppure intercorrere in un guasto che le fermerà per 5.

Utilizzo:

Inizialmente verrà richiesto di fare l'accesso(se si possiede già un account), altrimenti se ne
può creare uno gratuitamente scegliendo di registrarsi.
Successivamente inizierà la procedura di creazione della gara su conferma del Giocatore, quindi prima la
creazione del circuito dove verrà richiesta la lunghezza poi il numero di giri e possibili pitstop durante la
competizione. Verrà richiesto il nome della Gara e quante auto si vuole far gareggiare, per poi specificarne
il modello e Pilota.
Raccolte le informazioni necessarie, chiederà all'utente se fare iniziare la gara (rispondere "si" per confermare).

Esempio:

[Punto] ha percorso: 20/200
[CinaCar] entra nel pitstop...
[Punto] GUASTO
[Mazda] ha percorso: 10/200
[Illaary] ha percorso: 10/200
[Punto] Entrata safety car...
[Illaary] GUASTO
[Mazda] ha percorso: 20/200
[CinaCar] GUASTO
[Mazda] ha percorso: 30/200
[Mazda] entra nel pitstop...
[Safety car] Fine riparazione di Punto

Licenza:
Questo programma è distribuito sotto la licenza GRUPPO4-5AINF.

Contributi:
Sono ben accetti contributi per migliorare questo programma. 

Note:
Realizzato per il corso di TIPSIT a seguito di prof. Monica Ciuchetti e Ilaria Fioroni.

Altri file:
Giocatori.txt: file contenente i nomi e le password dei Giocatori
Piloti.txt: file contenente i nomi dei piloti disponibili

CREDITI:
Gruppo4-5AINF
