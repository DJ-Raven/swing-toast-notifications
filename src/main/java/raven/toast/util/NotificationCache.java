package raven.toast.util;

import raven.toast.Notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificationCache {
    private final List<Notifications.NotificationAnimation> cache;
    private final int cacheLimit = 10;

    public NotificationCache() {
        cache = new ArrayList<>();
    }

    public synchronized Notifications.NotificationAnimation get() {
        synchronized (cache) {
            if (cache.isEmpty()) {
                return null;
            }
            System.out.println("get cache : " + cache.size());
            Notifications.NotificationAnimation data = cache.get(0);
            cache.remove(data);
            return data;
        }
    }

    public synchronized void put(Notifications.NotificationAnimation notificationAnimation) {
        synchronized (cache) {
            cache.add(notificationAnimation);
        }
    }
}
