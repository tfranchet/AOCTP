package M3.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import M3.services.CapteurAsync;

public class Afficheur implements ObserverDeCapteur{
	
	private List<Integer> valeurs;
	
	public Afficheur() {
		super();
		this.valeurs = new ArrayList<Integer>();
	}

	@Override
	public void update(CapteurAsync canal) {
		try {
			Future<Integer> gv = canal.getValue();
			System.out.println(gv.get());
			this.valeurs.add((gv.get()));
			
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
