package M3.clients;

public interface Capteur{

    public void attach(Afficheur o);

    public void detach(Afficheur o);

    public Integer getValue();

    public void tick();
}
