package M3.MethodInvocations;

import java.util.List;

import M3.clients.ObserverDeCapteur;

public interface MethodInvocation {

    List<String> parameters = null;

    public Boolean gard();

    public void call(ObserverDeCapteur o);

    public void setParameters();

    public String getParameters();
}
