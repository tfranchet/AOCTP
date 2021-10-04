package M3;

import java.util.ArrayList;
import java.util.List;

import M3.clients.Afficheur;
import M3.clients.Capteur;
import M3.clients.CapteurImpl;
import M3.scheduler.Scheduler;
import M3.strategy.AlgoDiffusion;
import M3.strategy.DiffusionAtomique;

public class App {
    public static void main(String[] args) throws Exception {
    	
    	Scheduler scheduler = new Scheduler();
		// Création du capteur
		Capteur capteur = new CapteurImpl();
		// Création des afficheurs
		List<Afficheur> afficheurs = new ArrayList<Afficheur>();
		for (int i =0;i< 4;i++) {
			afficheurs.add(new Afficheur());
		}
		//Connexion du capteur aux afficheurs
		for (Afficheur afficheur : afficheurs) {
			capteur.attach(afficheur);
		}
		AlgoDiffusion algo = new DiffusionAtomique();
		capteur.setStrategy(algo);
    }
}
