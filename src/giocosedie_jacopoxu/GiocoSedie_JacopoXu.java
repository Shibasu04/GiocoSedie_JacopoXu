/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package giocosedie_jacopoxu;

import java.util.logging.Logger;

/**
 *
 * @author Jacopo Xu
 */
public class GiocoSedie_JacopoXu {
    private final static int NUMSEDIE = 15;
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("deprecation") //Utilizzato per togliere il warning dal metodo "getId()"
    public static void main(String[] args) {
       Scrittore scrittore = new Scrittore("Risultato.txt");
       Posto sedie[] = new Posto[NUMSEDIE];

        for (int k = 0; k < sedie.length; k++)
		sedie[k] = new Posto();

	Display display = new Display(sedie);
	//System.out.println("Sto facendo partire il Display.");
        logger.info("Sto facendo partire il Display.\n");
	display.start();
            
	Partecipante array[] = new Partecipante[NUMSEDIE+1];
	for (int i = 1; i < NUMSEDIE + 1; i++) {
            array[i] = new Partecipante(sedie, scrittore);
            //System.out.println("Sto facendo partire il thread n." + array[i].getId());
            logger.info("Sto facendo partire il thread id: " + array[i].getId()+" name: "+array[i].getName()+"\n");
            array[i].start();
        }
        
    }

}
