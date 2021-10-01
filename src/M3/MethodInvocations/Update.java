package M3.MethodInvocations;

import java.util.concurrent.Callable;

import M3.clients.ObserverDeCapteur;
import M3.proxy.Canal;
import M3.services.CapteurAsync;

public class Update implements Callable<Void>, MethodInvocation {

	private ObserverDeCapteur observer;
	private Canal subject;
	
	public Update(ObserverDeCapteur observer,Canal subject) {
		super();
		this.observer 	= observer;
		this.subject 	= subject;
	}

    @Override
    public void callMI() {
    	this.observer.update(this.subject);
    }


	@Override
	public Boolean gard() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
