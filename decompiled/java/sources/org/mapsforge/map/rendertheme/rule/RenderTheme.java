package org.mapsforge.map.rendertheme.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mapsforge.core.util.LRUCache;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.layer.renderer.PolylineContainer;
import org.mapsforge.map.layer.renderer.StandardRenderer;
import org.mapsforge.map.rendertheme.RenderCallback;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.rendertheme.renderinstruction.Hillshading;
import org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction;
import org.mapsforge.map.rendertheme.rule.Rule;

/* loaded from: /root/release/classes2.dex */
public class RenderTheme {
    private static final int MATCHING_CACHE_SIZE = 1024;
    private final float baseStrokeWidth;
    private final float baseTextSize;
    private final boolean hasBackgroundOutside;
    private int levels;
    private final int mapBackground;
    private final int mapBackgroundOutside;
    private ArrayList<Hillshading> hillShadings = new ArrayList<>();
    private final Map<Byte, Float> strokeScales = new HashMap();
    private final Map<Byte, Float> textScales = new HashMap();
    private final ArrayList<Rule> rulesList = new ArrayList<>();
    private final LRUCache<MatchingCacheKey, List<RenderInstruction>> poiMatchingCache = new LRUCache<>(1024);
    private final LRUCache<MatchingCacheKey, List<RenderInstruction>> wayMatchingCache = new LRUCache<>(1024);

    RenderTheme(RenderThemeBuilder renderThemeBuilder) {
        this.baseStrokeWidth = renderThemeBuilder.baseStrokeWidth;
        this.baseTextSize = renderThemeBuilder.baseTextSize;
        this.hasBackgroundOutside = renderThemeBuilder.hasBackgroundOutside;
        this.mapBackground = renderThemeBuilder.mapBackground;
        this.mapBackgroundOutside = renderThemeBuilder.mapBackgroundOutside;
    }

    private synchronized void matchWay(RenderCallback renderCallback, RenderContext renderContext, Closed closed, PolylineContainer polylineContainer) {
        MatchingCacheKey matchingCacheKey = new MatchingCacheKey(polylineContainer.getTags(), polylineContainer.getUpperLeft().zoomLevel, closed);
        List<RenderInstruction> list = this.wayMatchingCache.get(matchingCacheKey);
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                list.get(i3).renderWay(renderCallback, renderContext, polylineContainer);
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size2 = this.rulesList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            this.rulesList.get(i4).matchWay(renderCallback, polylineContainer, polylineContainer.getUpperLeft(), closed, arrayList, renderContext);
        }
        this.wayMatchingCache.put(matchingCacheKey, arrayList);
    }

    void addHillShadings(Hillshading hillshading) {
        this.hillShadings.add(hillshading);
    }

    void addRule(Rule rule) {
        this.rulesList.add(rule);
    }

    void complete() {
        this.rulesList.trimToSize();
        this.hillShadings.trimToSize();
        int size = this.rulesList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.rulesList.get(i3).onComplete();
        }
    }

    public void destroy() {
        this.poiMatchingCache.clear();
        this.wayMatchingCache.clear();
        Iterator<Rule> it = this.rulesList.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    public int getLevels() {
        return this.levels;
    }

    public int getMapBackground() {
        return this.mapBackground;
    }

    public int getMapBackgroundOutside() {
        return this.mapBackgroundOutside;
    }

    public boolean hasMapBackgroundOutside() {
        return this.hasBackgroundOutside;
    }

    public void matchClosedWay(RenderCallback renderCallback, RenderContext renderContext, PolylineContainer polylineContainer) {
        matchWay(renderCallback, renderContext, Closed.YES, polylineContainer);
    }

    public void matchHillShadings(StandardRenderer standardRenderer, RenderContext renderContext) {
        Iterator<Hillshading> it = this.hillShadings.iterator();
        while (it.hasNext()) {
            it.next().render(renderContext, standardRenderer.hillsRenderConfig);
        }
    }

    public void matchLinearWay(RenderCallback renderCallback, RenderContext renderContext, PolylineContainer polylineContainer) {
        matchWay(renderCallback, renderContext, Closed.NO, polylineContainer);
    }

    public synchronized void matchNode(RenderCallback renderCallback, RenderContext renderContext, PointOfInterest pointOfInterest) {
        MatchingCacheKey matchingCacheKey = new MatchingCacheKey(pointOfInterest.tags, renderContext.rendererJob.tile.zoomLevel, Closed.NO);
        List<RenderInstruction> list = this.poiMatchingCache.get(matchingCacheKey);
        int i3 = 0;
        if (list != null) {
            int size = list.size();
            while (i3 < size) {
                list.get(i3).renderNode(renderCallback, renderContext, pointOfInterest);
                i3++;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size2 = this.rulesList.size();
        while (i3 < size2) {
            this.rulesList.get(i3).matchNode(renderCallback, renderContext, arrayList, pointOfInterest);
            i3++;
        }
        this.poiMatchingCache.put(matchingCacheKey, arrayList);
    }

    public synchronized void scaleStrokeWidth(float f3, byte b4) {
        if (!this.strokeScales.containsKey(Byte.valueOf(b4)) || f3 != this.strokeScales.get(Byte.valueOf(b4)).floatValue()) {
            int size = this.rulesList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Rule rule = this.rulesList.get(i3);
                if (rule.zoomMin <= b4 && rule.zoomMax >= b4) {
                    rule.scaleStrokeWidth(this.baseStrokeWidth * f3, b4);
                }
            }
            this.strokeScales.put(Byte.valueOf(b4), Float.valueOf(f3));
        }
    }

    public synchronized void scaleTextSize(float f3, byte b4) {
        if (!this.textScales.containsKey(Byte.valueOf(b4)) || f3 != this.textScales.get(Byte.valueOf(b4)).floatValue()) {
            int size = this.rulesList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Rule rule = this.rulesList.get(i3);
                if (rule.zoomMin <= b4 && rule.zoomMax >= b4) {
                    rule.scaleTextSize(this.baseTextSize * f3, b4);
                }
            }
            this.textScales.put(Byte.valueOf(b4), Float.valueOf(f3));
        }
    }

    void setLevels(int i3) {
        this.levels = i3;
    }

    public void traverseRules(Rule.RuleVisitor ruleVisitor) {
        Iterator<Rule> it = this.rulesList.iterator();
        while (it.hasNext()) {
            it.next().apply(ruleVisitor);
        }
    }
}
