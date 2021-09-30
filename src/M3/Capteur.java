package M3;

public interface Capteur{

    public void attach(ObserverDeCapteur o);

    public void detach(ObserverDeCapteur o);

    public Integer getValue();

    public void tick();
}
