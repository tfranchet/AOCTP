package M3.strategy;

import java.util.List;

import M3.clients.CapteurImpl;
import M3.proxy.Canal;

public class DiffusionAtomique implements AlgoDiffusion{

    private List<Canal> canaux;

    private List<CapteurImpl> capteurs;

    public void configure(){

    }

    public void execute(){
        for (Canal canal : canaux) {
            for (CapteurImpl capteur : capteurs) {
                canal.update(capteur);
            }
        }
        
    }
}
