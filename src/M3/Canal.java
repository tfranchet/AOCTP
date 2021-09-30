package M3;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements ObserverDeCapteurAsync{

    private CapteurImpl cimpl;

    private Afficheur affiche;

    private ScheduledExecutorService schedule;

    private Update update;

    public Canal(Afficheur affiche, CapteurImpl capteur, ScheduledExecutorService schedule){
        this.cimpl = capteur;
        this.affiche = affiche;
        this.schedule = schedule;
        this.update = new Update();
    }

    public Future<Integer> update(Capteur c){
        update = new Update();
        Long l = 1000L;
        return schedule.schedule(update, l, TimeUnit.MILLISECONDS);
        
        }

    public Future<Integer> getValue(){
        Future<Integer> f = null;
        return f;
    }
}
