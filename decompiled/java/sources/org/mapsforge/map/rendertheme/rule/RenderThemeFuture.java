package org.mapsforge.map.rendertheme.rule;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.XmlRenderTheme;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: /root/release/classes2.dex */
public class RenderThemeFuture extends FutureTask<RenderTheme> {
    private final AtomicInteger refCount;

    private static class RenderThemeCallable implements Callable<RenderTheme> {
        private final DisplayModel displayModel;
        private final GraphicFactory graphicFactory;
        private final XmlRenderTheme xmlRenderTheme;

        public RenderThemeCallable(GraphicFactory graphicFactory, XmlRenderTheme xmlRenderTheme, DisplayModel displayModel) {
            this.graphicFactory = graphicFactory;
            this.xmlRenderTheme = xmlRenderTheme;
            this.displayModel = displayModel;
        }

        @Override // java.util.concurrent.Callable
        public RenderTheme call() {
            DisplayModel displayModel;
            XmlRenderTheme xmlRenderTheme = this.xmlRenderTheme;
            if (xmlRenderTheme == null || (displayModel = this.displayModel) == null) {
                return null;
            }
            try {
                return RenderThemeHandler.getRenderTheme(this.graphicFactory, displayModel, xmlRenderTheme);
            } catch (IOException e3) {
                throw new IllegalArgumentException("File error for XML rendertheme", e3);
            } catch (XmlPullParserException e4) {
                throw new IllegalArgumentException("Parse error for XML rendertheme", e4);
            }
        }
    }

    public RenderThemeFuture(GraphicFactory graphicFactory, XmlRenderTheme xmlRenderTheme, DisplayModel displayModel) {
        super(new RenderThemeCallable(graphicFactory, xmlRenderTheme, displayModel));
        this.refCount = new AtomicInteger(1);
    }

    public void decrementRefCount() {
        if (this.refCount.decrementAndGet() <= 0) {
            try {
                if (isDone()) {
                    get().destroy();
                } else {
                    cancel(true);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void incrementRefCount() {
        this.refCount.incrementAndGet();
    }
}
