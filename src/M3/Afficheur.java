package M3;

public class Afficheur implements ObserverDeCapteur{

	int valeur;
	
	public Afficheur() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Capteur capteur) {
		// TODO Auto-generated method stub
		this.valeur = capteur.getValue();
	}

}
