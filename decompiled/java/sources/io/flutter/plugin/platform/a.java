package io.flutter.plugin.platform;

import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: /root/release/classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private io.flutter.view.h f3127a;

    a() {
    }

    public boolean a(MotionEvent motionEvent, boolean z3) {
        io.flutter.view.h hVar = this.f3127a;
        if (hVar == null) {
            return false;
        }
        return hVar.M(motionEvent, z3);
    }

    public boolean b(View view, View view2, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.h hVar = this.f3127a;
        if (hVar == null) {
            return false;
        }
        return hVar.w(view, view2, accessibilityEvent);
    }

    void c(io.flutter.view.h hVar) {
        this.f3127a = hVar;
    }
}
