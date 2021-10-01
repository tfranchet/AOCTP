package M3.clients;

public interface Capteur{

    public void attach(ObserverDeCapteur o);

    public void detach(ObserverDeCapteur o);

    public Integer getValue();

    public void tick();
}
