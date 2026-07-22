package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;

    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.outerSplitter = splitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(splitter2);
        }

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.outerSplitter.split(charSequence)) {
                Iterator splittingIterator = this.entrySplitter.splittingIterator(str);
                Preconditions.checkArgument(splittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                String str2 = (String) splittingIterator.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                Preconditions.checkArgument(splittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                linkedHashMap.put(str2, (String) splittingIterator.next());
                Preconditions.checkArgument(!splittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    private static abstract class SplittingIterator extends AbstractIterator<String> {
        int limit;
        int offset = 0;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        
            if (r0 >= r1) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
        
            if (r6.trimmer.matches(r6.toSplit.charAt(r0)) == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        
            r0 = r0 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
        
            if (r1 <= r0) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        
            if (r6.trimmer.matches(r6.toSplit.charAt(r1 - 1)) == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        
            r1 = r1 - 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        
            if (r6.omitEmptyStrings == false) goto L39;
         */
        @Override // com.google.common.base.AbstractIterator
        @javax.annotation.CheckForNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String computeNext() {
            /*
                r6 = this;
            L0:
                int r0 = r6.offset
            L2:
                int r1 = r6.offset
                r2 = -1
                if (r1 == r2) goto L8e
                int r1 = r6.separatorStart(r1)
                if (r1 != r2) goto L16
                java.lang.CharSequence r1 = r6.toSplit
                int r1 = r1.length()
                r6.offset = r2
                goto L1c
            L16:
                int r3 = r6.separatorEnd(r1)
                r6.offset = r3
            L1c:
                int r3 = r6.offset
                if (r3 != r0) goto L2f
                int r3 = r3 + 1
                r6.offset = r3
                java.lang.CharSequence r1 = r6.toSplit
                int r1 = r1.length()
                if (r3 <= r1) goto L2
                r6.offset = r2
                goto L2
            L2f:
                if (r0 >= r1) goto L42
                com.google.common.base.CharMatcher r3 = r6.trimmer
                java.lang.CharSequence r4 = r6.toSplit
                char r4 = r4.charAt(r0)
                boolean r3 = r3.matches(r4)
                if (r3 == 0) goto L42
                int r0 = r0 + 1
                goto L2f
            L42:
                if (r1 <= r0) goto L57
                com.google.common.base.CharMatcher r3 = r6.trimmer
                java.lang.CharSequence r4 = r6.toSplit
                int r5 = r1 + (-1)
                char r4 = r4.charAt(r5)
                boolean r3 = r3.matches(r4)
                if (r3 == 0) goto L57
                int r1 = r1 + (-1)
                goto L42
            L57:
                boolean r3 = r6.omitEmptyStrings
                if (r3 == 0) goto L5e
                if (r0 != r1) goto L5e
                goto L0
            L5e:
                int r3 = r6.limit
                r4 = 1
                if (r3 != r4) goto L80
                java.lang.CharSequence r1 = r6.toSplit
                int r1 = r1.length()
                r6.offset = r2
            L6b:
                if (r1 <= r0) goto L83
                com.google.common.base.CharMatcher r2 = r6.trimmer
                java.lang.CharSequence r3 = r6.toSplit
                int r4 = r1 + (-1)
                char r3 = r3.charAt(r4)
                boolean r2 = r2.matches(r3)
                if (r2 == 0) goto L83
                int r1 = r1 + (-1)
                goto L6b
            L80:
                int r3 = r3 - r4
                r6.limit = r3
            L83:
                java.lang.CharSequence r2 = r6.toSplit
                java.lang.CharSequence r0 = r2.subSequence(r0, r1)
                java.lang.String r0 = r0.toString()
                return r0
            L8e:
                java.lang.Object r0 = r6.endOfData()
                java.lang.String r0 = (java.lang.String) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Splitter.SplittingIterator.computeNext():java.lang.String");
        }

        abstract int separatorEnd(int i3);

        abstract int separatorStart(int i3);
    }

    private interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    private Splitter(Strategy strategy, boolean z3, CharMatcher charMatcher, int i3) {
        this.strategy = strategy;
        this.omitEmptyStrings = z3;
        this.trimmer = charMatcher;
        this.limit = i3;
    }

    public static Splitter fixedLength(final int i3) {
        Preconditions.checkArgument(i3 > 0, "The length may not be less than 1");
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.4
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.4.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorEnd(int i4) {
                        return i4;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorStart(int i4) {
                        int i5 = i4 + i3;
                        if (i5 < this.toSplit.length()) {
                            return i5;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    public static Splitter on(char c3) {
        return on(CharMatcher.is(c3));
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.1
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.1.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int separatorEnd(int i3) {
                        return i3 + 1;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int separatorStart(int i3) {
                        return CharMatcher.this.indexIn(this.toSplit, i3);
                    }
                };
            }
        });
    }

    private static Splitter on(final CommonPattern commonPattern) {
        Preconditions.checkArgument(!commonPattern.matcher("").matches(), "The pattern may not match the empty string: %s", commonPattern);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.3
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                final CommonMatcher matcher = CommonPattern.this.matcher(charSequence);
                return new SplittingIterator(this, splitter, charSequence) { // from class: com.google.common.base.Splitter.3.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorEnd(int i3) {
                        return matcher.end();
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorStart(int i3) {
                        if (matcher.find(i3)) {
                            return matcher.start();
                        }
                        return -1;
                    }
                };
            }
        });
    }

    public static Splitter on(final String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        return str.length() == 1 ? on(str.charAt(0)) : new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.2
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.2.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorEnd(int i3) {
                        return i3 + str.length();
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
                    
                        r6 = r6 + 1;
                     */
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public int separatorStart(int r6) {
                        /*
                            r5 = this;
                            com.google.common.base.Splitter$2 r0 = com.google.common.base.Splitter.AnonymousClass2.this
                            java.lang.String r0 = r1
                            int r0 = r0.length()
                            java.lang.CharSequence r1 = r5.toSplit
                            int r1 = r1.length()
                            int r1 = r1 - r0
                        Lf:
                            if (r6 > r1) goto L2d
                            r2 = 0
                        L12:
                            if (r2 >= r0) goto L2c
                            java.lang.CharSequence r3 = r5.toSplit
                            int r4 = r2 + r6
                            char r3 = r3.charAt(r4)
                            com.google.common.base.Splitter$2 r4 = com.google.common.base.Splitter.AnonymousClass2.this
                            java.lang.String r4 = r1
                            char r4 = r4.charAt(r2)
                            if (r3 == r4) goto L29
                            int r6 = r6 + 1
                            goto Lf
                        L29:
                            int r2 = r2 + 1
                            goto L12
                        L2c:
                            return r6
                        L2d:
                            r6 = -1
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Splitter.AnonymousClass2.AnonymousClass1.separatorStart(int):int");
                    }
                };
            }
        });
    }

    public static Splitter on(Pattern pattern) {
        return on(new JdkPattern(pattern));
    }

    public static Splitter onPattern(String str) {
        return on(Platform.compilePattern(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }

    public Splitter limit(int i3) {
        Preconditions.checkArgument(i3 > 0, "must be greater than zero: %s", i3);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i3);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() { // from class: com.google.common.base.Splitter.5
            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return Splitter.this.splittingIterator(charSequence);
            }

            public String toString() {
                Joiner on = Joiner.on(", ");
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                StringBuilder appendTo = on.appendTo(sb, (Iterable<? extends Object>) this);
                appendTo.append(']');
                return appendTo.toString();
            }
        };
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> splittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (splittingIterator.hasNext()) {
            arrayList.add(splittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    public MapSplitter withKeyValueSeparator(char c3) {
        return withKeyValueSeparator(on(c3));
    }

    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(splitter);
    }

    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }
}
