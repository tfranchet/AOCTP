package M3.strategy;

import java.util.List;
import java.util.concurrent.Future;

import M3.clients.CapteurImpl;
import M3.proxy.Canal;

public class DiffusionAtomique implements AlgoDiffusion{

    private List<Canal> canaux;

    private List<CapteurImpl> capteurs;

    private Future[] futures;

    public void configure(){

        futures= new Future[capteurs.size()];
    }

    public void execute(){
        //canadd a true entrainera une incrémentation du capteur
        int i = 0;
        boolean canadd = true;
        for (Canal canal : canaux) {
            for (CapteurImpl capteur : capteurs) {
                if (!(futures[i] == null)){
                 futures[i] = canal.update(capteur);
            }
            //Si au moins un future n'est pas terminé, l'inrémentation n'aura pas lieu
                if(futures[i] != null && !futures[i].isDone()){
                    canadd = false;
                }
        }
         i++;
        }
        for (CapteurImpl capteur : capteurs) {
            if(canadd) {
                capteur.updateValue() ;
            futures = new Future[capteurs.size()];
        }
    }
    }
}
