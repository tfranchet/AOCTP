package M3;

import java.util.List;

public interface MethodInvocation {

    List<String> parameters = null;

    public Boolean gard();

    public void callMI(ObserverDeCapteur o);

    public void setParameters();

    public String getParameters();
}
