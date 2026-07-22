package android.app;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.app.Notification;
import android.graphics.drawable.Icon;

/* loaded from: /root/release/classes.dex */
public /* synthetic */ class Notification$CallStyle extends Notification.Style {
    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public static native /* synthetic */ Notification$CallStyle forIncomingCall(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2);

    @NonNull
    public static native /* synthetic */ Notification$CallStyle forOngoingCall(@NonNull Person person, @NonNull PendingIntent pendingIntent);

    @NonNull
    public static native /* synthetic */ Notification$CallStyle forScreeningCall(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2);

    @NonNull
    public native /* synthetic */ Notification$CallStyle setAnswerButtonColorHint(int i3);

    @NonNull
    public native /* synthetic */ Notification$CallStyle setDeclineButtonColorHint(int i3);

    @NonNull
    public native /* synthetic */ Notification$CallStyle setIsVideo(boolean z3);

    @NonNull
    public native /* synthetic */ Notification$CallStyle setVerificationIcon(@Nullable Icon icon);

    @NonNull
    public native /* synthetic */ Notification$CallStyle setVerificationText(@Nullable CharSequence charSequence);
}
