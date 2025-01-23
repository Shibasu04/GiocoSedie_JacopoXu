/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giocosedie_jacopoxu;

/**
 *
 * @author Jacopo Xu
 */
public class Partecipante extends Thread {

	Posto sedie[];
	Scrittore scrittore;

	public Partecipante(Posto sedie[],Scrittore scrittore) {
		this.sedie = sedie;
		this.scrittore = scrittore;
	}

	@SuppressWarnings("deprecation") //Utilizzato per togliere il warning dal metodo "getId()"

	public void run() {		
		try {
			sleep((int) (Math.random() * 1000));

			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
					System.out.println("Sono il Thread " + this.getName() + ". Sono riuscito a sedermi sul posto " + ++i); //Questo ++i per correggere le sedie da 1-15, non 0-14
					scrittore.scrivi("Thread " + this.getId() + " ha preso il posto " + i);
					return;
				}
			}
			System.out.println("Sono il Thread " + this.getName()+ ". Ho perso :((((");
			scrittore.scrivi("Thread " + this.getId() + " non è riuscito a trovare una sedia.");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}