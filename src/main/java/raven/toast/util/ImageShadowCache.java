package raven.toast.util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImageShadowCache {
    private static ImageShadowCache instance;
    private Map<String, Image> cache;

    public static ImageShadowCache getInstance() {
        if (instance == null) {
            instance = new ImageShadowCache();
        }
        return instance;
    }

    private ImageShadowCache() {
        cache = new HashMap<>();
    }

    public void put(String key, Image image) {
        cache.put(key, image);
    }

    public Image get(String key) {
        System.out.println("cache image : " + cache.size());
        return cache.get(key);
    }
}
