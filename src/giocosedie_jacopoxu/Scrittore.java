/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocosedie_jacopoxu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
/**
 *
 * @author JacopoXu
 */
public class Scrittore implements Runnable{
     String nomeFile;
    
    public Scrittore(String nomeFile){
        this.nomeFile = nomeFile;
        //Inizializzazione del file, pulizia del vecchio contenuto + la data di avvio
        BufferedWriter dataWriter = null;
    try {
        dataWriter = new BufferedWriter(new FileWriter(nomeFile,false));
        String dataOra = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        dataWriter.write("Gioco del " + dataOra + "\n");
        dataWriter.newLine();
        dataWriter.flush();
    } catch (IOException e) {
        Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, e);
    }
    }
    
    @Override
    public void run() {
        System.out.println("Avvio scrittore\n");
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */


    public synchronized void scrivi(String text){
        BufferedWriter br=null;
        
        try {
            //1) apro il file
            br = new BufferedWriter(new FileWriter(nomeFile, true));
            //3) scrivo nel buffer
            br.write(text);
            br.write("\n\r");
            //4) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}
