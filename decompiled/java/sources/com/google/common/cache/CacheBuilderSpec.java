package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;
import org.mapsforge.core.model.Tag;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class CacheBuilderSpec {
    private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
    private static final Splitter KEY_VALUE_SPLITTER = Splitter.on(Tag.KEY_VALUE_SEPARATOR).trimResults();
    private static final ImmutableMap<String, ValueParser> VALUE_PARSERS;
    long accessExpirationDuration;

    @CheckForNull
    TimeUnit accessExpirationTimeUnit;

    @CheckForNull
    Integer concurrencyLevel;

    @CheckForNull
    Integer initialCapacity;

    @CheckForNull
    LocalCache.Strength keyStrength;

    @CheckForNull
    Long maximumSize;

    @CheckForNull
    Long maximumWeight;

    @CheckForNull
    Boolean recordStats;
    long refreshDuration;

    @CheckForNull
    TimeUnit refreshTimeUnit;
    private final String specification;

    @CheckForNull
    LocalCache.Strength valueStrength;
    long writeExpirationDuration;

    @CheckForNull
    TimeUnit writeExpirationTimeUnit;

    /* renamed from: com.google.common.cache.CacheBuilderSpec$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$cache$LocalCache$Strength;

        static {
            int[] iArr = new int[LocalCache.Strength.values().length];
            $SwitchMap$com$google$common$cache$LocalCache$Strength = iArr;
            try {
                iArr[LocalCache.Strength.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$cache$LocalCache$Strength[LocalCache.Strength.SOFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static class AccessDurationParser extends DurationParser {
        AccessDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j3, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.accessExpirationTimeUnit == null, "expireAfterAccess already set");
            cacheBuilderSpec.accessExpirationDuration = j3;
            cacheBuilderSpec.accessExpirationTimeUnit = timeUnit;
        }
    }

    static class ConcurrencyLevelParser extends IntegerParser {
        ConcurrencyLevelParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        protected void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i3) {
            Integer num = cacheBuilderSpec.concurrencyLevel;
            Preconditions.checkArgument(num == null, "concurrency level was already set to %s", num);
            cacheBuilderSpec.concurrencyLevel = Integer.valueOf(i3);
        }
    }

    static abstract class DurationParser implements ValueParser {
        DurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            TimeUnit timeUnit;
            if (Strings.isNullOrEmpty(str2)) {
                throw new IllegalArgumentException("value of key " + str + " omitted");
            }
            try {
                char charAt = str2.charAt(str2.length() - 1);
                if (charAt == 'd') {
                    timeUnit = TimeUnit.DAYS;
                } else if (charAt == 'h') {
                    timeUnit = TimeUnit.HOURS;
                } else if (charAt == 'm') {
                    timeUnit = TimeUnit.MINUTES;
                } else {
                    if (charAt != 's') {
                        throw new IllegalArgumentException(CacheBuilderSpec.format("key %s invalid unit: was %s, must end with one of [dhms]", str, str2));
                    }
                    timeUnit = TimeUnit.SECONDS;
                }
                parseDuration(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2));
            }
        }

        protected abstract void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j3, TimeUnit timeUnit);
    }

    static class InitialCapacityParser extends IntegerParser {
        InitialCapacityParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        protected void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i3) {
            Integer num = cacheBuilderSpec.initialCapacity;
            Preconditions.checkArgument(num == null, "initial capacity was already set to %s", num);
            cacheBuilderSpec.initialCapacity = Integer.valueOf(i3);
        }
    }

    static abstract class IntegerParser implements ValueParser {
        IntegerParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            if (!Strings.isNullOrEmpty(str2)) {
                try {
                    parseInteger(cacheBuilderSpec, Integer.parseInt(str2));
                } catch (NumberFormatException e3) {
                    throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2), e3);
                }
            } else {
                throw new IllegalArgumentException("value of key " + str + " omitted");
            }
        }

        protected abstract void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i3);
    }

    static class KeyStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public KeyStrengthParser(LocalCache.Strength strength) {
            this.strength = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            Preconditions.checkArgument(str2 == null, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.keyStrength;
            Preconditions.checkArgument(strength == null, "%s was already set to %s", str, strength);
            cacheBuilderSpec.keyStrength = this.strength;
        }
    }

    static abstract class LongParser implements ValueParser {
        LongParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            if (!Strings.isNullOrEmpty(str2)) {
                try {
                    parseLong(cacheBuilderSpec, Long.parseLong(str2));
                } catch (NumberFormatException e3) {
                    throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2), e3);
                }
            } else {
                throw new IllegalArgumentException("value of key " + str + " omitted");
            }
        }

        protected abstract void parseLong(CacheBuilderSpec cacheBuilderSpec, long j3);
    }

    static class MaximumSizeParser extends LongParser {
        MaximumSizeParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        protected void parseLong(CacheBuilderSpec cacheBuilderSpec, long j3) {
            Long l3 = cacheBuilderSpec.maximumSize;
            Preconditions.checkArgument(l3 == null, "maximum size was already set to %s", l3);
            Long l4 = cacheBuilderSpec.maximumWeight;
            Preconditions.checkArgument(l4 == null, "maximum weight was already set to %s", l4);
            cacheBuilderSpec.maximumSize = Long.valueOf(j3);
        }
    }

    static class MaximumWeightParser extends LongParser {
        MaximumWeightParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        protected void parseLong(CacheBuilderSpec cacheBuilderSpec, long j3) {
            Long l3 = cacheBuilderSpec.maximumWeight;
            Preconditions.checkArgument(l3 == null, "maximum weight was already set to %s", l3);
            Long l4 = cacheBuilderSpec.maximumSize;
            Preconditions.checkArgument(l4 == null, "maximum size was already set to %s", l4);
            cacheBuilderSpec.maximumWeight = Long.valueOf(j3);
        }
    }

    static class RecordStatsParser implements ValueParser {
        RecordStatsParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            Preconditions.checkArgument(str2 == null, "recordStats does not take values");
            Preconditions.checkArgument(cacheBuilderSpec.recordStats == null, "recordStats already set");
            cacheBuilderSpec.recordStats = Boolean.TRUE;
        }
    }

    static class RefreshDurationParser extends DurationParser {
        RefreshDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j3, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.refreshTimeUnit == null, "refreshAfterWrite already set");
            cacheBuilderSpec.refreshDuration = j3;
            cacheBuilderSpec.refreshTimeUnit = timeUnit;
        }
    }

    private interface ValueParser {
        void parse(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2);
    }

    static class ValueStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public ValueStrengthParser(LocalCache.Strength strength) {
            this.strength = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            Preconditions.checkArgument(str2 == null, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.valueStrength;
            Preconditions.checkArgument(strength == null, "%s was already set to %s", str, strength);
            cacheBuilderSpec.valueStrength = this.strength;
        }
    }

    static class WriteDurationParser extends DurationParser {
        WriteDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j3, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.writeExpirationTimeUnit == null, "expireAfterWrite already set");
            cacheBuilderSpec.writeExpirationDuration = j3;
            cacheBuilderSpec.writeExpirationTimeUnit = timeUnit;
        }
    }

    static {
        ImmutableMap.Builder put = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser());
        LocalCache.Strength strength = LocalCache.Strength.WEAK;
        VALUE_PARSERS = put.put("weakKeys", new KeyStrengthParser(strength)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(strength)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).buildOrThrow();
    }

    private CacheBuilderSpec(String str) {
        this.specification = str;
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    @CheckForNull
    private static Long durationInNanos(long j3, @CheckForNull TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String format(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CacheBuilderSpec parse(String str) {
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (String str2 : KEYS_SPLITTER.split(str)) {
                ImmutableList copyOf = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(str2));
                Preconditions.checkArgument(!copyOf.isEmpty(), "blank key-value pair");
                Preconditions.checkArgument(copyOf.size() <= 2, "key-value pair %s with more than one equals sign", str2);
                String str3 = (String) copyOf.get(0);
                ValueParser valueParser = VALUE_PARSERS.get(str3);
                Preconditions.checkArgument(valueParser != null, "unknown key %s", str3);
                valueParser.parse(cacheBuilderSpec, str3, copyOf.size() == 1 ? null : (String) copyOf.get(1));
            }
        }
        return cacheBuilderSpec;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        return Objects.equal(this.initialCapacity, cacheBuilderSpec.initialCapacity) && Objects.equal(this.maximumSize, cacheBuilderSpec.maximumSize) && Objects.equal(this.maximumWeight, cacheBuilderSpec.maximumWeight) && Objects.equal(this.concurrencyLevel, cacheBuilderSpec.concurrencyLevel) && Objects.equal(this.keyStrength, cacheBuilderSpec.keyStrength) && Objects.equal(this.valueStrength, cacheBuilderSpec.valueStrength) && Objects.equal(this.recordStats, cacheBuilderSpec.recordStats) && Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(cacheBuilderSpec.writeExpirationDuration, cacheBuilderSpec.writeExpirationTimeUnit)) && Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(cacheBuilderSpec.accessExpirationDuration, cacheBuilderSpec.accessExpirationTimeUnit)) && Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(cacheBuilderSpec.refreshDuration, cacheBuilderSpec.refreshTimeUnit));
    }

    public int hashCode() {
        return Objects.hashCode(this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit));
    }

    CacheBuilder<Object, Object> toCacheBuilder() {
        CacheBuilder<Object, Object> newBuilder = CacheBuilder.newBuilder();
        Integer num = this.initialCapacity;
        if (num != null) {
            newBuilder.initialCapacity(num.intValue());
        }
        Long l3 = this.maximumSize;
        if (l3 != null) {
            newBuilder.maximumSize(l3.longValue());
        }
        Long l4 = this.maximumWeight;
        if (l4 != null) {
            newBuilder.maximumWeight(l4.longValue());
        }
        Integer num2 = this.concurrencyLevel;
        if (num2 != null) {
            newBuilder.concurrencyLevel(num2.intValue());
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            if (AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[strength.ordinal()] != 1) {
                throw new AssertionError();
            }
            newBuilder.weakKeys();
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            int i3 = AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[strength2.ordinal()];
            if (i3 == 1) {
                newBuilder.weakValues();
            } else {
                if (i3 != 2) {
                    throw new AssertionError();
                }
                newBuilder.softValues();
            }
        }
        Boolean bool = this.recordStats;
        if (bool != null && bool.booleanValue()) {
            newBuilder.recordStats();
        }
        TimeUnit timeUnit = this.writeExpirationTimeUnit;
        if (timeUnit != null) {
            newBuilder.expireAfterWrite(this.writeExpirationDuration, timeUnit);
        }
        TimeUnit timeUnit2 = this.accessExpirationTimeUnit;
        if (timeUnit2 != null) {
            newBuilder.expireAfterAccess(this.accessExpirationDuration, timeUnit2);
        }
        TimeUnit timeUnit3 = this.refreshTimeUnit;
        if (timeUnit3 != null) {
            newBuilder.refreshAfterWrite(this.refreshDuration, timeUnit3);
        }
        return newBuilder;
    }

    public String toParsableString() {
        return this.specification;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
    }
}
