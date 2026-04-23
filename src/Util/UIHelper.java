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

    // Semantic tones for consistent green-first UI composition
    // App background requested: #2e7d32
    public static final Color APP_BACKGROUND = PRIMARY_GREEN;
    public static final Color SURFACE = new Color(248, 252, 248);
    public static final Color SURFACE_ALT = new Color(232, 245, 233);
    public static final Color BORDER_COLOR = new Color(165, 214, 167);
    public static final Color DISABLED_BG = new Color(220, 233, 221);
    public static final Color DISABLED_TEXT = new Color(120, 140, 122);
    public static final Color DANGER = new Color(229, 57, 53);
    public static final Color DANGER_HOVER = new Color(211, 47, 47);

    private static final Color OLD_BACKGROUND = new Color(122, 74, 74);
    private static final Color OLD_SURFACE = new Color(219, 189, 142);
    private static final Color OLD_SURFACE_HOVER = new Color(199, 159, 95);
    private static final Color OLD_DARK_SURFACE = new Color(106, 105, 105);
    private static final Color OLD_BUTTON = new Color(51, 51, 51);
    private static final Color OLD_DISABLED = new Color(211, 211, 211);
    private static final Color OLD_GREEN_TEXT = new Color(0, 102, 0);

    // Extra legacy colors found in generated forms/components
    private static final Color LEGACY_NEUTRAL_PANEL = new Color(240, 240, 240);
    private static final Color LEGACY_NEUTRAL_SOFT = new Color(245, 245, 245);
    private static final Color LEGACY_NEUTRAL_CARD = new Color(250, 250, 250);
    private static final Color LEGACY_SECTION_BG = new Color(217, 217, 217);
    private static final Color LEGACY_HEADER_ACCENT = new Color(168, 154, 143);
    private static final Color LEGACY_BEIGE_ALT = new Color(219, 195, 165);
    private static final Color LEGACY_BEIGE_LIGHT = new Color(239, 219, 203);
    private static final Color LEGACY_PRIMARY_RED = new Color(204, 0, 51);
    private static final Color LEGACY_MAGENTA = new Color(219, 19, 142);
    private static final Color LEGACY_BRIGHT_GREEN = new Color(2, 189, 1);
    private static final Color LEGACY_ACTION_ORANGE = new Color(255, 102, 0);
    private static final Color LEGACY_ACTION_BLUE = new Color(51, 102, 255);
    private static final Color LEGACY_BLACK = new Color(0, 0, 0);

    private static final Color LEGACY_TEXT_DARK_1 = new Color(50, 50, 50);
    private static final Color LEGACY_TEXT_DARK_2 = new Color(80, 80, 80);
    private static final Color LEGACY_TEXT_MEDIUM = new Color(100, 100, 100);
    private static final Color LEGACY_TEXT_DISABLED = new Color(150, 150, 150);
    private static final Color LEGACY_TEXT_BROWN = new Color(153, 102, 0);
    private static final Color LEGACY_TEXT_ORANGE_RED = new Color(255, 51, 0);
    private static final Color LEGACY_TEXT_BLUE = new Color(0, 102, 204);
    private static final Color LEGACY_TEXT_BLUE_DARK = new Color(51, 0, 255);
    private static final Color LEGACY_TEXT_YELLOW = new Color(255, 204, 0);
    private static final Color LEGACY_TEXT_SUCCESS = new Color(0, 153, 0);

    private static volatile boolean projectThemeInstalled = false;

    public static final Color DARK_TEXT = new Color(30, 57, 34); // Chữ đậm
    public static final Color LIGHT_TEXT = new Color(92, 118, 96); // Chữ nhạt
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

            installUiDefaults();

            Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
                if (event instanceof WindowEvent) {
                    WindowEvent windowEvent = (WindowEvent) event;
                    if (windowEvent.getID() == WindowEvent.WINDOW_OPENED) {
                        applyProjectTheme(windowEvent.getWindow());
                    }
                } else if (event instanceof ContainerEvent) {
                    ContainerEvent containerEvent = (ContainerEvent) event;
                    if (containerEvent.getID() == ContainerEvent.COMPONENT_ADDED) {
                        applyProjectTheme(containerEvent.getChild());
                    }
                }
            }, AWTEvent.WINDOW_EVENT_MASK | AWTEvent.CONTAINER_EVENT_MASK);

            projectThemeInstalled = true;
        }
    }

    private static void installUiDefaults() {
        UIManager.put("Panel.background", APP_BACKGROUND);
        UIManager.put("Label.foreground", DARK_TEXT);
        UIManager.put("Button.background", PRIMARY_GREEN);
        UIManager.put("Button.foreground", WHITE);
        UIManager.put("TextField.background", SURFACE);
        UIManager.put("TextField.foreground", DARK_TEXT);
        UIManager.put("PasswordField.background", SURFACE);
        UIManager.put("PasswordField.foreground", DARK_TEXT);
        UIManager.put("ComboBox.background", SURFACE);
        UIManager.put("ComboBox.foreground", DARK_TEXT);
        UIManager.put("Table.selectionBackground", ACCENT_GREEN);
        UIManager.put("Table.selectionForeground", WHITE);
    }

    public static void applyProjectTheme(Component root) {
        if (root == null) {
            return;
        }

        applyProjectThemeRecursive(root);
    }

    private static void applyProjectThemeRecursive(Component component) {
        remapThemeColors(component);

        if (component instanceof Container) {
            Container container = (Container) component;
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

        if (matches(color, WHITE)) {
            return SURFACE;
        }

        if (matches(color, OLD_BACKGROUND)) {
            return APP_BACKGROUND;
        }
        if (matches(color, OLD_SURFACE)) {
            return SURFACE_ALT;
        }
        if (matches(color, OLD_SURFACE_HOVER)) {
            return LIGHTER_GREEN;
        }
        if (matches(color, OLD_DARK_SURFACE)) {
            return PRIMARY_GREEN;
        }
        if (matches(color, OLD_BUTTON)) {
            return DARK_GREEN;
        }
        if (matches(color, OLD_DISABLED)) {
            return DISABLED_BG;
        }

        if (matches(color, LEGACY_NEUTRAL_PANEL) || matches(color, LEGACY_NEUTRAL_SOFT)
                || matches(color, LEGACY_NEUTRAL_CARD)) {
            return SURFACE;
        }
        if (matches(color, LEGACY_BEIGE_ALT) || matches(color, LEGACY_BEIGE_LIGHT)) {
            return SURFACE_ALT;
        }
        if (matches(color, LEGACY_SECTION_BG)) {
            return SURFACE_ALT;
        }
        if (matches(color, LEGACY_HEADER_ACCENT)) {
            return LIGHTER_GREEN;
        }
        if (matches(color, LEGACY_ACTION_ORANGE)) {
            return ACCENT_GREEN;
        }
        if (matches(color, LEGACY_ACTION_BLUE)) {
            return PRIMARY_GREEN;
        }
        if (matches(color, LEGACY_PRIMARY_RED)) {
            return PRIMARY_GREEN;
        }
        if (matches(color, LEGACY_MAGENTA) || matches(color, LEGACY_BRIGHT_GREEN)) {
            return ACCENT_GREEN;
        }
        if (matches(color, LEGACY_BLACK)) {
            return DARK_GREEN;
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
        if (matches(color, LEGACY_TEXT_DARK_1) || matches(color, LEGACY_TEXT_DARK_2)
                || matches(color, Color.BLACK)) {
            return DARK_TEXT;
        }
        if (matches(color, LEGACY_TEXT_MEDIUM) || matches(color, Color.GRAY)) {
            return LIGHT_TEXT;
        }
        if (matches(color, LEGACY_TEXT_DISABLED)) {
            return DISABLED_TEXT;
        }
        if (matches(color, LEGACY_TEXT_BLUE) || matches(color, LEGACY_TEXT_BLUE_DARK)
                || matches(color, LEGACY_TEXT_SUCCESS)) {
            return PRIMARY_GREEN;
        }
        if (matches(color, LEGACY_TEXT_YELLOW)) {
            return ACCENT_GREEN;
        }
        if (matches(color, LEGACY_TEXT_BROWN) || matches(color, LEGACY_TEXT_ORANGE_RED)) {
            return DARK_GREEN;
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
