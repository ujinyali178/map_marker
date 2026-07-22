.class public final Lcom/google/android/gms/internal/play_billing/zzcz;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final zza:[Ljava/lang/String;

.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzdd;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    const-string v0, "com.google.common.flogger.util.StackWalkerStackGetter"

    const-string v1, "com.google.common.flogger.util.JavaLangAccessStackGetter"

    filled-new-array {v0, v1}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzcz;->zza:[Ljava/lang/String;

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_c
    const/4 v2, 0x2

    if-ge v1, v2, :cond_33

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzcz;->zza:[Ljava/lang/String;

    aget-object v2, v2, v1

    :try_start_13
    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    const-class v3, Lcom/google/android/gms/internal/play_billing/zzdd;

    invoke-virtual {v2, v3}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v2

    new-array v3, v0, [Ljava/lang/Class;

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getDeclaredConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v2

    new-array v3, v0, [Ljava/lang/Object;

    invoke-virtual {v2, v3}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzdd;
    :try_end_2b
    .catchall {:try_start_13 .. :try_end_2b} :catchall_2c

    goto :goto_2d

    :catchall_2c
    const/4 v2, 0x0

    :goto_2d
    if-eqz v2, :cond_30

    goto :goto_38

    :cond_30
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    :cond_33
    new-instance v2, Lcom/google/android/gms/internal/play_billing/zzde;

    invoke-direct {v2}, Lcom/google/android/gms/internal/play_billing/zzde;-><init>()V

    :goto_38
    sput-object v2, Lcom/google/android/gms/internal/play_billing/zzcz;->zzb:Lcom/google/android/gms/internal/play_billing/zzdd;

    return-void
.end method

.method public static zza(Ljava/lang/Class;I)Ljava/lang/StackTraceElement;
    .registers 3
    .annotation runtime Lorg/checkerframework/checker/nullness/compatqual/NullableDecl;
    .end annotation

    const-string p1, "target"

    invoke-static {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzda;->zza(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzcz;->zzb:Lcom/google/android/gms/internal/play_billing/zzdd;

    const/4 v0, 0x2

    invoke-interface {p1, p0, v0}, Lcom/google/android/gms/internal/play_billing/zzdd;->zza(Ljava/lang/Class;I)Ljava/lang/StackTraceElement;

    move-result-object p0

    return-object p0
.end method
