package com.google.maps.android.data.geojson;

import android.util.Log;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Geometry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /root/release/classes.dex */
public class GeoJsonParser {
    private static final String BOUNDING_BOX = "bbox";
    private static final String FEATURE = "Feature";
    private static final String FEATURE_COLLECTION = "FeatureCollection";
    private static final String FEATURE_COLLECTION_ARRAY = "features";
    private static final String FEATURE_GEOMETRY = "geometry";
    private static final String FEATURE_ID = "id";
    private static final String GEOMETRY_COLLECTION = "GeometryCollection";
    private static final String GEOMETRY_COLLECTION_ARRAY = "geometries";
    private static final String GEOMETRY_COORDINATES_ARRAY = "coordinates";
    private static final String LINESTRING = "LineString";
    private static final String LOG_TAG = "GeoJsonParser";
    private static final String MULTILINESTRING = "MultiLineString";
    private static final String MULTIPOINT = "MultiPoint";
    private static final String MULTIPOLYGON = "MultiPolygon";
    private static final String POINT = "Point";
    private static final String POLYGON = "Polygon";
    private static final String PROPERTIES = "properties";
    private final JSONObject mGeoJsonFile;
    private final ArrayList<GeoJsonFeature> mGeoJsonFeatures = new ArrayList<>();
    private LatLngBounds mBoundingBox = null;

    private static class LatLngAlt {
        public final Double altitude;
        public final LatLng latLng;

        LatLngAlt(LatLng latLng, Double d3) {
            this.latLng = latLng;
            this.altitude = d3;
        }
    }

    public GeoJsonParser(JSONObject jSONObject) {
        this.mGeoJsonFile = jSONObject;
        parseGeoJson();
    }

    private static Geometry createGeometry(String str, JSONArray jSONArray) {
        str.hashCode();
        switch (str) {
            case "MultiPolygon":
                return createMultiPolygon(jSONArray);
            case "MultiPoint":
                return createMultiPoint(jSONArray);
            case "MultiLineString":
                return createMultiLineString(jSONArray);
            case "Point":
                return createPoint(jSONArray);
            case "Polygon":
                return createPolygon(jSONArray);
            case "LineString":
                return createLineString(jSONArray);
            case "GeometryCollection":
                return createGeometryCollection(jSONArray);
            default:
                return null;
        }
    }

    private static GeoJsonGeometryCollection createGeometryCollection(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Geometry parseGeometry = parseGeometry(jSONArray.getJSONObject(i3));
            if (parseGeometry != null) {
                arrayList.add(parseGeometry);
            }
        }
        return new GeoJsonGeometryCollection(arrayList);
    }

    private static GeoJsonLineString createLineString(JSONArray jSONArray) {
        ArrayList<LatLngAlt> parseCoordinatesArray = parseCoordinatesArray(jSONArray);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<LatLngAlt> it = parseCoordinatesArray.iterator();
        while (it.hasNext()) {
            LatLngAlt next = it.next();
            arrayList.add(next.latLng);
            Double d3 = next.altitude;
            if (d3 != null) {
                arrayList2.add(d3);
            }
        }
        return new GeoJsonLineString(arrayList, arrayList2);
    }

    private static GeoJsonMultiLineString createMultiLineString(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(createLineString(jSONArray.getJSONArray(i3)));
        }
        return new GeoJsonMultiLineString(arrayList);
    }

    private static GeoJsonMultiPoint createMultiPoint(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(createPoint(jSONArray.getJSONArray(i3)));
        }
        return new GeoJsonMultiPoint(arrayList);
    }

    private static GeoJsonMultiPolygon createMultiPolygon(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(createPolygon(jSONArray.getJSONArray(i3)));
        }
        return new GeoJsonMultiPolygon(arrayList);
    }

    private static GeoJsonPoint createPoint(JSONArray jSONArray) {
        LatLngAlt parseCoordinate = parseCoordinate(jSONArray);
        return new GeoJsonPoint(parseCoordinate.latLng, parseCoordinate.altitude);
    }

    private static GeoJsonPolygon createPolygon(JSONArray jSONArray) {
        return new GeoJsonPolygon(parseCoordinatesArrays(jSONArray));
    }

    private static boolean isGeometry(String str) {
        return str.matches("Point|MultiPoint|LineString|MultiLineString|Polygon|MultiPolygon|GeometryCollection");
    }

    private static LatLngBounds parseBoundingBox(JSONArray jSONArray) {
        return new LatLngBounds(new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0)), new LatLng(jSONArray.getDouble(3), jSONArray.getDouble(2)));
    }

    private static LatLngAlt parseCoordinate(JSONArray jSONArray) {
        return new LatLngAlt(new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0)), jSONArray.length() < 3 ? null : Double.valueOf(jSONArray.getDouble(2)));
    }

    private static ArrayList<LatLngAlt> parseCoordinatesArray(JSONArray jSONArray) {
        ArrayList<LatLngAlt> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(parseCoordinate(jSONArray.getJSONArray(i3)));
        }
        return arrayList;
    }

    private static ArrayList<ArrayList<LatLng>> parseCoordinatesArrays(JSONArray jSONArray) {
        ArrayList<ArrayList<LatLng>> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            ArrayList<LatLngAlt> parseCoordinatesArray = parseCoordinatesArray(jSONArray.getJSONArray(i3));
            ArrayList<LatLng> arrayList2 = new ArrayList<>();
            Iterator<LatLngAlt> it = parseCoordinatesArray.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().latLng);
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private static GeoJsonFeature parseFeature(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String string = jSONObject.has(FEATURE_ID) ? jSONObject.getString(FEATURE_ID) : null;
            LatLngBounds parseBoundingBox = jSONObject.has(BOUNDING_BOX) ? parseBoundingBox(jSONObject.getJSONArray(BOUNDING_BOX)) : null;
            Geometry parseGeometry = (!jSONObject.has(FEATURE_GEOMETRY) || jSONObject.isNull(FEATURE_GEOMETRY)) ? null : parseGeometry(jSONObject.getJSONObject(FEATURE_GEOMETRY));
            if (jSONObject.has(PROPERTIES) && !jSONObject.isNull(PROPERTIES)) {
                hashMap = parseProperties(jSONObject.getJSONObject(PROPERTIES));
            }
            return new GeoJsonFeature(parseGeometry, string, hashMap, parseBoundingBox);
        } catch (JSONException unused) {
            Log.w(LOG_TAG, "Feature could not be successfully parsed " + jSONObject.toString());
            return null;
        }
    }

    private ArrayList<GeoJsonFeature> parseFeatureCollection(JSONObject jSONObject) {
        ArrayList<GeoJsonFeature> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(FEATURE_COLLECTION_ARRAY);
            if (jSONObject.has(BOUNDING_BOX)) {
                this.mBoundingBox = parseBoundingBox(jSONObject.getJSONArray(BOUNDING_BOX));
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2.getString("type").equals(FEATURE)) {
                        GeoJsonFeature parseFeature = parseFeature(jSONObject2);
                        if (parseFeature != null) {
                            arrayList.add(parseFeature);
                        } else {
                            Log.w(LOG_TAG, "Index of Feature in Feature Collection that could not be created: " + i3);
                        }
                    }
                } catch (JSONException unused) {
                    Log.w(LOG_TAG, "Index of Feature in Feature Collection that could not be created: " + i3);
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            Log.w(LOG_TAG, "Feature Collection could not be created.");
            return arrayList;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r2 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void parseGeoJson() {
        /*
            r4 = this;
            java.lang.String r0 = "GeoJSON file could not be parsed."
            java.lang.String r1 = "GeoJsonParser"
            org.json.JSONObject r2 = r4.mGeoJsonFile     // Catch: org.json.JSONException -> L49
            java.lang.String r3 = "type"
            java.lang.String r2 = r2.getString(r3)     // Catch: org.json.JSONException -> L49
            java.lang.String r3 = "Feature"
            boolean r3 = r2.equals(r3)     // Catch: org.json.JSONException -> L49
            if (r3 == 0) goto L22
            org.json.JSONObject r2 = r4.mGeoJsonFile     // Catch: org.json.JSONException -> L49
            com.google.maps.android.data.geojson.GeoJsonFeature r2 = parseFeature(r2)     // Catch: org.json.JSONException -> L49
            if (r2 == 0) goto L4c
        L1c:
            java.util.ArrayList<com.google.maps.android.data.geojson.GeoJsonFeature> r3 = r4.mGeoJsonFeatures     // Catch: org.json.JSONException -> L49
            r3.add(r2)     // Catch: org.json.JSONException -> L49
            goto L4c
        L22:
            java.lang.String r3 = "FeatureCollection"
            boolean r3 = r2.equals(r3)     // Catch: org.json.JSONException -> L49
            if (r3 == 0) goto L36
            java.util.ArrayList<com.google.maps.android.data.geojson.GeoJsonFeature> r2 = r4.mGeoJsonFeatures     // Catch: org.json.JSONException -> L49
            org.json.JSONObject r3 = r4.mGeoJsonFile     // Catch: org.json.JSONException -> L49
            java.util.ArrayList r3 = r4.parseFeatureCollection(r3)     // Catch: org.json.JSONException -> L49
            r2.addAll(r3)     // Catch: org.json.JSONException -> L49
            goto L4c
        L36:
            boolean r2 = isGeometry(r2)     // Catch: org.json.JSONException -> L49
            if (r2 == 0) goto L45
            org.json.JSONObject r2 = r4.mGeoJsonFile     // Catch: org.json.JSONException -> L49
            com.google.maps.android.data.geojson.GeoJsonFeature r2 = parseGeometryToFeature(r2)     // Catch: org.json.JSONException -> L49
            if (r2 == 0) goto L4c
            goto L1c
        L45:
            android.util.Log.w(r1, r0)     // Catch: org.json.JSONException -> L49
            goto L4c
        L49:
            android.util.Log.w(r1, r0)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.data.geojson.GeoJsonParser.parseGeoJson():void");
    }

    public static Geometry parseGeometry(JSONObject jSONObject) {
        String string;
        String str;
        try {
            string = jSONObject.getString("type");
        } catch (JSONException unused) {
        }
        if (!string.equals(GEOMETRY_COLLECTION)) {
            if (isGeometry(string)) {
                str = GEOMETRY_COORDINATES_ARRAY;
            }
            return null;
        }
        str = GEOMETRY_COLLECTION_ARRAY;
        return createGeometry(string, jSONObject.getJSONArray(str));
    }

    private static GeoJsonFeature parseGeometryToFeature(JSONObject jSONObject) {
        Geometry parseGeometry = parseGeometry(jSONObject);
        if (parseGeometry != null) {
            return new GeoJsonFeature(parseGeometry, null, new HashMap(), null);
        }
        Log.w(LOG_TAG, "Geometry could not be parsed");
        return null;
    }

    private static HashMap<String, String> parseProperties(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.getString(next));
        }
        return hashMap;
    }

    public LatLngBounds getBoundingBox() {
        return this.mBoundingBox;
    }

    public ArrayList<GeoJsonFeature> getFeatures() {
        return this.mGeoJsonFeatures;
    }
}
