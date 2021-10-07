package M3.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import M3.services.CapteurAsync;

public class Afficheur implements ObserverDeCapteur{
	
	private List<Integer> valeurs;
	
	public Afficheur() {
		super();
		this.valeurs = new ArrayList<Integer>();
	}

	@Override
	public void update(CapteurAsync canal) {
		System.out.println("canal : " + canal);
		try {
			this.valeurs.add((Integer) (canal.getValue().get()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> getValeurs(){
		return valeurs;
	}

}
