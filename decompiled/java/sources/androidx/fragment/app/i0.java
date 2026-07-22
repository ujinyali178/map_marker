package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public abstract class i0 {

    class a implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1106c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f1107d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1108f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f1109g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f1110h;

        a(int i3, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f1106c = i3;
            this.f1107d = arrayList;
            this.f1108f = arrayList2;
            this.f1109g = arrayList3;
            this.f1110h = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i3 = 0; i3 < this.f1106c; i3++) {
                androidx.core.view.n.q((View) this.f1107d.get(i3), (String) this.f1108f.get(i3));
                androidx.core.view.n.q((View) this.f1109g.get(i3), (String) this.f1110h.get(i3));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (g(list, view, size)) {
            return;
        }
        if (androidx.core.view.n.h(view) != null) {
            list.add(view);
        }
        for (int i3 = size; i3 < list.size(); i3++) {
            View view2 = list.get(i3);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = viewGroup.getChildAt(i4);
                    if (!g(list, childAt, size) && androidx.core.view.n.h(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean g(List<View> list, View view, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (list.get(i4) == view) {
                return true;
            }
        }
        return false;
    }

    protected static boolean i(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    protected void h(View view, Rect rect) {
        if (androidx.core.view.n.i(view)) {
            RectF rectF = new RectF();
            rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object j(Object obj, Object obj2, Object obj3);

    public abstract Object k(Object obj, Object obj2, Object obj3);

    ArrayList<String> l(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = arrayList.get(i3);
            arrayList2.add(androidx.core.view.n.h(view));
            androidx.core.view.n.q(view, null);
        }
        return arrayList2;
    }

    public abstract void m(Object obj, View view, ArrayList<View> arrayList);

    public abstract void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void o(Object obj, Rect rect);

    public abstract void p(Object obj, View view);

    public void q(Fragment fragment, Object obj, androidx.core.os.f fVar, Runnable runnable) {
        runnable.run();
    }

    void r(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = arrayList.get(i3);
            String h3 = androidx.core.view.n.h(view2);
            arrayList4.add(h3);
            if (h3 != null) {
                androidx.core.view.n.q(view2, null);
                String str = map.get(h3);
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i4))) {
                        androidx.core.view.n.q(arrayList2.get(i4), h3);
                        break;
                    }
                    i4++;
                }
            }
        }
        androidx.core.view.k.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void s(Object obj, View view, ArrayList<View> arrayList);

    public abstract void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object u(Object obj);
}
