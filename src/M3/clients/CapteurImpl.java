package M3.clients;

import java.util.Iterator;
import java.util.List;


import M3.proxy.Canal;
import M3.services.ObserverDeCapteurAsync;
import M3.strategy.AlgoDiffusion;

public class CapteurImpl implements Capteur {

    private Integer value;

    private AlgoDiffusion strategy;

    private List<Canal> canaux;

    public CapteurImpl(AlgoDiffusion algo){
        super();
        this.strategy = algo;
    }

    public void attach(Afficheur o){
        Canal newcanal = new Canal(this, o);
        canaux.add(newcanal);
    }

    public void detach(Afficheur o){
        Iterator<Canal> it = canaux.iterator();
        Canal toremove = null;
        while(it.hasNext()){
            Canal canal = it.next();
            if (canal.affiche == o){
                toremove = canal;
            }
        }
        canaux.remove(toremove);
    }

    public Integer getValue(ObserverDeCapteurAsync o){
        return value;
    }

    public void updateValue(){
        value++;
    }

    public void tick(){
        strategy.execute();
    }

    public List<Canal> getAllCanaux(){
        return canaux;
    }
}
