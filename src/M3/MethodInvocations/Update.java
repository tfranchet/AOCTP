package M3.MethodInvocations;

import java.util.concurrent.Callable;

import M3.clients.ObserverDeCapteur;
import M3.services.CapteurAsync;

public class Update implements Callable<Void>, MethodInvocation {

	private ObserverDeCapteur observer;
	private CapteurAsync subject;
	
	public Update(ObserverDeCapteur observer,CapteurAsync subject) {
		super();
		this.observer 	= observer;
		this.subject 	= subject;
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
		// TODO Auto-generated method stub
		
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
