.class final Lcom/google/android/gms/internal/play_billing/zzig;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzfb;


# static fields
.field static final zza:Lcom/google/android/gms/internal/play_billing/zzfb;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzig;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzig;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzig;->zza:Lcom/google/android/gms/internal/play_billing/zzfb;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final zza(I)Z
    .registers 2

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzih;->zza(I)I

    move-result p1

    if-eqz p1, :cond_8

    const/4 p1, 0x1

    return p1

    :cond_8
    const/4 p1, 0x0

    return p1
.end method
