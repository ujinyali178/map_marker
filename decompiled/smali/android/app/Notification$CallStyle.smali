.class public synthetic Landroid/app/Notification$CallStyle;
.super Landroid/app/Notification$Style;
.source "SourceFile"


# direct methods
.method static synthetic constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/lang/NoClassDefFoundError;

    invoke-direct {v0}, Ljava/lang/NoClassDefFoundError;-><init>()V

    throw v0
.end method

.method public static native synthetic forIncomingCall(Landroid/app/Person;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)Landroid/app/Notification$CallStyle;
    .param p0    # Landroid/app/Person;
        .annotation build Landroid/annotation/NonNull;
        .end annotation
    .end param
    .param p1    # Landroid/app/PendingIntent;
        .annotation build Landroid/annotation/NonNull;
        .end annotation
    .end param
    .param p2    # Landroid/app/PendingIntent;
        .annotation build Landroid/annotation/NonNull;
        .end annotation
    .end param
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method

.method public static native synthetic forOngoingCall(Landroid/app/Person;Landroid/app/PendingIntent;)Landroid/app/Notification$CallStyle;
    .param p0    # Landroid/app/Person;
        .annotation build Landroid/annotation/NonNull;
        .end annotation
    .end param
    .param p1    # Landroid/app/PendingIntent;
        .annotation build Landroid/annotation/NonNull;
        .end annotation
    .end param
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method

.method public static native synthetic forScreeningCall(Landroid/app/Person;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)Landroid/app/Notification$CallStyle;
    .param p0    # Landroid/app/Person;
        .annotation build Landroid/annotation/NonNull;
        .end annotation
    .end param
    .param p1    # Landroid/app/PendingIntent;
        .annotation build Landroid/annotation/NonNull;
        .end annotation
    .end param
    .param p2    # Landroid/app/PendingIntent;
        .annotation build Landroid/annotation/NonNull;
        .end annotation
    .end param
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method


# virtual methods
.method public native synthetic setAnswerButtonColorHint(I)Landroid/app/Notification$CallStyle;
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method

.method public native synthetic setDeclineButtonColorHint(I)Landroid/app/Notification$CallStyle;
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method

.method public native synthetic setIsVideo(Z)Landroid/app/Notification$CallStyle;
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method

.method public native synthetic setVerificationIcon(Landroid/graphics/drawable/Icon;)Landroid/app/Notification$CallStyle;
    .param p1    # Landroid/graphics/drawable/Icon;
        .annotation build Landroid/annotation/Nullable;
        .end annotation
    .end param
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method

.method public native synthetic setVerificationText(Ljava/lang/CharSequence;)Landroid/app/Notification$CallStyle;
    .param p1    # Ljava/lang/CharSequence;
        .annotation build Landroid/annotation/Nullable;
        .end annotation
    .end param
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method
