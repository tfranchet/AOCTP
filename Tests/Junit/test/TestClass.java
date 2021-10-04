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
import M3.strategy.DiffusionEpoque;
import M3.strategy.DiffusionSequence;


class TestClass {

	private final int NOMBRE_AFFICHEURS = 4;
	
	private Scheduler scheduler;
	private AlgoDiffusion algo;
	private Capteur capteur;
	private List<Afficheur> afficheurs;
	
	@BeforeEach
	public void initVaraibles() {
		this.scheduler = new Scheduler();
		// Création du capteur
		this.capteur = new CapteurImpl();
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
		// Attache de la stratégie au capteur
		// Préparation de l'algorithme de diffusion
		this.algo = new DiffusionAtomique();
		this.capteur.setStrategy(algo);
		
		Runnable command = ()->{this.capteur.tick();};
		this.scheduler.scheduleAtFixedRate(
				command,				//Ce qui s'execute
				0,						//Le premier délai
				300,					// La période d'exécution
				TimeUnit.MILLISECONDS); // L'unité de temps des périodes
		Thread.sleep(2000);				// On attends un peu
		this.scheduler.remove(command);	// On arrête l'éxécution pérdiodique des tics
		this.scheduler.awaitTermination(5000, TimeUnit.MILLISECONDS);	// On attends un peu que toutes les tâches en cours d'éxécution se terminent
		// On check que toutes les listes soient égales à la liste du capteur
		List<Integer> expectedResult = new ArrayList<Integer>();
		for(int i =1; i<this.capteur.getValue();i++) {
			expectedResult.add(i);
		}
		for (Afficheur afficheur : this.afficheurs) {
			assertEquals(expectedResult,afficheur.getValeurs());
		}
	}

	/**
	 * @throws InterruptedException 
	 */
	@Test
	void testDiffusionEpoque() throws InterruptedException {
		// Attache de la stratégie au capteur
		// Préparation de l'algorithme de diffusion
		this.algo = new DiffusionEpoque();
		this.capteur.setStrategy(algo);
		
		Runnable command = ()->{this.capteur.tick();};
		this.scheduler.scheduleAtFixedRate(
				command,				//Ce qui s'execute
				0,						//Le premier délai
				300,					// La période d'exécution
				TimeUnit.MILLISECONDS); // L'unité de temps des périodes
		Thread.sleep(2000);				// On attends un peu
		this.scheduler.remove(command);	// On arrête l'éxécution pérdiodique des tics
		this.scheduler.awaitTermination(5000, TimeUnit.MILLISECONDS);	// On attends un peu que toutes les tâches en cours d'éxécution se terminent
		//TODO Arranger la vérification à la stratégie de diffusion
		List<Integer> expectedResult = new ArrayList<Integer>();
		for(int i =1; i<this.capteur.getValue();i++) {
			expectedResult.add(i);
		}
		for (Afficheur afficheur : this.afficheurs) {
			assertEquals(expectedResult,afficheur.getValeurs());
		}
	}
	
	/**
	 * @throws InterruptedException 
	 */
	@Test
	void testDiffusionSequence() throws InterruptedException {
		// Attache de la stratégie au capteur
		// Préparation de l'algorithme de diffusion
		this.algo = new DiffusionSequence();
		this.capteur.setStrategy(algo);
		
		Runnable command = ()->{this.capteur.tick();};
		this.scheduler.scheduleAtFixedRate(
				command,				//Ce qui s'execute
				0,						//Le premier délai
				300,					// La période d'exécution
				TimeUnit.MILLISECONDS); // L'unité de temps des périodes
		Thread.sleep(2000);				// On attends un peu
		this.scheduler.remove(command);	// On arrête l'éxécution pérdiodique des tics
		this.scheduler.awaitTermination(5000, TimeUnit.MILLISECONDS);	// On attends un peu que toutes les tâches en cours d'éxécution se terminent
		
		// Tous les afficheurs doivent avoir la même liste, même si ce n'est pas un sous ensemble des valeurs du capteur
		for(int i =0; i<this.afficheurs.size()-1;i++) {
			assertEquals(this.afficheurs.get(i).getValeurs(),this.afficheurs.get(i+1).getValeurs());
		}

	}
}
