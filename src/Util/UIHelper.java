package Util;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.basic.BasicArrowButton;
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
    // Color palette - Elegant Sage Green theme (Softer, eye-friendly)
    public static final Color DARK_GREEN = new Color(43, 76, 56);
    public static final Color PRIMARY_GREEN = new Color(74, 112, 85);
    public static final Color LIGHT_GREEN = new Color(108, 145, 120);
    public static final Color LIGHTER_GREEN = new Color(160, 186, 168);
    public static final Color LIGHTEST_GREEN = new Color(236, 243, 238);
    public static final Color ACCENT_GREEN = new Color(127, 166, 140);
    public static final Color EMERALD = new Color(0, 0, 0);

    // Semantic tones for consistent green-first UI composition
    // App background requested: #2e7d32
    public static final Color APP_BACKGROUND = PRIMARY_GREEN;
    public static final Color SURFACE = new Color(251, 253, 251);
    public static final Color SURFACE_ALT = new Color(242, 247, 243);
    public static final Color BORDER_COLOR = new Color(120, 140, 125); // Màu viền đậm hơn
    public static final Color DISABLED_BG = new Color(225, 232, 227);
    public static final Color DISABLED_TEXT = new Color(145, 158, 148);
    public static final Color DANGER = new Color(210, 85, 80);
    public static final Color DANGER_HOVER = new Color(190, 70, 65);

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
    private static final String BUTTON_ELEVATED_KEY = "uihelper.button.elevated";
    private static final String BUTTON_BASE_COLOR_KEY = "uihelper.button.base.color";

    public static final Color DARK_TEXT = new Color(45, 65, 50); // Chữ đậm
    public static final Color LIGHT_TEXT = new Color(105, 125, 110); // Chữ nhạt
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
                        Window window = windowEvent.getWindow();
                        centerWindowOnScreen(window);
                        applyProjectTheme(window);
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
        UIManager.put("Panel.background", SURFACE);
        UIManager.put("OptionPane.background", SURFACE);
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
        if (component instanceof JComponent
                && Boolean.TRUE.equals(((JComponent) component).getClientProperty("uihelper.ignore"))) {
            return;
        }
        remapThemeColors(component);

        if (component instanceof JButton) {
            applySoftRaisedButtonStyle((JButton) component);
        }

        if (component instanceof Container) {
            Container container = (Container) component;
            for (Component child : container.getComponents()) {
                applyProjectThemeRecursive(child);
            }
        }
    }

    private static void centerWindowOnScreen(Window window) {
        if (window == null) {
            return;
        }

        if (window instanceof Frame) {
            Frame frame = (Frame) window;
            if ((frame.getExtendedState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                return;
            }
        }

        if (window.getWidth() <= 0 || window.getHeight() <= 0) {
            return;
        }

        window.setLocationRelativeTo(null);
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
            return BORDER_COLOR;
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
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (button instanceof JButton) {
            applySoftRaisedButtonStyle((JButton) button);
        } else {
            button.setBorderPainted(false);
            addHoverEffect(button, ACCENT_GREEN, WHITE);
        }
    }

    /**
     * Style a panel as button-like with green theme
     */
    public static void stylePanelAsButton(JPanel panel) {
        panel.setBackground(PRIMARY_GREEN);
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addHoverEffectToPanel(panel, PRIMARY_GREEN, ACCENT_GREEN);
    }

    private static void applySoftRaisedButtonStyle(JButton button) {
        if (button == null || !isApplicationButton(button)
                || Boolean.TRUE.equals(button.getClientProperty("uihelper.ignore"))) {
            return;
        }

        Color baseColor = normalizeButtonColor(button.getBackground());
        Color textColor = isDarkColor(baseColor) ? WHITE : DARK_TEXT;

        button.putClientProperty(BUTTON_BASE_COLOR_KEY, baseColor);
        button.setBackground(baseColor);
        button.setForeground(textColor);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(createSoftRaisedBorder(baseColor));

        if (Boolean.TRUE.equals(button.getClientProperty(BUTTON_ELEVATED_KEY))) {
            return;
        }

        button.putClientProperty(BUTTON_ELEVATED_KEY, Boolean.TRUE);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!button.isEnabled()) {
                    return;
                }
                updateButtonTone(button, 0.10f);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!button.isEnabled()) {
                    return;
                }
                updateButtonTone(button, 0f);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!button.isEnabled()) {
                    return;
                }
                updateButtonTone(button, -0.06f);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!button.isEnabled()) {
                    return;
                }
                if (button.contains(e.getPoint())) {
                    updateButtonTone(button, 0.10f);
                } else {
                    updateButtonTone(button, 0f);
                }
            }
        });
    }

    private static void updateButtonTone(JButton button, float ratio) {
        Object value = button.getClientProperty(BUTTON_BASE_COLOR_KEY);
        Color base = value instanceof Color ? (Color) value : normalizeButtonColor(button.getBackground());
        Color adjusted = ratio >= 0 ? lighten(base, ratio) : darken(base, -ratio);
        button.setBackground(adjusted);
        button.setBorder(createSoftRaisedBorder(adjusted));
    }

    private static boolean isApplicationButton(JButton button) {
        if (button instanceof BasicArrowButton) {
            return false;
        }

        String className = button.getClass().getName();
        return !className.startsWith("javax.swing.plaf.");
    }

    private static Color normalizeButtonColor(Color color) {
        if (color == null) {
            return PRIMARY_GREEN;
        }

        if (matches(color, DISABLED_BG) || !color.equals(remapBackground(color))) {
            return remapBackground(color);
        }

        return color;
    }

    private static Border createSoftRaisedBorder(Color base) {
        Color borderColor = darken(base, 0.40f);
        Border line = BorderFactory.createLineBorder(borderColor, 2);
        Border margin = BorderFactory.createEmptyBorder(6, 14, 6, 14);
        return BorderFactory.createCompoundBorder(line, margin);
    }

    private static Color lighten(Color color, float ratio) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        int nr = clamp(r + Math.round((255 - r) * ratio));
        int ng = clamp(g + Math.round((255 - g) * ratio));
        int nb = clamp(b + Math.round((255 - b) * ratio));
        return new Color(nr, ng, nb, color.getAlpha());
    }

    private static Color darken(Color color, float ratio) {
        int nr = clamp(Math.round(color.getRed() * (1f - ratio)));
        int ng = clamp(Math.round(color.getGreen() * (1f - ratio)));
        int nb = clamp(Math.round(color.getBlue() * (1f - ratio)));
        return new Color(nr, ng, nb, color.getAlpha());
    }

    private static int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }

    private static boolean isDarkColor(Color color) {
        double luma = 0.2126 * color.getRed() + 0.7152 * color.getGreen() + 0.0722 * color.getBlue();
        return luma < 150;
    }

    public static Icon getSearchIcon() {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(DARK_TEXT);
                g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.drawOval(x + 3, y + 3, 10, 10);
                g2.drawLine(x + 11, y + 11, x + 17, y + 17);
                g2.dispose();
            }

            @Override
            public int getIconWidth() {
                return 20;
            }

            @Override
            public int getIconHeight() {
                return 20;
            }
        };
    }
}
