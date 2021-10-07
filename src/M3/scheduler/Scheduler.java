package M3.scheduler;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Scheduler extends  ScheduledThreadPoolExecutor {
	
	public Scheduler() {
		super(Runtime.getRuntime().availableProcessors());
	}	
	
	public Future<?> enqueue(Callable<?> methodInvocation) {
		return this.schedule(methodInvocation, ThreadLocalRandom.current().nextInt(200, 500 + 1)
		, TimeUnit.MILLISECONDS);
	}

}
