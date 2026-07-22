package org.mapsforge.map.rendertheme.rule;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Logger;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.util.IOUtils;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.XmlRenderTheme;
import org.mapsforge.map.rendertheme.XmlRenderThemeStyleLayer;
import org.mapsforge.map.rendertheme.XmlRenderThemeStyleMenu;
import org.mapsforge.map.rendertheme.XmlUtils;
import org.mapsforge.map.rendertheme.renderinstruction.Area;
import org.mapsforge.map.rendertheme.renderinstruction.Caption;
import org.mapsforge.map.rendertheme.renderinstruction.Circle;
import org.mapsforge.map.rendertheme.renderinstruction.Hillshading;
import org.mapsforge.map.rendertheme.renderinstruction.Line;
import org.mapsforge.map.rendertheme.renderinstruction.LineSymbol;
import org.mapsforge.map.rendertheme.renderinstruction.PathText;
import org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction;
import org.mapsforge.map.rendertheme.renderinstruction.Symbol;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: /root/release/classes2.dex */
public final class RenderThemeHandler {
    private static final String ELEMENT_NAME_RULE = "rule";
    private static final String UNEXPECTED_ELEMENT = "unexpected element: ";
    private Set<String> categories;
    private XmlRenderThemeStyleLayer currentLayer;
    private Rule currentRule;
    private final DisplayModel displayModel;
    private final GraphicFactory graphicFactory;
    private int level;
    private final XmlPullParser pullParser;
    private String qName;
    private final String relativePathPrefix;
    private RenderTheme renderTheme;
    private XmlRenderThemeStyleMenu renderThemeStyleMenu;
    private final XmlRenderTheme xmlRenderTheme;
    private static final Logger LOGGER = Logger.getLogger(RenderThemeHandler.class.getName());
    private static XmlPullParserFactory xmlPullParserFactory = null;
    private final Stack<Element> elementStack = new Stack<>();
    private final Stack<Rule> ruleStack = new Stack<>();
    private Map<String, Symbol> symbols = new HashMap();

    /* renamed from: org.mapsforge.map.rendertheme.rule.RenderThemeHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$map$rendertheme$rule$RenderThemeHandler$Element;

        static {
            int[] iArr = new int[Element.values().length];
            $SwitchMap$org$mapsforge$map$rendertheme$rule$RenderThemeHandler$Element = iArr;
            try {
                iArr[Element.RENDER_THEME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$map$rendertheme$rule$RenderThemeHandler$Element[Element.RULE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$map$rendertheme$rule$RenderThemeHandler$Element[Element.RENDERING_INSTRUCTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mapsforge$map$rendertheme$rule$RenderThemeHandler$Element[Element.RENDERING_STYLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private enum Element {
        RENDER_THEME,
        RENDERING_INSTRUCTION,
        RULE,
        RENDERING_STYLE
    }

    private RenderThemeHandler(GraphicFactory graphicFactory, DisplayModel displayModel, String str, XmlRenderTheme xmlRenderTheme, XmlPullParser xmlPullParser) {
        this.pullParser = xmlPullParser;
        this.graphicFactory = graphicFactory;
        this.displayModel = displayModel;
        this.relativePathPrefix = str;
        this.xmlRenderTheme = xmlRenderTheme;
    }

    private void checkElement(String str, Element element) {
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$map$rendertheme$rule$RenderThemeHandler$Element[element.ordinal()];
        if (i3 == 1) {
            if (this.elementStack.empty()) {
                return;
            }
            throw new XmlPullParserException(UNEXPECTED_ELEMENT + str);
        }
        if (i3 == 2) {
            Element peek = this.elementStack.peek();
            if (peek == Element.RENDER_THEME || peek == Element.RULE) {
                return;
            }
            throw new XmlPullParserException(UNEXPECTED_ELEMENT + str);
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return;
            }
            throw new XmlPullParserException("unknown enum value: " + element);
        }
        if (this.elementStack.peek() == Element.RULE) {
            return;
        }
        throw new XmlPullParserException(UNEXPECTED_ELEMENT + str);
    }

    private void checkState(String str, Element element) {
        checkElement(str, element);
        this.elementStack.push(element);
    }

    private void endDocument() {
        RenderTheme renderTheme = this.renderTheme;
        if (renderTheme == null) {
            throw new IllegalArgumentException("missing element: rules");
        }
        renderTheme.setLevels(this.level);
        this.renderTheme.complete();
    }

    private void endElement() {
        this.qName = this.pullParser.getName();
        this.elementStack.pop();
        if (!ELEMENT_NAME_RULE.equals(this.qName)) {
            if (!"stylemenu".equals(this.qName) || this.xmlRenderTheme.getMenuCallback() == null) {
                return;
            }
            this.categories = this.xmlRenderTheme.getMenuCallback().getCategories(this.renderThemeStyleMenu);
            return;
        }
        this.ruleStack.pop();
        if (!this.ruleStack.empty()) {
            this.currentRule = this.ruleStack.peek();
        } else if (isVisible(this.currentRule)) {
            this.renderTheme.addRule(this.currentRule);
        }
    }

    public static RenderTheme getRenderTheme(GraphicFactory graphicFactory, DisplayModel displayModel, XmlRenderTheme xmlRenderTheme) {
        InputStream inputStream;
        Throwable th;
        XmlPullParser newPullParser = getXmlPullParserFactory().newPullParser();
        RenderThemeHandler renderThemeHandler = new RenderThemeHandler(graphicFactory, displayModel, xmlRenderTheme.getRelativePathPrefix(), xmlRenderTheme, newPullParser);
        try {
            inputStream = xmlRenderTheme.getRenderThemeAsStream();
            try {
                newPullParser.setInput(inputStream, null);
                renderThemeHandler.processRenderTheme();
                RenderTheme renderTheme = renderThemeHandler.renderTheme;
                IOUtils.closeQuietly(inputStream);
                return renderTheme;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
        }
    }

    private String getStringAttribute(String str) {
        int attributeCount = this.pullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            if (this.pullParser.getAttributeName(i3).equals(str)) {
                return this.pullParser.getAttributeValue(i3);
            }
        }
        return null;
    }

    public static XmlPullParserFactory getXmlPullParserFactory() {
        if (xmlPullParserFactory == null) {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
        }
        return xmlPullParserFactory;
    }

    private boolean isVisible(RenderInstruction renderInstruction) {
        return this.categories == null || renderInstruction.getCategory() == null || this.categories.contains(renderInstruction.getCategory());
    }

    private boolean isVisible(Rule rule) {
        String str;
        Set<String> set = this.categories;
        return set == null || (str = rule.cat) == null || set.contains(str);
    }

    public static void setXmlPullParserFactory(XmlPullParserFactory xmlPullParserFactory2) {
        xmlPullParserFactory = xmlPullParserFactory2;
    }

    private void startElement() {
        RenderInstruction pathText;
        Rule rule;
        XmlRenderThemeStyleLayer layer;
        String name = this.pullParser.getName();
        this.qName = name;
        try {
            if ("rendertheme".equals(name)) {
                checkState(this.qName, Element.RENDER_THEME);
                this.renderTheme = new RenderThemeBuilder(this.graphicFactory, this.displayModel, this.qName, this.pullParser).build();
                return;
            }
            if (ELEMENT_NAME_RULE.equals(this.qName)) {
                checkState(this.qName, Element.RULE);
                Rule build = new RuleBuilder(this.qName, this.pullParser, this.ruleStack).build();
                if (!this.ruleStack.empty() && isVisible(build)) {
                    this.currentRule.addSubRule(build);
                }
                this.currentRule = build;
                this.ruleStack.push(build);
                return;
            }
            if ("area".equals(this.qName)) {
                checkState(this.qName, Element.RENDERING_INSTRUCTION);
                GraphicFactory graphicFactory = this.graphicFactory;
                DisplayModel displayModel = this.displayModel;
                String str = this.qName;
                XmlPullParser xmlPullParser = this.pullParser;
                int i3 = this.level;
                this.level = i3 + 1;
                pathText = new Area(graphicFactory, displayModel, str, xmlPullParser, i3, this.relativePathPrefix);
                if (!isVisible(pathText)) {
                    return;
                } else {
                    rule = this.currentRule;
                }
            } else if ("caption".equals(this.qName)) {
                checkState(this.qName, Element.RENDERING_INSTRUCTION);
                pathText = new Caption(this.graphicFactory, this.displayModel, this.qName, this.pullParser, this.symbols);
                if (!isVisible(pathText)) {
                    return;
                } else {
                    rule = this.currentRule;
                }
            } else {
                if ("cat".equals(this.qName)) {
                    checkState(this.qName, Element.RENDERING_STYLE);
                    this.currentLayer.addCategory(getStringAttribute("id"));
                    return;
                }
                if ("circle".equals(this.qName)) {
                    checkState(this.qName, Element.RENDERING_INSTRUCTION);
                    GraphicFactory graphicFactory2 = this.graphicFactory;
                    DisplayModel displayModel2 = this.displayModel;
                    String str2 = this.qName;
                    XmlPullParser xmlPullParser2 = this.pullParser;
                    int i4 = this.level;
                    this.level = i4 + 1;
                    pathText = new Circle(graphicFactory2, displayModel2, str2, xmlPullParser2, i4);
                    if (!isVisible(pathText)) {
                        return;
                    } else {
                        rule = this.currentRule;
                    }
                } else {
                    if ("layer".equals(this.qName)) {
                        checkState(this.qName, Element.RENDERING_STYLE);
                        this.currentLayer = this.renderThemeStyleMenu.createLayer(getStringAttribute("id"), Boolean.valueOf(getStringAttribute("visible")).booleanValue(), getStringAttribute("enabled") != null ? Boolean.valueOf(getStringAttribute("enabled")).booleanValue() : false);
                        String stringAttribute = getStringAttribute("parent");
                        if (stringAttribute == null || (layer = this.renderThemeStyleMenu.getLayer(stringAttribute)) == null) {
                            return;
                        }
                        Iterator<String> it = layer.getCategories().iterator();
                        while (it.hasNext()) {
                            this.currentLayer.addCategory(it.next());
                        }
                        Iterator<XmlRenderThemeStyleLayer> it2 = layer.getOverlays().iterator();
                        while (it2.hasNext()) {
                            this.currentLayer.addOverlay(it2.next());
                        }
                        return;
                    }
                    if ("line".equals(this.qName)) {
                        checkState(this.qName, Element.RENDERING_INSTRUCTION);
                        GraphicFactory graphicFactory3 = this.graphicFactory;
                        DisplayModel displayModel3 = this.displayModel;
                        String str3 = this.qName;
                        XmlPullParser xmlPullParser3 = this.pullParser;
                        int i5 = this.level;
                        this.level = i5 + 1;
                        pathText = new Line(graphicFactory3, displayModel3, str3, xmlPullParser3, i5, this.relativePathPrefix);
                        if (!isVisible(pathText)) {
                            return;
                        } else {
                            rule = this.currentRule;
                        }
                    } else if ("lineSymbol".equals(this.qName)) {
                        checkState(this.qName, Element.RENDERING_INSTRUCTION);
                        pathText = new LineSymbol(this.graphicFactory, this.displayModel, this.qName, this.pullParser, this.relativePathPrefix);
                        if (!isVisible(pathText)) {
                            return;
                        } else {
                            rule = this.currentRule;
                        }
                    } else {
                        if ("name".equals(this.qName)) {
                            checkState(this.qName, Element.RENDERING_STYLE);
                            this.currentLayer.addTranslation(getStringAttribute("lang"), getStringAttribute("value"));
                            return;
                        }
                        if ("overlay".equals(this.qName)) {
                            checkState(this.qName, Element.RENDERING_STYLE);
                            XmlRenderThemeStyleLayer layer2 = this.renderThemeStyleMenu.getLayer(getStringAttribute("id"));
                            if (layer2 != null) {
                                this.currentLayer.addOverlay(layer2);
                                return;
                            }
                            return;
                        }
                        if (!"pathText".equals(this.qName)) {
                            if ("stylemenu".equals(this.qName)) {
                                checkState(this.qName, Element.RENDERING_STYLE);
                                this.renderThemeStyleMenu = new XmlRenderThemeStyleMenu(getStringAttribute("id"), getStringAttribute("defaultlang"), getStringAttribute("defaultvalue"));
                                return;
                            }
                            if ("symbol".equals(this.qName)) {
                                checkState(this.qName, Element.RENDERING_INSTRUCTION);
                                Symbol symbol = new Symbol(this.graphicFactory, this.displayModel, this.qName, this.pullParser, this.relativePathPrefix);
                                if (isVisible(symbol)) {
                                    this.currentRule.addRenderingInstruction(symbol);
                                }
                                String id = symbol.getId();
                                if (id != null) {
                                    this.symbols.put(id, symbol);
                                    return;
                                }
                                return;
                            }
                            if (!"hillshading".equals(this.qName)) {
                                throw new XmlPullParserException("unknown element: " + this.qName);
                            }
                            checkState(this.qName, Element.RULE);
                            String str4 = null;
                            byte b4 = 5;
                            byte b5 = 17;
                            short s3 = 64;
                            byte b6 = 5;
                            boolean z3 = false;
                            for (int i6 = 0; i6 < this.pullParser.getAttributeCount(); i6++) {
                                String attributeName = this.pullParser.getAttributeName(i6);
                                String attributeValue = this.pullParser.getAttributeValue(i6);
                                if ("cat".equals(attributeName)) {
                                    str4 = attributeValue;
                                } else if ("zoom-min".equals(attributeName)) {
                                    b4 = XmlUtils.parseNonNegativeByte("zoom-min", attributeValue);
                                } else if ("zoom-max".equals(attributeName)) {
                                    b5 = XmlUtils.parseNonNegativeByte("zoom-max", attributeValue);
                                } else if ("magnitude".equals(attributeName)) {
                                    s3 = (short) XmlUtils.parseNonNegativeInteger("magnitude", attributeValue);
                                    if (s3 > 255) {
                                        throw new XmlPullParserException("Attribute 'magnitude' must not be > 255");
                                    }
                                } else if ("always".equals(attributeName)) {
                                    z3 = Boolean.valueOf(attributeValue).booleanValue();
                                } else if ("layer".equals(attributeName)) {
                                    b6 = XmlUtils.parseNonNegativeByte("layer", attributeValue);
                                }
                            }
                            int i7 = this.level;
                            this.level = i7 + 1;
                            Hillshading hillshading = new Hillshading(b4, b5, s3, b6, z3, i7, this.graphicFactory);
                            Set<String> set = this.categories;
                            if (set == null || str4 == null || set.contains(str4)) {
                                this.renderTheme.addHillShadings(hillshading);
                                return;
                            }
                            return;
                        }
                        checkState(this.qName, Element.RENDERING_INSTRUCTION);
                        pathText = new PathText(this.graphicFactory, this.displayModel, this.qName, this.pullParser);
                        if (!isVisible(pathText)) {
                            return;
                        } else {
                            rule = this.currentRule;
                        }
                    }
                }
            }
            rule.addRenderingInstruction(pathText);
        } catch (IOException e3) {
            LOGGER.warning("Rendertheme missing or invalid resource " + e3.getMessage());
        }
    }

    public void processRenderTheme() {
        int eventType = this.pullParser.getEventType();
        do {
            if (eventType != 0) {
                if (eventType == 2) {
                    startElement();
                } else if (eventType == 3) {
                    endElement();
                }
            }
            eventType = this.pullParser.next();
        } while (eventType != 1);
        endDocument();
    }
}
