package M3.strategy;

import java.util.List;
import java.util.concurrent.Future;

import M3.clients.CapteurImpl;
import M3.proxy.Canal;

public class DiffusionAtomique implements AlgoDiffusion{

    private List<Canal> canaux;

    private List<CapteurImpl> capteurs;

    public void configure(){

    }

    public void execute(){
        int[] vals= new int[capteurs.size()];
        int i = 0;
        for (Canal canal : canaux) {
            vals[i]= canal.affiche.valeurs.size();
            for (CapteurImpl capteur : capteurs) {
                if (vals[i]] == capteur.value){
                Future currentFuture = canal.update(capteur);
            }
        }
        i++;
        }
        
    }
}
