package M3;

import java.util.List;

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
