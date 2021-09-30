package M3;

public interface Capteur{

    public void attach(ObserveDeCapteur o);

    public void detach(ObserveDeCapteur o);

    public Integer getValue();

    public void tick();
}
