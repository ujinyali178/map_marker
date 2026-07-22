package c0;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import c0.b;
import c0.e;
import c0.g;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.android.gms.maps.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.PinConfig;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.kxml2.wap.Wbxml;
import org.mapsforge.core.model.Tag;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /root/release/classes.dex */
class k {

    /* renamed from: d, reason: collision with root package name */
    private int f1979d;

    /* renamed from: a, reason: collision with root package name */
    private c0.g f1976a = null;

    /* renamed from: b, reason: collision with root package name */
    private g.j0 f1977b = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1978c = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1980e = false;

    /* renamed from: f, reason: collision with root package name */
    private h f1981f = null;

    /* renamed from: g, reason: collision with root package name */
    private StringBuilder f1982g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1983h = false;

    /* renamed from: i, reason: collision with root package name */
    private StringBuilder f1984i = null;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1985a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1986b;

        static {
            int[] iArr = new int[g.values().length];
            f1986b = iArr;
            try {
                iArr[g.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1986b[g.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1986b[g.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1986b[g.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1986b[g.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1986b[g.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1986b[g.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1986b[g.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1986b[g.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1986b[g.rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1986b[g.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1986b[g.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1986b[g.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1986b[g.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1986b[g.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1986b[g.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1986b[g.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1986b[g.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f1986b[g.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f1986b[g.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f1986b[g.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f1986b[g.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f1986b[g.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f1986b[g.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f1986b[g.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f1986b[g.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f1986b[g.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f1986b[g.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f1986b[g.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f1986b[g.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f1986b[g.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f1986b[g.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f1986b[g.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f1986b[g.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f1986b[g.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f1986b[g.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f1986b[g.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f1986b[g.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f1986b[g.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f1986b[g.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f1986b[g.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f1986b[g.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f1986b[g.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f1986b[g.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f1986b[g.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f1986b[g.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f1986b[g.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f1986b[g.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f1986b[g.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f1986b[g.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f1986b[g.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f1986b[g.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f1986b[g.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f1986b[g.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f1986b[g.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f1986b[g.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f1986b[g.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f1986b[g.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f1986b[g.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f1986b[g.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f1986b[g.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f1986b[g.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f1986b[g.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f1986b[g.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f1986b[g.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                f1986b[g.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                f1986b[g.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                f1986b[g.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                f1986b[g.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                f1986b[g.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                f1986b[g.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                f1986b[g.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                f1986b[g.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                f1986b[g.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                f1986b[g.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                f1986b[g.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                f1986b[g.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                f1986b[g.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                f1986b[g.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                f1986b[g.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                f1986b[g.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                f1986b[g.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                f1986b[g.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                f1986b[g.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                f1986b[g.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                f1986b[g.image_rendering.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                f1986b[g.viewBox.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                f1986b[g.type.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                f1986b[g.media.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            int[] iArr2 = new int[h.values().length];
            f1985a = iArr2;
            try {
                iArr2[h.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                f1985a[h.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                f1985a[h.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                f1985a[h.defs.ordinal()] = 4;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                f1985a[h.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                f1985a[h.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                f1985a[h.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                f1985a[h.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                f1985a[h.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                f1985a[h.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                f1985a[h.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                f1985a[h.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                f1985a[h.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                f1985a[h.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                f1985a[h.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                f1985a[h.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                f1985a[h.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                f1985a[h.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                f1985a[h.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                f1985a[h.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                f1985a[h.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                f1985a[h.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                f1985a[h.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                f1985a[h.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                f1985a[h.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                f1985a[h.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                f1985a[h.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                f1985a[h.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                f1985a[h.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                f1985a[h.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                f1985a[h.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused120) {
            }
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final Map<String, e.a> f1987a;

        static {
            HashMap hashMap = new HashMap(10);
            f1987a = hashMap;
            hashMap.put(DevicePublicKeyStringDef.NONE, e.a.none);
            hashMap.put("xMinYMin", e.a.xMinYMin);
            hashMap.put("xMidYMin", e.a.xMidYMin);
            hashMap.put("xMaxYMin", e.a.xMaxYMin);
            hashMap.put("xMinYMid", e.a.xMinYMid);
            hashMap.put("xMidYMid", e.a.xMidYMid);
            hashMap.put("xMaxYMid", e.a.xMaxYMid);
            hashMap.put("xMinYMax", e.a.xMinYMax);
            hashMap.put("xMidYMax", e.a.xMidYMax);
            hashMap.put("xMaxYMax", e.a.xMaxYMax);
        }

        static e.a a(String str) {
            return f1987a.get(str);
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final Map<String, Integer> f1988a;

        static {
            HashMap hashMap = new HashMap(47);
            f1988a = hashMap;
            hashMap.put("aliceblue", -984833);
            hashMap.put("antiquewhite", -332841);
            hashMap.put("aqua", -16711681);
            hashMap.put("aquamarine", -8388652);
            hashMap.put("azure", -983041);
            hashMap.put("beige", -657956);
            hashMap.put("bisque", -6972);
            hashMap.put("black", -16777216);
            hashMap.put("blanchedalmond", -5171);
            hashMap.put("blue", -16776961);
            hashMap.put("blueviolet", -7722014);
            hashMap.put("brown", -5952982);
            hashMap.put("burlywood", -2180985);
            hashMap.put("cadetblue", -10510688);
            hashMap.put("chartreuse", -8388864);
            hashMap.put("chocolate", -2987746);
            hashMap.put("coral", -32944);
            hashMap.put("cornflowerblue", -10185235);
            hashMap.put("cornsilk", -1828);
            hashMap.put("crimson", -2354116);
            hashMap.put("cyan", -16711681);
            hashMap.put("darkblue", -16777077);
            hashMap.put("darkcyan", -16741493);
            hashMap.put("darkgoldenrod", -4684277);
            hashMap.put("darkgray", -5658199);
            hashMap.put("darkgreen", -16751616);
            hashMap.put("darkgrey", -5658199);
            hashMap.put("darkkhaki", -4343957);
            hashMap.put("darkmagenta", -7667573);
            hashMap.put("darkolivegreen", -11179217);
            hashMap.put("darkorange", -29696);
            hashMap.put("darkorchid", -6737204);
            hashMap.put("darkred", -7667712);
            hashMap.put("darksalmon", -1468806);
            hashMap.put("darkseagreen", -7357297);
            hashMap.put("darkslateblue", -12042869);
            hashMap.put("darkslategray", -13676721);
            hashMap.put("darkslategrey", -13676721);
            hashMap.put("darkturquoise", -16724271);
            hashMap.put("darkviolet", -7077677);
            hashMap.put("deeppink", -60269);
            hashMap.put("deepskyblue", -16728065);
            hashMap.put("dimgray", -9868951);
            hashMap.put("dimgrey", -9868951);
            hashMap.put("dodgerblue", -14774017);
            hashMap.put("firebrick", -5103070);
            hashMap.put("floralwhite", -1296);
            hashMap.put("forestgreen", -14513374);
            hashMap.put("fuchsia", -65281);
            hashMap.put("gainsboro", -2302756);
            hashMap.put("ghostwhite", -460545);
            hashMap.put("gold", -10496);
            hashMap.put("goldenrod", -2448096);
            hashMap.put("gray", -8355712);
            hashMap.put("green", -16744448);
            hashMap.put("greenyellow", -5374161);
            hashMap.put("grey", -8355712);
            hashMap.put("honeydew", -983056);
            hashMap.put("hotpink", -38476);
            hashMap.put("indianred", -3318692);
            hashMap.put("indigo", -11861886);
            hashMap.put("ivory", -16);
            hashMap.put("khaki", -989556);
            hashMap.put("lavender", -1644806);
            hashMap.put("lavenderblush", -3851);
            hashMap.put("lawngreen", -8586240);
            hashMap.put("lemonchiffon", -1331);
            hashMap.put("lightblue", -5383962);
            hashMap.put("lightcoral", -1015680);
            hashMap.put("lightcyan", -2031617);
            hashMap.put("lightgoldenrodyellow", -329006);
            hashMap.put("lightgray", -2894893);
            hashMap.put("lightgreen", -7278960);
            hashMap.put("lightgrey", -2894893);
            hashMap.put("lightpink", -18751);
            hashMap.put("lightsalmon", -24454);
            hashMap.put("lightseagreen", -14634326);
            hashMap.put("lightskyblue", -7876870);
            hashMap.put("lightslategray", -8943463);
            hashMap.put("lightslategrey", -8943463);
            hashMap.put("lightsteelblue", -5192482);
            hashMap.put("lightyellow", -32);
            hashMap.put("lime", -16711936);
            hashMap.put("limegreen", -13447886);
            hashMap.put("linen", -331546);
            hashMap.put("magenta", -65281);
            hashMap.put("maroon", -8388608);
            hashMap.put("mediumaquamarine", -10039894);
            hashMap.put("mediumblue", -16777011);
            hashMap.put("mediumorchid", -4565549);
            hashMap.put("mediumpurple", -7114533);
            hashMap.put("mediumseagreen", -12799119);
            hashMap.put("mediumslateblue", -8689426);
            hashMap.put("mediumspringgreen", -16713062);
            hashMap.put("mediumturquoise", -12004916);
            hashMap.put("mediumvioletred", -3730043);
            hashMap.put("midnightblue", -15132304);
            hashMap.put("mintcream", -655366);
            hashMap.put("mistyrose", -6943);
            hashMap.put("moccasin", -6987);
            hashMap.put("navajowhite", -8531);
            hashMap.put("navy", -16777088);
            hashMap.put("oldlace", -133658);
            hashMap.put("olive", -8355840);
            hashMap.put("olivedrab", -9728477);
            hashMap.put("orange", -23296);
            hashMap.put("orangered", -47872);
            hashMap.put("orchid", -2461482);
            hashMap.put("palegoldenrod", -1120086);
            hashMap.put("palegreen", -6751336);
            hashMap.put("paleturquoise", -5247250);
            hashMap.put("palevioletred", -2396013);
            hashMap.put("papayawhip", -4139);
            hashMap.put("peachpuff", -9543);
            hashMap.put("peru", -3308225);
            hashMap.put("pink", -16181);
            hashMap.put("plum", -2252579);
            hashMap.put("powderblue", -5185306);
            hashMap.put("purple", -8388480);
            hashMap.put("rebeccapurple", -10079335);
            hashMap.put("red", -65536);
            hashMap.put("rosybrown", -4419697);
            hashMap.put("royalblue", -12490271);
            hashMap.put("saddlebrown", -7650029);
            hashMap.put("salmon", -360334);
            hashMap.put("sandybrown", -744352);
            hashMap.put("seagreen", -13726889);
            hashMap.put("seashell", -2578);
            hashMap.put("sienna", -6270419);
            hashMap.put("silver", -4144960);
            hashMap.put("skyblue", -7876885);
            hashMap.put("slateblue", -9807155);
            hashMap.put("slategray", -9404272);
            hashMap.put("slategrey", -9404272);
            hashMap.put("snow", -1286);
            hashMap.put("springgreen", -16711809);
            hashMap.put("steelblue", -12156236);
            hashMap.put("tan", -2968436);
            hashMap.put("teal", -16744320);
            hashMap.put("thistle", -2572328);
            hashMap.put("tomato", -40121);
            hashMap.put("turquoise", -12525360);
            hashMap.put("violet", -1146130);
            hashMap.put("wheat", -663885);
            hashMap.put("white", -1);
            hashMap.put("whitesmoke", -657931);
            hashMap.put("yellow", -256);
            hashMap.put("yellowgreen", -6632142);
            hashMap.put("transparent", 0);
        }

        static Integer a(String str) {
            return f1988a.get(str);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final Map<String, g.p> f1989a;

        static {
            HashMap hashMap = new HashMap(9);
            f1989a = hashMap;
            g.d1 d1Var = g.d1.pt;
            hashMap.put("xx-small", new g.p(0.694f, d1Var));
            hashMap.put("x-small", new g.p(0.833f, d1Var));
            hashMap.put("small", new g.p(10.0f, d1Var));
            hashMap.put("medium", new g.p(12.0f, d1Var));
            hashMap.put("large", new g.p(14.4f, d1Var));
            hashMap.put("x-large", new g.p(17.3f, d1Var));
            hashMap.put("xx-large", new g.p(20.7f, d1Var));
            g.d1 d1Var2 = g.d1.percent;
            hashMap.put("smaller", new g.p(83.33f, d1Var2));
            hashMap.put("larger", new g.p(120.0f, d1Var2));
        }

        static g.p a(String str) {
            return f1989a.get(str);
        }
    }

    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final Map<String, Integer> f1990a;

        static {
            HashMap hashMap = new HashMap(13);
            f1990a = hashMap;
            hashMap.put("normal", 400);
            hashMap.put("bold", 700);
            hashMap.put("bolder", 1);
            hashMap.put("lighter", -1);
            hashMap.put("100", 100);
            hashMap.put("200", 200);
            hashMap.put("300", 300);
            hashMap.put("400", 400);
            hashMap.put("500", 500);
            hashMap.put("600", 600);
            hashMap.put("700", 700);
            hashMap.put("800", 800);
            hashMap.put("900", 900);
        }

        static Integer a(String str) {
            return f1990a.get(str);
        }
    }

    private class f extends DefaultHandler2 {
        private f() {
        }

        /* synthetic */ f(k kVar, a aVar) {
            this();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i4) {
            k.this.c1(new String(cArr, i3, i4));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() {
            k.this.o();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            k.this.p(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
            k.this.r(str, k.this.x0(new i(str2)));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() {
            k.this.W0();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            k.this.X0(str, str2, str3, attributes);
        }
    }

    private enum g {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;

        private static final Map<String, g> R0 = new HashMap();

        static {
            for (g gVar : values()) {
                if (gVar == CLASS) {
                    R0.put("class", gVar);
                } else if (gVar != UNSUPPORTED) {
                    R0.put(gVar.name().replace('_', '-'), gVar);
                }
            }
        }

        public static g a(String str) {
            g gVar = R0.get(str);
            return gVar != null ? gVar : UNSUPPORTED;
        }
    }

    private enum h {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;

        private static final Map<String, h> J = new HashMap();

        static {
            for (h hVar : values()) {
                if (hVar == SWITCH) {
                    J.put("switch", hVar);
                } else if (hVar != UNSUPPORTED) {
                    J.put(hVar.name(), hVar);
                }
            }
        }

        public static h a(String str) {
            h hVar = J.get(str);
            return hVar != null ? hVar : UNSUPPORTED;
        }
    }

    static class i {

        /* renamed from: a, reason: collision with root package name */
        String f2064a;

        /* renamed from: c, reason: collision with root package name */
        int f2066c;

        /* renamed from: b, reason: collision with root package name */
        int f2065b = 0;

        /* renamed from: d, reason: collision with root package name */
        private c0.d f2067d = new c0.d();

        i(String str) {
            this.f2066c = 0;
            String trim = str.trim();
            this.f2064a = trim;
            this.f2066c = trim.length();
        }

        void A() {
            while (true) {
                int i3 = this.f2065b;
                if (i3 >= this.f2066c || !k(this.f2064a.charAt(i3))) {
                    return;
                } else {
                    this.f2065b++;
                }
            }
        }

        int a() {
            int i3 = this.f2065b;
            int i4 = this.f2066c;
            if (i3 == i4) {
                return -1;
            }
            int i5 = i3 + 1;
            this.f2065b = i5;
            if (i5 < i4) {
                return this.f2064a.charAt(i5);
            }
            return -1;
        }

        String b() {
            int i3 = this.f2065b;
            while (!h() && !k(this.f2064a.charAt(this.f2065b))) {
                this.f2065b++;
            }
            String substring = this.f2064a.substring(i3, this.f2065b);
            this.f2065b = i3;
            return substring;
        }

        Boolean c(Object obj) {
            if (obj == null) {
                return null;
            }
            z();
            return m();
        }

        float d(float f3) {
            if (Float.isNaN(f3)) {
                return Float.NaN;
            }
            z();
            return n();
        }

        float e(Boolean bool) {
            if (bool == null) {
                return Float.NaN;
            }
            z();
            return n();
        }

        boolean f(char c3) {
            int i3 = this.f2065b;
            boolean z3 = i3 < this.f2066c && this.f2064a.charAt(i3) == c3;
            if (z3) {
                this.f2065b++;
            }
            return z3;
        }

        boolean g(String str) {
            int length = str.length();
            int i3 = this.f2065b;
            boolean z3 = i3 <= this.f2066c - length && this.f2064a.substring(i3, i3 + length).equals(str);
            if (z3) {
                this.f2065b += length;
            }
            return z3;
        }

        boolean h() {
            return this.f2065b == this.f2066c;
        }

        boolean i() {
            int i3 = this.f2065b;
            if (i3 == this.f2066c) {
                return false;
            }
            char charAt = this.f2064a.charAt(i3);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        boolean j(int i3) {
            return i3 == 10 || i3 == 13;
        }

        boolean k(int i3) {
            return i3 == 32 || i3 == 10 || i3 == 13 || i3 == 9;
        }

        Integer l() {
            int i3 = this.f2065b;
            if (i3 == this.f2066c) {
                return null;
            }
            String str = this.f2064a;
            this.f2065b = i3 + 1;
            return Integer.valueOf(str.charAt(i3));
        }

        Boolean m() {
            int i3 = this.f2065b;
            if (i3 == this.f2066c) {
                return null;
            }
            char charAt = this.f2064a.charAt(i3);
            if (charAt != '0' && charAt != '1') {
                return null;
            }
            this.f2065b++;
            return Boolean.valueOf(charAt == '1');
        }

        float n() {
            float b4 = this.f2067d.b(this.f2064a, this.f2065b, this.f2066c);
            if (!Float.isNaN(b4)) {
                this.f2065b = this.f2067d.a();
            }
            return b4;
        }

        String o() {
            if (h()) {
                return null;
            }
            int i3 = this.f2065b;
            int charAt = this.f2064a.charAt(i3);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = a();
            }
            int i4 = this.f2065b;
            while (k(charAt)) {
                charAt = a();
            }
            if (charAt == 40) {
                this.f2065b++;
                return this.f2064a.substring(i3, i4);
            }
            this.f2065b = i3;
            return null;
        }

        g.p p() {
            float n3 = n();
            if (Float.isNaN(n3)) {
                return null;
            }
            g.d1 v3 = v();
            return v3 == null ? new g.p(n3, g.d1.px) : new g.p(n3, v3);
        }

        String q() {
            int a4;
            if (h()) {
                return null;
            }
            int i3 = this.f2065b;
            char charAt = this.f2064a.charAt(i3);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            do {
                a4 = a();
                if (a4 == -1) {
                    break;
                }
            } while (a4 != charAt);
            if (a4 == -1) {
                this.f2065b = i3;
                return null;
            }
            int i4 = this.f2065b + 1;
            this.f2065b = i4;
            return this.f2064a.substring(i3 + 1, i4 - 1);
        }

        String r() {
            return t(' ', false);
        }

        String s(char c3) {
            return t(c3, false);
        }

        String t(char c3, boolean z3) {
            if (h()) {
                return null;
            }
            char charAt = this.f2064a.charAt(this.f2065b);
            if ((!z3 && k(charAt)) || charAt == c3) {
                return null;
            }
            int i3 = this.f2065b;
            while (true) {
                int a4 = a();
                if (a4 == -1 || a4 == c3 || (!z3 && k(a4))) {
                    break;
                }
            }
            return this.f2064a.substring(i3, this.f2065b);
        }

        String u(char c3) {
            return t(c3, true);
        }

        g.d1 v() {
            if (h()) {
                return null;
            }
            if (this.f2064a.charAt(this.f2065b) == '%') {
                this.f2065b++;
                return g.d1.percent;
            }
            int i3 = this.f2065b;
            if (i3 > this.f2066c - 2) {
                return null;
            }
            try {
                g.d1 valueOf = g.d1.valueOf(this.f2064a.substring(i3, i3 + 2).toLowerCase(Locale.US));
                this.f2065b += 2;
                return valueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        String w() {
            if (h()) {
                return null;
            }
            int i3 = this.f2065b;
            char charAt = this.f2064a.charAt(i3);
            if ((charAt < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z')) {
                this.f2065b = i3;
                return null;
            }
            while (true) {
                int a4 = a();
                if (a4 < 65 || a4 > 90) {
                    if (a4 < 97 || a4 > 122) {
                        break;
                    }
                }
            }
            return this.f2064a.substring(i3, this.f2065b);
        }

        float x() {
            z();
            float b4 = this.f2067d.b(this.f2064a, this.f2065b, this.f2066c);
            if (!Float.isNaN(b4)) {
                this.f2065b = this.f2067d.a();
            }
            return b4;
        }

        String y() {
            if (h()) {
                return null;
            }
            int i3 = this.f2065b;
            this.f2065b = this.f2066c;
            return this.f2064a.substring(i3);
        }

        boolean z() {
            A();
            int i3 = this.f2065b;
            if (i3 == this.f2066c || this.f2064a.charAt(i3) != ',') {
                return false;
            }
            this.f2065b++;
            A();
            return true;
        }
    }

    private class j implements Attributes {

        /* renamed from: a, reason: collision with root package name */
        private XmlPullParser f2068a;

        public j(XmlPullParser xmlPullParser) {
            this.f2068a = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.f2068a.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i3) {
            return this.f2068a.getAttributeName(i3);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i3) {
            String attributeName = this.f2068a.getAttributeName(i3);
            if (this.f2068a.getAttributePrefix(i3) == null) {
                return attributeName;
            }
            return this.f2068a.getAttributePrefix(i3) + ':' + attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i3) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i3) {
            return this.f2068a.getAttributeNamespace(i3);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i3) {
            return this.f2068a.getAttributeValue(i3);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }
    }

    k() {
    }

    private void A(g.d dVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 12:
                    dVar.f1740o = o0(trim);
                    break;
                case 13:
                    dVar.f1741p = o0(trim);
                    break;
                case 14:
                    g.p o02 = o0(trim);
                    dVar.f1742q = o02;
                    if (o02.g()) {
                        throw new c0.j("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private static Set<String> A0(String str) {
        i iVar = new i(str);
        HashSet hashSet = new HashSet();
        while (!iVar.h()) {
            hashSet.add(iVar.r());
            iVar.A();
        }
        return hashSet;
    }

    private void B(g.e eVar, Attributes attributes) {
        Boolean bool;
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(trim)) {
                    bool = Boolean.FALSE;
                } else {
                    if (!"userSpaceOnUse".equals(trim)) {
                        throw new c0.j("Invalid value for attribute clipPathUnits");
                    }
                    bool = Boolean.TRUE;
                }
                eVar.f1754p = bool;
            }
        }
    }

    private static g.p[] B0(String str) {
        g.p p3;
        i iVar = new i(str);
        iVar.A();
        if (iVar.h() || (p3 = iVar.p()) == null || p3.g()) {
            return null;
        }
        float a4 = p3.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(p3);
        while (!iVar.h()) {
            iVar.z();
            g.p p4 = iVar.p();
            if (p4 == null || p4.g()) {
                return null;
            }
            arrayList.add(p4);
            a4 += p4.a();
        }
        if (a4 == BitmapDescriptorFactory.HUE_RED) {
            return null;
        }
        return (g.p[]) arrayList.toArray(new g.p[arrayList.size()]);
    }

    private void C(g.g0 g0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 21:
                    g0Var.g(z0(trim));
                    break;
                case 22:
                    g0Var.h(trim);
                    break;
                case 23:
                    g0Var.k(F0(trim));
                    break;
                case 24:
                    g0Var.c(A0(trim));
                    break;
                case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                    List<String> i02 = i0(trim);
                    g0Var.e(i02 != null ? new HashSet(i02) : new HashSet(0));
                    break;
            }
        }
    }

    private static g.e0.c C0(String str) {
        if ("butt".equals(str)) {
            return g.e0.c.Butt;
        }
        if ("round".equals(str)) {
            return g.e0.c.Round;
        }
        if ("square".equals(str)) {
            return g.e0.c.Square;
        }
        return null;
    }

    private void D(g.l0 l0Var, Attributes attributes) {
        Boolean bool;
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String qName = attributes.getQName(i3);
            if (qName.equals("id") || qName.equals("xml:id")) {
                l0Var.f1853c = attributes.getValue(i3).trim();
                return;
            }
            if (qName.equals("xml:space")) {
                String trim = attributes.getValue(i3).trim();
                if ("default".equals(trim)) {
                    bool = Boolean.FALSE;
                } else {
                    if (!"preserve".equals(trim)) {
                        throw new c0.j("Invalid value for \"xml:space\" attribute: " + trim);
                    }
                    bool = Boolean.TRUE;
                }
                l0Var.f1854d = bool;
                return;
            }
        }
    }

    private static g.e0.d D0(String str) {
        if ("miter".equals(str)) {
            return g.e0.d.Miter;
        }
        if ("round".equals(str)) {
            return g.e0.d.Round;
        }
        if ("bevel".equals(str)) {
            return g.e0.d.Bevel;
        }
        return null;
    }

    private void E(g.i iVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 10:
                    g.p o02 = o0(trim);
                    iVar.f1835q = o02;
                    if (o02.g()) {
                        throw new c0.j("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case 11:
                    g.p o03 = o0(trim);
                    iVar.f1836r = o03;
                    if (o03.g()) {
                        throw new c0.j("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case 12:
                    iVar.f1833o = o0(trim);
                    break;
                case 13:
                    iVar.f1834p = o0(trim);
                    break;
            }
        }
    }

    private static void E0(g.l0 l0Var, String str) {
        i iVar = new i(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String s3 = iVar.s(':');
            iVar.A();
            if (!iVar.f(':')) {
                return;
            }
            iVar.A();
            String u3 = iVar.u(';');
            if (u3 == null) {
                return;
            }
            iVar.A();
            if (iVar.h() || iVar.f(';')) {
                if (l0Var.f1856f == null) {
                    l0Var.f1856f = new g.e0();
                }
                S0(l0Var.f1856f, s3, u3);
                iVar.A();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void F(c0.g.j r5, org.xml.sax.Attributes r6) {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L8e
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = c0.k.a.f1986b
            java.lang.String r3 = r6.getLocalName(r0)
            c0.k$g r3 = c0.k.g.a(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 6
            if (r2 == r3) goto L70
            switch(r2) {
                case 32: goto L50;
                case 33: goto L49;
                case 34: goto L26;
                default: goto L25;
            }
        L25:
            goto L8a
        L26:
            c0.g$k r2 = c0.g.k.valueOf(r1)     // Catch: java.lang.IllegalArgumentException -> L2d
            r5.f1845k = r2     // Catch: java.lang.IllegalArgumentException -> L2d
            goto L8a
        L2d:
            c0.j r5 = new c0.j
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Invalid spreadMethod attribute. \""
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "\" is not a valid value."
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L49:
            android.graphics.Matrix r1 = r4.J0(r1)
            r5.f1844j = r1
            goto L8a
        L50:
            java.lang.String r2 = "objectBoundingBox"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L5d
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
        L5a:
            r5.f1843i = r1
            goto L8a
        L5d:
            java.lang.String r2 = "userSpaceOnUse"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L68
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            goto L5a
        L68:
            c0.j r5 = new c0.j
            java.lang.String r6 = "Invalid value for attribute gradientUnits"
            r5.<init>(r6)
            throw r5
        L70:
            java.lang.String r2 = r6.getURI(r0)
            java.lang.String r3 = ""
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L88
            java.lang.String r2 = r6.getURI(r0)
            java.lang.String r3 = "http://www.w3.org/1999/xlink"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L8a
        L88:
            r5.f1846l = r1
        L8a:
            int r0 = r0 + 1
            goto L1
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.k.F(c0.g$j, org.xml.sax.Attributes):void");
    }

    private static Set<String> F0(String str) {
        i iVar = new i(str);
        HashSet hashSet = new HashSet();
        while (!iVar.h()) {
            String r3 = iVar.r();
            int indexOf = r3.indexOf(45);
            if (indexOf != -1) {
                r3 = r3.substring(0, indexOf);
            }
            hashSet.add(new Locale(r3, "", "").getLanguage());
            iVar.A();
        }
        return hashSet;
    }

    private void G(g.o oVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                oVar.f1866q = o0(trim);
            } else if (i4 == 2) {
                oVar.f1867r = o0(trim);
            } else if (i4 == 3) {
                g.p o02 = o0(trim);
                oVar.f1868s = o02;
                if (o02.g()) {
                    throw new c0.j("Invalid <use> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                g.p o03 = o0(trim);
                oVar.f1869t = o03;
                if (o03.g()) {
                    throw new c0.j("Invalid <use> element. height cannot be negative");
                }
            } else if (i4 != 6) {
                if (i4 == 7) {
                    w0(oVar, trim);
                }
            } else if ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3))) {
                oVar.f1865p = trim;
            }
        }
    }

    private static g.e0.f G0(String str) {
        str.hashCode();
        switch (str) {
            case "middle":
                return g.e0.f.Middle;
            case "end":
                return g.e0.f.End;
            case "start":
                return g.e0.f.Start;
            default:
                return null;
        }
    }

    private void H(g.q qVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 15:
                    qVar.f1874o = o0(trim);
                    break;
                case 16:
                    qVar.f1875p = o0(trim);
                    break;
                case 17:
                    qVar.f1876q = o0(trim);
                    break;
                case 18:
                    qVar.f1877r = o0(trim);
                    break;
            }
        }
    }

    private static g.e0.EnumC0043g H0(String str) {
        str.hashCode();
        switch (str) {
            case "line-through":
                return g.e0.EnumC0043g.LineThrough;
            case "underline":
                return g.e0.EnumC0043g.Underline;
            case "none":
                return g.e0.EnumC0043g.None;
            case "blink":
                return g.e0.EnumC0043g.Blink;
            case "overline":
                return g.e0.EnumC0043g.Overline;
            default:
                return null;
        }
    }

    private void I(g.m0 m0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case 15:
                    m0Var.f1859m = o0(trim);
                    break;
                case 16:
                    m0Var.f1860n = o0(trim);
                    break;
                case 17:
                    m0Var.f1861o = o0(trim);
                    break;
                case 18:
                    m0Var.f1862p = o0(trim);
                    break;
            }
        }
    }

    private static g.e0.h I0(String str) {
        str.hashCode();
        if (str.equals("ltr")) {
            return g.e0.h.LTR;
        }
        if (str.equals("rtl")) {
            return g.e0.h.RTL;
        }
        return null;
    }

    private void J(g.r rVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            switch (a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()]) {
                case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                    rVar.f1884r = o0(trim);
                    break;
                case 27:
                    rVar.f1885s = o0(trim);
                    break;
                case 28:
                    g.p o02 = o0(trim);
                    rVar.f1886t = o02;
                    if (o02.g()) {
                        throw new c0.j("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case 29:
                    g.p o03 = o0(trim);
                    rVar.f1887u = o03;
                    if (o03.g()) {
                        throw new c0.j("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case 30:
                    if (!"strokeWidth".equals(trim)) {
                        if (!"userSpaceOnUse".equals(trim)) {
                            throw new c0.j("Invalid value for attribute markerUnits");
                        }
                        rVar.f1883q = true;
                        break;
                    } else {
                        rVar.f1883q = false;
                        break;
                    }
                case 31:
                    rVar.f1888v = Float.valueOf("auto".equals(trim) ? Float.NaN : f0(trim));
                    break;
            }
        }
    }

    private Matrix J0(String str) {
        Matrix matrix = new Matrix();
        i iVar = new i(str);
        iVar.A();
        while (!iVar.h()) {
            String o3 = iVar.o();
            if (o3 == null) {
                throw new c0.j("Bad transform function encountered in transform list: " + str);
            }
            switch (o3) {
                case "matrix":
                    iVar.A();
                    float n3 = iVar.n();
                    iVar.z();
                    float n4 = iVar.n();
                    iVar.z();
                    float n5 = iVar.n();
                    iVar.z();
                    float n6 = iVar.n();
                    iVar.z();
                    float n7 = iVar.n();
                    iVar.z();
                    float n8 = iVar.n();
                    iVar.A();
                    if (!Float.isNaN(n8) && iVar.f(')')) {
                        Matrix matrix2 = new Matrix();
                        matrix2.setValues(new float[]{n3, n5, n7, n4, n6, n8, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f});
                        matrix.preConcat(matrix2);
                        break;
                    } else {
                        throw new c0.j("Invalid transform list: " + str);
                    }
                    break;
                case "rotate":
                    iVar.A();
                    float n9 = iVar.n();
                    float x3 = iVar.x();
                    float x4 = iVar.x();
                    iVar.A();
                    if (Float.isNaN(n9) || !iVar.f(')')) {
                        throw new c0.j("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(x3)) {
                        matrix.preRotate(n9);
                        break;
                    } else if (!Float.isNaN(x4)) {
                        matrix.preRotate(n9, x3, x4);
                        break;
                    } else {
                        throw new c0.j("Invalid transform list: " + str);
                    }
                case "scale":
                    iVar.A();
                    float n10 = iVar.n();
                    float x5 = iVar.x();
                    iVar.A();
                    if (!Float.isNaN(n10) && iVar.f(')')) {
                        if (!Float.isNaN(x5)) {
                            matrix.preScale(n10, x5);
                            break;
                        } else {
                            matrix.preScale(n10, n10);
                            break;
                        }
                    } else {
                        throw new c0.j("Invalid transform list: " + str);
                    }
                    break;
                case "skewX":
                    iVar.A();
                    float n11 = iVar.n();
                    iVar.A();
                    if (!Float.isNaN(n11) && iVar.f(')')) {
                        matrix.preSkew((float) Math.tan(Math.toRadians(n11)), BitmapDescriptorFactory.HUE_RED);
                        break;
                    } else {
                        throw new c0.j("Invalid transform list: " + str);
                    }
                    break;
                case "skewY":
                    iVar.A();
                    float n12 = iVar.n();
                    iVar.A();
                    if (!Float.isNaN(n12) && iVar.f(')')) {
                        matrix.preSkew(BitmapDescriptorFactory.HUE_RED, (float) Math.tan(Math.toRadians(n12)));
                        break;
                    } else {
                        throw new c0.j("Invalid transform list: " + str);
                    }
                case "translate":
                    iVar.A();
                    float n13 = iVar.n();
                    float x6 = iVar.x();
                    iVar.A();
                    if (!Float.isNaN(n13) && iVar.f(')')) {
                        if (!Float.isNaN(x6)) {
                            matrix.preTranslate(n13, x6);
                            break;
                        } else {
                            matrix.preTranslate(n13, BitmapDescriptorFactory.HUE_RED);
                            break;
                        }
                    } else {
                        throw new c0.j("Invalid transform list: " + str);
                    }
                    break;
                default:
                    throw new c0.j("Invalid transform list fn: " + o3 + ")");
            }
            if (iVar.h()) {
                return matrix;
            }
            iVar.z();
        }
        return matrix;
    }

    private void K(g.s sVar, Attributes attributes) {
        Boolean bool;
        Boolean bool2;
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                sVar.f1892q = o0(trim);
            } else if (i4 == 2) {
                sVar.f1893r = o0(trim);
            } else if (i4 == 3) {
                g.p o02 = o0(trim);
                sVar.f1894s = o02;
                if (o02.g()) {
                    throw new c0.j("Invalid <mask> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                g.p o03 = o0(trim);
                sVar.f1895t = o03;
                if (o03.g()) {
                    throw new c0.j("Invalid <mask> element. height cannot be negative");
                }
            } else if (i4 == 43) {
                if ("objectBoundingBox".equals(trim)) {
                    bool = Boolean.FALSE;
                } else {
                    if (!"userSpaceOnUse".equals(trim)) {
                        throw new c0.j("Invalid value for attribute maskUnits");
                    }
                    bool = Boolean.TRUE;
                }
                sVar.f1890o = bool;
            } else if (i4 == 44) {
                if ("objectBoundingBox".equals(trim)) {
                    bool2 = Boolean.FALSE;
                } else {
                    if (!"userSpaceOnUse".equals(trim)) {
                        throw new c0.j("Invalid value for attribute maskContentUnits");
                    }
                    bool2 = Boolean.TRUE;
                }
                sVar.f1891p = bool2;
            } else {
                continue;
            }
        }
    }

    private void K0(InputStream inputStream) {
        Log.d("SVGParser", "Falling back to SAX parser");
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            f fVar = new f(this, null);
            xMLReader.setContentHandler(fVar);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", fVar);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e3) {
            throw new c0.j("Stream error", e3);
        } catch (ParserConfigurationException e4) {
            throw new c0.j("XML parser problem", e4);
        } catch (SAXException e5) {
            throw new c0.j("SVG parse error", e5);
        }
    }

    private void L(g.v vVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 8) {
                vVar.f1900o = u0(trim);
            } else if (i4 != 9) {
                continue;
            } else {
                Float valueOf = Float.valueOf(f0(trim));
                vVar.f1901p = valueOf;
                if (valueOf.floatValue() < BitmapDescriptorFactory.HUE_RED) {
                    throw new c0.j("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    private void L0(InputStream inputStream, boolean z3) {
        try {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                j jVar = new j(newPullParser);
                newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, false);
                newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
                newPullParser.setInput(inputStream, null);
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                    if (eventType == 0) {
                        W0();
                    } else if (eventType == 8) {
                        Log.d("SVGParser", "PROC INSTR: " + newPullParser.getText());
                        i iVar = new i(newPullParser.getText());
                        r(iVar.r(), x0(iVar));
                    } else if (eventType != 10) {
                        if (eventType == 2) {
                            String name = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name = newPullParser.getPrefix() + ':' + name;
                            }
                            X0(newPullParser.getNamespace(), newPullParser.getName(), name, jVar);
                        } else if (eventType == 3) {
                            String name2 = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name2 = newPullParser.getPrefix() + ':' + name2;
                            }
                            p(newPullParser.getNamespace(), newPullParser.getName(), name2);
                        } else if (eventType == 4) {
                            int[] iArr = new int[2];
                            e1(newPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                        } else if (eventType == 5) {
                            c1(newPullParser.getText());
                        }
                    } else if (z3 && this.f1976a.i() == null && newPullParser.getText().contains("<!ENTITY ")) {
                        try {
                            Log.d("SVGParser", "Switching to SAX parser to process entities");
                            inputStream.reset();
                            K0(inputStream);
                            return;
                        } catch (IOException unused) {
                            Log.w("SVGParser", "Detected internal entity definitions, but could not parse them.");
                            return;
                        }
                    }
                }
                o();
            } catch (IOException e3) {
                throw new c0.j("Stream error", e3);
            }
        } catch (XmlPullParserException e4) {
            throw new c0.j("XML parser problem", e4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ca, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void M(c0.g.y r6, org.xml.sax.Attributes r7) {
        /*
            r5 = this;
            r0 = 0
        L1:
            int r1 = r7.getLength()
            if (r0 >= r1) goto Lce
            java.lang.String r1 = r7.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = c0.k.a.f1986b
            java.lang.String r3 = r7.getLocalName(r0)
            c0.k$g r3 = c0.k.g.a(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto Lc4
            r3 = 2
            if (r2 == r3) goto Lbd
            r3 = 3
            if (r2 == r3) goto La8
            r3 = 4
            if (r2 == r3) goto L93
            r3 = 6
            if (r2 == r3) goto L78
            java.lang.String r3 = "userSpaceOnUse"
            java.lang.String r4 = "objectBoundingBox"
            switch(r2) {
                case 40: goto L5c;
                case 41: goto L3f;
                case 42: goto L37;
                default: goto L35;
            }
        L35:
            goto Lca
        L37:
            android.graphics.Matrix r1 = r5.J0(r1)
            r6.f1910s = r1
            goto Lca
        L3f:
            boolean r2 = r4.equals(r1)
            if (r2 == 0) goto L4b
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
        L47:
            r6.f1909r = r1
            goto Lca
        L4b:
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L54
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            goto L47
        L54:
            c0.j r6 = new c0.j
            java.lang.String r7 = "Invalid value for attribute patternContentUnits"
            r6.<init>(r7)
            throw r6
        L5c:
            boolean r2 = r4.equals(r1)
            if (r2 == 0) goto L67
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
        L64:
            r6.f1908q = r1
            goto Lca
        L67:
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L70
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            goto L64
        L70:
            c0.j r6 = new c0.j
            java.lang.String r7 = "Invalid value for attribute patternUnits"
            r6.<init>(r7)
            throw r6
        L78:
            java.lang.String r2 = r7.getURI(r0)
            java.lang.String r3 = ""
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L90
            java.lang.String r2 = r7.getURI(r0)
            java.lang.String r3 = "http://www.w3.org/1999/xlink"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto Lca
        L90:
            r6.f1915x = r1
            goto Lca
        L93:
            c0.g$p r1 = o0(r1)
            r6.f1914w = r1
            boolean r1 = r1.g()
            if (r1 != 0) goto La0
            goto Lca
        La0:
            c0.j r6 = new c0.j
            java.lang.String r7 = "Invalid <pattern> element. height cannot be negative"
            r6.<init>(r7)
            throw r6
        La8:
            c0.g$p r1 = o0(r1)
            r6.f1913v = r1
            boolean r1 = r1.g()
            if (r1 != 0) goto Lb5
            goto Lca
        Lb5:
            c0.j r6 = new c0.j
            java.lang.String r7 = "Invalid <pattern> element. width cannot be negative"
            r6.<init>(r7)
            throw r6
        Lbd:
            c0.g$p r1 = o0(r1)
            r6.f1912u = r1
            goto Lca
        Lc4:
            c0.g$p r1 = o0(r1)
            r6.f1911t = r1
        Lca:
            int r0 = r0 + 1
            goto L1
        Lce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.k.M(c0.g$y, org.xml.sax.Attributes):void");
    }

    private static g.e0.i M0(String str) {
        str.hashCode();
        if (str.equals(DevicePublicKeyStringDef.NONE)) {
            return g.e0.i.None;
        }
        if (str.equals("non-scaling-stroke")) {
            return g.e0.i.NonScalingStroke;
        }
        return null;
    }

    private void N(g.z zVar, Attributes attributes, String str) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            if (g.a(attributes.getLocalName(i3)) == g.points) {
                i iVar = new i(attributes.getValue(i3));
                ArrayList arrayList = new ArrayList();
                iVar.A();
                while (!iVar.h()) {
                    float n3 = iVar.n();
                    if (Float.isNaN(n3)) {
                        throw new c0.j("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    iVar.z();
                    float n4 = iVar.n();
                    if (Float.isNaN(n4)) {
                        throw new c0.j("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    iVar.z();
                    arrayList.add(Float.valueOf(n3));
                    arrayList.add(Float.valueOf(n4));
                }
                zVar.f1916o = new float[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    zVar.f1916o[i4] = ((Float) it.next()).floatValue();
                    i4++;
                }
            }
        }
    }

    private static g.b N0(String str) {
        i iVar = new i(str);
        iVar.A();
        float n3 = iVar.n();
        iVar.z();
        float n4 = iVar.n();
        iVar.z();
        float n5 = iVar.n();
        iVar.z();
        float n6 = iVar.n();
        if (Float.isNaN(n3) || Float.isNaN(n4) || Float.isNaN(n5) || Float.isNaN(n6)) {
            throw new c0.j("Invalid viewBox definition - should have four numbers");
        }
        if (n5 < BitmapDescriptorFactory.HUE_RED) {
            throw new c0.j("Invalid viewBox. width cannot be negative");
        }
        if (n6 >= BitmapDescriptorFactory.HUE_RED) {
            return new g.b(n3, n4, n5, n6);
        }
        throw new c0.j("Invalid viewBox. height cannot be negative");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void O(c0.g.q0 r5, org.xml.sax.Attributes r6) {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L5e
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = c0.k.a.f1986b
            java.lang.String r3 = r6.getLocalName(r0)
            c0.k$g r3 = c0.k.g.a(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 35
            if (r2 == r3) goto L55
            r3 = 36
            if (r2 == r3) goto L4e
            switch(r2) {
                case 12: goto L47;
                case 13: goto L40;
                case 14: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L5b
        L2b:
            c0.g$p r1 = o0(r1)
            r5.f1880o = r1
            boolean r1 = r1.g()
            if (r1 != 0) goto L38
            goto L5b
        L38:
            c0.j r5 = new c0.j
            java.lang.String r6 = "Invalid <radialGradient> element. r cannot be negative"
            r5.<init>(r6)
            throw r5
        L40:
            c0.g$p r1 = o0(r1)
            r5.f1879n = r1
            goto L5b
        L47:
            c0.g$p r1 = o0(r1)
            r5.f1878m = r1
            goto L5b
        L4e:
            c0.g$p r1 = o0(r1)
            r5.f1882q = r1
            goto L5b
        L55:
            c0.g$p r1 = o0(r1)
            r5.f1881p = r1
        L5b:
            int r0 = r0 + 1
            goto L1
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.k.O(c0.g$q0, org.xml.sax.Attributes):void");
    }

    private void O0(Attributes attributes) {
        l("<path>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.v vVar = new g.v();
        vVar.f1863a = this.f1976a;
        vVar.f1864b = this.f1977b;
        D(vVar, attributes);
        S(vVar, attributes);
        W(vVar, attributes);
        C(vVar, attributes);
        L(vVar, attributes);
        this.f1977b.i(vVar);
    }

    private void P(g.b0 b0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                b0Var.f1728o = o0(trim);
            } else if (i4 == 2) {
                b0Var.f1729p = o0(trim);
            } else if (i4 == 3) {
                g.p o02 = o0(trim);
                b0Var.f1730q = o02;
                if (o02.g()) {
                    throw new c0.j("Invalid <rect> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                g.p o03 = o0(trim);
                b0Var.f1731r = o03;
                if (o03.g()) {
                    throw new c0.j("Invalid <rect> element. height cannot be negative");
                }
            } else if (i4 == 10) {
                g.p o04 = o0(trim);
                b0Var.f1732s = o04;
                if (o04.g()) {
                    throw new c0.j("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i4 != 11) {
                continue;
            } else {
                g.p o05 = o0(trim);
                b0Var.f1733t = o05;
                if (o05.g()) {
                    throw new c0.j("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void P0(Attributes attributes) {
        l("<pattern>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.y yVar = new g.y();
        yVar.f1863a = this.f1976a;
        yVar.f1864b = this.f1977b;
        D(yVar, attributes);
        S(yVar, attributes);
        C(yVar, attributes);
        Y(yVar, attributes);
        M(yVar, attributes);
        this.f1977b.i(yVar);
        this.f1977b = yVar;
    }

    private void Q(g.f0 f0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                f0Var.f1821q = o0(trim);
            } else if (i4 == 2) {
                f0Var.f1822r = o0(trim);
            } else if (i4 == 3) {
                g.p o02 = o0(trim);
                f0Var.f1823s = o02;
                if (o02.g()) {
                    throw new c0.j("Invalid <svg> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                g.p o03 = o0(trim);
                f0Var.f1824t = o03;
                if (o03.g()) {
                    throw new c0.j("Invalid <svg> element. height cannot be negative");
                }
            } else if (i4 == 5) {
                f0Var.f1825u = trim;
            }
        }
    }

    private void Q0(Attributes attributes) {
        l("<polygon>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.z a0Var = new g.a0();
        a0Var.f1863a = this.f1976a;
        a0Var.f1864b = this.f1977b;
        D(a0Var, attributes);
        S(a0Var, attributes);
        W(a0Var, attributes);
        C(a0Var, attributes);
        N(a0Var, attributes, "polygon");
        this.f1977b.i(a0Var);
    }

    private void R(g.d0 d0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()] == 37) {
                d0Var.f1743h = n0(trim);
            }
        }
    }

    private void R0(Attributes attributes) {
        l("<polyline>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.z zVar = new g.z();
        zVar.f1863a = this.f1976a;
        zVar.f1864b = this.f1977b;
        D(zVar, attributes);
        S(zVar, attributes);
        W(zVar, attributes);
        C(zVar, attributes);
        N(zVar, attributes, "polyline");
        this.f1977b.i(zVar);
    }

    private void S(g.l0 l0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (trim.length() != 0) {
                int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
                if (i4 == 45) {
                    E0(l0Var, trim);
                } else if (i4 != 46) {
                    if (l0Var.f1855e == null) {
                        l0Var.f1855e = new g.e0();
                    }
                    S0(l0Var.f1855e, attributes.getLocalName(i3), attributes.getValue(i3).trim());
                } else {
                    l0Var.f1857g = c0.b.f(trim);
                }
            }
        }
    }

    static void S0(g.e0 e0Var, String str, String str2) {
        long j3;
        long j4;
        long j5;
        long j6;
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        try {
            try {
                switch (a.f1986b[g.a(str).ordinal()]) {
                    case 47:
                        g.o0 t02 = t0(str2);
                        e0Var.f1756d = t02;
                        if (t02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 1;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 48:
                        g.e0.a e02 = e0(str2);
                        e0Var.f1757f = e02;
                        if (e02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 2;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 49:
                        Float r02 = r0(str2);
                        e0Var.f1758g = r02;
                        if (r02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 4;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 50:
                        g.o0 t03 = t0(str2);
                        e0Var.f1759h = t03;
                        if (t03 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 8;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 51:
                        Float r03 = r0(str2);
                        e0Var.f1760i = r03;
                        if (r03 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 16;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 52:
                        e0Var.f1761j = o0(str2);
                        j5 = e0Var.f1755c;
                        j6 = 32;
                        e0Var.f1755c = j5 | j6;
                        break;
                    case 53:
                        g.e0.c C0 = C0(str2);
                        e0Var.f1762k = C0;
                        if (C0 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 64;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 54:
                        g.e0.d D0 = D0(str2);
                        e0Var.f1763l = D0;
                        if (D0 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 128;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 55:
                        e0Var.f1764m = Float.valueOf(f0(str2));
                        j5 = e0Var.f1755c;
                        j6 = 256;
                        e0Var.f1755c = j5 | j6;
                        break;
                    case 56:
                        j4 = 512;
                        if (DevicePublicKeyStringDef.NONE.equals(str2)) {
                            e0Var.f1765n = null;
                        } else {
                            g.p[] B0 = B0(str2);
                            e0Var.f1765n = B0;
                            if (B0 == null) {
                            }
                        }
                        j3 = e0Var.f1755c;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 57:
                        e0Var.f1766o = o0(str2);
                        j5 = e0Var.f1755c;
                        j6 = FileUtils.ONE_KB;
                        e0Var.f1755c = j5 | j6;
                        break;
                    case 58:
                        e0Var.f1767p = r0(str2);
                        j3 = e0Var.f1755c;
                        j4 = 2048;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 59:
                        e0Var.f1768q = b0(str2);
                        j5 = e0Var.f1755c;
                        j6 = 4096;
                        e0Var.f1755c = j5 | j6;
                        break;
                    case 60:
                        h0(e0Var, str2);
                        break;
                    case 61:
                        List<String> i02 = i0(str2);
                        e0Var.f1769r = i02;
                        if (i02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 8192;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 62:
                        g.p j02 = j0(str2);
                        e0Var.f1770s = j02;
                        if (j02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 16384;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 63:
                        Integer l02 = l0(str2);
                        e0Var.f1771t = l02;
                        if (l02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 32768;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 64:
                        g.e0.b k02 = k0(str2);
                        e0Var.f1772u = k02;
                        if (k02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 65536;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 65:
                        g.e0.EnumC0043g H0 = H0(str2);
                        e0Var.f1773v = H0;
                        if (H0 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 131072;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case Wbxml.EXT_I_2 /* 66 */:
                        g.e0.h I0 = I0(str2);
                        e0Var.f1774w = I0;
                        if (I0 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 68719476736L;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case Wbxml.PI /* 67 */:
                        g.e0.f G0 = G0(str2);
                        e0Var.f1775x = G0;
                        if (G0 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 262144;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case Wbxml.LITERAL_C /* 68 */:
                        Boolean s02 = s0(str2);
                        e0Var.f1776y = s02;
                        if (s02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 524288;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 69:
                        String m02 = m0(str2, str);
                        e0Var.A = m02;
                        e0Var.B = m02;
                        e0Var.C = m02;
                        j3 = e0Var.f1755c;
                        j4 = 14680064;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 70:
                        e0Var.A = m0(str2, str);
                        j3 = e0Var.f1755c;
                        j4 = 2097152;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 71:
                        e0Var.B = m0(str2, str);
                        j3 = e0Var.f1755c;
                        j4 = 4194304;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 72:
                        e0Var.C = m0(str2, str);
                        j3 = e0Var.f1755c;
                        j4 = 8388608;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 73:
                        if (str2.indexOf(124) < 0) {
                            if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains('|' + str2 + '|')) {
                                e0Var.D = Boolean.valueOf(!str2.equals(DevicePublicKeyStringDef.NONE));
                                j3 = e0Var.f1755c;
                                j4 = 16777216;
                                e0Var.f1755c = j3 | j4;
                                break;
                            }
                        }
                        break;
                    case 74:
                        if (str2.indexOf(124) < 0) {
                            if ("|visible|hidden|collapse|".contains('|' + str2 + '|')) {
                                e0Var.E = Boolean.valueOf(str2.equals("visible"));
                                j3 = e0Var.f1755c;
                                j4 = 33554432;
                                e0Var.f1755c = j3 | j4;
                                break;
                            }
                        }
                        break;
                    case 75:
                        if (str2.equals("currentColor")) {
                            e0Var.F = g.C0044g.a();
                        } else {
                            e0Var.F = b0(str2);
                        }
                        j3 = e0Var.f1755c;
                        j4 = 67108864;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 76:
                        e0Var.G = r0(str2);
                        j3 = e0Var.f1755c;
                        j4 = 134217728;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 77:
                        g.c a02 = a0(str2);
                        e0Var.f1777z = a02;
                        if (a02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = FileUtils.ONE_MB;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 78:
                        e0Var.H = m0(str2, str);
                        j3 = e0Var.f1755c;
                        j4 = 268435456;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 79:
                        e0Var.I = e0(str2);
                        j3 = e0Var.f1755c;
                        j4 = 536870912;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 80:
                        e0Var.J = m0(str2, str);
                        j3 = e0Var.f1755c;
                        j4 = FileUtils.ONE_GB;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 81:
                        if (str2.equals("currentColor")) {
                            e0Var.K = g.C0044g.a();
                        } else {
                            e0Var.K = b0(str2);
                        }
                        j3 = e0Var.f1755c;
                        j4 = 2147483648L;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 82:
                        e0Var.L = r0(str2);
                        j3 = e0Var.f1755c;
                        j4 = 4294967296L;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 83:
                        if (str2.equals("currentColor")) {
                            e0Var.M = g.C0044g.a();
                        } else {
                            e0Var.M = b0(str2);
                        }
                        j3 = e0Var.f1755c;
                        j4 = 8589934592L;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 84:
                        e0Var.N = r0(str2);
                        j3 = e0Var.f1755c;
                        j4 = 17179869184L;
                        e0Var.f1755c = j3 | j4;
                        break;
                    case 85:
                        g.e0.i M0 = M0(str2);
                        e0Var.O = M0;
                        if (M0 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 34359738368L;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                    case 86:
                        g.e0.e y02 = y0(str2);
                        e0Var.P = y02;
                        if (y02 != null) {
                            j3 = e0Var.f1755c;
                            j4 = 137438953472L;
                            e0Var.f1755c = j3 | j4;
                            break;
                        }
                        break;
                }
            } catch (c0.j unused) {
            }
        } catch (c0.j e3) {
            Log.w("SVGParser", e3.getMessage());
        }
    }

    private void T(g.u0 u0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            if (a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()] == 6 && ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3)))) {
                u0Var.f1898o = trim;
            }
        }
    }

    private void T0(Attributes attributes) {
        l("<radialGradient>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.q0 q0Var = new g.q0();
        q0Var.f1863a = this.f1976a;
        q0Var.f1864b = this.f1977b;
        D(q0Var, attributes);
        S(q0Var, attributes);
        F(q0Var, attributes);
        O(q0Var, attributes);
        this.f1977b.i(q0Var);
        this.f1977b = q0Var;
    }

    private void U(g.z0 z0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 != 6) {
                if (i4 == 39) {
                    z0Var.f1918p = o0(trim);
                }
            } else if ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3))) {
                z0Var.f1917o = trim;
            }
        }
    }

    private void U0(Attributes attributes) {
        l("<rect>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.b0 b0Var = new g.b0();
        b0Var.f1863a = this.f1976a;
        b0Var.f1864b = this.f1977b;
        D(b0Var, attributes);
        S(b0Var, attributes);
        W(b0Var, attributes);
        C(b0Var, attributes);
        P(b0Var, attributes);
        this.f1977b.i(b0Var);
    }

    private void V(g.a1 a1Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                a1Var.f1720o = p0(trim);
            } else if (i4 == 2) {
                a1Var.f1721p = p0(trim);
            } else if (i4 == 19) {
                a1Var.f1722q = p0(trim);
            } else if (i4 == 20) {
                a1Var.f1723r = p0(trim);
            }
        }
    }

    private void V0(Attributes attributes) {
        l("<solidColor>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.c0 c0Var = new g.c0();
        c0Var.f1863a = this.f1976a;
        c0Var.f1864b = this.f1977b;
        D(c0Var, attributes);
        S(c0Var, attributes);
        this.f1977b.i(c0Var);
        this.f1977b = c0Var;
    }

    private void W(g.n nVar, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            if (g.a(attributes.getLocalName(i3)) == g.transform) {
                nVar.j(J0(attributes.getValue(i3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        this.f1976a = new c0.g();
    }

    private void X(g.e1 e1Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                e1Var.f1814q = o0(trim);
            } else if (i4 == 2) {
                e1Var.f1815r = o0(trim);
            } else if (i4 == 3) {
                g.p o02 = o0(trim);
                e1Var.f1816s = o02;
                if (o02.g()) {
                    throw new c0.j("Invalid <use> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                g.p o03 = o0(trim);
                e1Var.f1817t = o03;
                if (o03.g()) {
                    throw new c0.j("Invalid <use> element. height cannot be negative");
                }
            } else if (i4 == 6 && ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3)))) {
                e1Var.f1813p = trim;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(String str, String str2, String str3, Attributes attributes) {
        if (this.f1978c) {
            this.f1979d++;
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            h a4 = h.a(str2);
            switch (a.f1985a[a4.ordinal()]) {
                case 1:
                    a1(attributes);
                    break;
                case 2:
                case 3:
                    q(attributes);
                    break;
                case 4:
                    m(attributes);
                    break;
                case 5:
                    i1(attributes);
                    break;
                case 6:
                    O0(attributes);
                    break;
                case 7:
                    U0(attributes);
                    break;
                case 8:
                    i(attributes);
                    break;
                case 9:
                    n(attributes);
                    break;
                case 10:
                    v(attributes);
                    break;
                case 11:
                    R0(attributes);
                    break;
                case 12:
                    Q0(attributes);
                    break;
                case 13:
                    d1(attributes);
                    break;
                case 14:
                    h1(attributes);
                    break;
                case 15:
                    g1(attributes);
                    break;
                case 16:
                    k1(attributes);
                    break;
                case 17:
                    b1(attributes);
                    break;
                case 18:
                    x(attributes);
                    break;
                case 19:
                    w(attributes);
                    break;
                case 20:
                    T0(attributes);
                    break;
                case 21:
                    Y0(attributes);
                    break;
                case 22:
                case 23:
                    this.f1980e = true;
                    this.f1981f = a4;
                    break;
                case 24:
                    k(attributes);
                    break;
                case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                    f1(attributes);
                    break;
                case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                    P0(attributes);
                    break;
                case 27:
                    u(attributes);
                    break;
                case 28:
                    j1(attributes);
                    break;
                case 29:
                    y(attributes);
                    break;
                case 30:
                    Z0(attributes);
                    break;
                case 31:
                    V0(attributes);
                    break;
                default:
                    this.f1978c = true;
                    this.f1979d = 1;
                    break;
            }
        }
    }

    private void Y(g.r0 r0Var, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 7) {
                w0(r0Var, trim);
            } else if (i4 == 87) {
                r0Var.f1889p = N0(trim);
            }
        }
    }

    private void Y0(Attributes attributes) {
        l("<stop>", new Object[0]);
        g.j0 j0Var = this.f1977b;
        if (j0Var == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        if (!(j0Var instanceof g.j)) {
            throw new c0.j("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        g.d0 d0Var = new g.d0();
        d0Var.f1863a = this.f1976a;
        d0Var.f1864b = this.f1977b;
        D(d0Var, attributes);
        S(d0Var, attributes);
        R(d0Var, attributes);
        this.f1977b.i(d0Var);
        this.f1977b = d0Var;
    }

    private void Z(String str) {
        this.f1976a.a(new c0.b(b.f.screen, b.u.Document).d(str));
    }

    private void Z0(Attributes attributes) {
        l("<style>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        String str = "all";
        boolean z3 = true;
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String trim = attributes.getValue(i3).trim();
            int i4 = a.f1986b[g.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 88) {
                z3 = trim.equals("text/css");
            } else if (i4 == 89) {
                str = trim;
            }
        }
        if (z3 && c0.b.b(str, b.f.screen)) {
            this.f1983h = true;
        } else {
            this.f1978c = true;
            this.f1979d = 1;
        }
    }

    private static g.c a0(String str) {
        if ("auto".equals(str) || !str.startsWith("rect(")) {
            return null;
        }
        i iVar = new i(str.substring(5));
        iVar.A();
        g.p q02 = q0(iVar);
        iVar.z();
        g.p q03 = q0(iVar);
        iVar.z();
        g.p q04 = q0(iVar);
        iVar.z();
        g.p q05 = q0(iVar);
        iVar.A();
        if (iVar.f(')') || iVar.h()) {
            return new g.c(q02, q03, q04, q05);
        }
        return null;
    }

    private void a1(Attributes attributes) {
        l("<svg>", new Object[0]);
        g.f0 f0Var = new g.f0();
        f0Var.f1863a = this.f1976a;
        f0Var.f1864b = this.f1977b;
        D(f0Var, attributes);
        S(f0Var, attributes);
        C(f0Var, attributes);
        Y(f0Var, attributes);
        Q(f0Var, attributes);
        g.j0 j0Var = this.f1977b;
        if (j0Var == null) {
            this.f1976a.p(f0Var);
        } else {
            j0Var.i(f0Var);
        }
        this.f1977b = f0Var;
    }

    private static g.f b0(String str) {
        if (str.charAt(0) == '#') {
            c0.c b4 = c0.c.b(str, 1, str.length());
            if (b4 == null) {
                throw new c0.j("Bad hex colour value: " + str);
            }
            int a4 = b4.a();
            if (a4 == 4) {
                int d3 = b4.d();
                int i3 = d3 & 3840;
                int i4 = d3 & 240;
                int i5 = d3 & 15;
                return new g.f(i5 | (i3 << 8) | (-16777216) | (i3 << 12) | (i4 << 8) | (i4 << 4) | (i5 << 4));
            }
            if (a4 == 5) {
                int d4 = b4.d();
                int i6 = 61440 & d4;
                int i7 = d4 & 3840;
                int i8 = d4 & 240;
                int i9 = d4 & 15;
                return new g.f((i9 << 24) | (i9 << 28) | (i6 << 8) | (i6 << 4) | (i7 << 4) | i7 | i8 | (i8 >> 4));
            }
            if (a4 == 7) {
                return new g.f(b4.d() | (-16777216));
            }
            if (a4 == 9) {
                return new g.f((b4.d() >>> 8) | (b4.d() << 24));
            }
            throw new c0.j("Bad hex colour value: " + str);
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean startsWith = lowerCase.startsWith("rgba(");
        if (!startsWith && !lowerCase.startsWith("rgb(")) {
            boolean startsWith2 = lowerCase.startsWith("hsla(");
            if (!startsWith2 && !lowerCase.startsWith("hsl(")) {
                return c0(lowerCase);
            }
            i iVar = new i(str.substring(startsWith2 ? 5 : 4));
            iVar.A();
            float n3 = iVar.n();
            float d5 = iVar.d(n3);
            if (!Float.isNaN(d5)) {
                iVar.f('%');
            }
            float d6 = iVar.d(d5);
            if (!Float.isNaN(d6)) {
                iVar.f('%');
            }
            if (!startsWith2) {
                iVar.A();
                if (!Float.isNaN(d6) && iVar.f(')')) {
                    return new g.f(s(n3, d5, d6) | (-16777216));
                }
                throw new c0.j("Bad hsl() colour value: " + str);
            }
            float d7 = iVar.d(d6);
            iVar.A();
            if (!Float.isNaN(d7) && iVar.f(')')) {
                return new g.f((j(d7 * 256.0f) << 24) | s(n3, d5, d6));
            }
            throw new c0.j("Bad hsla() colour value: " + str);
        }
        i iVar2 = new i(str.substring(startsWith ? 5 : 4));
        iVar2.A();
        float n4 = iVar2.n();
        if (!Float.isNaN(n4) && iVar2.f('%')) {
            n4 = (n4 * 256.0f) / 100.0f;
        }
        float d8 = iVar2.d(n4);
        if (!Float.isNaN(d8) && iVar2.f('%')) {
            d8 = (d8 * 256.0f) / 100.0f;
        }
        float d9 = iVar2.d(d8);
        if (!Float.isNaN(d9) && iVar2.f('%')) {
            d9 = (d9 * 256.0f) / 100.0f;
        }
        if (!startsWith) {
            iVar2.A();
            if (!Float.isNaN(d9) && iVar2.f(')')) {
                return new g.f((j(n4) << 16) | (-16777216) | (j(d8) << 8) | j(d9));
            }
            throw new c0.j("Bad rgb() colour value: " + str);
        }
        float d10 = iVar2.d(d9);
        iVar2.A();
        if (!Float.isNaN(d10) && iVar2.f(')')) {
            return new g.f((j(d10 * 256.0f) << 24) | (j(n4) << 16) | (j(d8) << 8) | j(d9));
        }
        throw new c0.j("Bad rgba() colour value: " + str);
    }

    private void b1(Attributes attributes) {
        l("<symbol>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.r0 t0Var = new g.t0();
        t0Var.f1863a = this.f1976a;
        t0Var.f1864b = this.f1977b;
        D(t0Var, attributes);
        S(t0Var, attributes);
        C(t0Var, attributes);
        Y(t0Var, attributes);
        this.f1977b.i(t0Var);
        this.f1977b = t0Var;
    }

    private static g.f c0(String str) {
        Integer a4 = c.a(str);
        if (a4 != null) {
            return new g.f(a4.intValue());
        }
        throw new c0.j("Invalid colour keyword: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(String str) {
        StringBuilder sb;
        if (this.f1978c) {
            return;
        }
        if (this.f1980e) {
            if (this.f1982g == null) {
                this.f1982g = new StringBuilder(str.length());
            }
            sb = this.f1982g;
        } else if (!this.f1983h) {
            if (this.f1977b instanceof g.y0) {
                h(str);
                return;
            }
            return;
        } else {
            if (this.f1984i == null) {
                this.f1984i = new StringBuilder(str.length());
            }
            sb = this.f1984i;
        }
        sb.append(str);
    }

    private static g.o0 d0(String str) {
        str.hashCode();
        if (str.equals(DevicePublicKeyStringDef.NONE)) {
            return g.f.f1819f;
        }
        if (str.equals("currentColor")) {
            return g.C0044g.a();
        }
        try {
            return b0(str);
        } catch (c0.j unused) {
            return null;
        }
    }

    private void d1(Attributes attributes) {
        l("<text>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.w0 w0Var = new g.w0();
        w0Var.f1863a = this.f1976a;
        w0Var.f1864b = this.f1977b;
        D(w0Var, attributes);
        S(w0Var, attributes);
        W(w0Var, attributes);
        C(w0Var, attributes);
        V(w0Var, attributes);
        this.f1977b.i(w0Var);
        this.f1977b = w0Var;
    }

    private static g.e0.a e0(String str) {
        if ("nonzero".equals(str)) {
            return g.e0.a.NonZero;
        }
        if ("evenodd".equals(str)) {
            return g.e0.a.EvenOdd;
        }
        return null;
    }

    private void e1(char[] cArr, int i3, int i4) {
        StringBuilder sb;
        if (this.f1978c) {
            return;
        }
        if (this.f1980e) {
            if (this.f1982g == null) {
                this.f1982g = new StringBuilder(i4);
            }
            sb = this.f1982g;
        } else if (!this.f1983h) {
            if (this.f1977b instanceof g.y0) {
                h(new String(cArr, i3, i4));
                return;
            }
            return;
        } else {
            if (this.f1984i == null) {
                this.f1984i = new StringBuilder(i4);
            }
            sb = this.f1984i;
        }
        sb.append(cArr, i3, i4);
    }

    private static float f0(String str) {
        int length = str.length();
        if (length != 0) {
            return g0(str, 0, length);
        }
        throw new c0.j("Invalid float value (empty string)");
    }

    private void f1(Attributes attributes) {
        l("<textPath>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.z0 z0Var = new g.z0();
        z0Var.f1863a = this.f1976a;
        z0Var.f1864b = this.f1977b;
        D(z0Var, attributes);
        S(z0Var, attributes);
        C(z0Var, attributes);
        U(z0Var, attributes);
        this.f1977b.i(z0Var);
        this.f1977b = z0Var;
        g.j0 j0Var = z0Var.f1864b;
        z0Var.o(j0Var instanceof g.b1 ? (g.b1) j0Var : ((g.x0) j0Var).f());
    }

    private static float g0(String str, int i3, int i4) {
        float b4 = new c0.d().b(str, i3, i4);
        if (!Float.isNaN(b4)) {
            return b4;
        }
        throw new c0.j("Invalid float value: " + str);
    }

    private void g1(Attributes attributes) {
        l("<tref>", new Object[0]);
        g.j0 j0Var = this.f1977b;
        if (j0Var == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        if (!(j0Var instanceof g.y0)) {
            throw new c0.j("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        g.u0 u0Var = new g.u0();
        u0Var.f1863a = this.f1976a;
        u0Var.f1864b = this.f1977b;
        D(u0Var, attributes);
        S(u0Var, attributes);
        C(u0Var, attributes);
        T(u0Var, attributes);
        this.f1977b.i(u0Var);
        g.j0 j0Var2 = u0Var.f1864b;
        u0Var.o(j0Var2 instanceof g.b1 ? (g.b1) j0Var2 : ((g.x0) j0Var2).f());
    }

    private void h(String str) {
        g.h0 h0Var = (g.h0) this.f1977b;
        int size = h0Var.f1827i.size();
        g.n0 n0Var = size == 0 ? null : h0Var.f1827i.get(size - 1);
        if (!(n0Var instanceof g.c1)) {
            this.f1977b.i(new g.c1(str));
            return;
        }
        StringBuilder sb = new StringBuilder();
        g.c1 c1Var = (g.c1) n0Var;
        sb.append(c1Var.f1738c);
        sb.append(str);
        c1Var.f1738c = sb.toString();
    }

    private static void h0(g.e0 e0Var, String str) {
        String s3;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            i iVar = new i(str);
            Integer num = null;
            g.e0.b bVar = null;
            String str2 = null;
            while (true) {
                s3 = iVar.s(IOUtils.DIR_SEPARATOR_UNIX);
                iVar.A();
                if (s3 != null) {
                    if (num != null && bVar != null) {
                        break;
                    }
                    if (!s3.equals("normal") && (num != null || (num = e.a(s3)) == null)) {
                        if (bVar != null || (bVar = k0(s3)) == null) {
                            if (str2 != null || !s3.equals("small-caps")) {
                                break;
                            } else {
                                str2 = s3;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
            g.p j02 = j0(s3);
            if (iVar.f(IOUtils.DIR_SEPARATOR_UNIX)) {
                iVar.A();
                String r3 = iVar.r();
                if (r3 != null) {
                    try {
                        o0(r3);
                    } catch (c0.j unused) {
                        return;
                    }
                }
                iVar.A();
            }
            e0Var.f1769r = i0(iVar.y());
            e0Var.f1770s = j02;
            e0Var.f1771t = Integer.valueOf(num == null ? 400 : num.intValue());
            if (bVar == null) {
                bVar = g.e0.b.Normal;
            }
            e0Var.f1772u = bVar;
            e0Var.f1755c |= 122880;
        }
    }

    private void h1(Attributes attributes) {
        l("<tspan>", new Object[0]);
        g.j0 j0Var = this.f1977b;
        if (j0Var == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        if (!(j0Var instanceof g.y0)) {
            throw new c0.j("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        g.v0 v0Var = new g.v0();
        v0Var.f1863a = this.f1976a;
        v0Var.f1864b = this.f1977b;
        D(v0Var, attributes);
        S(v0Var, attributes);
        C(v0Var, attributes);
        V(v0Var, attributes);
        this.f1977b.i(v0Var);
        this.f1977b = v0Var;
        g.j0 j0Var2 = v0Var.f1864b;
        v0Var.o(j0Var2 instanceof g.b1 ? (g.b1) j0Var2 : ((g.x0) j0Var2).f());
    }

    private void i(Attributes attributes) {
        l("<circle>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.d dVar = new g.d();
        dVar.f1863a = this.f1976a;
        dVar.f1864b = this.f1977b;
        D(dVar, attributes);
        S(dVar, attributes);
        W(dVar, attributes);
        C(dVar, attributes);
        A(dVar, attributes);
        this.f1977b.i(dVar);
    }

    private static List<String> i0(String str) {
        i iVar = new i(str);
        ArrayList arrayList = null;
        do {
            String q3 = iVar.q();
            if (q3 == null) {
                q3 = iVar.u(',');
            }
            if (q3 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(q3);
            iVar.z();
        } while (!iVar.h());
        return arrayList;
    }

    private void i1(Attributes attributes) {
        l("<use>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.e1 e1Var = new g.e1();
        e1Var.f1863a = this.f1976a;
        e1Var.f1864b = this.f1977b;
        D(e1Var, attributes);
        S(e1Var, attributes);
        W(e1Var, attributes);
        C(e1Var, attributes);
        X(e1Var, attributes);
        this.f1977b.i(e1Var);
        this.f1977b = e1Var;
    }

    private static int j(float f3) {
        if (f3 < BitmapDescriptorFactory.HUE_RED) {
            return 0;
        }
        if (f3 > 255.0f) {
            return 255;
        }
        return Math.round(f3);
    }

    private static g.p j0(String str) {
        try {
            g.p a4 = d.a(str);
            return a4 == null ? o0(str) : a4;
        } catch (c0.j unused) {
            return null;
        }
    }

    private void j1(Attributes attributes) {
        l("<view>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.r0 f1Var = new g.f1();
        f1Var.f1863a = this.f1976a;
        f1Var.f1864b = this.f1977b;
        D(f1Var, attributes);
        C(f1Var, attributes);
        Y(f1Var, attributes);
        this.f1977b.i(f1Var);
        this.f1977b = f1Var;
    }

    private void k(Attributes attributes) {
        l("<clipPath>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.e eVar = new g.e();
        eVar.f1863a = this.f1976a;
        eVar.f1864b = this.f1977b;
        D(eVar, attributes);
        S(eVar, attributes);
        W(eVar, attributes);
        C(eVar, attributes);
        B(eVar, attributes);
        this.f1977b.i(eVar);
        this.f1977b = eVar;
    }

    private static g.e0.b k0(String str) {
        str.hashCode();
        switch (str) {
            case "oblique":
                return g.e0.b.Oblique;
            case "italic":
                return g.e0.b.Italic;
            case "normal":
                return g.e0.b.Normal;
            default:
                return null;
        }
    }

    private void k1(Attributes attributes) {
        l("<switch>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.s0 s0Var = new g.s0();
        s0Var.f1863a = this.f1976a;
        s0Var.f1864b = this.f1977b;
        D(s0Var, attributes);
        S(s0Var, attributes);
        W(s0Var, attributes);
        C(s0Var, attributes);
        this.f1977b.i(s0Var);
        this.f1977b = s0Var;
    }

    private void l(String str, Object... objArr) {
    }

    private static Integer l0(String str) {
        return e.a(str);
    }

    private void m(Attributes attributes) {
        l("<defs>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.h hVar = new g.h();
        hVar.f1863a = this.f1976a;
        hVar.f1864b = this.f1977b;
        D(hVar, attributes);
        S(hVar, attributes);
        W(hVar, attributes);
        this.f1977b.i(hVar);
        this.f1977b = hVar;
    }

    private static String m0(String str, String str2) {
        if (!str.equals(DevicePublicKeyStringDef.NONE) && str.startsWith("url(")) {
            return (str.endsWith(")") ? str.substring(4, str.length() - 1) : str.substring(4)).trim();
        }
        return null;
    }

    private void n(Attributes attributes) {
        l("<ellipse>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.i iVar = new g.i();
        iVar.f1863a = this.f1976a;
        iVar.f1864b = this.f1977b;
        D(iVar, attributes);
        S(iVar, attributes);
        W(iVar, attributes);
        C(iVar, attributes);
        E(iVar, attributes);
        this.f1977b.i(iVar);
    }

    private Float n0(String str) {
        if (str.length() == 0) {
            throw new c0.j("Invalid offset value in <stop> (empty string)");
        }
        int length = str.length();
        boolean z3 = true;
        if (str.charAt(str.length() - 1) == '%') {
            length--;
        } else {
            z3 = false;
        }
        try {
            float g02 = g0(str, 0, length);
            float f3 = 100.0f;
            if (z3) {
                g02 /= 100.0f;
            }
            if (g02 < BitmapDescriptorFactory.HUE_RED) {
                f3 = BitmapDescriptorFactory.HUE_RED;
            } else if (g02 <= 100.0f) {
                f3 = g02;
            }
            return Float.valueOf(f3);
        } catch (NumberFormatException e3) {
            throw new c0.j("Invalid offset value in <stop>: " + str, e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
    }

    static g.p o0(String str) {
        if (str.length() == 0) {
            throw new c0.j("Invalid length value (empty string)");
        }
        int length = str.length();
        g.d1 d1Var = g.d1.px;
        char charAt = str.charAt(length - 1);
        if (charAt == '%') {
            length--;
            d1Var = g.d1.percent;
        } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                d1Var = g.d1.valueOf(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException unused) {
                throw new c0.j("Invalid length unit specifier: " + str);
            }
        }
        try {
            return new g.p(g0(str, 0, length), d1Var);
        } catch (NumberFormatException e3) {
            throw new c0.j("Invalid length value: " + str, e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, String str3) {
        if (this.f1978c) {
            int i3 = this.f1979d - 1;
            this.f1979d = i3;
            if (i3 == 0) {
                this.f1978c = false;
                return;
            }
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i4 = a.f1985a[h.a(str2).ordinal()];
            if (i4 != 1 && i4 != 2 && i4 != 4 && i4 != 5 && i4 != 13 && i4 != 14) {
                switch (i4) {
                    case 22:
                    case 23:
                        this.f1980e = false;
                        StringBuilder sb = this.f1982g;
                        if (sb != null) {
                            h hVar = this.f1981f;
                            if (hVar == h.title) {
                                this.f1976a.q(sb.toString());
                            } else if (hVar == h.desc) {
                                this.f1976a.o(sb.toString());
                            }
                            this.f1982g.setLength(0);
                            break;
                        }
                        break;
                    case 30:
                        StringBuilder sb2 = this.f1984i;
                        if (sb2 != null) {
                            this.f1983h = false;
                            Z(sb2.toString());
                            this.f1984i.setLength(0);
                            break;
                        }
                        break;
                }
                return;
            }
            this.f1977b = ((g.n0) this.f1977b).f1864b;
        }
    }

    private static List<g.p> p0(String str) {
        if (str.length() == 0) {
            throw new c0.j("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        i iVar = new i(str);
        iVar.A();
        while (!iVar.h()) {
            float n3 = iVar.n();
            if (Float.isNaN(n3)) {
                throw new c0.j("Invalid length list value: " + iVar.b());
            }
            g.d1 v3 = iVar.v();
            if (v3 == null) {
                v3 = g.d1.px;
            }
            arrayList.add(new g.p(n3, v3));
            iVar.z();
        }
        return arrayList;
    }

    private void q(Attributes attributes) {
        l("<g>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.m mVar = new g.m();
        mVar.f1863a = this.f1976a;
        mVar.f1864b = this.f1977b;
        D(mVar, attributes);
        S(mVar, attributes);
        W(mVar, attributes);
        C(mVar, attributes);
        this.f1977b.i(mVar);
        this.f1977b = mVar;
    }

    private static g.p q0(i iVar) {
        return iVar.g("auto") ? new g.p(BitmapDescriptorFactory.HUE_RED) : iVar.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, Map<String, String> map) {
        if (str.equals("xml-stylesheet")) {
            c0.g.g();
        }
    }

    private static Float r0(String str) {
        try {
            float f02 = f0(str);
            if (f02 < BitmapDescriptorFactory.HUE_RED) {
                f02 = BitmapDescriptorFactory.HUE_RED;
            } else if (f02 > 1.0f) {
                f02 = 1.0f;
            }
            return Float.valueOf(f02);
        } catch (c0.j unused) {
            return null;
        }
    }

    private static int s(float f3, float f4, float f5) {
        float f6 = BitmapDescriptorFactory.HUE_RED;
        float f7 = f3 % 360.0f;
        if (f3 < BitmapDescriptorFactory.HUE_RED) {
            f7 += 360.0f;
        }
        float f8 = f7 / 60.0f;
        float f9 = f4 / 100.0f;
        float f10 = f5 / 100.0f;
        if (f9 < BitmapDescriptorFactory.HUE_RED) {
            f9 = BitmapDescriptorFactory.HUE_RED;
        } else if (f9 > 1.0f) {
            f9 = 1.0f;
        }
        if (f10 >= BitmapDescriptorFactory.HUE_RED) {
            f6 = f10 > 1.0f ? 1.0f : f10;
        }
        float f11 = f6 <= 0.5f ? (f9 + 1.0f) * f6 : (f6 + f9) - (f9 * f6);
        float f12 = (f6 * 2.0f) - f11;
        float t3 = t(f12, f11, f8 + 2.0f);
        float t4 = t(f12, f11, f8);
        return j(t(f12, f11, f8 - 2.0f) * 256.0f) | (j(t3 * 256.0f) << 16) | (j(t4 * 256.0f) << 8);
    }

    private static Boolean s0(String str) {
        str.hashCode();
        switch (str) {
            case "hidden":
            case "scroll":
                return Boolean.FALSE;
            case "auto":
            case "visible":
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    private static float t(float f3, float f4, float f5) {
        float f6;
        if (f5 < BitmapDescriptorFactory.HUE_RED) {
            f5 += 6.0f;
        }
        if (f5 >= 6.0f) {
            f5 -= 6.0f;
        }
        if (f5 < 1.0f) {
            f6 = (f4 - f3) * f5;
        } else {
            if (f5 < 3.0f) {
                return f4;
            }
            if (f5 >= 4.0f) {
                return f3;
            }
            f6 = (f4 - f3) * (4.0f - f5);
        }
        return f6 + f3;
    }

    private static g.o0 t0(String str) {
        if (!str.startsWith("url(")) {
            return d0(str);
        }
        int indexOf = str.indexOf(")");
        if (indexOf == -1) {
            return new g.u(str.substring(4).trim(), null);
        }
        String trim = str.substring(4, indexOf).trim();
        String trim2 = str.substring(indexOf + 1).trim();
        return new g.u(trim, trim2.length() > 0 ? d0(trim2) : null);
    }

    private void u(Attributes attributes) {
        l("<image>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.o oVar = new g.o();
        oVar.f1863a = this.f1976a;
        oVar.f1864b = this.f1977b;
        D(oVar, attributes);
        S(oVar, attributes);
        W(oVar, attributes);
        C(oVar, attributes);
        G(oVar, attributes);
        this.f1977b.i(oVar);
        this.f1977b = oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01fe A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static c0.g.w u0(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.k.u0(java.lang.String):c0.g$w");
    }

    private void v(Attributes attributes) {
        l("<line>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.q qVar = new g.q();
        qVar.f1863a = this.f1976a;
        qVar.f1864b = this.f1977b;
        D(qVar, attributes);
        S(qVar, attributes);
        W(qVar, attributes);
        C(qVar, attributes);
        H(qVar, attributes);
        this.f1977b.i(qVar);
    }

    static c0.e v0(String str) {
        i iVar = new i(str);
        iVar.A();
        String r3 = iVar.r();
        if ("defer".equals(r3)) {
            iVar.A();
            r3 = iVar.r();
        }
        e.a a4 = b.a(r3);
        e.b bVar = null;
        iVar.A();
        if (!iVar.h()) {
            String r4 = iVar.r();
            r4.hashCode();
            if (r4.equals("meet")) {
                bVar = e.b.meet;
            } else {
                if (!r4.equals("slice")) {
                    throw new c0.j("Invalid preserveAspectRatio definition: " + str);
                }
                bVar = e.b.slice;
            }
        }
        return new c0.e(a4, bVar);
    }

    private void w(Attributes attributes) {
        l("<linearGradient>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.m0 m0Var = new g.m0();
        m0Var.f1863a = this.f1976a;
        m0Var.f1864b = this.f1977b;
        D(m0Var, attributes);
        S(m0Var, attributes);
        F(m0Var, attributes);
        I(m0Var, attributes);
        this.f1977b.i(m0Var);
        this.f1977b = m0Var;
    }

    private static void w0(g.p0 p0Var, String str) {
        p0Var.f1873o = v0(str);
    }

    private void x(Attributes attributes) {
        l("<marker>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.r rVar = new g.r();
        rVar.f1863a = this.f1976a;
        rVar.f1864b = this.f1977b;
        D(rVar, attributes);
        S(rVar, attributes);
        C(rVar, attributes);
        Y(rVar, attributes);
        J(rVar, attributes);
        this.f1977b.i(rVar);
        this.f1977b = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> x0(i iVar) {
        HashMap hashMap = new HashMap();
        iVar.A();
        while (true) {
            String s3 = iVar.s(Tag.KEY_VALUE_SEPARATOR);
            if (s3 == null) {
                return hashMap;
            }
            iVar.f(Tag.KEY_VALUE_SEPARATOR);
            hashMap.put(s3, iVar.q());
            iVar.A();
        }
    }

    private void y(Attributes attributes) {
        l("<mask>", new Object[0]);
        if (this.f1977b == null) {
            throw new c0.j("Invalid document. Root element must be <svg>");
        }
        g.s sVar = new g.s();
        sVar.f1863a = this.f1976a;
        sVar.f1864b = this.f1977b;
        D(sVar, attributes);
        S(sVar, attributes);
        C(sVar, attributes);
        K(sVar, attributes);
        this.f1977b.i(sVar);
        this.f1977b = sVar;
    }

    private static g.e0.e y0(String str) {
        str.hashCode();
        switch (str) {
            case "optimizeQuality":
                return g.e0.e.optimizeQuality;
            case "auto":
                return g.e0.e.auto;
            case "optimizeSpeed":
                return g.e0.e.optimizeSpeed;
            default:
                return null;
        }
    }

    private static Set<String> z0(String str) {
        i iVar = new i(str);
        HashSet hashSet = new HashSet();
        while (!iVar.h()) {
            String r3 = iVar.r();
            hashSet.add(r3.startsWith("http://www.w3.org/TR/SVG11/feature#") ? r3.substring(35) : "UNSUPPORTED");
            iVar.A();
        }
        return hashSet;
    }

    c0.g z(InputStream inputStream, boolean z3) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            inputStream.mark(4096);
            L0(inputStream, z3);
            return this.f1976a;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Log.e("SVGParser", "Exception thrown closing input stream");
            }
        }
    }
}
