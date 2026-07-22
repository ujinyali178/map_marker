package org.mapsforge.map.rendertheme.rule;

import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.XmlUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /root/release/classes2.dex */
public class RenderThemeBuilder {
    private static final String BASE_STROKE_WIDTH = "base-stroke-width";
    private static final String BASE_TEXT_SIZE = "base-text-size";
    private static final String MAP_BACKGROUND = "map-background";
    private static final String MAP_BACKGROUND_OUTSIDE = "map-background-outside";
    private static final int RENDER_THEME_VERSION = 6;
    private static final String VERSION = "version";
    private static final String XMLNS = "xmlns";
    private static final String XMLNS_XSI = "xmlns:xsi";
    private static final String XSI_SCHEMALOCATION = "xsi:schemaLocation";
    float baseStrokeWidth = 1.0f;
    float baseTextSize = 1.0f;
    private final DisplayModel displayModel;
    boolean hasBackgroundOutside;
    int mapBackground;
    int mapBackgroundOutside;
    private Integer version;

    public RenderThemeBuilder(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlPullParser xmlPullParser) {
        this.displayModel = displayModel;
        this.mapBackground = graphicFactory.createColor(Color.WHITE);
        extractValues(graphicFactory, str, xmlPullParser);
    }

    private void extractValues(GraphicFactory graphicFactory, String str, XmlPullParser xmlPullParser) {
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (!XMLNS.equals(attributeName) && !XMLNS_XSI.equals(attributeName) && !XSI_SCHEMALOCATION.equals(attributeName)) {
                if (VERSION.equals(attributeName)) {
                    this.version = Integer.valueOf(XmlUtils.parseNonNegativeInteger(attributeName, attributeValue));
                } else if (MAP_BACKGROUND.equals(attributeName)) {
                    this.mapBackground = XmlUtils.getColor(graphicFactory, attributeValue, this.displayModel.getThemeCallback(), null);
                } else if (MAP_BACKGROUND_OUTSIDE.equals(attributeName)) {
                    this.mapBackgroundOutside = XmlUtils.getColor(graphicFactory, attributeValue, this.displayModel.getThemeCallback(), null);
                    this.hasBackgroundOutside = true;
                } else if (BASE_STROKE_WIDTH.equals(attributeName)) {
                    this.baseStrokeWidth = XmlUtils.parseNonNegativeFloat(attributeName, attributeValue);
                } else {
                    if (!BASE_TEXT_SIZE.equals(attributeName)) {
                        throw XmlUtils.createXmlPullParserException(str, attributeName, attributeValue, i3);
                    }
                    this.baseTextSize = XmlUtils.parseNonNegativeFloat(attributeName, attributeValue);
                }
            }
        }
        validate(str);
    }

    private void validate(String str) {
        XmlUtils.checkMandatoryAttribute(str, VERSION, this.version);
        if (this.version.intValue() <= 6) {
            return;
        }
        throw new XmlPullParserException("unsupported render theme version: " + this.version);
    }

    public RenderTheme build() {
        return new RenderTheme(this);
    }
}
