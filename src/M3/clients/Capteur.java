package M3.clients;

import M3.services.ObserverDeCapteurAsync;
import M3.strategy.AlgoDiffusion;

public interface Capteur{

    public void attach(Afficheur o);

    public void detach(Afficheur o);

    public Integer getValue();

    public void tick();

	public void setStrategy(AlgoDiffusion algo);
}
