package io.flutter.plugin.editing;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import t1.q;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class f implements q.b, SpellCheckerSession.SpellCheckerSessionListener {

    /* renamed from: a, reason: collision with root package name */
    private final q f3079a;

    /* renamed from: b, reason: collision with root package name */
    private final TextServicesManager f3080b;

    /* renamed from: c, reason: collision with root package name */
    private SpellCheckerSession f3081c;

    /* renamed from: d, reason: collision with root package name */
    l.d f3082d;

    public f(TextServicesManager textServicesManager, q qVar) {
        this.f3080b = textServicesManager;
        this.f3079a = qVar;
        qVar.b(this);
    }

    @Override // t1.q.b
    public void a(String str, String str2, l.d dVar) {
        if (this.f3082d != null) {
            dVar.b("error", "Previous spell check request still pending.", null);
        } else {
            this.f3082d = dVar;
            c(str, str2);
        }
    }

    public void b() {
        this.f3079a.b(null);
        SpellCheckerSession spellCheckerSession = this.f3081c;
        if (spellCheckerSession != null) {
            spellCheckerSession.close();
        }
    }

    public void c(String str, String str2) {
        Locale b4 = v1.b.b(str);
        if (this.f3081c == null) {
            this.f3081c = this.f3080b.newSpellCheckerSession(null, b4, this, true);
        }
        this.f3081c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        ArrayList arrayList;
        l.d dVar;
        if (sentenceSuggestionsInfoArr.length == 0) {
            dVar = this.f3082d;
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList();
            SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
            if (sentenceSuggestionsInfo == null) {
                dVar = this.f3082d;
                arrayList = new ArrayList();
            } else {
                for (int i3 = 0; i3 < sentenceSuggestionsInfo.getSuggestionsCount(); i3++) {
                    SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i3);
                    int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
                    if (suggestionsCount > 0) {
                        HashMap hashMap = new HashMap();
                        int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i3);
                        int lengthAt = sentenceSuggestionsInfo.getLengthAt(i3) + offsetAt;
                        hashMap.put("startIndex", Integer.valueOf(offsetAt));
                        hashMap.put("endIndex", Integer.valueOf(lengthAt));
                        ArrayList arrayList2 = new ArrayList();
                        boolean z3 = false;
                        for (int i4 = 0; i4 < suggestionsCount; i4++) {
                            String suggestionAt = suggestionsInfoAt.getSuggestionAt(i4);
                            if (!suggestionAt.equals("")) {
                                arrayList2.add(suggestionAt);
                                z3 = true;
                            }
                        }
                        if (z3) {
                            hashMap.put("suggestions", arrayList2);
                            arrayList.add(hashMap);
                        }
                    }
                }
                dVar = this.f3082d;
            }
        }
        dVar.a(arrayList);
        this.f3082d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}
