package M3.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import M3.clients.CapteurImpl;
import M3.proxy.Canal;

public class DiffusionEpoque implements AlgoDiffusion{

    private List<Canal> canaux;

    private List<CapteurImpl> capteurs;

    private Future[] futures;

    public DiffusionEpoque(){
        canaux = new ArrayList<>();
        capteurs = new ArrayList<>();
        futures = new Future[capteurs.size()];
    }

    @Override
    public void configure() {
    }

    /**
     * Les afficheurs recoivent les éléments dans l'ordre croissant
     */
    @Override
    public void execute() {
        for (Canal canal : canaux) {
            for (CapteurImpl capt : capteurs) {
                canal.update(capt);
            }
        }
        for (CapteurImpl capt : capteurs) {
                capt.updateValue();
                futures = new Future[capteurs.size()];
        }
    }
}
