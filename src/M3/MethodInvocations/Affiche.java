package M3.MethodInvocations;

import java.util.concurrent.Callable;

import M3.clients.ObserverDeCapteur;
import M3.services.CapteurAsync;
import M3.services.ObserverDeCapteurAsync;

public class Affiche implements Callable<Void>, MethodInvocation{

	private ObserverDeCapteurAsync observer;
	private CapteurAsync subject;
	
	public Affiche(ObserverDeCapteurAsync observer,CapteurAsync subject) {
		this.observer = observer;
		this.subject = subject;
	}

	@Override
	public Void call() throws Exception {
		this.observer.update(this.subject);
		return null;
	}
	
	@Override
	public Boolean gard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void call(ObserverDeCapteur o) {
		this.observer.update(this.subject);		
	}

	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

}