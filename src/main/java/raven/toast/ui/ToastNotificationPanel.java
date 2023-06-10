package raven.toast.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import raven.toast.Notifications;
import raven.toast.ToastClientProperties;

import javax.swing.*;
import java.awt.*;

public class ToastNotificationPanel extends JPanel {

    protected JWindow window;
    protected JLabel labelIcon;
    protected JTextArea textArea;

    private Notifications.Type type;

    public ToastNotificationPanel() {
        installDefault();
    }

    private void installPropertyStyle() {
        String key = getKey();
        String outlineColor = toTextColor(getDefaultOutlineColor());
        String outline = convertsKey(key, "outlineColor", outlineColor);
        putClientProperty(FlatClientProperties.STYLE, "" +
                "background:" + convertsKey(key, "background", "@background") + ";" +
                "outlineColor:" + outline + ";" +
                "effectColor:" + convertsKey(key, "effectColor", outline));
    }

    private String convertsKey(String key, String value, String defaultValue) {
        return "if($Toast." + key + "." + value + ", $Toast." + key + "." + value + ", if($Toast." + value + ", $Toast." + value + ", " + defaultValue + "))";
    }

    @Override
    public void updateUI() {
        setUI(new ToastPanelUI());
        removeDialogBackground();
    }

    private void removeDialogBackground() {
        if (window != null) {
            Color bg = getBackground();
            window.setBackground(new Color(bg.getRed(), bg.getGreen(), bg.getBlue(), 0));
            window.setSize(getPreferredSize());
        }
    }

    private void installDefault() {
        labelIcon = new JLabel();
        textArea = new JTextArea("Hello my name\nRaven");
        textArea.setOpaque(false);
        textArea.setWrapStyleWord(true);
        textArea.setFocusable(false);
        textArea.setCursor(Cursor.getDefaultCursor());
        putClientProperty(ToastClientProperties.TOAST_ICON, labelIcon);
        putClientProperty(ToastClientProperties.TOAST_COMPONENT, textArea);
    }

    public void set(Notifications.Type type, String message) {
        this.type = type;
        labelIcon.setIcon(getIcon());
        textArea.setText(message);
        installPropertyStyle();
    }

    public void setDialog(JWindow window) {
        this.window = window;
        removeDialogBackground();
    }

    private Color getDefaultOutlineColor() {
        if (type == Notifications.Type.SUCCESS) {
            return Color.decode("#2e7d32");
        } else if (type == Notifications.Type.INFO) {
            return Color.decode("#0288d1");
        } else if (type == Notifications.Type.WARNING) {
            return Color.decode("#ed6c02");
        } else {
            return Color.decode("#d32f2f");
        }
    }

    private String toTextColor(Color color) {
        return "rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
    }

    private Color getOutlineColor(String key) {
        Color color = UIManager.getColor("Toast." + key + ".outlineColor");
        if (color != null) {
            return color;
        }
        return getDefaultOutlineColor();
    }

    private Icon getIcon() {
        String key = getKey();
        Icon icon = UIManager.getIcon("Toast." + key + ".icon");
        if (icon != null) {
            return icon;
        }
        FlatSVGIcon svgIcon = new FlatSVGIcon("raven/toast/svg/" + key + ".svg");
        FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter();
        colorFilter.add(new Color(150, 150, 150), getDefaultOutlineColor());
        svgIcon.setColorFilter(colorFilter);
        return svgIcon;
    }

    private String getKey() {
        if (type == Notifications.Type.SUCCESS) {
            return "success";
        } else if (type == Notifications.Type.INFO) {
            return "info";
        } else if (type == Notifications.Type.WARNING) {
            return "warning";
        } else {
            return "error";
        }
    }
}
