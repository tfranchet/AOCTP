package M3.services;

import java.util.concurrent.Future;

public interface ObserverDeCapteurAsync {

	Future update(CapteurAsync subject);

}
