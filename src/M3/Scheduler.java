package M3;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Scheduler extends  ScheduledThreadPoolExecutor {

	List<Future> futures;
	
	public Scheduler() {
		super(Runtime.getRuntime().availableProcessors());
	}
	
	public Future<?> enqueue(Callable<?> methodInvocation) {
		return this.schedule(methodInvocation, getActiveCount(), null);
	}

}
