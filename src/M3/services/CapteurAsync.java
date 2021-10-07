package M3.services;

import java.util.concurrent.Future;

import M3.MethodInvocations.GetValue;

public interface CapteurAsync {

	Future<Integer> getValue();

}
