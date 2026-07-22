package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Layer;
import com.google.maps.android.data.Renderer;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: /root/release/classes.dex */
public class KmlLayer extends Layer {
    public KmlLayer(GoogleMap googleMap, int i3, Context context) {
        this(googleMap, context.getResources().openRawResource(i3), context, new MarkerManager(googleMap), new PolygonManager(googleMap), new PolylineManager(googleMap), new GroundOverlayManager(googleMap), (Renderer.ImagesCache) null);
    }

    public KmlLayer(GoogleMap googleMap, int i3, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache imagesCache) {
        this(googleMap, context.getResources().openRawResource(i3), context, markerManager, polygonManager, polylineManager, groundOverlayManager, imagesCache);
    }

    public KmlLayer(GoogleMap googleMap, InputStream inputStream, Context context) {
        this(googleMap, inputStream, context, new MarkerManager(googleMap), new PolygonManager(googleMap), new PolylineManager(googleMap), new GroundOverlayManager(googleMap), (Renderer.ImagesCache) null);
    }

    public KmlLayer(GoogleMap googleMap, InputStream inputStream, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache imagesCache) {
        if (inputStream == null) {
            throw new IllegalArgumentException("KML InputStream cannot be null");
        }
        KmlRenderer kmlRenderer = new KmlRenderer(googleMap, context, markerManager, polygonManager, polylineManager, groundOverlayManager, imagesCache);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.mark(UserVerificationMethods.USER_VERIFY_ALL);
        ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
        KmlParser kmlParser = null;
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                HashMap<String, Bitmap> hashMap = new HashMap<>();
                while (nextEntry != null) {
                    if (kmlParser == null && nextEntry.getName().toLowerCase().endsWith(".kml")) {
                        kmlParser = parseKml(zipInputStream);
                    } else {
                        Bitmap decodeStream = BitmapFactory.decodeStream(zipInputStream);
                        if (decodeStream != null) {
                            hashMap.put(nextEntry.getName(), decodeStream);
                        } else {
                            Log.w("KmlLayer", "Unsupported KMZ contents file type: " + nextEntry.getName());
                        }
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                if (kmlParser == null) {
                    throw new IllegalArgumentException("KML not found in InputStream");
                }
                kmlRenderer.storeKmzData(kmlParser.getStyles(), kmlParser.getStyleMaps(), kmlParser.getPlacemarks(), kmlParser.getContainers(), kmlParser.getGroundOverlays(), hashMap);
            } else {
                bufferedInputStream.reset();
                KmlParser parseKml = parseKml(bufferedInputStream);
                kmlRenderer.storeKmlData(parseKml.getStyles(), parseKml.getStyleMaps(), parseKml.getPlacemarks(), parseKml.getContainers(), parseKml.getGroundOverlays());
            }
            try {
                storeRenderer(kmlRenderer);
                inputStream.close();
                bufferedInputStream.close();
                zipInputStream.close();
            } catch (Throwable th) {
                th = th;
                inputStream.close();
                bufferedInputStream.close();
                zipInputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static XmlPullParser createXmlParser(InputStream inputStream) {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(inputStream, null);
        return newPullParser;
    }

    private static KmlParser parseKml(InputStream inputStream) {
        KmlParser kmlParser = new KmlParser(createXmlParser(inputStream));
        kmlParser.parseKml();
        return kmlParser;
    }

    @Override // com.google.maps.android.data.Layer
    public void addLayerToMap() {
        super.addKMLToMap();
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<KmlContainer> getContainers() {
        return super.getContainers();
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return super.getGroundOverlays();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return getFeatures();
    }

    @Override // com.google.maps.android.data.Layer
    public boolean hasContainers() {
        return super.hasContainers();
    }

    public boolean hasPlacemarks() {
        return hasFeatures();
    }
}
