package al.yn.driedfish.timer;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FishTimer {
    private ScheduledThreadPoolExecutor pool =
            new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors());

    public FishTimer() {
        pool.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);  // Do not continue.

        pool.scheduleWithFixedDelay(() -> {

        }, 1L, 24 * 60 * 60L, TimeUnit.SECONDS);
    }

    public void run() {

    }

    public void stop() {
        pool.shutdown();
    }
}
