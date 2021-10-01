

package M3.services;

import java.util.concurrent.Future;

import M3.clients.Capteur;

public interface ObserverDeCapteurAsync {

    public Future update(Capteur c);
}
