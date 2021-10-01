package M3.strategy;

import java.util.ArrayList;
import java.util.List;

import M3.clients.CapteurImpl;
import M3.proxy.Canal;

public class DiffusionEpoque implements AlgoDiffusion{

    private List<Canal> canaux;

    private CapteurImpl capteur;

    public DiffusionEpoque(){
        canaux = new ArrayList<>();
        capteur = new CapteurImpl(this);
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
            canal.update(capteur);
        }
    }
}
