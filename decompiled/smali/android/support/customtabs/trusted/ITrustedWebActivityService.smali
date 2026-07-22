.class public interface abstract Landroid/support/customtabs/trusted/ITrustedWebActivityService;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/customtabs/trusted/ITrustedWebActivityService$_Parcel;,
        Landroid/support/customtabs/trusted/ITrustedWebActivityService$Stub;,
        Landroid/support/customtabs/trusted/ITrustedWebActivityService$Default;
    }
.end annotation


# static fields
.field public static final DESCRIPTOR:Ljava/lang/String; = "android.support.customtabs.trusted.ITrustedWebActivityService"


# virtual methods
.method public abstract areNotificationsEnabled(Landroid/os/Bundle;)Landroid/os/Bundle;
.end method

.method public abstract cancelNotification(Landroid/os/Bundle;)V
.end method

.method public abstract extraCommand(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/IBinder;)Landroid/os/Bundle;
.end method

.method public abstract getActiveNotifications()Landroid/os/Bundle;
.end method

.method public abstract getSmallIconBitmap()Landroid/os/Bundle;
.end method

.method public abstract getSmallIconId()I
.end method

.method public abstract notifyNotificationWithChannel(Landroid/os/Bundle;)Landroid/os/Bundle;
.end method
