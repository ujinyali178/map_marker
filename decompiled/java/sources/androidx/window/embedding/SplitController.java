package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import g2.q;
import h2.j0;
import h2.v;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class SplitController {
    private static volatile SplitController globalInstance;
    public static final boolean sDebug = false;
    private final EmbeddingBackend embeddingBackend;
    private Set<? extends EmbeddingRule> staticSplitRules;
    public static final Companion Companion = new Companion(null);
    private static final ReentrantLock globalLock = new ReentrantLock();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final SplitController getInstance() {
            if (SplitController.globalInstance == null) {
                ReentrantLock reentrantLock = SplitController.globalLock;
                reentrantLock.lock();
                try {
                    if (SplitController.globalInstance == null) {
                        SplitController.globalInstance = new SplitController(null);
                    }
                    q qVar = q.f2555a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            SplitController splitController = SplitController.globalInstance;
            k.b(splitController);
            return splitController;
        }

        public final void initialize(Context context, int i3) {
            k.e(context, "context");
            Set<EmbeddingRule> parseSplitRules$window_release = new SplitRuleParser().parseSplitRules$window_release(context, i3);
            SplitController companion = getInstance();
            if (parseSplitRules$window_release == null) {
                parseSplitRules$window_release = j0.b();
            }
            companion.setStaticSplitRules(parseSplitRules$window_release);
        }
    }

    private SplitController() {
        Set<? extends EmbeddingRule> b4;
        this.embeddingBackend = ExtensionEmbeddingBackend.Companion.getInstance();
        b4 = j0.b();
        this.staticSplitRules = b4;
    }

    public /* synthetic */ SplitController(kotlin.jvm.internal.g gVar) {
        this();
    }

    public static final SplitController getInstance() {
        return Companion.getInstance();
    }

    public static final void initialize(Context context, int i3) {
        Companion.initialize(context, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStaticSplitRules(Set<? extends EmbeddingRule> set) {
        this.staticSplitRules = set;
        this.embeddingBackend.setSplitRules(set);
    }

    public final void addSplitListener(Activity activity, Executor executor, androidx.core.util.a<List<SplitInfo>> consumer) {
        k.e(activity, "activity");
        k.e(executor, "executor");
        k.e(consumer, "consumer");
        this.embeddingBackend.registerSplitListenerForActivity(activity, executor, consumer);
    }

    public final void clearRegisteredRules() {
        this.embeddingBackend.setSplitRules(this.staticSplitRules);
    }

    public final Set<EmbeddingRule> getSplitRules() {
        Set<EmbeddingRule> z3;
        z3 = v.z(this.embeddingBackend.getSplitRules());
        return z3;
    }

    public final boolean isSplitSupported() {
        return this.embeddingBackend.isSplitSupported();
    }

    public final void registerRule(EmbeddingRule rule) {
        k.e(rule, "rule");
        this.embeddingBackend.registerRule(rule);
    }

    public final void removeSplitListener(androidx.core.util.a<List<SplitInfo>> consumer) {
        k.e(consumer, "consumer");
        this.embeddingBackend.unregisterSplitListenerForActivity(consumer);
    }

    public final void unregisterRule(EmbeddingRule rule) {
        k.e(rule, "rule");
        this.embeddingBackend.unregisterRule(rule);
    }
}
