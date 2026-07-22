package org.mapsforge.map.rendertheme;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.ResourceBitmap;
import org.mapsforge.core.model.Tag;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /root/release/classes2.dex */
public final class XmlUtils {
    private static final Logger LOGGER = Logger.getLogger(XmlUtils.class.getName());
    private static final String PREFIX_ASSETS = "assets:";
    private static final String PREFIX_FILE = "file:";
    private static final String PREFIX_JAR = "jar:";
    private static final String PREFIX_JAR_V1 = "jar:/org/mapsforge/android/maps/rendertheme";
    private static final String UNSUPPORTED_COLOR_FORMAT = "unsupported color format: ";

    private XmlUtils() {
        throw new IllegalStateException();
    }

    private static void checkForNegativeValue(String str, float f3) {
        if (f3 >= BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        throw new XmlPullParserException("Attribute '" + str + "' must not be negative: " + f3);
    }

    public static void checkMandatoryAttribute(String str, String str2, Object obj) {
        if (obj != null) {
            return;
        }
        throw new XmlPullParserException("missing attribute '" + str2 + "' for element: " + str);
    }

    public static ResourceBitmap createBitmap(GraphicFactory graphicFactory, DisplayModel displayModel, String str, String str2, int i3, int i4, int i5) {
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        InputStream createInputStream = createInputStream(graphicFactory, str, str2);
        try {
            int hashCode = (getAbsoluteName(str, str2) + i3 + i4 + i5).hashCode();
            if (str2.toLowerCase(Locale.ENGLISH).endsWith(".svg")) {
                try {
                    return graphicFactory.renderSvg(createInputStream, displayModel.getScaleFactor(), i3, i4, i5, hashCode);
                } catch (IOException e3) {
                    throw new IOException("SVG render failed " + str2, e3);
                }
            }
            try {
                return graphicFactory.createResourceBitmap(createInputStream, displayModel.getScaleFactor(), i3, i4, i5, hashCode);
            } catch (IOException e4) {
                throw new IOException("Reading bitmap file failed " + str2, e4);
            }
        } finally {
        }
        createInputStream.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (r3 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.io.InputStream createInputStream(org.mapsforge.core.graphics.GraphicFactory r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "assets:"
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L12
            r0 = 7
            java.lang.String r5 = r5.substring(r0)
            java.io.InputStream r3 = inputStreamFromAssets(r3, r4, r5)
            goto L5d
        L12:
            java.lang.String r0 = "file:"
            boolean r0 = r5.startsWith(r0)
            if (r0 == 0) goto L24
            r3 = 5
            java.lang.String r5 = r5.substring(r3)
            java.io.InputStream r3 = inputStreamFromFile(r4, r5)
            goto L5d
        L24:
            java.lang.String r0 = "jar:"
            boolean r1 = r5.startsWith(r0)
            java.lang.String r2 = "jar:/org/mapsforge/android/maps/rendertheme"
            if (r1 != 0) goto L44
            boolean r1 = r5.startsWith(r2)
            if (r1 == 0) goto L35
            goto L44
        L35:
            java.io.InputStream r0 = inputStreamFromFile(r4, r5)
            if (r0 != 0) goto L40
            java.io.InputStream r3 = inputStreamFromAssets(r3, r4, r5)
            goto L41
        L40:
            r3 = r0
        L41:
            if (r3 != 0) goto L5d
            goto L59
        L44:
            boolean r3 = r5.startsWith(r0)
            if (r3 == 0) goto L50
            r3 = 4
        L4b:
            java.lang.String r5 = r5.substring(r3)
            goto L59
        L50:
            boolean r3 = r5.startsWith(r2)
            if (r3 == 0) goto L59
            r3 = 43
            goto L4b
        L59:
            java.io.InputStream r3 = inputStreamFromJar(r4, r5)
        L5d:
            if (r3 != 0) goto L7d
            java.lang.String r3 = "/assets/"
            java.io.InputStream r3 = inputStreamFromJar(r3, r5)
            if (r3 == 0) goto L7d
            java.util.logging.Logger r4 = org.mapsforge.map.rendertheme.XmlUtils.LOGGER
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "internal resource: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r4.info(r0)
        L7d:
            if (r3 == 0) goto L80
            return r3
        L80:
            java.util.logging.Logger r3 = org.mapsforge.map.rendertheme.XmlUtils.LOGGER
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "invalid resource: "
            r4.append(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.severe(r4)
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.map.rendertheme.XmlUtils.createInputStream(org.mapsforge.core.graphics.GraphicFactory, java.lang.String, java.lang.String):java.io.InputStream");
    }

    public static XmlPullParserException createXmlPullParserException(String str, String str2, String str3, int i3) {
        return new XmlPullParserException("unknown attribute (" + i3 + ") in element '" + str + "': " + str2 + Tag.KEY_VALUE_SEPARATOR + str3);
    }

    private static String getAbsoluteName(String str, String str2) {
        if (str2.charAt(0) == File.separatorChar) {
            return str2;
        }
        return str + str2;
    }

    public static int getColor(GraphicFactory graphicFactory, String str) {
        return getColor(graphicFactory, str, null, null);
    }

    private static int getColor(GraphicFactory graphicFactory, String str, int i3, int i4, ThemeCallback themeCallback, RenderInstruction renderInstruction) {
        int i5 = i4 + 2;
        int i6 = i4 + 4;
        int createColor = graphicFactory.createColor(i3, Integer.parseInt(str.substring(i4, i5), 16), Integer.parseInt(str.substring(i5, i6), 16), Integer.parseInt(str.substring(i6, i4 + 6), 16));
        return themeCallback != null ? themeCallback.getColor(renderInstruction, createColor) : createColor;
    }

    public static int getColor(GraphicFactory graphicFactory, String str, ThemeCallback themeCallback, RenderInstruction renderInstruction) {
        if (str.isEmpty() || str.charAt(0) != '#') {
            throw new IllegalArgumentException(UNSUPPORTED_COLOR_FORMAT + str);
        }
        if (str.length() == 7) {
            return getColor(graphicFactory, str, 255, 1, themeCallback, renderInstruction);
        }
        if (str.length() == 9) {
            return getColor(graphicFactory, str, Integer.parseInt(str.substring(1, 3), 16), 3, themeCallback, renderInstruction);
        }
        throw new IllegalArgumentException(UNSUPPORTED_COLOR_FORMAT + str);
    }

    private static File getFile(String str, String str2) {
        return str2.charAt(0) == File.separatorChar ? new File(str2) : new File(str, str2);
    }

    private static InputStream inputStreamFromAssets(GraphicFactory graphicFactory, String str, String str2) {
        InputStream inputStream;
        try {
            inputStream = graphicFactory.platformSpecificSources(str, str2);
        } catch (IOException unused) {
            inputStream = null;
        }
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        if (r0.canRead() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        if (r0.exists() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.io.InputStream inputStreamFromFile(java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r0 = getFile(r4, r5)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 != 0) goto L2b
            int r1 = r5.length()
            if (r1 <= 0) goto L24
            r1 = 0
            char r1 = r5.charAt(r1)
            char r3 = java.io.File.separatorChar
            if (r1 != r3) goto L24
            r0 = 1
            java.lang.String r5 = r5.substring(r0)
            java.io.File r4 = getFile(r4, r5)
            r0 = r4
        L24:
            boolean r4 = r0.exists()
            if (r4 != 0) goto L38
            goto L37
        L2b:
            boolean r4 = r0.isFile()
            if (r4 == 0) goto L37
            boolean r4 = r0.canRead()
            if (r4 != 0) goto L38
        L37:
            r0 = r2
        L38:
            if (r0 == 0) goto L40
            java.io.FileInputStream r4 = new java.io.FileInputStream
            r4.<init>(r0)
            return r4
        L40:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.map.rendertheme.XmlUtils.inputStreamFromFile(java.lang.String, java.lang.String):java.io.InputStream");
    }

    private static InputStream inputStreamFromJar(String str, String str2) {
        return XmlUtils.class.getResourceAsStream(getAbsoluteName(str, str2));
    }

    public static byte parseNonNegativeByte(String str, String str2) {
        byte parseByte = Byte.parseByte(str2);
        checkForNegativeValue(str, parseByte);
        return parseByte;
    }

    public static float parseNonNegativeFloat(String str, String str2) {
        float parseFloat = Float.parseFloat(str2);
        checkForNegativeValue(str, parseFloat);
        return parseFloat;
    }

    public static int parseNonNegativeInteger(String str, String str2) {
        int parseInt = Integer.parseInt(str2);
        checkForNegativeValue(str, parseInt);
        return parseInt;
    }
}
