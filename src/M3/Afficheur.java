package M3;

import java.util.ArrayList;
import java.util.List;

public class Afficheur implements ObserverDeCapteur{
	
	List<Integer> valeurs;
	private Capteur capteur;
	
	public Afficheur(Capteur capteur) {
		super();
		this.valeurs = new ArrayList<Integer>();
		this.capteur = capteur;
	}

	@Override
	public void update() {
		this.valeurs.add(this.capteur.getValue());
	}

}
