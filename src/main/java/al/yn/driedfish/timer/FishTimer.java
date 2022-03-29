package al.yn.driedfish.timer;

import cn.hutool.cron.CronUtil;

import java.util.ArrayList;
import java.util.List;

public class FishTimer {
    protected List<IDayChangeListener> dayChangeListeners = new ArrayList<>();

    public FishTimer() {
        CronUtil.setMatchSecond(true);
    }

    public void run() {
        CronUtil.start();

        listenDayChange();
    }

    private void listenDayChange() {
        CronUtil.schedule("0 0 * * *", (Runnable) () -> {
            dayChangeListeners.forEach(IDayChangeListener::onDayChanged);
        });
    }

    public void registerDayChangeListener(IDayChangeListener listener) {
        dayChangeListeners.add(listener);
    }

    public void unregisterDayChangeListener(IDayChangeListener listener) {
        dayChangeListeners.remove(listener);
    }

    public void clearDayChangeListeners() {
        dayChangeListeners.clear();
    }

    public void stop() {
        CronUtil.stop();
    }
}
