package androidx.window.embedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import androidx.window.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import h2.j0;
import java.util.Set;
import kotlin.jvm.internal.k;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import v2.n;

/* loaded from: /root/release/classes.dex */
public final class SplitRuleParser {
    private final ComponentName buildClassName(String str, CharSequence charSequence) {
        if (charSequence != null) {
            if (!(charSequence.length() == 0)) {
                String obj = charSequence.toString();
                if (obj.charAt(0) == '.') {
                    return new ComponentName(str, k.j(str, obj));
                }
                int z3 = n.z(obj, IOUtils.DIR_SEPARATOR_UNIX, 0, false, 6, null);
                if (z3 > 0) {
                    str = obj.substring(0, z3);
                    k.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    obj = obj.substring(z3 + 1);
                    k.d(obj, "(this as java.lang.String).substring(startIndex)");
                }
                if (k.a(obj, "*") || n.z(obj, FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, null) >= 0) {
                    return new ComponentName(str, obj);
                }
                return new ComponentName(str, str + FilenameUtils.EXTENSION_SEPARATOR + obj);
            }
        }
        throw new IllegalArgumentException("Activity name must not be null");
    }

    private final ActivityFilter parseActivityFilter(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.ActivityFilter, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.ActivityFilter_activityName);
        String string2 = obtainStyledAttributes.getString(R.styleable.ActivityFilter_activityAction);
        String packageName = context.getApplicationContext().getPackageName();
        k.d(packageName, "packageName");
        return new ActivityFilter(buildClassName(packageName, string), string2);
    }

    private final ActivityRule parseSplitActivityRule(Context context, XmlResourceParser xmlResourceParser) {
        Set b4;
        boolean z3 = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.ActivityRule, 0, 0).getBoolean(R.styleable.ActivityRule_alwaysExpand, false);
        b4 = j0.b();
        return new ActivityRule(b4, z3);
    }

    private final SplitPairFilter parseSplitPairFilter(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.SplitPairFilter, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.SplitPairFilter_primaryActivityName);
        String string2 = obtainStyledAttributes.getString(R.styleable.SplitPairFilter_secondaryActivityName);
        String string3 = obtainStyledAttributes.getString(R.styleable.SplitPairFilter_secondaryActivityAction);
        String packageName = context.getApplicationContext().getPackageName();
        k.d(packageName, "packageName");
        return new SplitPairFilter(buildClassName(packageName, string), buildClassName(packageName, string2), string3);
    }

    private final SplitPairRule parseSplitPairRule(Context context, XmlResourceParser xmlResourceParser) {
        Set b4;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.SplitPairRule, 0, 0);
        float f3 = obtainStyledAttributes.getFloat(R.styleable.SplitPairRule_splitRatio, BitmapDescriptorFactory.HUE_RED);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.SplitPairRule_splitMinWidth, BitmapDescriptorFactory.HUE_RED);
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.SplitPairRule_splitMinSmallestWidth, BitmapDescriptorFactory.HUE_RED);
        int i3 = obtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitLayoutDirection, 3);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.SplitPairRule_finishPrimaryWithSecondary, false);
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.SplitPairRule_finishSecondaryWithPrimary, true);
        boolean z5 = obtainStyledAttributes.getBoolean(R.styleable.SplitPairRule_clearTop, false);
        b4 = j0.b();
        return new SplitPairRule(b4, z3, z4, z5, dimension, dimension2, f3, i3);
    }

    private final SplitPlaceholderRule parseSplitPlaceholderRule(Context context, XmlResourceParser xmlResourceParser) {
        Set b4;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.SplitPlaceholderRule, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.SplitPlaceholderRule_placeholderActivityName);
        float f3 = obtainStyledAttributes.getFloat(R.styleable.SplitPlaceholderRule_splitRatio, BitmapDescriptorFactory.HUE_RED);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.SplitPlaceholderRule_splitMinWidth, BitmapDescriptorFactory.HUE_RED);
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.SplitPlaceholderRule_splitMinSmallestWidth, BitmapDescriptorFactory.HUE_RED);
        int i3 = obtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitLayoutDirection, 3);
        String packageName = context.getApplicationContext().getPackageName();
        k.d(packageName, "packageName");
        ComponentName buildClassName = buildClassName(packageName, string);
        b4 = j0.b();
        Intent component = new Intent().setComponent(buildClassName);
        k.d(component, "Intent().setComponent(pl…eholderActivityClassName)");
        return new SplitPlaceholderRule(b4, component, dimension, dimension2, f3, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e5, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Set<androidx.window.embedding.EmbeddingRule> parseSplitXml(android.content.Context r9, int r10) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitRuleParser.parseSplitXml(android.content.Context, int):java.util.Set");
    }

    public final Set<EmbeddingRule> parseSplitRules$window_release(Context context, int i3) {
        k.e(context, "context");
        return parseSplitXml(context, i3);
    }
}
