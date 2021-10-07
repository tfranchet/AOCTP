package M3.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import M3.clients.Capteur;
import M3.clients.CapteurImpl;
import M3.proxy.Canal;

public class DiffusionAtomique implements AlgoDiffusion{

    private List<Canal> canaux;

    private List<Capteur> capteurs;

    private Future[] futures;

    public DiffusionAtomique(Capteur capteur){
        this.capteurs = new ArrayList<Capteur>();
        capteurs.add(capteur);
        this.canaux = capteur.getAllCanaux();
    }

    public void configure(){
        
        futures= new Future[canaux.size()];
    }

    public void execute(){
        //canadd a true entrainera une incrémentation du capteur
        int i = 0;
        boolean canadd = true;
        for (Canal canal : canaux) {
            for (Capteur capteur : capteurs) {
                if (futures[i] == null){
                    futures[i] = canal.update(capteur);
            }
            //Si au moins un future n'est pas terminé, l'inrémentation n'aura pas lieu
                if(futures[i] != null && !futures[i].isDone()){
                    canadd = false;
                }
        }
         i++;
        }
        for (Capteur capteur : capteurs) {
            if(canadd) {
                capteur.updateValue() ;
            futures = new Future[canaux.size()];
        }
    }
    }
}
