package M3;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Canal implements ObserverDeCapteurAsync{

    private CapteurImpl cimpl;

    private Afficheur affiche;

    private ScheduledExecutorService schedule;

    public Future<Integer> update(Capteur c){
        Future<Integer> f;
        return f;
    }

    public Future<Integer> getValue(){
        Future<Integer> f;
        return f;
    }
}
