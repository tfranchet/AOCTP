package M3.clients;

import java.util.List;

import M3.proxy.Canal;
import M3.scheduler.Scheduler;
import M3.strategy.AlgoDiffusion;

public interface Capteur{

    public void attach(Afficheur o, Scheduler schedule);

    public void detach(Afficheur o);

    public Integer getValue();

    public void tick();

	public void setStrategy(AlgoDiffusion algo);

    public void updateValue();

    public List<Canal> getAllCanaux();
}
