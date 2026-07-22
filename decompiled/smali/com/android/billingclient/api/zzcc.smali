.class public final Lcom/android/billingclient/api/zzcc;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method constructor <init>(Lorg/json/JSONObject;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "startTimeMillis"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    const-string v0, "endTimeMillis"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    return-void
.end method
