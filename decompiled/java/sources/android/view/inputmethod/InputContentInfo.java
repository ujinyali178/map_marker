package android.view.inputmethod;

import android.annotation.NonNull;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Parcelable;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class InputContentInfo implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public native /* synthetic */ Uri getContentUri();

    @NonNull
    public native /* synthetic */ ClipDescription getDescription();

    public native /* synthetic */ void releasePermission();

    public native /* synthetic */ void requestPermission();
}
