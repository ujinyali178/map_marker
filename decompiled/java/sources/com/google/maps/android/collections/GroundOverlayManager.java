package com.google.maps.android.collections;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.maps.android.collections.MapObjectManager;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public class GroundOverlayManager extends MapObjectManager<GroundOverlay, Collection> implements GoogleMap.OnGroundOverlayClickListener {

    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.OnGroundOverlayClickListener mGroundOverlayClickListener;

        public Collection() {
            super();
        }

        public void addAll(java.util.Collection<GroundOverlayOptions> collection) {
            Iterator<GroundOverlayOptions> it = collection.iterator();
            while (it.hasNext()) {
                addGroundOverlay(it.next());
            }
        }

        public void addAll(java.util.Collection<GroundOverlayOptions> collection, boolean z3) {
            Iterator<GroundOverlayOptions> it = collection.iterator();
            while (it.hasNext()) {
                addGroundOverlay(it.next()).setVisible(z3);
            }
        }

        public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
            GroundOverlay addGroundOverlay = GroundOverlayManager.this.mMap.addGroundOverlay(groundOverlayOptions);
            super.add(addGroundOverlay);
            return addGroundOverlay;
        }

        public java.util.Collection<GroundOverlay> getGroundOverlays() {
            return getObjects();
        }

        public void hideAll() {
            Iterator<GroundOverlay> it = getGroundOverlays().iterator();
            while (it.hasNext()) {
                it.next().setVisible(false);
            }
        }

        public boolean remove(GroundOverlay groundOverlay) {
            return super.remove((Collection) groundOverlay);
        }

        public void setOnGroundOverlayClickListener(GoogleMap.OnGroundOverlayClickListener onGroundOverlayClickListener) {
            this.mGroundOverlayClickListener = onGroundOverlayClickListener;
        }

        public void showAll() {
            Iterator<GroundOverlay> it = getGroundOverlays().iterator();
            while (it.hasNext()) {
                it.next().setVisible(true);
            }
        }
    }

    public GroundOverlayManager(GoogleMap googleMap) {
        super(googleMap);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.GroundOverlayManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection getCollection(String str) {
        return super.getCollection(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.GroundOverlayManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener
    public void onGroundOverlayClick(GroundOverlay groundOverlay) {
        Collection collection = (Collection) this.mAllObjects.get(groundOverlay);
        if (collection == null || collection.mGroundOverlayClickListener == null) {
            return;
        }
        collection.mGroundOverlayClickListener.onGroundOverlayClick(groundOverlay);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(GroundOverlay groundOverlay) {
        return super.remove(groundOverlay);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(GroundOverlay groundOverlay) {
        groundOverlay.remove();
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    void setListenersOnUiThread() {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setOnGroundOverlayClickListener(this);
        }
    }
}
