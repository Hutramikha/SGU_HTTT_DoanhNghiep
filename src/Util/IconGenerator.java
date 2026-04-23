package Util;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.InputStream;
import java.awt.RenderingHints;

/**
 * Generates beautiful coffee cup icons dynamically for the application
 */
public class IconGenerator {

    /**
     * Generate a premium coffee cup icon with gradient and details
     */
    public static ImageIcon generateCoffeeIcon(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Draw coffee cup with premium styling
        drawPremiumCoffeeCup(g2d, width, height);

        g2d.dispose();
        return new ImageIcon(image);
    }

    private static void drawPremiumCoffeeCup(Graphics2D g2d, int width, int height) {
        int centerX = width / 2;
        int centerY = height / 2;

        // Cup dimensions
        int cupWidth = (int) (width * 0.45);
        int cupHeight = (int) (height * 0.5);
        int cupX = centerX - cupWidth / 2;
        int cupY = centerY - cupHeight / 2;

        // Shadow
        g2d.setColor(new Color(0, 0, 0, 30));
        g2d.fillOval(cupX - 5, cupY + cupHeight + 10, cupWidth + 10, 8);

        // Cup gradient background
        GradientPaint cupGradient = new GradientPaint(
                cupX, cupY,
                new Color(175, 85, 25), // Lighter brown top
                cupX, cupY + cupHeight,
                new Color(120, 50, 15) // Darker brown bottom
        );
        g2d.setPaint(cupGradient);

        // Draw cup shape (rounded rectangle)
        RoundRectangle2D cupShape = new RoundRectangle2D.Double(cupX, cupY, cupWidth, cupHeight, 15, 15);
        g2d.fill(cupShape);

        // Cup outline - dark brown with stroke
        g2d.setColor(new Color(90, 40, 10));
        g2d.setStroke(new BasicStroke(2.5f));
        g2d.draw(cupShape);

        // Cup handle - with gradient
        int handleX = cupX + cupWidth + 5;
        int handleY = cupY + cupHeight / 4;
        int handleWidth = (int) (cupWidth * 0.3);
        int handleHeight = (int) (cupHeight * 0.4);

        Arc2D handle = new Arc2D.Double(handleX, handleY, handleWidth, handleHeight,
                0, 180, Arc2D.OPEN);

        g2d.setColor(new Color(100, 40, 10));
        g2d.setStroke(new BasicStroke(4));
        g2d.draw(handle);

        // Inner cup - coffee
        int coffeeInsetX = cupX + 5;
        int coffeeInsetY = cupY + 8;
        int coffeeWidth = cupWidth - 10;
        int coffeeHeight = cupHeight - 16;

        GradientPaint coffeeGradient = new GradientPaint(
                coffeeInsetX, coffeeInsetY,
                new Color(90, 45, 15), // Lighter coffee
                coffeeInsetX, coffeeInsetY + coffeeHeight,
                new Color(40, 20, 5) // Darker coffee
        );
        g2d.setPaint(coffeeGradient);

        RoundRectangle2D coffeeShape = new RoundRectangle2D.Double(
                coffeeInsetX, coffeeInsetY, coffeeWidth, coffeeHeight, 8, 8);
        g2d.fill(coffeeShape);

        // Coffee shine - top highlight
        g2d.setColor(new Color(255, 200, 140, 120));
        g2d.fillOval(cupX + cupWidth / 4, cupY + 8, cupWidth / 2, 12);

        // Steam - animated waves
        drawSteam(g2d, centerX, cupY - 5);

        // Top rim of cup
        g2d.setColor(new Color(160, 70, 15));
        g2d.fillRect(cupX, cupY - 3, cupWidth, 4);

        // Rim highlight
        g2d.setColor(new Color(200, 100, 30, 100));
        g2d.drawRect(cupX, cupY - 3, cupWidth, 4);
    }

    private static void drawSteam(Graphics2D g2d, int centerX, int startY) {
        g2d.setColor(new Color(200, 180, 150, 140));
        g2d.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Three steam waves
        for (int i = 0; i < 3; i++) {
            Path2D steam = new Path2D.Double();
            int steamX = centerX - 20 + (i * 20);
            steam.moveTo(steamX, startY);
            steam.quadTo(steamX - 5, startY - 10, steamX, startY - 20);
            steam.quadTo(steamX + 5, startY - 30, steamX, startY - 40);
            g2d.draw(steam);
        }

        // Steam wisps - light effect
        g2d.setColor(new Color(255, 240, 220, 80));
        for (int i = 0; i < 3; i++) {
            int steamX = centerX - 15 + (i * 15);
            g2d.drawOval(steamX - 4, startY - 15 - (i * 8), 8, 8);
        }
    }

    /**
     * Generate a leaf icon (green leaf for branding)
     */
    public static ImageIcon generateLeafIcon(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = width / 2;
        int centerY = height / 2;

        // Leaf shape - green with gradient
        GradientPaint leafGradient = new GradientPaint(
                centerX - width / 3, centerY,
                UIHelper.ACCENT_GREEN,
                centerX + width / 3, centerY,
                UIHelper.PRIMARY_GREEN);
        g2d.setPaint(leafGradient);

        Path2D leaf = new Path2D.Double();
        leaf.moveTo(centerX, centerY - height / 3);
        leaf.quadTo(centerX + width / 3, centerY, centerX, centerY + height / 3);
        leaf.quadTo(centerX - width / 3, centerY, centerX, centerY - height / 3);
        g2d.fill(leaf);

        // Leaf outline
        g2d.setColor(new Color(60, 120, 50));
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.draw(leaf);

        // Leaf vein
        g2d.setColor(new Color(80, 150, 70, 150));
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(centerX, centerY - height / 3, centerX, centerY + height / 3);

        // Veins on left and right
        for (int i = 1; i <= 4; i++) {
            int y = (int) (centerY - height / 3 + (i * height / 12));
            int x = (int) (centerX - (i * width / 15));
            g2d.drawLine(centerX, y, x, y);

            x = (int) (centerX + (i * width / 15));
            g2d.drawLine(centerX, y, x, y);
        }

        g2d.dispose();
        return new ImageIcon(image);
    }

    /**
     * Load logo image, scale it, and colorize with PRIMARY_GREEN color
     */
    public static ImageIcon loadAndColorizeLogoWithGreen(String imagePath) {
        return loadAndColorizeLogoWithGreen(imagePath, 200, 200); // Default size
    }

    /**
     * Load logo image, scale to specified size, and colorize with PRIMARY_GREEN
     * color
     */
    public static ImageIcon loadAndColorizeLogoWithGreen(String imagePath, int width, int height) {
        try {
            // Load image directly from resources using ImageIO
            InputStream imageStream = IconGenerator.class.getResourceAsStream(imagePath);
            BufferedImage originalImage = ImageIO.read(imageStream);

            if (originalImage == null) {
                return new javax.swing.ImageIcon(IconGenerator.class.getResource(imagePath));
            }

            // Scale image to specified size
            BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = scaledImage.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.drawImage(originalImage, 0, 0, width, height, null);
            g2d.dispose();

            // Create colorized version
            BufferedImage colorized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Get PRIMARY_GREEN color
            int greenRGB = UIHelper.PRIMARY_GREEN.getRGB();
            int greenRed = (greenRGB >> 16) & 0xFF;
            int greenGreen = (greenRGB >> 8) & 0xFF;
            int greenBlue = greenRGB & 0xFF;

            // Process each pixel
            for (int y = 0; y < scaledImage.getHeight(); y++) {
                for (int x = 0; x < scaledImage.getWidth(); x++) {
                    int argb = scaledImage.getRGB(x, y);
                    int alpha = (argb >> 24) & 0xFF;

                    if (alpha > 10) { // Only colorize pixels with visible alpha
                        // Convert to grayscale to preserve brightness
                        int r = (argb >> 16) & 0xFF;
                        int g = (argb >> 8) & 0xFF;
                        int b = argb & 0xFF;

                        // Get brightness (luminance)
                        double brightness = (0.299 * r + 0.587 * g + 0.114 * b) / 255.0;

                        // Apply green color with original brightness
                        int newR = Math.min(255, (int) (greenRed * brightness));
                        int newG = Math.min(255, (int) (greenGreen * brightness));
                        int newB = Math.min(255, (int) (greenBlue * brightness));

                        int newARGB = (alpha << 24) | (newR << 16) | (newG << 8) | newB;
                        colorized.setRGB(x, y, newARGB);
                    } else {
                        // Keep transparent pixels completely transparent
                        colorized.setRGB(x, y, 0x00000000);
                    }
                }
            }

            return new ImageIcon(colorized);
        } catch (Exception e) {
            // If colorization fails, return original
            try {
                return new javax.swing.ImageIcon(IconGenerator.class.getResource(imagePath));
            } catch (Exception ex) {
                return null;
            }
        }
    }

    /**
     * Generate app logo icon for "Cà phê Xanh" branding.
     */
    public static ImageIcon generateGreenCoffeeLogoIcon(int width, int height) {
        return loadLogoQuanIcon("/IMAGE/logo2.png", width, height, true);
    }

    /**
     * Draw premium steam with coffee aesthetic
     */
    private static void drawPremiumCoffeeSteam(Graphics2D g2d, int centerX, int startY, int maxWidth) {
        g2d.setColor(new Color(150, 120, 80, 130));
        g2d.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Three elegant steam curves
        for (int i = 0; i < 3; i++) {
            Path2D steam = new Path2D.Double();
            int steamX = centerX - 18 + (i * 18);
            steam.moveTo(steamX, startY);
            steam.quadTo(steamX - 5, startY - 9, steamX, startY - 16);
            steam.quadTo(steamX + 5, startY - 23, steamX, startY - 30);
            g2d.draw(steam);
        }

        // Steam glow - greenish tint for brand
        g2d.setColor(new Color(100, 160, 100, 70));
        for (int i = 0; i < 3; i++) {
            int steamX = centerX - 15 + (i * 15);
            g2d.drawOval(steamX - 3, startY - 13 - (i * 6), 7, 7);
        }
    }

    /**
     * Generate login logo icon.
     */
    public static ImageIcon generateCoffeeIconWithHandle(int width, int height) {
        return loadLogoQuanIcon("/IMAGE/logo2.png", width, height, false);
    }

    private static ImageIcon loadLogoQuanIcon(String imagePath, int width, int height, boolean circleBadge) {
        try (InputStream imageStream = IconGenerator.class.getResourceAsStream(imagePath)) {
            if (imageStream == null) {
                return createFallbackCoffeeLogo(width, height, circleBadge);
            }

            BufferedImage originalImage = ImageIO.read(imageStream);
            if (originalImage == null) {
                return createFallbackCoffeeLogo(width, height, circleBadge);
            }

            boolean sourceHasAlpha = originalImage.getColorModel().hasAlpha();
            BufferedImage preparedImage = sourceHasAlpha ? removeUniformBackgroundByCorners(originalImage)
                    : originalImage;
            Rectangle cropBounds = sourceHasAlpha
                    ? findOpaqueBounds(preparedImage)
                    : new Rectangle(0, 0, originalImage.getWidth(), originalImage.getHeight());
            if (cropBounds.width <= 0 || cropBounds.height <= 0) {
                preparedImage = originalImage;
                cropBounds = findLogoBounds(originalImage);
            }

            BufferedImage croppedImage = preparedImage.getSubimage(
                    cropBounds.x,
                    cropBounds.y,
                    cropBounds.width,
                    cropBounds.height);

            float logoFillRatio = sourceHasAlpha ? 0.94f : 0.96f;
            int logoTargetWidth = Math.max(1, Math.round(width * logoFillRatio));
            int logoTargetHeight = Math.max(1, Math.round(height * logoFillRatio));
            float scale = Math.min(
                    (float) logoTargetWidth / croppedImage.getWidth(),
                    (float) logoTargetHeight / croppedImage.getHeight());
            // Never upscale logos to avoid blur artifacts.
            scale = Math.min(scale, 1.0f);

            int scaledWidth = Math.max(1, Math.round(croppedImage.getWidth() * scale));
            int scaledHeight = Math.max(1, Math.round(croppedImage.getHeight() * scale));
            BufferedImage scaledLogo = scaleImage(croppedImage, scaledWidth, scaledHeight);

            if (!sourceHasAlpha) {
                float shrinkX = croppedImage.getWidth() / (float) scaledWidth;
                float shrinkY = croppedImage.getHeight() / (float) scaledHeight;
                float shrinkFactor = Math.max(shrinkX, shrinkY);
                if (shrinkFactor >= 6f) {
                    scaledLogo = applySubtleSmoothing(scaledLogo);
                }
            }

            if (sourceHasAlpha && preparedImage == originalImage) {
                softenWhiteBackground(scaledLogo);
            }

            BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = canvas.createGraphics();
            applyHighQualityHints(g2d);

            // Keep opaque brand logos intact instead of drawing a synthetic badge behind
            // them.
            if (sourceHasAlpha) {
                drawGreenLogoBadge(g2d, width, height, circleBadge);
            }

            int drawX = (width - scaledWidth) / 2;
            int drawY = (height - scaledHeight) / 2;
            g2d.drawImage(scaledLogo, drawX, drawY, null);
            g2d.dispose();
            return new ImageIcon(canvas);
        } catch (Exception ex) {
            ex.printStackTrace();
            return createFallbackCoffeeLogo(width, height, circleBadge);
        }
    }

    private static BufferedImage removeUniformBackgroundByCorners(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        if (width <= 2 || height <= 2) {
            return image;
        }

        Color bg = estimateCornerBackground(image);
        BufferedImage cleaned = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        int foregroundCount = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = image.getRGB(x, y);
                int alpha = (argb >>> 24) & 0xFF;

                if (alpha < 10) {
                    cleaned.setRGB(x, y, 0x00000000);
                    continue;
                }

                if (isNearColor(argb, bg, 38)) {
                    cleaned.setRGB(x, y, 0x00000000);
                } else {
                    cleaned.setRGB(x, y, argb);
                    foregroundCount++;
                }
            }
        }

        int minForegroundPixels = Math.max(32, (width * height) / 500);
        if (foregroundCount < minForegroundPixels) {
            return image;
        }
        return cleaned;
    }

    private static Color estimateCornerBackground(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        int[] samples = new int[] {
                image.getRGB(0, 0),
                image.getRGB(width - 1, 0),
                image.getRGB(0, height - 1),
                image.getRGB(width - 1, height - 1),
                image.getRGB(width / 2, 0),
                image.getRGB(width / 2, height - 1)
        };

        int sumR = 0;
        int sumG = 0;
        int sumB = 0;
        int count = 0;

        for (int argb : samples) {
            int alpha = (argb >>> 24) & 0xFF;
            if (alpha < 10) {
                continue;
            }
            sumR += (argb >>> 16) & 0xFF;
            sumG += (argb >>> 8) & 0xFF;
            sumB += argb & 0xFF;
            count++;
        }

        if (count == 0) {
            return UIHelper.PRIMARY_GREEN;
        }

        return new Color(sumR / count, sumG / count, sumB / count);
    }

    private static boolean isNearColor(int argb, Color target, int tolerancePerChannel) {
        int red = (argb >>> 16) & 0xFF;
        int green = (argb >>> 8) & 0xFF;
        int blue = argb & 0xFF;

        return Math.abs(red - target.getRed()) <= tolerancePerChannel
                && Math.abs(green - target.getGreen()) <= tolerancePerChannel
                && Math.abs(blue - target.getBlue()) <= tolerancePerChannel;
    }

    private static Rectangle findOpaqueBounds(BufferedImage image) {
        int minX = image.getWidth();
        int minY = image.getHeight();
        int maxX = -1;
        int maxY = -1;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int alpha = (image.getRGB(x, y) >>> 24) & 0xFF;
                if (alpha > 10) {
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        if (maxX < minX || maxY < minY) {
            return new Rectangle(0, 0, 0, 0);
        }

        int padX = Math.max(4, (int) (image.getWidth() * 0.015f));
        int padY = Math.max(4, (int) (image.getHeight() * 0.015f));
        minX = Math.max(0, minX - padX);
        minY = Math.max(0, minY - padY);
        maxX = Math.min(image.getWidth() - 1, maxX + padX);
        maxY = Math.min(image.getHeight() - 1, maxY + padY);

        return new Rectangle(minX, minY, maxX - minX + 1, maxY - minY + 1);
    }

    private static Rectangle findForegroundBoundsByBackground(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Color bg = estimateCornerBackground(image);

        int minX = width;
        int minY = height;
        int maxX = -1;
        int maxY = -1;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = image.getRGB(x, y);
                if (!isNearColor(argb, bg, 26)) {
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        if (maxX < minX || maxY < minY) {
            return new Rectangle(0, 0, width, height);
        }

        int padX = Math.max(4, (int) (width * 0.02f));
        int padY = Math.max(4, (int) (height * 0.02f));
        minX = Math.max(0, minX - padX);
        minY = Math.max(0, minY - padY);
        maxX = Math.min(width - 1, maxX + padX);
        maxY = Math.min(height - 1, maxY + padY);
        return new Rectangle(minX, minY, maxX - minX + 1, maxY - minY + 1);
    }

    private static void drawGreenLogoBadge(Graphics2D g2d, int width, int height, boolean circleBadge) {
        float inset = Math.max(2f, Math.min(width, height) * 0.04f);
        float badgeWidth = width - inset * 2f;
        float badgeHeight = height - inset * 2f;

        Shape badgeShape = circleBadge
                ? new Ellipse2D.Float(inset, inset, badgeWidth, badgeHeight)
                : new RoundRectangle2D.Float(inset, inset, badgeWidth, badgeHeight, width * 0.26f, height * 0.26f);

        GradientPaint badgeGradient = new GradientPaint(
                width / 2f, inset,
                new Color(156, 214, 164),
                width / 2f, inset + badgeHeight,
                new Color(82, 162, 94));
        g2d.setPaint(badgeGradient);
        g2d.fill(badgeShape);

        g2d.setColor(new Color(255, 255, 255, 26));
        g2d.setStroke(new BasicStroke(Math.max(1.0f, Math.min(width, height) * 0.013f)));
        if (badgeShape instanceof Ellipse2D) {
            g2d.draw(new Ellipse2D.Float(inset + 0.7f, inset + 0.7f, badgeWidth - 1.4f, badgeHeight - 1.4f));
        } else {
            g2d.draw(new RoundRectangle2D.Float(inset + 0.7f, inset + 0.7f, badgeWidth - 1.4f, badgeHeight - 1.4f,
                    width * 0.24f, height * 0.24f));
        }
    }

    private static Rectangle findLogoBounds(BufferedImage image) {
        int minX = image.getWidth();
        int minY = image.getHeight();
        int maxX = -1;
        int maxY = -1;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (!isNearWhite(image.getRGB(x, y))) {
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        if (maxX < minX || maxY < minY) {
            return new Rectangle(0, 0, image.getWidth(), image.getHeight());
        }

        int padX = Math.max(6, (int) (image.getWidth() * 0.03f));
        int padY = Math.max(6, (int) (image.getHeight() * 0.03f));
        minX = Math.max(0, minX - padX);
        minY = Math.max(0, minY - padY);
        maxX = Math.min(image.getWidth() - 1, maxX + padX);
        maxY = Math.min(image.getHeight() - 1, maxY + padY);

        return new Rectangle(minX, minY, maxX - minX + 1, maxY - minY + 1);
    }

    private static boolean isNearWhite(int argb) {
        int alpha = (argb >>> 24) & 0xFF;
        if (alpha < 10) {
            return true;
        }
        int red = (argb >>> 16) & 0xFF;
        int green = (argb >>> 8) & 0xFF;
        int blue = argb & 0xFF;
        return red > 245 && green > 245 && blue > 245;
    }

    private static void softenWhiteBackground(BufferedImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int argb = image.getRGB(x, y);
                int alpha = (argb >>> 24) & 0xFF;
                if (alpha == 0) {
                    continue;
                }

                int red = (argb >>> 16) & 0xFF;
                int green = (argb >>> 8) & 0xFF;
                int blue = argb & 0xFF;

                int brightness = (int) (0.299 * red + 0.587 * green + 0.114 * blue);

                int max = Math.max(red, Math.max(green, blue));
                int min = Math.min(red, Math.min(green, blue));
                int saturation = max == 0 ? 0 : (int) (((max - min) / (float) max) * 255f);

                // Remove only true white / near-white background pixels.
                // Keep anti-aliased brown edge pixels by requiring low saturation
                // before making a pixel transparent.
                if (brightness >= 248 && saturation <= 28) {
                    image.setRGB(x, y, 0x00000000);
                } else if (brightness >= 232 && saturation <= 22) {
                    float factor = (248 - brightness) / 16f;
                    int newAlpha = Math.max(0, Math.min(255, Math.round(alpha * factor)));
                    image.setRGB(x, y, (newAlpha << 24) | (red << 16) | (green << 8) | blue);
                }
            }
        }
    }

    private static ImageIcon createFallbackCoffeeLogo(int width, int height, boolean badgeStyle) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        applyHighQualityHints(g2d);
        drawBrandCoffeeMark(g2d, width, height, badgeStyle);
        g2d.dispose();
        return new ImageIcon(image);
    }

    private static BufferedImage scaleImage(BufferedImage source, int targetWidth, int targetHeight) {
        if (targetWidth <= 0 || targetHeight <= 0) {
            return source;
        }

        BufferedImage current = source;
        int currentW = source.getWidth();
        int currentH = source.getHeight();

        // Progressive downscaling keeps edges smoother than a single massive resize.
        while (currentW / 2 >= targetWidth && currentH / 2 >= targetHeight) {
            currentW = Math.max(targetWidth, currentW / 2);
            currentH = Math.max(targetHeight, currentH / 2);
            BufferedImage step = new BufferedImage(currentW, currentH, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = step.createGraphics();
            applyHighQualityHints(g2d);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(current, 0, 0, currentW, currentH, null);
            g2d.dispose();
            current = step;
        }

        if (current.getWidth() == targetWidth && current.getHeight() == targetHeight) {
            return current;
        }

        BufferedImage scaled = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaled.createGraphics();
        applyHighQualityHints(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(current, 0, 0, targetWidth, targetHeight, null);
        g2d.dispose();
        return scaled;
    }

    private static BufferedImage applySubtleSmoothing(BufferedImage image) {
        float[] kernelData = {
                1f / 20f, 2f / 20f, 1f / 20f,
                2f / 20f, 8f / 20f, 2f / 20f,
                1f / 20f, 2f / 20f, 1f / 20f
        };

        Kernel kernel = new Kernel(3, 3, kernelData);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        op.filter(image, output);
        return output;
    }

    private static void applyHighQualityHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

    /**
     * Draw a modern brand mark: optional green badge + premium coffee cup + steam.
     */
    private static void drawBrandCoffeeMark(Graphics2D g2d, int width, int height, boolean badgeStyle) {
        float size = Math.min(width, height);
        float cx = width / 2f;
        float cy = height / 2f;

        if (badgeStyle) {
            // Badge shadow
            g2d.setColor(new Color(0, 0, 0, 32));
            g2d.fill(new Ellipse2D.Float(cx - size * 0.37f, cy - size * 0.30f, size * 0.74f, size * 0.74f));

            // Green radial badge
            RadialGradientPaint badgeGradient = new RadialGradientPaint(
                    new Point2D.Float(cx, cy),
                    size * 0.36f,
                    new float[] { 0f, 0.70f, 1f },
                    new Color[] { new Color(102, 182, 114), new Color(56, 130, 74), new Color(32, 90, 50) });
            g2d.setPaint(badgeGradient);
            g2d.fill(new Ellipse2D.Float(cx - size * 0.36f, cy - size * 0.29f, size * 0.72f, size * 0.72f));

            // Inner cream plate
            g2d.setColor(new Color(248, 243, 228));
            g2d.fill(new Ellipse2D.Float(cx - size * 0.29f, cy - size * 0.22f, size * 0.58f, size * 0.58f));
        }

        // Cup placement (larger so the icon reads clearly as a coffee cup)
        float cupW = size * (badgeStyle ? 0.48f : 0.62f);
        float cupH = size * (badgeStyle ? 0.34f : 0.43f);
        float cupX = cx - cupW / 2f;
        float cupY = cy - cupH * 0.35f;

        // Saucer shadow
        g2d.setColor(new Color(0, 0, 0, 28));
        g2d.fill(new Ellipse2D.Float(cx - cupW * 0.72f, cupY + cupH * 0.98f, cupW * 1.44f, cupH * 0.28f));

        // Saucer
        g2d.setColor(new Color(236, 230, 216));
        g2d.fill(new Ellipse2D.Float(cx - cupW * 0.66f, cupY + cupH * 0.92f, cupW * 1.32f, cupH * 0.24f));

        // Cup body gradient
        GradientPaint cupGradient = new GradientPaint(
                cupX, cupY,
                new Color(205, 128, 65),
                cupX, cupY + cupH,
                new Color(122, 63, 28));
        g2d.setPaint(cupGradient);
        RoundRectangle2D cup = new RoundRectangle2D.Float(cupX, cupY, cupW, cupH, size * 0.11f, size * 0.11f);
        g2d.fill(cup);

        // Cup border
        g2d.setColor(new Color(72, 38, 18));
        g2d.setStroke(new BasicStroke(Math.max(1.7f, size * 0.022f)));
        g2d.draw(cup);

        // Top rim band to make cup shape obvious
        g2d.setColor(new Color(228, 186, 144, 200));
        g2d.fill(new RoundRectangle2D.Float(
                cupX + cupW * 0.03f,
                cupY + cupH * 0.02f,
                cupW * 0.94f,
                cupH * 0.10f,
                size * 0.08f,
                size * 0.08f));

        // Cup handle
        Arc2D handle = new Arc2D.Float(
                cupX + cupW * 0.86f,
                cupY + cupH * 0.18f,
                cupW * 0.44f,
                cupH * 0.58f,
                -25, 230, Arc2D.OPEN);
        g2d.setColor(UIHelper.PRIMARY_GREEN);
        g2d.setStroke(new BasicStroke(Math.max(2.2f, size * 0.030f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(handle);

        // Inner handle line for depth
        Arc2D innerHandle = new Arc2D.Float(
                cupX + cupW * 0.92f,
                cupY + cupH * 0.24f,
                cupW * 0.30f,
                cupH * 0.44f,
                -18, 210, Arc2D.OPEN);
        g2d.setColor(new Color(40, 120, 55, 170));
        g2d.setStroke(new BasicStroke(Math.max(1.1f, size * 0.015f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(innerHandle);

        // Coffee surface
        g2d.setColor(new Color(74, 38, 17));
        g2d.fill(new Ellipse2D.Float(
                cupX + cupW * 0.12f,
                cupY + cupH * 0.12f,
                cupW * 0.76f,
                cupH * 0.20f));

        // Inner coffee body
        g2d.setColor(new Color(60, 30, 14, 140));
        g2d.fill(new RoundRectangle2D.Float(
                cupX + cupW * 0.08f,
                cupY + cupH * 0.18f,
                cupW * 0.84f,
                cupH * 0.50f,
                size * 0.05f,
                size * 0.05f));

        // Latte art leaf
        g2d.setColor(new Color(234, 194, 138, 170));
        Path2D leaf = new Path2D.Float();
        leaf.moveTo(cx, cupY + cupH * 0.28f);
        leaf.quadTo(cx + cupW * 0.11f, cupY + cupH * 0.20f, cx, cupY + cupH * 0.16f);
        leaf.quadTo(cx - cupW * 0.11f, cupY + cupH * 0.20f, cx, cupY + cupH * 0.28f);
        g2d.fill(leaf);

        // Rim highlight
        g2d.setColor(new Color(255, 233, 205, 145));
        g2d.setStroke(new BasicStroke(Math.max(1.1f, size * 0.013f)));
        g2d.draw(new Line2D.Float(cupX + cupW * 0.14f, cupY + cupH * 0.10f, cupX + cupW * 0.86f, cupY + cupH * 0.10f));

        // Steam
        g2d.setColor(new Color(120, 150, 124, 160));
        g2d.setStroke(new BasicStroke(Math.max(1.4f, size * 0.018f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for (int i = 0; i < 3; i++) {
            float sx = cx - cupW * 0.20f + i * (cupW * 0.20f);
            Path2D steam = new Path2D.Float();
            steam.moveTo(sx, cupY - cupH * 0.03f);
            steam.curveTo(sx - cupW * 0.05f, cupY - cupH * 0.22f,
                    sx + cupW * 0.04f, cupY - cupH * 0.34f,
                    sx, cupY - cupH * 0.55f);
            g2d.draw(steam);
        }

        // Tiny accent leaf near handle
        g2d.setColor(new Color(84, 162, 93, 190));
        Path2D accentLeaf = new Path2D.Float();
        float lx = cupX + cupW * 1.13f;
        float ly = cupY + cupH * 0.42f;
        accentLeaf.moveTo(lx, ly);
        accentLeaf.quadTo(lx + cupW * 0.08f, ly - cupH * 0.06f, lx + cupW * 0.03f, ly + cupH * 0.09f);
        accentLeaf.quadTo(lx - cupW * 0.06f, ly + cupH * 0.04f, lx, ly);
        g2d.fill(accentLeaf);
    }

    /**
     * Draw decorative steam for login page icon
     */
    private static void drawLoginPageSteam(Graphics2D g2d, int centerX, int startY) {
        g2d.setColor(new Color(180, 140, 100, 120));
        g2d.setStroke(new BasicStroke(1.8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Two gentle steam wisps
        for (int i = 0; i < 2; i++) {
            Path2D steam = new Path2D.Double();
            int steamX = centerX - 10 + (i * 20);
            steam.moveTo(steamX, startY);
            steam.quadTo(steamX - 4, startY - 7, steamX, startY - 12);
            steam.quadTo(steamX + 4, startY - 17, steamX, startY - 22);
            g2d.draw(steam);
        }

        // Subtle steam glow
        g2d.setColor(new Color(100, 150, 100, 60));
        for (int i = 0; i < 2; i++) {
            int steamX = centerX - 8 + (i * 16);
            g2d.drawOval(steamX - 2, startY - 10 - (i * 4), 5, 5);
        }
    }

}
