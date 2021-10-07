

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
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
import M3.strategy.DiffusionSequentielle;


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
			capteur.attach(afficheur, scheduler);
		}

	}
	
	/**
	 * @throws InterruptedException 
	 */
	@Test
	void testDiffusionAtomique() throws InterruptedException {
		// Attache de la stratégie au capteur
		// Préparation de l'algorithme de diffusion
		this.algo = new DiffusionAtomique(capteur);
		algo.configure();
		this.capteur.setStrategy(algo);
		
		Runnable command = ()->{this.capteur.tick();};
		this.scheduler.scheduleAtFixedRate(
				command,				//Ce qui s'execute
				0,						//Le premier délai
				100,					// La période d'exécution
				TimeUnit.MILLISECONDS); // L'unité de temps des périodes
		Thread.sleep(2000);				// On attends un peu
		this.scheduler.remove(command);	// On arrête l'éxécution pérdiodique des tics
		this.scheduler.awaitTermination(10000, TimeUnit.MILLISECONDS);	// On attends un peu que toutes les tâches en cours d'éxécution se terminent
		// On check que toutes les listes soient égales à la liste du capteur
		List<Integer> expectedResult = new ArrayList<Integer>();
		for(int i =0; i<this.capteur.getValue();i++) {
			expectedResult.add(i);
		}
		assertFalse(expectedResult .size() == 0);
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
		this.algo = new DiffusionEpoque(capteur);
		algo.configure();
		this.capteur.setStrategy(algo);
		
		Runnable command = ()->{this.capteur.tick();};
		this.scheduler.scheduleAtFixedRate(
				command,				//Ce qui s'execute
				0,						//Le premier délai
				100,					// La période d'exécution
				TimeUnit.MILLISECONDS); // L'unité de temps des périodes
		Thread.sleep(2000);				// On attends un peu
		this.scheduler.remove(command);	// On arrête l'éxécution pérdiodique des tics
		this.scheduler.awaitTermination(10000, TimeUnit.MILLISECONDS);	// On attends un peu que toutes les tâches en cours d'éxécution se terminent
		//TODO Arranger la vérification à la stratégie de diffusion
		List<Integer> expectedResult = new ArrayList<Integer>();
		System.out.println(this.capteur.getValue());
		for(int i =1; i<this.capteur.getValue();i++) {
			expectedResult.add(i);
		}
		assertFalse(expectedResult.isEmpty());

		for(int i =0; i<this.afficheurs.size();i++) {
			System.out.println(this.afficheurs.get(i).getValeurs());
			List<Integer> vals= this.afficheurs.get(i).getValeurs();
			for (Integer integer : vals) {
				assertTrue(expectedResult.contains(integer));
			}	
			Collections.sort(vals);
			assertTrue(this.afficheurs.get(i).getValeurs() == vals);
		}
	}
	
	/**
	 * @throws InterruptedException 
	 */
	@Test
	void testDiffusionSequence() throws InterruptedException {
		// Attache de la stratégie au capteur
		// Préparation de l'algorithme de diffusion
		this.algo = new DiffusionSequentielle(capteur);
		algo.configure();
		this.capteur.setStrategy(algo);
		
		Runnable command = ()->{this.capteur.tick();};
		this.scheduler.scheduleAtFixedRate(
				command,				//Ce qui s'execute
				0,						//Le premier délai
				100,					// La période d'exécution
				TimeUnit.MILLISECONDS); // L'unité de temps des périodes
		Thread.sleep(2000);				// On attends un peu
		this.scheduler.remove(command);	// On arrête l'éxécution pérdiodique des tics
		this.scheduler.awaitTermination(10000, TimeUnit.MILLISECONDS);	// On attends un peu que toutes les tâches en cours d'éxécution se terminent
		
		// Tous les afficheurs doivent avoir la même liste, même si ce n'est pas un sous ensemble des valeurs du capteur
		assertFalse(capteur.getValue() == 0);
		List<Integer> a1 = this.afficheurs.get(0).getValeurs();
		for (Afficheur afficheur : this.afficheurs) {
			System.out.println(afficheur.getValeurs());
			assertEquals(a1,afficheur.getValeurs());
			List<Integer> vals= afficheur.getValeurs();
			for (Integer integer : vals) {
				assertTrue(a1.contains(integer));
			}	
			Collections.sort(vals);
			assertTrue(afficheur.getValeurs() == vals);
		
		}
		

	}
}
