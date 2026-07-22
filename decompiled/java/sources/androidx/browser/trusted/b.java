package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

/* loaded from: /root/release/classes.dex */
class b {
    static Notification a(Context context, NotificationManager notificationManager, Notification notification, String str, String str2) {
        NotificationChannel notificationChannel;
        Notification.Builder recoverBuilder;
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, 3));
        notificationChannel = notificationManager.getNotificationChannel(str);
        if (notificationChannel.getImportance() == 0) {
            return null;
        }
        recoverBuilder = Notification.Builder.recoverBuilder(context, notification);
        recoverBuilder.setChannelId(str);
        return recoverBuilder.build();
    }

    static boolean b(NotificationManager notificationManager, String str) {
        NotificationChannel notificationChannel;
        notificationChannel = notificationManager.getNotificationChannel(str);
        return notificationChannel == null || notificationChannel.getImportance() != 0;
    }
}
