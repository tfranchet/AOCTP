package M3.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import M3.proxy.Canal;

public class Afficheur implements ObserverDeCapteur{
	
	public List<Integer> valeurs;
	
	public Afficheur(Canal canal) {
		super();
		this.valeurs = new ArrayList<Integer>();
	}

	@Override
	public void update(Canal canal) {
		try {
			this.valeurs.add((Integer) (canal.getValue().get()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
