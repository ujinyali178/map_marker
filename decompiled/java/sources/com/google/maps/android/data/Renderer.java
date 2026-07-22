package com.google.maps.android.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.R;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Layer;
import com.google.maps.android.data.geojson.BiMultiMap;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonGeometryCollection;
import com.google.maps.android.data.geojson.GeoJsonLineString;
import com.google.maps.android.data.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.data.geojson.GeoJsonMultiLineString;
import com.google.maps.android.data.geojson.GeoJsonMultiPoint;
import com.google.maps.android.data.geojson.GeoJsonMultiPolygon;
import com.google.maps.android.data.geojson.GeoJsonPoint;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygon;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlMultiGeometry;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPolygon;
import com.google.maps.android.data.kml.KmlStyle;
import com.google.maps.android.data.kml.KmlUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public class Renderer {
    private static final Object FEATURE_NOT_ON_MAP = null;
    private static final int MARKER_ICON_SIZE = 32;
    private static final DecimalFormat sScaleFormat = new DecimalFormat("#.####");
    private final BiMultiMap<Feature> mContainerFeatures;
    private ArrayList<KmlContainer> mContainers;
    private Context mContext;
    private final GeoJsonLineStringStyle mDefaultLineStringStyle;
    private final GeoJsonPointStyle mDefaultPointStyle;
    private final GeoJsonPolygonStyle mDefaultPolygonStyle;
    private final BiMultiMap<Feature> mFeatures;
    private HashMap<KmlGroundOverlay, GroundOverlay> mGroundOverlayMap;
    private final GroundOverlayManager.Collection mGroundOverlays;
    private ImagesCache mImagesCache;
    private boolean mLayerOnMap;
    private GoogleMap mMap;
    private final Set<String> mMarkerIconUrls;
    private final MarkerManager.Collection mMarkers;
    private int mNumActiveDownloads;
    private final PolygonManager.Collection mPolygons;
    private final PolylineManager.Collection mPolylines;
    private HashMap<String, String> mStyleMaps;
    private HashMap<String, KmlStyle> mStyles;
    private HashMap<String, KmlStyle> mStylesRenderer;

    public static final class ImagesCache {
        final Map<String, Map<String, BitmapDescriptor>> markerImagesCache = new HashMap();
        final Map<String, BitmapDescriptor> groundOverlayImagesCache = new HashMap();
        final Map<String, Bitmap> bitmapCache = new HashMap();
    }

    public Renderer(GoogleMap googleMap, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, ImagesCache imagesCache) {
        this(googleMap, new HashSet(), null, null, null, new BiMultiMap(), markerManager, polygonManager, polylineManager, groundOverlayManager);
        this.mContext = context;
        this.mStylesRenderer = new HashMap<>();
        this.mImagesCache = imagesCache == null ? new ImagesCache() : imagesCache;
    }

    public Renderer(GoogleMap googleMap, HashMap<? extends Feature, Object> hashMap, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        this(googleMap, null, new GeoJsonPointStyle(), new GeoJsonLineStringStyle(), new GeoJsonPolygonStyle(), null, markerManager, polygonManager, polylineManager, groundOverlayManager);
        this.mFeatures.putAll(hashMap);
        this.mImagesCache = null;
    }

    private Renderer(GoogleMap googleMap, Set<String> set, GeoJsonPointStyle geoJsonPointStyle, GeoJsonLineStringStyle geoJsonLineStringStyle, GeoJsonPolygonStyle geoJsonPolygonStyle, BiMultiMap<Feature> biMultiMap, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        GroundOverlayManager.Collection collection;
        this.mFeatures = new BiMultiMap<>();
        this.mNumActiveDownloads = 0;
        this.mMap = googleMap;
        this.mLayerOnMap = false;
        this.mMarkerIconUrls = set;
        this.mDefaultPointStyle = geoJsonPointStyle;
        this.mDefaultLineStringStyle = geoJsonLineStringStyle;
        this.mDefaultPolygonStyle = geoJsonPolygonStyle;
        this.mContainerFeatures = biMultiMap;
        if (googleMap != null) {
            this.mMarkers = (markerManager == null ? new MarkerManager(googleMap) : markerManager).newCollection();
            this.mPolygons = (polygonManager == null ? new PolygonManager(googleMap) : polygonManager).newCollection();
            this.mPolylines = (polylineManager == null ? new PolylineManager(googleMap) : polylineManager).newCollection();
            collection = (groundOverlayManager == null ? new GroundOverlayManager(googleMap) : groundOverlayManager).newCollection();
        } else {
            collection = null;
            this.mMarkers = null;
            this.mPolygons = null;
            this.mPolylines = null;
        }
        this.mGroundOverlays = collection;
    }

    private ArrayList<Object> addGeometryCollectionToMap(GeoJsonFeature geoJsonFeature, List<Geometry> list) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<Geometry> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(addGeoJsonFeatureToMap(geoJsonFeature, it.next()));
        }
        return arrayList;
    }

    private Polyline addLineStringToMap(PolylineOptions polylineOptions, LineString lineString) {
        polylineOptions.addAll(lineString.getGeometryObject());
        Polyline addPolyline = this.mPolylines.addPolyline(polylineOptions);
        addPolyline.setClickable(polylineOptions.isClickable());
        return addPolyline;
    }

    private void addMarkerIcons(String str, double d3, MarkerOptions markerOptions) {
        BitmapDescriptor cachedMarkerImage = getCachedMarkerImage(str, d3);
        if (cachedMarkerImage != null) {
            markerOptions.icon(cachedMarkerImage);
        } else {
            this.mMarkerIconUrls.add(str);
        }
    }

    private ArrayList<Object> addMultiGeometryToMap(KmlPlacemark kmlPlacemark, KmlMultiGeometry kmlMultiGeometry, KmlStyle kmlStyle, KmlStyle kmlStyle2, boolean z3) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<Geometry> it = kmlMultiGeometry.getGeometryObject().iterator();
        while (it.hasNext()) {
            arrayList.add(addKmlPlacemarkToMap(kmlPlacemark, it.next(), kmlStyle, kmlStyle2, z3));
        }
        return arrayList;
    }

    private ArrayList<Polyline> addMultiLineStringToMap(GeoJsonLineStringStyle geoJsonLineStringStyle, GeoJsonMultiLineString geoJsonMultiLineString) {
        ArrayList<Polyline> arrayList = new ArrayList<>();
        Iterator<GeoJsonLineString> it = geoJsonMultiLineString.getLineStrings().iterator();
        while (it.hasNext()) {
            arrayList.add(addLineStringToMap(geoJsonLineStringStyle.toPolylineOptions(), it.next()));
        }
        return arrayList;
    }

    private ArrayList<Marker> addMultiPointToMap(GeoJsonPointStyle geoJsonPointStyle, GeoJsonMultiPoint geoJsonMultiPoint) {
        ArrayList<Marker> arrayList = new ArrayList<>();
        Iterator<GeoJsonPoint> it = geoJsonMultiPoint.getPoints().iterator();
        while (it.hasNext()) {
            arrayList.add(addPointToMap(geoJsonPointStyle.toMarkerOptions(), it.next()));
        }
        return arrayList;
    }

    private ArrayList<Polygon> addMultiPolygonToMap(GeoJsonPolygonStyle geoJsonPolygonStyle, GeoJsonMultiPolygon geoJsonMultiPolygon) {
        ArrayList<Polygon> arrayList = new ArrayList<>();
        Iterator<GeoJsonPolygon> it = geoJsonMultiPolygon.getPolygons().iterator();
        while (it.hasNext()) {
            arrayList.add(addPolygonToMap(geoJsonPolygonStyle.toPolygonOptions(), it.next()));
        }
        return arrayList;
    }

    private Marker addPointToMap(MarkerOptions markerOptions, Point point) {
        markerOptions.position(point.getGeometryObject());
        return this.mMarkers.addMarker(markerOptions);
    }

    private Polygon addPolygonToMap(PolygonOptions polygonOptions, DataPolygon dataPolygon) {
        polygonOptions.addAll(dataPolygon.getOuterBoundaryCoordinates());
        Iterator<List<LatLng>> it = dataPolygon.getInnerBoundaryCoordinates().iterator();
        while (it.hasNext()) {
            polygonOptions.addHole(it.next());
        }
        Polygon addPolygon = this.mPolygons.addPolygon(polygonOptions);
        addPolygon.setClickable(polygonOptions.isClickable());
        return addPolygon;
    }

    private void createInfoWindow() {
        this.mMarkers.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() { // from class: com.google.maps.android.data.Renderer.1
            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
            public View getInfoContents(Marker marker) {
                String title;
                View inflate = LayoutInflater.from(Renderer.this.mContext).inflate(R.layout.amu_info_window, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.window);
                if (marker.getSnippet() != null) {
                    title = marker.getTitle() + "<br>" + marker.getSnippet();
                } else {
                    title = marker.getTitle();
                }
                textView.setText(Html.fromHtml(title));
                return inflate;
            }

            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
            public View getInfoWindow(Marker marker) {
                return null;
            }
        });
    }

    protected static boolean getPlacemarkVisibility(Feature feature) {
        return (feature.hasProperty("visibility") && Integer.parseInt(feature.getProperty("visibility")) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setOnFeatureClickListener$0(Layer.OnFeatureClickListener onFeatureClickListener, Polygon polygon) {
        Feature containerFeature;
        Feature feature = getFeature(polygon);
        ArrayList<?> arrayList = polygon;
        if (feature == null) {
            if (getContainerFeature(polygon) != null) {
                containerFeature = getContainerFeature(polygon);
                onFeatureClickListener.onFeatureClick(containerFeature);
            }
            arrayList = multiObjectHandler(polygon);
        }
        containerFeature = getFeature(arrayList);
        onFeatureClickListener.onFeatureClick(containerFeature);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean lambda$setOnFeatureClickListener$1(Layer.OnFeatureClickListener onFeatureClickListener, Marker marker) {
        Feature containerFeature;
        Feature feature = getFeature(marker);
        ArrayList<?> arrayList = marker;
        if (feature == null) {
            if (getContainerFeature(marker) != null) {
                containerFeature = getContainerFeature(marker);
                onFeatureClickListener.onFeatureClick(containerFeature);
                return false;
            }
            arrayList = multiObjectHandler(marker);
        }
        containerFeature = getFeature(arrayList);
        onFeatureClickListener.onFeatureClick(containerFeature);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setOnFeatureClickListener$2(Layer.OnFeatureClickListener onFeatureClickListener, Polyline polyline) {
        Feature containerFeature;
        Feature feature = getFeature(polyline);
        ArrayList<?> arrayList = polyline;
        if (feature == null) {
            if (getContainerFeature(polyline) != null) {
                containerFeature = getContainerFeature(polyline);
                onFeatureClickListener.onFeatureClick(containerFeature);
            }
            arrayList = multiObjectHandler(polyline);
        }
        containerFeature = getFeature(arrayList);
        onFeatureClickListener.onFeatureClick(containerFeature);
    }

    private ArrayList<?> multiObjectHandler(Object obj) {
        for (Object obj2 : getValues()) {
            if (obj2.getClass().getSimpleName().equals("ArrayList")) {
                ArrayList<?> arrayList = (ArrayList) obj2;
                if (arrayList.contains(obj)) {
                    return arrayList;
                }
            }
        }
        return null;
    }

    private void putMarkerImagesCache(String str, String str2, BitmapDescriptor bitmapDescriptor) {
        Map<String, BitmapDescriptor> map = this.mImagesCache.markerImagesCache.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.mImagesCache.markerImagesCache.put(str, map);
        }
        map.put(str2, bitmapDescriptor);
    }

    private void removeFeatures(Collection collection) {
        for (Object obj : collection) {
            if (obj instanceof Collection) {
                removeFeatures((Collection) obj);
            } else if (obj instanceof Marker) {
                this.mMarkers.remove((Marker) obj);
            } else if (obj instanceof Polyline) {
                this.mPolylines.remove((Polyline) obj);
            } else if (obj instanceof Polygon) {
                this.mPolygons.remove((Polygon) obj);
            }
        }
    }

    private BitmapDescriptor scaleIcon(Bitmap bitmap, double d3) {
        int i3;
        int i4 = (int) (this.mContext.getResources().getDisplayMetrics().density * 32.0f * d3);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < height) {
            i3 = (int) ((height * i4) / width);
        } else if (width > height) {
            int i5 = (int) ((width * i4) / height);
            i3 = i4;
            i4 = i5;
        } else {
            i3 = i4;
        }
        return BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(bitmap, i4, i3, false));
    }

    private void setFeatureDefaultStyles(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature.getPointStyle() == null) {
            geoJsonFeature.setPointStyle(this.mDefaultPointStyle);
        }
        if (geoJsonFeature.getLineStringStyle() == null) {
            geoJsonFeature.setLineStringStyle(this.mDefaultLineStringStyle);
        }
        if (geoJsonFeature.getPolygonStyle() == null) {
            geoJsonFeature.setPolygonStyle(this.mDefaultPolygonStyle);
        }
    }

    private void setInlineLineStringStyle(PolylineOptions polylineOptions, KmlStyle kmlStyle) {
        PolylineOptions polylineOptions2 = kmlStyle.getPolylineOptions();
        if (kmlStyle.isStyleSet("outlineColor")) {
            polylineOptions.color(polylineOptions2.getColor());
        }
        if (kmlStyle.isStyleSet("width")) {
            polylineOptions.width(polylineOptions2.getWidth());
        }
        if (kmlStyle.isLineRandomColorMode()) {
            polylineOptions.color(KmlStyle.computeRandomColor(polylineOptions2.getColor()));
        }
    }

    private void setInlinePointStyle(MarkerOptions markerOptions, KmlStyle kmlStyle, KmlStyle kmlStyle2) {
        String iconUrl;
        MarkerOptions markerOptions2 = kmlStyle.getMarkerOptions();
        if (kmlStyle.isStyleSet("heading")) {
            markerOptions.rotation(markerOptions2.getRotation());
        }
        if (kmlStyle.isStyleSet("hotSpot")) {
            markerOptions.anchor(markerOptions2.getAnchorU(), markerOptions2.getAnchorV());
        }
        if (kmlStyle.isStyleSet("markerColor")) {
            markerOptions.icon(markerOptions2.getIcon());
        }
        double iconScale = kmlStyle.isStyleSet("iconScale") ? kmlStyle.getIconScale() : kmlStyle2.isStyleSet("iconScale") ? kmlStyle2.getIconScale() : 1.0d;
        if (kmlStyle.isStyleSet("iconUrl")) {
            iconUrl = kmlStyle.getIconUrl();
        } else if (kmlStyle2.getIconUrl() == null) {
            return;
        } else {
            iconUrl = kmlStyle2.getIconUrl();
        }
        addMarkerIcons(iconUrl, iconScale, markerOptions);
    }

    private void setInlinePolygonStyle(PolygonOptions polygonOptions, KmlStyle kmlStyle) {
        PolygonOptions polygonOptions2 = kmlStyle.getPolygonOptions();
        if (kmlStyle.hasFill() && kmlStyle.isStyleSet("fillColor")) {
            polygonOptions.fillColor(polygonOptions2.getFillColor());
        }
        if (kmlStyle.hasOutline()) {
            if (kmlStyle.isStyleSet("outlineColor")) {
                polygonOptions.strokeColor(polygonOptions2.getStrokeColor());
            }
            if (kmlStyle.isStyleSet("width")) {
                polygonOptions.strokeWidth(polygonOptions2.getStrokeWidth());
            }
        }
        if (kmlStyle.isPolyRandomColorMode()) {
            polygonOptions.fillColor(KmlStyle.computeRandomColor(polygonOptions2.getFillColor()));
        }
    }

    private void setMarkerInfoWindow(KmlStyle kmlStyle, Marker marker, KmlPlacemark kmlPlacemark) {
        String property;
        boolean hasProperty = kmlPlacemark.hasProperty("name");
        boolean hasProperty2 = kmlPlacemark.hasProperty("description");
        boolean hasBalloonStyle = kmlStyle.hasBalloonStyle();
        boolean containsKey = kmlStyle.getBalloonOptions().containsKey("text");
        if (hasBalloonStyle && containsKey) {
            property = KmlUtil.substituteProperties(kmlStyle.getBalloonOptions().get("text"), kmlPlacemark);
        } else {
            if (!hasBalloonStyle || !hasProperty) {
                if (hasProperty && hasProperty2) {
                    marker.setTitle(kmlPlacemark.getProperty("name"));
                    marker.setSnippet(kmlPlacemark.getProperty("description"));
                    createInfoWindow();
                } else if (hasProperty2) {
                    property = kmlPlacemark.getProperty("description");
                } else if (!hasProperty) {
                    return;
                }
            }
            property = kmlPlacemark.getProperty("name");
        }
        marker.setTitle(property);
        createInfoWindow();
    }

    protected void addFeature(Feature feature) {
        Object obj = FEATURE_NOT_ON_MAP;
        if (feature instanceof GeoJsonFeature) {
            setFeatureDefaultStyles((GeoJsonFeature) feature);
        }
        if (this.mLayerOnMap) {
            if (this.mFeatures.containsKey(feature)) {
                removeFromMap(this.mFeatures.get(feature));
            }
            if (feature.hasGeometry()) {
                if (feature instanceof KmlPlacemark) {
                    KmlPlacemark kmlPlacemark = (KmlPlacemark) feature;
                    obj = addKmlPlacemarkToMap(kmlPlacemark, feature.getGeometry(), getPlacemarkStyle(feature.getId()), kmlPlacemark.getInlineStyle(), getPlacemarkVisibility(feature));
                } else {
                    obj = addGeoJsonFeatureToMap(feature, feature.getGeometry());
                }
            }
        }
        this.mFeatures.put((BiMultiMap<Feature>) feature, obj);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    protected Object addGeoJsonFeatureToMap(Feature feature, Geometry geometry) {
        String geometryType = geometry.getGeometryType();
        geometryType.hashCode();
        char c3 = 65535;
        switch (geometryType.hashCode()) {
            case -2116761119:
                if (geometryType.equals("MultiPolygon")) {
                    c3 = 0;
                    break;
                }
                break;
            case -1065891849:
                if (geometryType.equals("MultiPoint")) {
                    c3 = 1;
                    break;
                }
                break;
            case -627102946:
                if (geometryType.equals("MultiLineString")) {
                    c3 = 2;
                    break;
                }
                break;
            case 77292912:
                if (geometryType.equals("Point")) {
                    c3 = 3;
                    break;
                }
                break;
            case 1267133722:
                if (geometryType.equals(KmlPolygon.GEOMETRY_TYPE)) {
                    c3 = 4;
                    break;
                }
                break;
            case 1806700869:
                if (geometryType.equals("LineString")) {
                    c3 = 5;
                    break;
                }
                break;
            case 1950410960:
                if (geometryType.equals("GeometryCollection")) {
                    c3 = 6;
                    break;
                }
                break;
        }
        MarkerOptions markerOptions = null;
        PolylineOptions polylineOptions = null;
        PolygonOptions polygonOptions = null;
        switch (c3) {
            case 0:
                return addMultiPolygonToMap(((GeoJsonFeature) feature).getPolygonStyle(), (GeoJsonMultiPolygon) geometry);
            case 1:
                return addMultiPointToMap(((GeoJsonFeature) feature).getPointStyle(), (GeoJsonMultiPoint) geometry);
            case 2:
                return addMultiLineStringToMap(((GeoJsonFeature) feature).getLineStringStyle(), (GeoJsonMultiLineString) geometry);
            case 3:
                if (feature instanceof GeoJsonFeature) {
                    markerOptions = ((GeoJsonFeature) feature).getMarkerOptions();
                } else if (feature instanceof KmlPlacemark) {
                    markerOptions = ((KmlPlacemark) feature).getMarkerOptions();
                }
                return addPointToMap(markerOptions, (GeoJsonPoint) geometry);
            case 4:
                if (feature instanceof GeoJsonFeature) {
                    polygonOptions = ((GeoJsonFeature) feature).getPolygonOptions();
                } else if (feature instanceof KmlPlacemark) {
                    polygonOptions = ((KmlPlacemark) feature).getPolygonOptions();
                }
                return addPolygonToMap(polygonOptions, (DataPolygon) geometry);
            case 5:
                if (feature instanceof GeoJsonFeature) {
                    polylineOptions = ((GeoJsonFeature) feature).getPolylineOptions();
                } else if (feature instanceof KmlPlacemark) {
                    polylineOptions = ((KmlPlacemark) feature).getPolylineOptions();
                }
                return addLineStringToMap(polylineOptions, (GeoJsonLineString) geometry);
            case 6:
                return addGeometryCollectionToMap((GeoJsonFeature) feature, ((GeoJsonGeometryCollection) geometry).getGeometries());
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0054, code lost:
    
        if (r0.equals("Point") == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object addKmlPlacemarkToMap(com.google.maps.android.data.kml.KmlPlacemark r13, com.google.maps.android.data.Geometry r14, com.google.maps.android.data.kml.KmlStyle r15, com.google.maps.android.data.kml.KmlStyle r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.data.Renderer.addKmlPlacemarkToMap(com.google.maps.android.data.kml.KmlPlacemark, com.google.maps.android.data.Geometry, com.google.maps.android.data.kml.KmlStyle, com.google.maps.android.data.kml.KmlStyle, boolean):java.lang.Object");
    }

    public void assignStyleMap(HashMap<String, String> hashMap, HashMap<String, KmlStyle> hashMap2) {
        for (String str : hashMap.keySet()) {
            String str2 = hashMap.get(str);
            if (hashMap2.containsKey(str2)) {
                hashMap2.put(str, hashMap2.get(str2));
            }
        }
    }

    protected GroundOverlay attachGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return this.mGroundOverlays.addGroundOverlay(groundOverlayOptions);
    }

    protected void cacheBitmap(String str, Bitmap bitmap) {
        this.mImagesCache.bitmapCache.put(str, bitmap);
    }

    protected void checkClearBitmapCache() {
        ImagesCache imagesCache;
        if (this.mNumActiveDownloads != 0 || (imagesCache = this.mImagesCache) == null || imagesCache.bitmapCache.isEmpty()) {
            return;
        }
        this.mImagesCache.bitmapCache.clear();
    }

    protected void clearStylesRenderer() {
        this.mStylesRenderer.clear();
    }

    protected void downloadFinished() {
        this.mNumActiveDownloads--;
        checkClearBitmapCache();
    }

    protected void downloadStarted() {
        this.mNumActiveDownloads++;
    }

    protected HashMap<? extends Feature, Object> getAllFeatures() {
        return this.mFeatures;
    }

    protected BitmapDescriptor getCachedGroundOverlayImage(String str) {
        Bitmap bitmap;
        BitmapDescriptor bitmapDescriptor = this.mImagesCache.groundOverlayImagesCache.get(str);
        if (bitmapDescriptor != null || (bitmap = this.mImagesCache.bitmapCache.get(str)) == null) {
            return bitmapDescriptor;
        }
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
        this.mImagesCache.groundOverlayImagesCache.put(str, fromBitmap);
        return fromBitmap;
    }

    protected BitmapDescriptor getCachedMarkerImage(String str, double d3) {
        Bitmap bitmap;
        String format = sScaleFormat.format(d3);
        Map<String, BitmapDescriptor> map = this.mImagesCache.markerImagesCache.get(str);
        BitmapDescriptor bitmapDescriptor = map != null ? map.get(format) : null;
        if (bitmapDescriptor != null || (bitmap = this.mImagesCache.bitmapCache.get(str)) == null) {
            return bitmapDescriptor;
        }
        BitmapDescriptor scaleIcon = scaleIcon(bitmap, d3);
        putMarkerImagesCache(str, format, scaleIcon);
        return scaleIcon;
    }

    Feature getContainerFeature(Object obj) {
        BiMultiMap<Feature> biMultiMap = this.mContainerFeatures;
        if (biMultiMap != null) {
            return biMultiMap.getKey(obj);
        }
        return null;
    }

    protected ArrayList<KmlContainer> getContainerList() {
        return this.mContainers;
    }

    GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.mDefaultLineStringStyle;
    }

    GeoJsonPointStyle getDefaultPointStyle() {
        return this.mDefaultPointStyle;
    }

    GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.mDefaultPolygonStyle;
    }

    Feature getFeature(Object obj) {
        return this.mFeatures.getKey(obj);
    }

    public Set<Feature> getFeatures() {
        return this.mFeatures.keySet();
    }

    public HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlayMap() {
        return this.mGroundOverlayMap;
    }

    public GoogleMap getMap() {
        return this.mMap;
    }

    protected Set<String> getMarkerIconUrls() {
        return this.mMarkerIconUrls;
    }

    protected KmlStyle getPlacemarkStyle(String str) {
        return this.mStylesRenderer.get(str) != null ? this.mStylesRenderer.get(str) : this.mStylesRenderer.get(null);
    }

    protected HashMap<String, String> getStyleMaps() {
        return this.mStyleMaps;
    }

    protected HashMap<String, KmlStyle> getStylesRenderer() {
        return this.mStylesRenderer;
    }

    public Collection<Object> getValues() {
        return this.mFeatures.values();
    }

    protected boolean hasFeatures() {
        return this.mFeatures.size() > 0;
    }

    public boolean isLayerOnMap() {
        return this.mLayerOnMap;
    }

    protected void putContainerFeature(Object obj, Feature feature) {
        this.mContainerFeatures.put((BiMultiMap<Feature>) feature, obj);
    }

    protected void putFeatures(Feature feature, Object obj) {
        this.mFeatures.put((BiMultiMap<Feature>) feature, obj);
    }

    protected void putStyles() {
        this.mStylesRenderer.putAll(this.mStyles);
    }

    protected void putStyles(HashMap<String, KmlStyle> hashMap) {
        this.mStylesRenderer.putAll(hashMap);
    }

    protected void removeFeature(Feature feature) {
        if (this.mFeatures.containsKey(feature)) {
            removeFromMap(this.mFeatures.remove(feature));
        }
    }

    protected void removeFeatures(HashMap<? extends Feature, Object> hashMap) {
        removeFeatures(hashMap.values());
    }

    protected void removeFromMap(Object obj) {
        if (obj instanceof Marker) {
            this.mMarkers.remove((Marker) obj);
            return;
        }
        if (obj instanceof Polyline) {
            this.mPolylines.remove((Polyline) obj);
            return;
        }
        if (obj instanceof Polygon) {
            this.mPolygons.remove((Polygon) obj);
            return;
        }
        if (obj instanceof GroundOverlay) {
            this.mGroundOverlays.remove((GroundOverlay) obj);
        } else if (obj instanceof ArrayList) {
            Iterator it = ((ArrayList) obj).iterator();
            while (it.hasNext()) {
                removeFromMap(it.next());
            }
        }
    }

    protected void removeGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> hashMap) {
        for (GroundOverlay groundOverlay : hashMap.values()) {
            if (groundOverlay != null) {
                this.mGroundOverlays.remove(groundOverlay);
            }
        }
    }

    protected void setLayerVisibility(boolean z3) {
        this.mLayerOnMap = z3;
    }

    public void setMap(GoogleMap googleMap) {
        this.mMap = googleMap;
    }

    void setOnFeatureClickListener(final Layer.OnFeatureClickListener onFeatureClickListener) {
        this.mPolygons.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() { // from class: com.google.maps.android.data.a
            @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
            public final void onPolygonClick(Polygon polygon) {
                Renderer.this.lambda$setOnFeatureClickListener$0(onFeatureClickListener, polygon);
            }
        });
        this.mMarkers.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.google.maps.android.data.b
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                boolean lambda$setOnFeatureClickListener$1;
                lambda$setOnFeatureClickListener$1 = Renderer.this.lambda$setOnFeatureClickListener$1(onFeatureClickListener, marker);
                return lambda$setOnFeatureClickListener$1;
            }
        });
        this.mPolylines.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() { // from class: com.google.maps.android.data.c
            @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
            public final void onPolylineClick(Polyline polyline) {
                Renderer.this.lambda$setOnFeatureClickListener$2(onFeatureClickListener, polyline);
            }
        });
    }

    protected void storeData(HashMap<String, KmlStyle> hashMap, HashMap<String, String> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap4) {
        this.mStyles = hashMap;
        this.mStyleMaps = hashMap2;
        this.mFeatures.putAll(hashMap3);
        this.mContainers = arrayList;
        this.mGroundOverlayMap = hashMap4;
    }
}
