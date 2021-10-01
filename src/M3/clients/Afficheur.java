package M3.clients;

import java.util.ArrayList;
import java.util.List;

import M3.services.CapteurAsync;

public class Afficheur implements ObserverDeCapteur{
	
	List<Integer> valeurs;
	
	public Afficheur(Capteur capteur) {
		super();
		this.valeurs = new ArrayList<Integer>();
	}

	@Override
	public void update(CapteurAsync capteur) {
		this.valeurs.add(capteur.getValue());
	}

}
