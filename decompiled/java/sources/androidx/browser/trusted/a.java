package androidx.browser.trusted;

import android.app.NotificationManager;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;

/* loaded from: /root/release/classes.dex */
public class a {
    static Parcelable[] a(NotificationManager notificationManager) {
        StatusBarNotification[] activeNotifications;
        activeNotifications = notificationManager.getActiveNotifications();
        return activeNotifications;
    }
}
