package com.google.common.cache;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class CacheBuilder<K, V> {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final int UNSET_INT = -1;

    @CheckForNull
    Equivalence<Object> keyEquivalence;

    @CheckForNull
    LocalCache.Strength keyStrength;

    @CheckForNull
    RemovalListener<? super K, ? super V> removalListener;

    @CheckForNull
    Ticker ticker;

    @CheckForNull
    Equivalence<Object> valueEquivalence;

    @CheckForNull
    LocalCache.Strength valueStrength;

    @CheckForNull
    Weigher<? super K, ? super V> weigher;
    static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() { // from class: com.google.common.cache.CacheBuilder.1
        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i3) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j3) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j3) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i3) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return CacheBuilder.EMPTY_STATS;
        }
    });
    static final CacheStats EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = new Supplier() { // from class: com.google.common.cache.a
        @Override // com.google.common.base.Supplier
        public final Object get() {
            AbstractCache.StatsCounter lambda$static$0;
            lambda$static$0 = CacheBuilder.lambda$static$0();
            return lambda$static$0;
        }
    };
    static final Ticker NULL_TICKER = new Ticker() { // from class: com.google.common.cache.CacheBuilder.2
        @Override // com.google.common.base.Ticker
        public long read() {
            return 0L;
        }
    };
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    boolean strictParsing = true;
    int initialCapacity = -1;
    int concurrencyLevel = -1;
    long maximumSize = -1;
    long maximumWeight = -1;
    long expireAfterWriteNanos = -1;
    long expireAfterAccessNanos = -1;
    long refreshNanos = -1;
    Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;

    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    private void checkNonLoadingCache() {
        Preconditions.checkState(this.refreshNanos == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        boolean z3;
        String str;
        if (this.weigher == null) {
            z3 = this.maximumWeight == -1;
            str = "maximumWeight requires weigher";
        } else {
            if (!this.strictParsing) {
                if (this.maximumWeight == -1) {
                    logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
                    return;
                }
                return;
            }
            z3 = this.maximumWeight != -1;
            str = "weigher requires maximumWeight";
        }
        Preconditions.checkState(z3, str);
    }

    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AbstractCache.StatsCounter lambda$static$0() {
        return new AbstractCache.SimpleStatsCounter();
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public CacheBuilder<K, V> concurrencyLevel(int i3) {
        int i4 = this.concurrencyLevel;
        Preconditions.checkState(i4 == -1, "concurrency level was already set to %s", i4);
        Preconditions.checkArgument(i3 > 0);
        this.concurrencyLevel = i3;
        return this;
    }

    public CacheBuilder<K, V> expireAfterAccess(long j3, TimeUnit timeUnit) {
        long j4 = this.expireAfterAccessNanos;
        Preconditions.checkState(j4 == -1, "expireAfterAccess was already set to %s ns", j4);
        Preconditions.checkArgument(j3 >= 0, "duration cannot be negative: %s %s", j3, timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j3);
        return this;
    }

    public CacheBuilder<K, V> expireAfterWrite(long j3, TimeUnit timeUnit) {
        long j4 = this.expireAfterWriteNanos;
        Preconditions.checkState(j4 == -1, "expireAfterWrite was already set to %s ns", j4);
        Preconditions.checkArgument(j3 >= 0, "duration cannot be negative: %s %s", j3, timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j3);
        return this;
    }

    int getConcurrencyLevel() {
        int i3 = this.concurrencyLevel;
        if (i3 == -1) {
            return 4;
        }
        return i3;
    }

    long getExpireAfterAccessNanos() {
        long j3 = this.expireAfterAccessNanos;
        if (j3 == -1) {
            return 0L;
        }
        return j3;
    }

    long getExpireAfterWriteNanos() {
        long j3 = this.expireAfterWriteNanos;
        if (j3 == -1) {
            return 0L;
        }
        return j3;
    }

    int getInitialCapacity() {
        int i3 = this.initialCapacity;
        if (i3 == -1) {
            return 16;
        }
        return i3;
    }

    Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    long getMaximumWeight() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0L;
        }
        return this.weigher == null ? this.maximumSize : this.maximumWeight;
    }

    long getRefreshNanos() {
        long j3 = this.refreshNanos;
        if (j3 == -1) {
            return 0L;
        }
        return j3;
    }

    <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    Ticker getTicker(boolean z3) {
        Ticker ticker = this.ticker;
        return ticker != null ? ticker : z3 ? Ticker.systemTicker() : NULL_TICKER;
    }

    Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> initialCapacity(int i3) {
        int i4 = this.initialCapacity;
        Preconditions.checkState(i4 == -1, "initial capacity was already set to %s", i4);
        Preconditions.checkArgument(i3 >= 0);
        this.initialCapacity = i3;
        return this;
    }

    boolean isRecordingStats() {
        return this.statsCounterSupplier == CACHE_STATS_COUNTER;
    }

    CacheBuilder<K, V> keyEquivalence(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        Preconditions.checkState(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    public CacheBuilder<K, V> maximumSize(long j3) {
        long j4 = this.maximumSize;
        Preconditions.checkState(j4 == -1, "maximum size was already set to %s", j4);
        long j5 = this.maximumWeight;
        Preconditions.checkState(j5 == -1, "maximum weight was already set to %s", j5);
        Preconditions.checkState(this.weigher == null, "maximum size can not be combined with weigher");
        Preconditions.checkArgument(j3 >= 0, "maximum size must not be negative");
        this.maximumSize = j3;
        return this;
    }

    public CacheBuilder<K, V> maximumWeight(long j3) {
        long j4 = this.maximumWeight;
        Preconditions.checkState(j4 == -1, "maximum weight was already set to %s", j4);
        long j5 = this.maximumSize;
        Preconditions.checkState(j5 == -1, "maximum size was already set to %s", j5);
        Preconditions.checkArgument(j3 >= 0, "maximum weight must not be negative");
        this.maximumWeight = j3;
        return this;
    }

    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    public CacheBuilder<K, V> refreshAfterWrite(long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        long j4 = this.refreshNanos;
        Preconditions.checkState(j4 == -1, "refresh was already set to %s ns", j4);
        Preconditions.checkArgument(j3 > 0, "duration must be positive: %s %s", j3, timeUnit);
        this.refreshNanos = timeUnit.toNanos(j3);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener) {
        Preconditions.checkState(this.removalListener == null);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener);
        return this;
    }

    CacheBuilder<K, V> setKeyStrength(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.keyStrength;
        Preconditions.checkState(strength2 == null, "Key strength was already set to %s", strength2);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    CacheBuilder<K, V> setValueStrength(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.valueStrength;
        Preconditions.checkState(strength2 == null, "Value strength was already set to %s", strength2);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    public CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    public CacheBuilder<K, V> ticker(Ticker ticker) {
        Preconditions.checkState(this.ticker == null);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker);
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i3 = this.initialCapacity;
        if (i3 != -1) {
            stringHelper.add("initialCapacity", i3);
        }
        int i4 = this.concurrencyLevel;
        if (i4 != -1) {
            stringHelper.add("concurrencyLevel", i4);
        }
        long j3 = this.maximumSize;
        if (j3 != -1) {
            stringHelper.add("maximumSize", j3);
        }
        long j4 = this.maximumWeight;
        if (j4 != -1) {
            stringHelper.add("maximumWeight", j4);
        }
        if (this.expireAfterWriteNanos != -1) {
            stringHelper.add("expireAfterWrite", this.expireAfterWriteNanos + "ns");
        }
        if (this.expireAfterAccessNanos != -1) {
            stringHelper.add("expireAfterAccess", this.expireAfterAccessNanos + "ns");
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue("keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            stringHelper.addValue("valueEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue("removalListener");
        }
        return stringHelper.toString();
    }

    CacheBuilder<K, V> valueEquivalence(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.valueEquivalence;
        Preconditions.checkState(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher) {
        Preconditions.checkState(this.weigher == null);
        if (this.strictParsing) {
            long j3 = this.maximumSize;
            Preconditions.checkState(j3 == -1, "weigher can not be combined with maximum size (%s provided)", j3);
        }
        this.weigher = (Weigher) Preconditions.checkNotNull(weigher);
        return this;
    }
}
