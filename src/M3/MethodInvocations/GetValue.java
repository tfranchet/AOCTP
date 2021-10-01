package M3.MethodInvocations;

import java.util.concurrent.Callable;

import M3.clients.Capteur;
import M3.clients.ObserverDeCapteur;
import M3.proxy.Canal;
import M3.services.CapteurAsync;
import M3.services.ObserverDeCapteurAsync;

public class GetValue implements Callable<Void>, MethodInvocation{

	private Canal subject;
	private Capteur observer;
	
	public GetValue(Capteur observer,Canal subject) {
		super();
		this.observer = observer;
		this.subject = subject;
	}

	@Override
	public Void call() throws Exception {
		this.observer.getValue();
		return null;
	}
	
	@Override
	public Boolean gard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void callMI() {
		this.observer.getValue();		
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