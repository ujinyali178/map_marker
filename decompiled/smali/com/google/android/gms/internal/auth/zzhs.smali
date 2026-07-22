.class public final Lcom/google/android/gms/internal/auth/zzhs;
.super Lcom/google/android/gms/internal/auth/zzev;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/internal/auth/zzfy;


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/auth/zzhs;


# instance fields
.field private zzd:Lcom/google/android/gms/internal/auth/zzez;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lcom/google/android/gms/internal/auth/zzhs;

    invoke-direct {v0}, Lcom/google/android/gms/internal/auth/zzhs;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/auth/zzhs;->zzb:Lcom/google/android/gms/internal/auth/zzhs;

    const-class v1, Lcom/google/android/gms/internal/auth/zzhs;

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/auth/zzev;->zzk(Ljava/lang/Class;Lcom/google/android/gms/internal/auth/zzev;)V

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/gms/internal/auth/zzev;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzev;->zzf()Lcom/google/android/gms/internal/auth/zzez;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/auth/zzhs;->zzd:Lcom/google/android/gms/internal/auth/zzez;

    return-void
.end method

.method static synthetic zzo()Lcom/google/android/gms/internal/auth/zzhs;
    .registers 1

    sget-object v0, Lcom/google/android/gms/internal/auth/zzhs;->zzb:Lcom/google/android/gms/internal/auth/zzhs;

    return-object v0
.end method

.method public static zzp([B)Lcom/google/android/gms/internal/auth/zzhs;
    .registers 2

    sget-object v0, Lcom/google/android/gms/internal/auth/zzhs;->zzb:Lcom/google/android/gms/internal/auth/zzhs;

    invoke-static {v0, p0}, Lcom/google/android/gms/internal/auth/zzev;->zzd(Lcom/google/android/gms/internal/auth/zzev;[B)Lcom/google/android/gms/internal/auth/zzev;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/internal/auth/zzhs;

    return-object p0
.end method


# virtual methods
.method protected final zzn(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4

    add-int/lit8 p1, p1, -0x1

    const/4 p2, 0x1

    if-eqz p1, :cond_32

    const/4 p3, 0x2

    if-eq p1, p3, :cond_22

    const/4 p2, 0x3

    if-eq p1, p2, :cond_1c

    const/4 p2, 0x4

    const/4 p3, 0x0

    if-eq p1, p2, :cond_16

    const/4 p2, 0x5

    if-eq p1, p2, :cond_13

    return-object p3

    :cond_13
    sget-object p1, Lcom/google/android/gms/internal/auth/zzhs;->zzb:Lcom/google/android/gms/internal/auth/zzhs;

    return-object p1

    :cond_16
    new-instance p1, Lcom/google/android/gms/internal/auth/zzhr;

    invoke-direct {p1, p3}, Lcom/google/android/gms/internal/auth/zzhr;-><init>(Lcom/google/android/gms/internal/auth/zzhq;)V

    return-object p1

    :cond_1c
    new-instance p1, Lcom/google/android/gms/internal/auth/zzhs;

    invoke-direct {p1}, Lcom/google/android/gms/internal/auth/zzhs;-><init>()V

    return-object p1

    :cond_22
    new-array p1, p2, [Ljava/lang/Object;

    const/4 p2, 0x0

    const-string p3, "zzd"

    aput-object p3, p1, p2

    sget-object p2, Lcom/google/android/gms/internal/auth/zzhs;->zzb:Lcom/google/android/gms/internal/auth/zzhs;

    const-string p3, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a"

    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/auth/zzev;->zzh(Lcom/google/android/gms/internal/auth/zzfx;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_32
    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    return-object p1
.end method

.method public final zzq()Ljava/util/List;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzhs;->zzd:Lcom/google/android/gms/internal/auth/zzez;

    return-object v0
.end method
