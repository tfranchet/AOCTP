package M3.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import M3.clients.Capteur;
import M3.clients.CapteurImpl;
import M3.proxy.Canal;

public class DiffusionEpoque implements AlgoDiffusion{

    private List<Canal> canaux;

    private List<Capteur> capteurs;

    private Future[] futures;

    public DiffusionEpoque(Capteur capteur){
        this.capteurs = new ArrayList<Capteur>();
        capteurs.add(capteur);
        this.canaux = capteur.getAllCanaux();
    }

    @Override
    public void configure() {
        futures = new Future[canaux.size()];
    }

    /**
     * Les afficheurs recoivent les éléments dans l'ordre croissant
     */
    @Override
    public void execute() {
                //canadd a true entrainera une incrémentation du capteur
                int i = 0;
                for (Canal canal : canaux) {
                    for (Capteur capteur : capteurs) {
                        if (futures[i] == null){
                            futures[i] = canal.update(capteur);
                    }
                    //Si au moins un future n'est pas terminé, l'inrémentation n'aura pas lieu
                        if(futures[i] != null && futures[i].isDone()){
                            futures[i] = null;
                        }
                }
                 i++;
                }
                for (Capteur capteur : capteurs) {
                        capteur.updateValue() ;
                }
            
    }
}
