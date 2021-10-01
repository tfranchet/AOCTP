package M3.proxy;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

import M3.MethodInvocations.Update;
import M3.clients.Afficheur;
import M3.clients.Capteur;
import M3.clients.CapteurImpl;
import M3.services.ObserverDeCapteurAsync;

public class Canal implements ObserverDeCapteurAsync{

    private CapteurImpl cimpl;

    private Afficheur affiche;

    private ScheduledExecutorService schedule;

    private Update update;

    public Future<Integer> update(Capteur c){
        Future<Integer> f = null;
        return f;
    }

    public Future<Integer> getValue(){
        Future<Integer> f = null;
        return f;
    }
}
