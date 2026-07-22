package org.mapsforge.map.rendertheme.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mapsforge.core.model.Tag;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.layer.renderer.PolylineContainer;
import org.mapsforge.map.rendertheme.RenderCallback;
import org.mapsforge.map.rendertheme.RenderContext;
import org.mapsforge.map.rendertheme.renderinstruction.RenderInstruction;

/* loaded from: /root/release/classes2.dex */
public abstract class Rule {
    static final Map<List<String>, AttributeMatcher> MATCHERS_CACHE_KEY = new HashMap();
    static final Map<List<String>, AttributeMatcher> MATCHERS_CACHE_VALUE = new HashMap();
    String cat;
    final ClosedMatcher closedMatcher;
    final ElementMatcher elementMatcher;
    public final ArrayList<RenderInstruction> renderInstructions = new ArrayList<>(4);
    public final ArrayList<Rule> subRules = new ArrayList<>(4);
    final byte zoomMax;
    final byte zoomMin;

    public static class RuleVisitor {
        public void apply(Rule rule) {
            Iterator<Rule> it = rule.subRules.iterator();
            while (it.hasNext()) {
                apply(it.next());
            }
        }
    }

    Rule(RuleBuilder ruleBuilder) {
        this.cat = ruleBuilder.cat;
        this.closedMatcher = ruleBuilder.closedMatcher;
        this.elementMatcher = ruleBuilder.elementMatcher;
        this.zoomMax = ruleBuilder.zoomMax;
        this.zoomMin = ruleBuilder.zoomMin;
    }

    void addRenderingInstruction(RenderInstruction renderInstruction) {
        this.renderInstructions.add(renderInstruction);
    }

    void addSubRule(Rule rule) {
        this.subRules.add(rule);
    }

    void apply(RuleVisitor ruleVisitor) {
        ruleVisitor.apply(this);
    }

    void destroy() {
        Iterator<RenderInstruction> it = this.renderInstructions.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        Iterator<Rule> it2 = this.subRules.iterator();
        while (it2.hasNext()) {
            it2.next().destroy();
        }
    }

    void matchNode(RenderCallback renderCallback, RenderContext renderContext, List<RenderInstruction> list, PointOfInterest pointOfInterest) {
        if (matchesNode(pointOfInterest.tags, renderContext.rendererJob.tile.zoomLevel)) {
            int size = this.renderInstructions.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.renderInstructions.get(i3).renderNode(renderCallback, renderContext, pointOfInterest);
                list.add(this.renderInstructions.get(i3));
            }
            int size2 = this.subRules.size();
            for (int i4 = 0; i4 < size2; i4++) {
                this.subRules.get(i4).matchNode(renderCallback, renderContext, list, pointOfInterest);
            }
        }
    }

    void matchWay(RenderCallback renderCallback, PolylineContainer polylineContainer, Tile tile, Closed closed, List<RenderInstruction> list, RenderContext renderContext) {
        if (matchesWay(polylineContainer.getTags(), tile.zoomLevel, closed)) {
            int size = this.renderInstructions.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.renderInstructions.get(i3).renderWay(renderCallback, renderContext, polylineContainer);
                list.add(this.renderInstructions.get(i3));
            }
            int size2 = this.subRules.size();
            for (int i4 = 0; i4 < size2; i4++) {
                this.subRules.get(i4).matchWay(renderCallback, polylineContainer, tile, closed, list, renderContext);
            }
        }
    }

    abstract boolean matchesNode(List<Tag> list, byte b4);

    abstract boolean matchesWay(List<Tag> list, byte b4, Closed closed);

    void onComplete() {
        MATCHERS_CACHE_KEY.clear();
        MATCHERS_CACHE_VALUE.clear();
        this.renderInstructions.trimToSize();
        this.subRules.trimToSize();
        int size = this.subRules.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.subRules.get(i3).onComplete();
        }
    }

    void scaleStrokeWidth(float f3, byte b4) {
        int size = this.renderInstructions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.renderInstructions.get(i3).scaleStrokeWidth(f3, b4);
        }
        int size2 = this.subRules.size();
        for (int i4 = 0; i4 < size2; i4++) {
            this.subRules.get(i4).scaleStrokeWidth(f3, b4);
        }
    }

    void scaleTextSize(float f3, byte b4) {
        int size = this.renderInstructions.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.renderInstructions.get(i3).scaleTextSize(f3, b4);
        }
        int size2 = this.subRules.size();
        for (int i4 = 0; i4 < size2; i4++) {
            this.subRules.get(i4).scaleTextSize(f3, b4);
        }
    }
}
