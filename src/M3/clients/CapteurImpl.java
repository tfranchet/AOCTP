package M3.clients;

import M3.strategy.AlgoDiffusion;

public class CapteurImpl implements Capteur {

    private Integer value;

    private AlgoDiffusion strategy;

    public void attach(ObserverDeCapteur o){
        
    }

    public void detach(ObserverDeCapteur o){
        
    }

    public Integer getValue(){
        return value;
    }

    public void tick(){
        strategy.execute();
    }
}
