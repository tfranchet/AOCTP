package M3.clients;

import M3.proxy.Canal;
import M3.services.CapteurAsync;

public interface ObserverDeCapteur {
	
	void update(Canal subject);
}
