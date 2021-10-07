package M3.MethodInvocations;

import java.util.concurrent.Callable;

import M3.clients.Capteur;
import M3.proxy.Canal;

public class GetValue implements Callable<Integer>, MethodInvocation{

	private Canal subject;
	private Capteur observer;
	public Integer value;
	
	public GetValue(Capteur observer,Canal subject) {
		super();
		this.observer = observer;
		this.subject = subject;
	}

	@Override
	public Integer call() throws Exception {
		value = this.observer.getValue();
		System.out.println(value);
		return value;
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