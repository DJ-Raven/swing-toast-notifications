package raven.toast.util;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ImageShadowCache extends LinkedHashMap<String, Image> {
    private static ImageShadowCache instance;
    private static final int capacity = 10;

    public static ImageShadowCache getInstance() {
        if (instance == null) {
            instance = new ImageShadowCache();
        }
        return instance;
    }

    private ImageShadowCache() {
        super(capacity);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Image> eldest) {
        boolean shouldRemove = size() > capacity;
        if (shouldRemove) {
            onRemoveEldestEntry(eldest);
        }
        return shouldRemove;
    }

    protected void onRemoveEldestEntry(Map.Entry<String, Image> eldest) {
        if (eldest.getValue() != null) {
            eldest.getValue().flush();
        }
    }
}
