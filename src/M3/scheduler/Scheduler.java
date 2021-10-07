package M3.scheduler;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Scheduler extends  ScheduledThreadPoolExecutor {
	
	public Scheduler() {
		super(Runtime.getRuntime().availableProcessors());
	}
	
	public Future<?> enqueue(Callable<?> methodInvocation) {
		return this.schedule(methodInvocation, getActiveCount(), TimeUnit.MILLISECONDS);
	}

}
