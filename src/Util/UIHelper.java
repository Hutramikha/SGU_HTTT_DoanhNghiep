package Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

/**
 * Utility class for UI customizations and hover effects
 * Color scheme: Dark Green theme
 */
public class UIHelper {
    // Color palette - Dark Green theme
    public static final Color DARK_GREEN = new Color(27, 94, 32);
    public static final Color PRIMARY_GREEN = new Color(46, 125, 50);
    public static final Color LIGHT_GREEN = new Color(67, 160, 71);
    public static final Color LIGHTER_GREEN = new Color(129, 199, 132);
    public static final Color LIGHTEST_GREEN = new Color(232, 245, 233);
    public static final Color ACCENT_GREEN = new Color(102, 187, 106);

    private static final Color OLD_BACKGROUND = new Color(122, 74, 74);
    private static final Color OLD_SURFACE = new Color(219, 189, 142);
    private static final Color OLD_SURFACE_HOVER = new Color(199, 159, 95);
    private static final Color OLD_DARK_SURFACE = new Color(106, 105, 105);
    private static final Color OLD_BUTTON = new Color(51, 51, 51);
    private static final Color OLD_DISABLED = new Color(211, 211, 211);
    private static final Color OLD_GREEN_TEXT = new Color(0, 102, 0);

    private static volatile boolean projectThemeInstalled = false;

    public static final Color DARK_TEXT = new Color(33, 33, 33); // Chữ đậm
    public static final Color LIGHT_TEXT = new Color(117, 117, 117); // Chữ nhạt
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color LIGHT_GRAY = new Color(240, 240, 240);

    public static void installProjectTheme() {
        if (projectThemeInstalled) {
            return;
        }

        synchronized (UIHelper.class) {
            if (projectThemeInstalled) {
                return;
            }

            Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
                if (event instanceof WindowEvent windowEvent) {
                    if (windowEvent.getID() == WindowEvent.WINDOW_OPENED) {
                        applyProjectTheme(windowEvent.getWindow());
                    }
                } else if (event instanceof ContainerEvent containerEvent) {
                    if (containerEvent.getID() == ContainerEvent.COMPONENT_ADDED) {
                        applyProjectTheme(containerEvent.getChild());
                    }
                }
            }, AWTEvent.WINDOW_EVENT_MASK | AWTEvent.CONTAINER_EVENT_MASK);

            projectThemeInstalled = true;
        }
    }

    public static void applyProjectTheme(Component root) {
        if (root == null) {
            return;
        }

        applyProjectThemeRecursive(root);
    }

    private static void applyProjectThemeRecursive(Component component) {
        remapThemeColors(component);

        if (component instanceof Container container) {
            for (Component child : container.getComponents()) {
                applyProjectThemeRecursive(child);
            }
        }
    }

    private static void remapThemeColors(Component component) {
        Color background = component.getBackground();
        Color mappedBackground = remapBackground(background);
        if (mappedBackground != null && !mappedBackground.equals(background)) {
            component.setBackground(mappedBackground);
        }

        Color foreground = component.getForeground();
        Color mappedForeground = remapForeground(foreground);
        if (mappedForeground != null && !mappedForeground.equals(foreground)) {
            component.setForeground(mappedForeground);
        }
    }

    private static Color remapBackground(Color color) {
        if (color == null) {
            return null;
        }

        if (matches(color, OLD_BACKGROUND)) {
            return LIGHTEST_GREEN;
        }
        if (matches(color, OLD_SURFACE)) {
            return LIGHT_GREEN;
        }
        if (matches(color, OLD_SURFACE_HOVER)) {
            return ACCENT_GREEN;
        }
        if (matches(color, OLD_DARK_SURFACE)) {
            return PRIMARY_GREEN;
        }
        if (matches(color, OLD_BUTTON)) {
            return DARK_GREEN;
        }
        if (matches(color, OLD_DISABLED)) {
            return LIGHTER_GREEN;
        }

        return color;
    }

    private static Color remapForeground(Color color) {
        if (color == null) {
            return null;
        }

        if (matches(color, OLD_GREEN_TEXT)) {
            return PRIMARY_GREEN;
        }

        return color;
    }

    private static boolean matches(Color left, Color right) {
        return left != null && right != null && left.getRGB() == right.getRGB();
    }

    /**
     * Add hover effect to buttons/labels
     * - Changes background on hover
     * - Changes cursor to HAND_CURSOR
     * - Smooth transition effect
     */
    public static void addHoverEffect(AbstractButton button) {
        addHoverEffect(button, ACCENT_GREEN, WHITE);
    }

    public static void addHoverEffect(AbstractButton button, Color hoverColor, Color textColor) {
        Color originalBg = button.getBackground();
        Color originalFg = button.getForeground();

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
                button.setForeground(textColor);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalBg);
                button.setForeground(originalFg);
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    /**
     * Add hover effect to JLabel (used as button)
     */
    public static void addHoverEffectToLabel(JLabel label, Color normalBg, Color hoverBg) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setBackground(hoverBg);
                label.setOpaque(true);
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setBackground(normalBg);
                label.setOpaque(true);
                label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    /**
     * Add hover effect to JPanel (used as button)
     */
    public static void addHoverEffectToPanel(JPanel panel, Color normalBg, Color hoverBg) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(hoverBg);
                panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(normalBg);
                panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    /**
     * Style a button with green theme
     */
    public static void styleButton(AbstractButton button) {
        button.setBackground(PRIMARY_GREEN);
        button.setForeground(WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addHoverEffect(button, ACCENT_GREEN, WHITE);
    }

    /**
     * Style a panel as button-like with green theme
     */
    public static void stylePanelAsButton(JPanel panel) {
        panel.setBackground(PRIMARY_GREEN);
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addHoverEffectToPanel(panel, PRIMARY_GREEN, ACCENT_GREEN);
    }
}
