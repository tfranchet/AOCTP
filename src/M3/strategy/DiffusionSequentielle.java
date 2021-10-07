package M3.strategy;

import java.util.List;
import java.util.concurrent.Future;

import M3.clients.CapteurImpl;
import M3.proxy.Canal;

public class DiffusionSequentielle implements AlgoDiffusion{

    private List<Canal> canaux;

    private List<CapteurImpl> capteurs;

    private Future[][] futures;

    public DiffusionSequentielle(List<Canal> canaux, List<CapteurImpl> capteurs){
        this.canaux = canaux;
        this.capteurs = capteurs;
    }

    public void configure(){

        futures= new Future[canaux.size()][capteurs.size()];
    }

    public void execute(){
        int i = 0;
        int j = 0;
        boolean canadd = true;
        for (Canal canal : canaux) {
            for (CapteurImpl capteur : capteurs) {
                if (!(futures[i][j] == null)){
                 futures[i][j] = canal.update(capteur);
                }
                if(futures[i][j] != null && !futures[i][j].isDone()){
                    canadd = false;
                }
                j++;
        }
         i++;
        }
        for (CapteurImpl capteur : capteurs) {
            capteur.updateValue();
            if(canadd) {
            futures = new Future[canaux.size()][capteurs.size()];
        }
    }
    }
}
