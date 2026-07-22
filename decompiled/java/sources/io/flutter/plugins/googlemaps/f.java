package io.flutter.plugins.googlemaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Tile;
import com.google.maps.android.clustering.Cluster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
class f {
    private static double A(Object obj) {
        return ((Number) obj).doubleValue();
    }

    private static float B(Object obj) {
        return ((Number) obj).floatValue();
    }

    private static Float C(Object obj) {
        if (obj == null) {
            return null;
        }
        return Float.valueOf(B(obj));
    }

    private static float D(Object obj, float f3) {
        return B(obj) * f3;
    }

    private static List<List<LatLng>> E(Object obj) {
        List<?> I = I(obj);
        ArrayList arrayList = new ArrayList(I.size());
        Iterator<?> it = I.iterator();
        while (it.hasNext()) {
            arrayList.add(P(it.next()));
        }
        return arrayList;
    }

    private static int F(Object obj) {
        return ((Number) obj).intValue();
    }

    static LatLng G(Object obj) {
        List<?> I = I(obj);
        return new LatLng(A(I.get(0)), A(I.get(1)));
    }

    private static LatLngBounds H(Object obj) {
        if (obj == null) {
            return null;
        }
        List<?> I = I(obj);
        return new LatLngBounds(G(I.get(0)), G(I.get(1)));
    }

    private static List<?> I(Object obj) {
        return (List) obj;
    }

    private static Map<?, ?> J(Object obj) {
        return (Map) obj;
    }

    private static Map<String, Object> K(Object obj) {
        HashMap hashMap = new HashMap();
        Map map = (Map) obj;
        for (Object obj2 : map.keySet()) {
            Object obj3 = map.get(obj2);
            if (obj3 != null) {
                hashMap.put((String) obj2, obj3);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        if (r3.equals("dot") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.google.android.gms.maps.model.PatternItem> L(java.lang.Object r7) {
        /*
            java.util.List r7 = I(r7)
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto Lc
            r7 = 0
            return r7
        Lc:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L19:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto La5
            java.lang.Object r1 = r7.next()
            java.util.List r1 = I(r1)
            r2 = 0
            java.lang.Object r3 = r1.get(r2)
            java.lang.String r3 = Q(r3)
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 1
            switch(r5) {
                case 99657: goto L54;
                case 102102: goto L49;
                case 3075986: goto L3e;
                default: goto L3c;
            }
        L3c:
            r2 = -1
            goto L5d
        L3e:
            java.lang.String r2 = "dash"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L47
            goto L3c
        L47:
            r2 = 2
            goto L5d
        L49:
            java.lang.String r2 = "gap"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L52
            goto L3c
        L52:
            r2 = 1
            goto L5d
        L54:
            java.lang.String r5 = "dot"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L5d
            goto L3c
        L5d:
            switch(r2) {
                case 0: goto L9b;
                case 1: goto L8d;
                case 2: goto L7c;
                default: goto L60;
            }
        L60:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " as PatternItem"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r7.<init>(r0)
            throw r7
        L7c:
            com.google.android.gms.maps.model.Dash r2 = new com.google.android.gms.maps.model.Dash
            java.lang.Object r1 = r1.get(r6)
            float r1 = B(r1)
            r2.<init>(r1)
        L89:
            r0.add(r2)
            goto L19
        L8d:
            com.google.android.gms.maps.model.Gap r2 = new com.google.android.gms.maps.model.Gap
            java.lang.Object r1 = r1.get(r6)
            float r1 = B(r1)
            r2.<init>(r1)
            goto L89
        L9b:
            com.google.android.gms.maps.model.Dot r1 = new com.google.android.gms.maps.model.Dot
            r1.<init>()
            r0.add(r1)
            goto L19
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.f.L(java.lang.Object):java.util.List");
    }

    private static int M(Object obj, float f3) {
        return (int) D(obj, f3);
    }

    static Point N(Object obj) {
        return new Point(((Integer) J(obj).get("x")).intValue(), ((Integer) J(obj).get("y")).intValue());
    }

    private static Point O(Object obj, float f3) {
        List<?> I = I(obj);
        return new Point(M(I.get(0), f3), M(I.get(1), f3));
    }

    static List<LatLng> P(Object obj) {
        List<?> I = I(obj);
        ArrayList arrayList = new ArrayList(I.size());
        Iterator<?> it = I.iterator();
        while (it.hasNext()) {
            List<?> I2 = I(it.next());
            arrayList.add(new LatLng(A(I2.get(0)), A(I2.get(1))));
        }
        return arrayList;
    }

    private static String Q(Object obj) {
        return (String) obj;
    }

    static Object a(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("bearing", Float.valueOf(cameraPosition.bearing));
        hashMap.put("target", o(cameraPosition.target));
        hashMap.put("tilt", Float.valueOf(cameraPosition.tilt));
        hashMap.put("zoom", Float.valueOf(cameraPosition.zoom));
        return hashMap;
    }

    static Object b(String str) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("circleId", str);
        return hashMap;
    }

    static Object c(String str, Cluster<n> cluster) {
        int size = cluster.getSize();
        LatLngBounds.Builder builder = LatLngBounds.builder();
        String[] strArr = new String[size];
        n[] nVarArr = (n[]) cluster.getItems().toArray(new n[size]);
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = nVarArr[i3];
            builder.include(nVar.getPosition());
            strArr[i3] = nVar.n();
        }
        Object o3 = o(cluster.getPosition());
        Object n3 = n(builder.build());
        HashMap hashMap = new HashMap(4);
        hashMap.put("clusterManagerId", str);
        hashMap.put("position", o3);
        hashMap.put("bounds", n3);
        hashMap.put("markerIds", Arrays.asList(strArr));
        return hashMap;
    }

    static Object d(String str, Set<? extends Cluster<n>> set) {
        ArrayList arrayList = new ArrayList(set.size());
        Iterator<? extends Cluster<n>> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(c(str, it.next()));
        }
        return arrayList;
    }

    private static BitmapDescriptor e(List<?> list) {
        if (list.size() == 2) {
            try {
                return BitmapDescriptorFactory.fromBitmap(u(list.get(1)));
            } catch (Exception e3) {
                throw new IllegalArgumentException("Unable to interpret bytes as a valid image.", e3);
            }
        }
        throw new IllegalArgumentException("fromBytes should have exactly one argument, interpretTileOverlayOptions the bytes. Got: " + list.size());
    }

    static String f(Object obj, c cVar) {
        Map<?, ?> J = J(obj);
        Object obj2 = J.get("consumeTapEvents");
        if (obj2 != null) {
            cVar.b(w(obj2));
        }
        Object obj3 = J.get("fillColor");
        if (obj3 != null) {
            cVar.f(F(obj3));
        }
        Object obj4 = J.get("strokeColor");
        if (obj4 != null) {
            cVar.c(F(obj4));
        }
        Object obj5 = J.get("visible");
        if (obj5 != null) {
            cVar.setVisible(w(obj5));
        }
        if (J.get("strokeWidth") != null) {
            cVar.setStrokeWidth(F(r0));
        }
        Object obj6 = J.get("zIndex");
        if (obj6 != null) {
            cVar.a(B(obj6));
        }
        Object obj7 = J.get("center");
        if (obj7 != null) {
            cVar.h(G(obj7));
        }
        Object obj8 = J.get("radius");
        if (obj8 != null) {
            cVar.g(A(obj8));
        }
        String str = (String) J.get("circleId");
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("circleId was null");
    }

    static void g(Object obj, k kVar) {
        Map<?, ?> J = J(obj);
        Object obj2 = J.get("cameraTargetBounds");
        if (obj2 != null) {
            kVar.r(H(I(obj2).get(0)));
        }
        Object obj3 = J.get("compassEnabled");
        if (obj3 != null) {
            kVar.setCompassEnabled(w(obj3));
        }
        Object obj4 = J.get("mapToolbarEnabled");
        if (obj4 != null) {
            kVar.setMapToolbarEnabled(w(obj4));
        }
        Object obj5 = J.get("mapType");
        if (obj5 != null) {
            kVar.setMapType(F(obj5));
        }
        Object obj6 = J.get("minMaxZoomPreference");
        if (obj6 != null) {
            List<?> I = I(obj6);
            kVar.k(C(I.get(0)), C(I.get(1)));
        }
        Object obj7 = J.get("padding");
        if (obj7 != null) {
            List<?> I2 = I(obj7);
            kVar.l(B(I2.get(0)), B(I2.get(1)), B(I2.get(2)), B(I2.get(3)));
        }
        Object obj8 = J.get("rotateGesturesEnabled");
        if (obj8 != null) {
            kVar.setRotateGesturesEnabled(w(obj8));
        }
        Object obj9 = J.get("scrollGesturesEnabled");
        if (obj9 != null) {
            kVar.setScrollGesturesEnabled(w(obj9));
        }
        Object obj10 = J.get("tiltGesturesEnabled");
        if (obj10 != null) {
            kVar.setTiltGesturesEnabled(w(obj10));
        }
        Object obj11 = J.get("trackCameraPosition");
        if (obj11 != null) {
            kVar.g(w(obj11));
        }
        Object obj12 = J.get("zoomGesturesEnabled");
        if (obj12 != null) {
            kVar.setZoomGesturesEnabled(w(obj12));
        }
        Object obj13 = J.get("liteModeEnabled");
        if (obj13 != null) {
            kVar.p(w(obj13));
        }
        Object obj14 = J.get("myLocationEnabled");
        if (obj14 != null) {
            kVar.setMyLocationEnabled(w(obj14));
        }
        Object obj15 = J.get("zoomControlsEnabled");
        if (obj15 != null) {
            kVar.setZoomControlsEnabled(w(obj15));
        }
        Object obj16 = J.get("myLocationButtonEnabled");
        if (obj16 != null) {
            kVar.setMyLocationButtonEnabled(w(obj16));
        }
        Object obj17 = J.get("indoorEnabled");
        if (obj17 != null) {
            kVar.setIndoorEnabled(w(obj17));
        }
        Object obj18 = J.get("trafficEnabled");
        if (obj18 != null) {
            kVar.setTrafficEnabled(w(obj18));
        }
        Object obj19 = J.get("buildingsEnabled");
        if (obj19 != null) {
            kVar.setBuildingsEnabled(w(obj19));
        }
        Object obj20 = J.get("style");
        if (obj20 != null) {
            kVar.t(Q(obj20));
        }
    }

    private static void h(p pVar, Map<String, Object> map) {
        String str = (String) map.get("title");
        String str2 = (String) map.get("snippet");
        if (str != null) {
            pVar.h(str, str2);
        }
        Object obj = map.get("anchor");
        if (obj != null) {
            List<?> I = I(obj);
            pVar.e(B(I.get(0)), B(I.get(1)));
        }
    }

    static void i(Object obj, p pVar) {
        Map<?, ?> J = J(obj);
        Object obj2 = J.get("alpha");
        if (obj2 != null) {
            pVar.i(B(obj2));
        }
        Object obj3 = J.get("anchor");
        if (obj3 != null) {
            List<?> I = I(obj3);
            pVar.f(B(I.get(0)), B(I.get(1)));
        }
        Object obj4 = J.get("consumeTapEvents");
        if (obj4 != null) {
            pVar.b(w(obj4));
        }
        Object obj5 = J.get("draggable");
        if (obj5 != null) {
            pVar.c(w(obj5));
        }
        Object obj6 = J.get("flat");
        if (obj6 != null) {
            pVar.d(w(obj6));
        }
        Object obj7 = J.get("icon");
        if (obj7 != null) {
            pVar.g(v(obj7));
        }
        Object obj8 = J.get("infoWindow");
        if (obj8 != null) {
            h(pVar, K(obj8));
        }
        Object obj9 = J.get("position");
        if (obj9 != null) {
            pVar.setPosition(G(obj9));
        }
        Object obj10 = J.get("rotation");
        if (obj10 != null) {
            pVar.j(B(obj10));
        }
        Object obj11 = J.get("visible");
        if (obj11 != null) {
            pVar.setVisible(w(obj11));
        }
        Object obj12 = J.get("zIndex");
        if (obj12 != null) {
            pVar.a(B(obj12));
        }
    }

    static String j(Object obj, t tVar) {
        Map<?, ?> J = J(obj);
        Object obj2 = J.get("consumeTapEvents");
        if (obj2 != null) {
            tVar.b(w(obj2));
        }
        Object obj3 = J.get("geodesic");
        if (obj3 != null) {
            tVar.d(w(obj3));
        }
        Object obj4 = J.get("visible");
        if (obj4 != null) {
            tVar.setVisible(w(obj4));
        }
        Object obj5 = J.get("fillColor");
        if (obj5 != null) {
            tVar.f(F(obj5));
        }
        Object obj6 = J.get("strokeColor");
        if (obj6 != null) {
            tVar.c(F(obj6));
        }
        if (J.get("strokeWidth") != null) {
            tVar.setStrokeWidth(F(r0));
        }
        Object obj7 = J.get("zIndex");
        if (obj7 != null) {
            tVar.a(B(obj7));
        }
        Object obj8 = J.get("points");
        if (obj8 != null) {
            tVar.e(P(obj8));
        }
        Object obj9 = J.get("holes");
        if (obj9 != null) {
            tVar.g(E(obj9));
        }
        String str = (String) J.get("polygonId");
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("polygonId was null");
    }

    static String k(Object obj, x xVar) {
        Map<?, ?> J = J(obj);
        Object obj2 = J.get("consumeTapEvents");
        if (obj2 != null) {
            xVar.b(w(obj2));
        }
        Object obj3 = J.get("color");
        if (obj3 != null) {
            xVar.setColor(F(obj3));
        }
        Object obj4 = J.get("endCap");
        if (obj4 != null) {
            xVar.f(z(obj4));
        }
        Object obj5 = J.get("geodesic");
        if (obj5 != null) {
            xVar.d(w(obj5));
        }
        Object obj6 = J.get("jointType");
        if (obj6 != null) {
            xVar.g(F(obj6));
        }
        Object obj7 = J.get("startCap");
        if (obj7 != null) {
            xVar.i(z(obj7));
        }
        Object obj8 = J.get("visible");
        if (obj8 != null) {
            xVar.setVisible(w(obj8));
        }
        if (J.get("width") != null) {
            xVar.h(F(r0));
        }
        Object obj9 = J.get("zIndex");
        if (obj9 != null) {
            xVar.a(B(obj9));
        }
        Object obj10 = J.get("points");
        if (obj10 != null) {
            xVar.e(P(obj10));
        }
        Object obj11 = J.get("pattern");
        if (obj11 != null) {
            xVar.c(L(obj11));
        }
        String str = (String) J.get("polylineId");
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("polylineId was null");
    }

    static Tile l(Map<String, ?> map) {
        return new Tile(F(map.get("width")), F(map.get("height")), map.get("data") != null ? (byte[]) map.get("data") : null);
    }

    static String m(Map<String, ?> map, b0 b0Var) {
        Object obj = map.get("fadeIn");
        if (obj != null) {
            b0Var.b(w(obj));
        }
        Object obj2 = map.get("transparency");
        if (obj2 != null) {
            b0Var.c(B(obj2));
        }
        Object obj3 = map.get("zIndex");
        if (obj3 != null) {
            b0Var.a(B(obj3));
        }
        Object obj4 = map.get("visible");
        if (obj4 != null) {
            b0Var.setVisible(w(obj4));
        }
        String str = (String) map.get("tileOverlayId");
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("tileOverlayId was null");
    }

    static Object n(LatLngBounds latLngBounds) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("southwest", o(latLngBounds.southwest));
        hashMap.put("northeast", o(latLngBounds.northeast));
        return hashMap;
    }

    static Object o(LatLng latLng) {
        return Arrays.asList(Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude));
    }

    static Object p(String str) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("markerId", str);
        return hashMap;
    }

    static Map<String, Integer> q(Point point) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("x", Integer.valueOf(point.x));
        hashMap.put("y", Integer.valueOf(point.y));
        return hashMap;
    }

    static Object r(String str) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("polygonId", str);
        return hashMap;
    }

    static Object s(String str) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("polylineId", str);
        return hashMap;
    }

    static Map<String, Object> t(String str, int i3, int i4, int i5) {
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("tileOverlayId", str);
        hashMap.put("x", Integer.valueOf(i3));
        hashMap.put("y", Integer.valueOf(i4));
        hashMap.put("zoom", Integer.valueOf(i5));
        return hashMap;
    }

    private static Bitmap u(Object obj) {
        byte[] bArr = (byte[]) obj;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray != null) {
            return decodeByteArray;
        }
        throw new IllegalArgumentException("Unable to decode bytes as a valid bitmap.");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0044, code lost:
    
        if (r2.equals("fromAssetImage") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.maps.model.BitmapDescriptor v(java.lang.Object r8) {
        /*
            java.util.List r0 = I(r8)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = Q(r2)
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = -1
            switch(r3) {
                case -458749035: goto L3e;
                case 52960614: goto L33;
                case 54063841: goto L28;
                case 784458203: goto L1d;
                default: goto L1b;
            }
        L1b:
            r1 = -1
            goto L47
        L1d:
            java.lang.String r1 = "defaultMarker"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L26
            goto L1b
        L26:
            r1 = 3
            goto L47
        L28:
            java.lang.String r1 = "fromBytes"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L31
            goto L1b
        L31:
            r1 = 2
            goto L47
        L33:
            java.lang.String r1 = "fromAsset"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L3c
            goto L1b
        L3c:
            r1 = 1
            goto L47
        L3e:
            java.lang.String r3 = "fromAssetImage"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L47
            goto L1b
        L47:
            switch(r1) {
                case 0: goto Lb3;
                case 1: goto L83;
                case 2: goto L7e;
                case 3: goto L66;
                default: goto L4a;
            }
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = " as BitmapDescriptor"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L66:
            int r8 = r0.size()
            if (r8 != r6) goto L71
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker()
            return r8
        L71:
            java.lang.Object r8 = r0.get(r6)
            float r8 = B(r8)
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker(r8)
            return r8
        L7e:
            com.google.android.gms.maps.model.BitmapDescriptor r8 = e(r0)
            return r8
        L83:
            int r8 = r0.size()
            if (r8 != r5) goto L9a
            java.lang.Object r8 = r0.get(r6)
            java.lang.String r8 = Q(r8)
            java.lang.String r8 = io.flutter.view.s.c(r8)
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r8)
            return r8
        L9a:
            java.lang.Object r8 = r0.get(r6)
            java.lang.String r8 = Q(r8)
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = Q(r0)
            java.lang.String r8 = io.flutter.view.s.d(r8, r0)
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r8)
            return r8
        Lb3:
            int r8 = r0.size()
            if (r8 != r4) goto Lca
            java.lang.Object r8 = r0.get(r6)
            java.lang.String r8 = Q(r8)
            java.lang.String r8 = io.flutter.view.s.c(r8)
            com.google.android.gms.maps.model.BitmapDescriptor r8 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r8)
            return r8
        Lca:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "'fromAssetImage' Expected exactly 3 arguments, got: "
            r1.append(r2)
            int r0 = r0.size()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.f.v(java.lang.Object):com.google.android.gms.maps.model.BitmapDescriptor");
    }

    private static boolean w(Object obj) {
        return ((Boolean) obj).booleanValue();
    }

    static CameraPosition x(Object obj) {
        Map<?, ?> J = J(obj);
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.bearing(B(J.get("bearing")));
        builder.target(G(J.get("target")));
        builder.tilt(B(J.get("tilt")));
        builder.zoom(B(J.get("zoom")));
        return builder.build();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007d, code lost:
    
        if (r2.equals("newLatLng") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.maps.CameraUpdate y(java.lang.Object r7, float r8) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.f.y(java.lang.Object, float):com.google.android.gms.maps.CameraUpdate");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0044, code lost:
    
        if (r2.equals("roundCap") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.maps.model.Cap z(java.lang.Object r7) {
        /*
            java.util.List r0 = I(r7)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = Q(r2)
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = 2
            r5 = 1
            r5 = 1
            r6 = -1
            switch(r3) {
                case -179356: goto L3e;
                case 241309887: goto L33;
                case 1314340213: goto L28;
                case 1611528865: goto L1d;
                default: goto L1b;
            }
        L1b:
            r1 = -1
            goto L47
        L1d:
            java.lang.String r1 = "customCap"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L26
            goto L1b
        L26:
            r1 = 3
            goto L47
        L28:
            java.lang.String r1 = "squareCap"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L31
            goto L1b
        L31:
            r1 = 2
            goto L47
        L33:
            java.lang.String r1 = "buttCap"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L3c
            goto L1b
        L3c:
            r1 = 1
            goto L47
        L3e:
            java.lang.String r3 = "roundCap"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L47
            goto L1b
        L47:
            switch(r1) {
                case 0: goto L9c;
                case 1: goto L96;
                case 2: goto L90;
                case 3: goto L66;
                default: goto L4a;
            }
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = " as Cap"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L66:
            int r7 = r0.size()
            if (r7 != r4) goto L7a
            com.google.android.gms.maps.model.CustomCap r7 = new com.google.android.gms.maps.model.CustomCap
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.maps.model.BitmapDescriptor r0 = v(r0)
            r7.<init>(r0)
            return r7
        L7a:
            com.google.android.gms.maps.model.CustomCap r7 = new com.google.android.gms.maps.model.CustomCap
            java.lang.Object r1 = r0.get(r5)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = v(r1)
            java.lang.Object r0 = r0.get(r4)
            float r0 = B(r0)
            r7.<init>(r1, r0)
            return r7
        L90:
            com.google.android.gms.maps.model.SquareCap r7 = new com.google.android.gms.maps.model.SquareCap
            r7.<init>()
            return r7
        L96:
            com.google.android.gms.maps.model.ButtCap r7 = new com.google.android.gms.maps.model.ButtCap
            r7.<init>()
            return r7
        L9c:
            com.google.android.gms.maps.model.RoundCap r7 = new com.google.android.gms.maps.model.RoundCap
            r7.<init>()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.f.z(java.lang.Object):com.google.android.gms.maps.model.Cap");
    }
}
