package Junit.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import M3.clients.Afficheur;
import M3.clients.Capteur;
import M3.clients.CapteurImpl;
import M3.proxy.Canal;
import M3.scheduler.Scheduler;
import M3.strategy.AlgoDiffusion;
import M3.strategy.DiffusionAtomique;


class TestClass {

	private final int NOMBRE_AFFICHEURS = 4;
	
	private Scheduler scheduler;
	private AlgoDiffusion algo;
	private Capteur capteur;
	private List<Afficheur> afficheurs;
	
	@BeforeEach
	public void initVaraibles() {
		this.scheduler = new Scheduler();
		// Préparation de l'algorithme de diffusion
		this.algo = new DiffusionAtomique();
		// Création du capteur
		this.capteur = new CapteurImpl(this.algo);
		// Création des afficheurs
		this.afficheurs = new ArrayList<Afficheur>();
		for (int i =0;i< NOMBRE_AFFICHEURS;i++) {
			this.afficheurs.add(new Afficheur());
		}
		//Connexion du capteur aux afficheurs
		for (Afficheur afficheur : afficheurs) {
			capteur.attach(afficheur);
		}

	}
	/**
	 * @throws InterruptedException 
	 */
	@Test
	void testDiffusionAtomique() throws InterruptedException {
		Runnable command = ()->{this.capteur.tick();};
		this.scheduler.scheduleAtFixedRate(
				command,				//Ce qui s'execute
				0,						//Le premier délai
				300,					// La période d'exécution
				TimeUnit.MILLISECONDS); // L'unité de temps des périodes
		Thread.sleep(2000);				// On attends un peu
		this.scheduler.remove(command);	// On arrête l'éxécution pérdiodique des tics
		this.scheduler.awaitTermination(5000, TimeUnit.MILLISECONDS);	// On attends un peu que toutes les tâches en cours d'éxécution se terminent
		
		List<Integer> expectedResult = new ArrayList<Integer>();
		for(int i =1; i<this.capteur.getValue();i++) {
			expectedResult.add(i);
		}
		for (Afficheur afficheur : this.afficheurs) {
			assertEquals(expectedResult,afficheur.getValeurs());
		}
	}

}
