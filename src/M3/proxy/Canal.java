package M3.proxy;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

import M3.MethodInvocations.GetValue;
import M3.MethodInvocations.Update;
import M3.clients.Afficheur;
import M3.clients.Capteur;
import M3.clients.CapteurImpl;
import M3.scheduler.Scheduler;
import M3.services.CapteurAsync;
import M3.services.ObserverDeCapteurAsync;

public class Canal implements ObserverDeCapteurAsync, CapteurAsync{

    private Capteur cimpl;

    public Afficheur affiche;

    private Scheduler schedule;

    private Update update;

    private GetValue getValue;

    public Canal(Capteur cimpl, Afficheur afficheur){
        this.cimpl = cimpl;
        this.affiche = afficheur;
    }

    public Future update(Capteur c){
        try {
            update = new Update(affiche, this);            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	return schedule.enqueue(update);
    }

    public Future getValue(){
        try {
            getValue = new GetValue(cimpl, this);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
    	return schedule.enqueue(getValue);
    }
    

	@Override
	public Future update(CapteurAsync subject) {
		// TODO Auto-generated method stub
		return null;
	}
}
