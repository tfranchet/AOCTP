package M3;

public class Afficheur implements ObserverDeCapteur{
	
	int valeur;
	private Capteur capteur;
	
	public Afficheur(Capteur capteur) {
		super();
		this.capteur = capteur;
	}

	@Override
	public void update() {
		this.valeur = this.capteur.getValue();
	}

}
