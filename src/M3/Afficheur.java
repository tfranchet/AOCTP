package M3;

public class Afficheur implements ObserverDeCapteur{

	int valeur;
	private Canal canal;
	
	public Afficheur(Canal canal) {
		super();
		this.canal = canal;
	}

	@Override
	public void update(Capteur capteur) {
		canal.update(capteur);
		this.canal.update(capteur);
		this.valeur = capteur.getValue();
	}

}
