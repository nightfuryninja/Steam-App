package android.support.v4.graphics;

import android.graphics.Color;

public final class ColorUtils {
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal();

    public static int compositeColors(int foreground, int background) {
        int bgAlpha = Color.alpha(background);
        int fgAlpha = Color.alpha(foreground);
        int a = compositeAlpha(fgAlpha, bgAlpha);
        return Color.argb(a, compositeComponent(Color.red(foreground), fgAlpha, Color.red(background), bgAlpha, a), compositeComponent(Color.green(foreground), fgAlpha, Color.green(background), bgAlpha, a), compositeComponent(Color.blue(foreground), fgAlpha, Color.blue(background), bgAlpha, a));
    }

    private static int compositeAlpha(int foregroundAlpha, int backgroundAlpha) {
        return 255 - (((255 - backgroundAlpha) * (255 - foregroundAlpha)) / 255);
    }

    private static int compositeComponent(int fgC, int fgA, int bgC, int bgA, int a) {
        if (a == 0) {
            return 0;
        }
        return (((fgC * 255) * fgA) + ((bgC * bgA) * (255 - fgA))) / (a * 255);
    }

    public static double calculateLuminance(int color) {
        double[] result = getTempDouble3Array();
        colorToXYZ(color, result);
        return result[1] / 100.0d;
    }

    public static double calculateContrast(int foreground, int background) {
        if (Color.alpha(background) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(background));
        }
        if (Color.alpha(foreground) < 255) {
            foreground = compositeColors(foreground, background);
        }
        double luminance1 = calculateLuminance(foreground) + 0.05d;
        double luminance2 = calculateLuminance(background) + 0.05d;
        return Math.max(luminance1, luminance2) / Math.min(luminance1, luminance2);
    }

    public static int setAlphaComponent(int color, int alpha) {
        if (alpha >= 0 && alpha <= 255) {
            return (16777215 & color) | (alpha << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static void colorToXYZ(int color, double[] outXyz) {
        RGBToXYZ(Color.red(color), Color.green(color), Color.blue(color), outXyz);
    }

    public static void RGBToXYZ(int r, int g, int b, double[] outXyz) {
        if (outXyz.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double sr = ((double) r) / 255.0d;
        sr = sr < 0.04045d ? sr / 12.92d : Math.pow((0.055d + sr) / 1.055d, 2.4d);
        double sg = ((double) g) / 255.0d;
        sg = sg < 0.04045d ? sg / 12.92d : Math.pow((0.055d + sg) / 1.055d, 2.4d);
        double sb = ((double) b) / 255.0d;
        sb = sb < 0.04045d ? sb / 12.92d : Math.pow((0.055d + sb) / 1.055d, 2.4d);
        outXyz[0] = 100.0d * (((0.4124d * sr) + (0.3576d * sg)) + (0.1805d * sb));
        outXyz[1] = 100.0d * (((0.2126d * sr) + (0.7152d * sg)) + (0.0722d * sb));
        outXyz[2] = 100.0d * (((0.0193d * sr) + (0.1192d * sg)) + (0.9505d * sb));
    }

    private static double[] getTempDouble3Array() {
        double[] result = (double[]) TEMP_ARRAY.get();
        if (result != null) {
            return result;
        }
        result = new double[3];
        TEMP_ARRAY.set(result);
        return result;
    }
}
