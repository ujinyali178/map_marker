package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: /root/release/classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f3050a;

    public a(FlutterJNI flutterJNI) {
        this.f3050a = flutterJNI;
    }

    public int a(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i4 = length - 1;
        if (i3 >= i4) {
            return length;
        }
        int codePointAt = Character.codePointAt(charSequence, i3);
        int charCount = Character.charCount(codePointAt);
        int i5 = i3 + charCount;
        int i6 = 0;
        if (i5 == 0) {
            return 0;
        }
        if (codePointAt == 10) {
            if (Character.codePointAt(charSequence, i5) == 13) {
                charCount++;
            }
            return i3 + charCount;
        }
        if (g(codePointAt)) {
            if (i5 >= i4 || !g(Character.codePointAt(charSequence, i5))) {
                return i5;
            }
            int i7 = i3;
            while (i7 > 0 && g(Character.codePointBefore(charSequence, i3))) {
                i7 -= Character.charCount(Character.codePointBefore(charSequence, i3));
                i6++;
            }
            if (i6 % 2 == 0) {
                charCount += 2;
            }
            return i3 + charCount;
        }
        if (f(codePointAt)) {
            charCount += Character.charCount(codePointAt);
        }
        if (codePointAt == 8419) {
            int codePointBefore = Character.codePointBefore(charSequence, i5);
            int charCount2 = i5 + Character.charCount(codePointBefore);
            if (charCount2 < length && i(codePointBefore)) {
                int codePointAt2 = Character.codePointAt(charSequence, charCount2);
                if (f(codePointAt2)) {
                    charCount += Character.charCount(codePointBefore) + Character.charCount(codePointAt2);
                }
            } else if (f(codePointBefore)) {
                charCount += Character.charCount(codePointBefore);
            }
            return i3 + charCount;
        }
        if (c(codePointAt)) {
            boolean z3 = false;
            int i8 = 0;
            do {
                if (z3) {
                    charCount += Character.charCount(codePointAt) + i8 + 1;
                    z3 = false;
                }
                if (d(codePointAt)) {
                    break;
                }
                if (i5 < length) {
                    codePointAt = Character.codePointAt(charSequence, i5);
                    i5 += Character.charCount(codePointAt);
                    if (codePointAt != 8419) {
                        if (!d(codePointAt) && !i(codePointAt)) {
                            if (codePointAt == 8205) {
                                codePointAt = Character.codePointAt(charSequence, i5);
                                i5 += Character.charCount(codePointAt);
                                if (i5 < length && i(codePointAt)) {
                                    codePointAt = Character.codePointAt(charSequence, i5);
                                    int charCount3 = Character.charCount(codePointAt);
                                    i5 += Character.charCount(codePointAt);
                                    i8 = charCount3;
                                    z3 = true;
                                    if (i5 < length || !z3) {
                                        break;
                                        break;
                                    }
                                } else {
                                    z3 = true;
                                }
                            }
                        } else {
                            charCount += Character.charCount(codePointAt) + 0;
                            break;
                        }
                    } else {
                        int codePointBefore2 = Character.codePointBefore(charSequence, i5);
                        int charCount4 = i5 + Character.charCount(codePointBefore2);
                        if (charCount4 < length && i(codePointBefore2)) {
                            int codePointAt3 = Character.codePointAt(charSequence, charCount4);
                            if (f(codePointAt3)) {
                                charCount += Character.charCount(codePointBefore2) + Character.charCount(codePointAt3);
                            }
                        } else if (f(codePointBefore2)) {
                            charCount += Character.charCount(codePointBefore2);
                        }
                        return i3 + charCount;
                    }
                }
                i8 = 0;
                if (i5 < length) {
                    break;
                }
            } while (c(codePointAt));
        }
        return i3 + charCount;
    }

    public int b(CharSequence charSequence, int i3) {
        int codePointBefore;
        int charCount;
        int charCount2;
        int i4 = 0;
        int i5 = 1;
        if (i3 <= 1 || (charCount2 = i3 - (charCount = Character.charCount((codePointBefore = Character.codePointBefore(charSequence, i3))))) == 0) {
            return 0;
        }
        if (codePointBefore == 10) {
            if (Character.codePointBefore(charSequence, charCount2) == 13) {
                charCount++;
            }
            return i3 - charCount;
        }
        if (g(codePointBefore)) {
            int codePointBefore2 = Character.codePointBefore(charSequence, charCount2);
            int charCount3 = charCount2 - Character.charCount(codePointBefore2);
            while (charCount3 > 0 && g(codePointBefore2)) {
                codePointBefore2 = Character.codePointBefore(charSequence, charCount3);
                charCount3 -= Character.charCount(codePointBefore2);
                i5++;
            }
            if (i5 % 2 == 0) {
                charCount += 2;
            }
            return i3 - charCount;
        }
        if (codePointBefore == 8419) {
            int codePointBefore3 = Character.codePointBefore(charSequence, charCount2);
            int charCount4 = charCount2 - Character.charCount(codePointBefore3);
            if (charCount4 > 0 && i(codePointBefore3)) {
                int codePointBefore4 = Character.codePointBefore(charSequence, charCount4);
                if (f(codePointBefore4)) {
                    charCount += Character.charCount(codePointBefore3) + Character.charCount(codePointBefore4);
                }
            } else if (f(codePointBefore3)) {
                charCount += Character.charCount(codePointBefore3);
            }
            return i3 - charCount;
        }
        if (codePointBefore == 917631) {
            while (true) {
                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                charCount2 -= Character.charCount(codePointBefore);
                if (charCount2 <= 0 || !h(codePointBefore)) {
                    break;
                }
                charCount += Character.charCount(codePointBefore);
            }
            if (!c(codePointBefore)) {
                return i3 - 2;
            }
            charCount += Character.charCount(codePointBefore);
        }
        if (i(codePointBefore)) {
            codePointBefore = Character.codePointBefore(charSequence, charCount2);
            if (!c(codePointBefore)) {
                return i3 - charCount;
            }
            charCount += Character.charCount(codePointBefore);
            charCount2 -= charCount;
        }
        if (c(codePointBefore)) {
            boolean z3 = false;
            int i6 = 0;
            while (true) {
                if (z3) {
                    charCount += Character.charCount(codePointBefore) + i6 + 1;
                    z3 = false;
                }
                if (d(codePointBefore)) {
                    int codePointBefore5 = Character.codePointBefore(charSequence, charCount2);
                    int charCount5 = charCount2 - Character.charCount(codePointBefore5);
                    if (charCount5 > 0 && i(codePointBefore5)) {
                        codePointBefore5 = Character.codePointBefore(charSequence, charCount5);
                        if (!c(codePointBefore5)) {
                            return i3 - charCount;
                        }
                        i4 = Character.charCount(codePointBefore5);
                        Character.charCount(codePointBefore5);
                    }
                    if (e(codePointBefore5)) {
                        charCount += i4 + Character.charCount(codePointBefore5);
                    }
                } else {
                    if (charCount2 > 0) {
                        codePointBefore = Character.codePointBefore(charSequence, charCount2);
                        charCount2 -= Character.charCount(codePointBefore);
                        if (codePointBefore == 8205) {
                            codePointBefore = Character.codePointBefore(charSequence, charCount2);
                            charCount2 -= Character.charCount(codePointBefore);
                            if (charCount2 > 0 && i(codePointBefore)) {
                                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                int charCount6 = Character.charCount(codePointBefore);
                                charCount2 -= Character.charCount(codePointBefore);
                                i6 = charCount6;
                                z3 = true;
                                if (charCount2 != 0 || !z3 || !c(codePointBefore)) {
                                    break;
                                    break;
                                }
                            } else {
                                z3 = true;
                            }
                        }
                    }
                    i6 = 0;
                    if (charCount2 != 0) {
                        break;
                    }
                }
            }
        }
        return i3 - charCount;
    }

    public boolean c(int i3) {
        return this.f3050a.isCodePointEmoji(i3);
    }

    public boolean d(int i3) {
        return this.f3050a.isCodePointEmojiModifier(i3);
    }

    public boolean e(int i3) {
        return this.f3050a.isCodePointEmojiModifierBase(i3);
    }

    public boolean f(int i3) {
        return (48 <= i3 && i3 <= 57) || i3 == 35 || i3 == 42;
    }

    public boolean g(int i3) {
        return this.f3050a.isCodePointRegionalIndicator(i3);
    }

    public boolean h(int i3) {
        return 917536 <= i3 && i3 <= 917630;
    }

    public boolean i(int i3) {
        return this.f3050a.isCodePointVariantSelector(i3);
    }
}
