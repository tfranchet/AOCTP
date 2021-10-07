package M3.clients;

import M3.services.CapteurAsync;

public interface ObserverDeCapteur {
	
	void update(CapteurAsync subject);
}
