package M3;

public class Afficheur implements ObserverDeCapteur{

	int valeur;

	private Canal canal;
	
	public Afficheur() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Capteur capteur) {
		canal.update(capteur);
		// TODO Auto-generated method stub
		this.valeur = capteur.getValue();
	}

}
