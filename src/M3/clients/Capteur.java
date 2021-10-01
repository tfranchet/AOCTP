package M3.clients;

import M3.services.ObserverDeCapteurAsync;

public interface Capteur{

    public void attach(Afficheur o);

    public void detach(Afficheur o);

    public Integer getValue(ObserverDeCapteurAsync o);

    public void tick();
}
