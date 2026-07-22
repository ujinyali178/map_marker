.class Lcom/android/billingclient/api/BillingClientImpl;
.super Lcom/android/billingclient/api/BillingClient;
.source "SourceFile"


# instance fields
.field private zzA:Ljava/util/concurrent/ExecutorService;

.field private volatile zza:I

.field private final zzb:Ljava/lang/String;

.field private final zzc:Landroid/os/Handler;

.field private volatile zzd:Lcom/android/billingclient/api/zzh;

.field private zze:Landroid/content/Context;

.field private zzf:Lcom/android/billingclient/api/zzbi;

.field private volatile zzg:Lcom/google/android/gms/internal/play_billing/zzm;

.field private volatile zzh:Lcom/android/billingclient/api/zzao;

.field private zzi:Z

.field private zzj:Z

.field private zzk:I

.field private zzl:Z

.field private zzm:Z

.field private zzn:Z

.field private zzo:Z

.field private zzp:Z

.field private zzq:Z

.field private zzr:Z

.field private zzs:Z

.field private zzt:Z

.field private zzu:Z

.field private zzv:Z

.field private zzw:Z

.field private zzx:Z

.field private zzy:Lcom/android/billingclient/api/zzbx;

.field private zzz:Z


# direct methods
.method private constructor <init>(Landroid/app/Activity;Lcom/android/billingclient/api/zzbx;Ljava/lang/String;)V
    .registers 13

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    new-instance v3, Lcom/android/billingclient/api/zzba;

    invoke-direct {v3}, Lcom/android/billingclient/api/zzba;-><init>()V

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object v0, p0

    move-object v2, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;-><init>(Landroid/content/Context;Lcom/android/billingclient/api/zzbx;Lcom/android/billingclient/api/PurchasesUpdatedListener;Ljava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/zzbi;Ljava/util/concurrent/ExecutorService;)V

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Lcom/android/billingclient/api/zzbx;Lcom/android/billingclient/api/PurchasesUpdatedListener;Ljava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/zzbi;Ljava/util/concurrent/ExecutorService;)V
    .registers 16

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClient;-><init>()V

    const/4 p5, 0x0

    iput p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    new-instance p7, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object p8

    invoke-direct {p7, p8}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p7, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    iput p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzk:I

    iput-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p3

    move-object v3, p2

    move-object v4, p6

    move-object v5, p4

    invoke-direct/range {v0 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->initialize(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzbx;Lcom/android/billingclient/api/UserChoiceBillingListener;Ljava/lang/String;Lcom/android/billingclient/api/zzbi;)V

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .registers 5

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClient;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    iput v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzk:I

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Landroid/content/Context;Lcom/android/billingclient/api/zzbi;Ljava/util/concurrent/ExecutorService;)V
    .registers 5

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClient;-><init>()V

    const/4 p1, 0x0

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    new-instance p3, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object p4

    invoke-direct {p3, p4}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzk:I

    invoke-static {}, Lcom/android/billingclient/api/BillingClientImpl;->zzab()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    invoke-virtual {p2}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p2

    iput-object p2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzio;->zzv()Lcom/google/android/gms/internal/play_billing/zzin;

    move-result-object p2

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzin;->zzj(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzin;

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzin;->zzi(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzin;

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzio;

    new-instance p3, Lcom/android/billingclient/api/zzbn;

    invoke-direct {p3, p1, p2}, Lcom/android/billingclient/api/zzbn;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzio;)V

    iput-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/android/billingclient/api/zzbx;Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/AlternativeBillingListener;Lcom/android/billingclient/api/zzbi;Ljava/util/concurrent/ExecutorService;)V
    .registers 15

    invoke-static {}, Lcom/android/billingclient/api/BillingClientImpl;->zzab()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClient;-><init>()V

    const/4 p1, 0x0

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    new-instance p6, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object p7

    invoke-direct {p6, p7}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzk:I

    iput-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p3

    move-object v2, p4

    move-object v3, p2

    move-object v4, p5

    invoke-direct/range {v0 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->initialize(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzbx;Lcom/android/billingclient/api/AlternativeBillingListener;Ljava/lang/String;Lcom/android/billingclient/api/zzbi;)V

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/android/billingclient/api/zzbx;Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/zzbi;Ljava/util/concurrent/ExecutorService;)V
    .registers 17

    invoke-static {}, Lcom/android/billingclient/api/BillingClientImpl;->zzab()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object v0, p0

    move-object v1, p3

    move-object v2, p2

    move-object v3, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;-><init>(Landroid/content/Context;Lcom/android/billingclient/api/zzbx;Lcom/android/billingclient/api/PurchasesUpdatedListener;Ljava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/zzbi;Ljava/util/concurrent/ExecutorService;)V

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/android/billingclient/api/zzbx;Landroid/content/Context;Lcom/android/billingclient/api/zzbq;Lcom/android/billingclient/api/zzbi;Ljava/util/concurrent/ExecutorService;)V
    .registers 7

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClient;-><init>()V

    const/4 p1, 0x0

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    new-instance p4, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object p5

    invoke-direct {p4, p5}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzk:I

    invoke-static {}, Lcom/android/billingclient/api/BillingClientImpl;->zzab()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    invoke-virtual {p3}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzio;->zzv()Lcom/google/android/gms/internal/play_billing/zzin;

    move-result-object p1

    invoke-static {}, Lcom/android/billingclient/api/BillingClientImpl;->zzab()Ljava/lang/String;

    move-result-object p3

    invoke-virtual {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzin;->zzj(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzin;

    iget-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p3

    invoke-virtual {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzin;->zzi(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzin;

    iget-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzio;

    new-instance p4, Lcom/android/billingclient/api/zzbn;

    invoke-direct {p4, p3, p1}, Lcom/android/billingclient/api/zzbn;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzio;)V

    iput-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const-string p1, "BillingClient"

    const-string p3, "Billing client should have a valid listener but the provided is null."

    invoke-static {p1, p3}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    new-instance p1, Lcom/android/billingclient/api/zzh;

    iget-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    iget-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 p5, 0x0

    invoke-direct {p1, p3, p5, p4}, Lcom/android/billingclient/api/zzh;-><init>(Landroid/content/Context;Lcom/android/billingclient/api/zzbq;Lcom/android/billingclient/api/zzbi;)V

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    iput-object p2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzy:Lcom/android/billingclient/api/zzbx;

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    return-void
.end method

.method private initialize(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzbx;Lcom/android/billingclient/api/AlternativeBillingListener;Ljava/lang/String;Lcom/android/billingclient/api/zzbi;)V
    .registers 7

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzio;->zzv()Lcom/google/android/gms/internal/play_billing/zzin;

    move-result-object p1

    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/play_billing/zzin;->zzj(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzin;

    iget-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p5

    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/play_billing/zzin;->zzi(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzin;

    if-eqz p6, :cond_19

    goto :goto_26

    :cond_19
    iget-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzio;

    new-instance p6, Lcom/android/billingclient/api/zzbn;

    invoke-direct {p6, p5, p1}, Lcom/android/billingclient/api/zzbn;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzio;)V

    :goto_26
    iput-object p6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    if-nez p2, :cond_31

    const-string p1, "BillingClient"

    const-string p5, "Billing client should have a valid listener but the provided is null."

    invoke-static {p1, p5}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    :cond_31
    new-instance p1, Lcom/android/billingclient/api/zzh;

    iget-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    iget-object p6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-direct {p1, p5, p2, p4, p6}, Lcom/android/billingclient/api/zzh;-><init>(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/AlternativeBillingListener;Lcom/android/billingclient/api/zzbi;)V

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    iput-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzy:Lcom/android/billingclient/api/zzbx;

    if-eqz p4, :cond_42

    const/4 p1, 0x1

    goto :goto_43

    :cond_42
    const/4 p1, 0x0

    :goto_43
    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzz:Z

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    return-void
.end method

.method private initialize(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/zzbx;Lcom/android/billingclient/api/UserChoiceBillingListener;Ljava/lang/String;Lcom/android/billingclient/api/zzbi;)V
    .registers 7

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p1

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzio;->zzv()Lcom/google/android/gms/internal/play_billing/zzin;

    move-result-object p1

    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/play_billing/zzin;->zzj(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzin;

    iget-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p5

    invoke-virtual {p1, p5}, Lcom/google/android/gms/internal/play_billing/zzin;->zzi(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzin;

    if-eqz p6, :cond_19

    goto :goto_26

    :cond_19
    iget-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzio;

    new-instance p6, Lcom/android/billingclient/api/zzbn;

    invoke-direct {p6, p5, p1}, Lcom/android/billingclient/api/zzbn;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/play_billing/zzio;)V

    :goto_26
    iput-object p6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    if-nez p2, :cond_31

    const-string p1, "BillingClient"

    const-string p5, "Billing client should have a valid listener but the provided is null."

    invoke-static {p1, p5}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    :cond_31
    new-instance p1, Lcom/android/billingclient/api/zzh;

    iget-object p5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    iget-object p6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-direct {p1, p5, p2, p4, p6}, Lcom/android/billingclient/api/zzh;-><init>(Landroid/content/Context;Lcom/android/billingclient/api/PurchasesUpdatedListener;Lcom/android/billingclient/api/UserChoiceBillingListener;Lcom/android/billingclient/api/zzbi;)V

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    iput-object p3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzy:Lcom/android/billingclient/api/zzbx;

    if-eqz p4, :cond_42

    const/4 p1, 0x1

    goto :goto_43

    :cond_42
    const/4 p1, 0x0

    :goto_43
    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzz:Z

    return-void
.end method

.method private launchBillingFlowCpp(Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)I
    .registers 3

    invoke-virtual {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->launchBillingFlow(Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result p1

    return p1
.end method

.method private startConnection(J)V
    .registers 11

    new-instance v0, Lcom/android/billingclient/api/zzba;

    invoke-direct {v0, p1, p2}, Lcom/android/billingclient/api/zzba;-><init>(J)V

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result p1

    const/4 p2, 0x6

    const-string v1, "BillingClient"

    if-eqz p1, :cond_22

    const-string p1, "Service connection is valid. No need to re-initialize."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-static {p2}, Lcom/android/billingclient/api/zzbh;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzic;

    move-result-object p2

    invoke-interface {p1, p2}, Lcom/android/billingclient/api/zzbi;->zzb(Lcom/google/android/gms/internal/play_billing/zzic;)V

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    invoke-interface {v0, p1}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_22
    iget p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const/4 v2, 0x1

    if-ne p1, v2, :cond_3d

    const-string p1, "Client is already in the process of connecting to billing service."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x25

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzd:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v1, p2, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object p2

    invoke-interface {p1, p2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_3d
    iget p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const/4 v3, 0x3

    if-ne p1, v3, :cond_58

    const-string p1, "Client was already closed and can\'t be reused. Please create another instance."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x26

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v1, p2, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object p2

    invoke-interface {p1, p2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_58
    iput v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const-string p1, "Starting in-app billing setup."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    new-instance p1, Lcom/android/billingclient/api/zzao;

    const/4 v3, 0x0

    invoke-direct {p1, p0, v0, v3}, Lcom/android/billingclient/api/zzao;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingClientStateListener;Lcom/android/billingclient/api/zzan;)V

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    new-instance p1, Landroid/content/Intent;

    const-string v3, "com.android.vending.billing.InAppBillingService.BIND"

    invoke-direct {p1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v3, "com.android.vending"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, p1, v5}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v4

    const/16 v6, 0x29

    if-eqz v4, :cond_d2

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_d2

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ResolveInfo;

    iget-object v4, v4, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    if-eqz v4, :cond_d4

    iget-object v6, v4, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    iget-object v4, v4, Landroid/content/pm/ServiceInfo;->name:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_ca

    if-eqz v4, :cond_ca

    new-instance v3, Landroid/content/ComponentName;

    invoke-direct {v3, v6, v4}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4, p1}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    invoke-virtual {v4, v3}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    const-string v3, "playBillingLibraryVersion"

    invoke-virtual {v4, v3, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    invoke-virtual {p1, v4, v3, v2}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result p1

    if-eqz p1, :cond_c2

    const-string p1, "Service was bonded successfully."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    :cond_c2
    const-string p1, "Connection to Billing service is blocked."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v2, 0x27

    goto :goto_d4

    :cond_ca
    const-string p1, "The device doesn\'t have valid Play Store."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v2, 0x28

    goto :goto_d4

    :cond_d2
    const/16 v2, 0x29

    :cond_d4
    :goto_d4
    iput v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const-string p1, "Billing service unavailable on device."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzc:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, p2, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object p2

    invoke-interface {p1, p2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method static bridge synthetic zzA(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzs:Z

    return-void
.end method

.method static bridge synthetic zzB(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzt:Z

    return-void
.end method

.method static bridge synthetic zzC(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzu:Z

    return-void
.end method

.method static bridge synthetic zzD(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzv:Z

    return-void
.end method

.method static bridge synthetic zzE(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzw:Z

    return-void
.end method

.method static bridge synthetic zzF(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzx:Z

    return-void
.end method

.method static bridge synthetic zzG(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzl:Z

    return-void
.end method

.method static bridge synthetic zzH(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:Z

    return-void
.end method

.method static bridge synthetic zzI(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    return-void
.end method

.method static bridge synthetic zzJ(Lcom/android/billingclient/api/BillingClientImpl;Lcom/google/android/gms/internal/play_billing/zzm;)V
    .registers 2

    iput-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    return-void
.end method

.method static bridge synthetic zzK(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Z

    return-void
.end method

.method static bridge synthetic zzL(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Z

    return-void
.end method

.method static synthetic zzX(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;I)Lcom/android/billingclient/api/zzce;
    .registers 20

    move-object/from16 v1, p0

    invoke-static/range {p1 .. p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "Querying owned items, item type: "

    invoke-virtual {v2, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "BillingClient"

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget-boolean v3, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    iget-boolean v4, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzv:Z

    iget-object v5, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    const/4 v6, 0x1

    const/4 v7, 0x0

    invoke-static {v3, v4, v6, v7, v5}, Lcom/google/android/gms/internal/play_billing/zzb;->zzd(ZZZZLjava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    const/4 v4, 0x0

    move-object v12, v4

    :goto_24
    const/16 v5, 0x9

    :try_start_26
    iget-boolean v8, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    if-eqz v8, :cond_45

    iget-object v8, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-boolean v9, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzv:Z

    if-eq v6, v9, :cond_33

    const/16 v9, 0x9

    goto :goto_35

    :cond_33
    const/16 v9, 0x13

    :goto_35
    iget-object v10, v1, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v11, p1

    move-object v13, v3

    invoke-interface/range {v8 .. v13}, Lcom/google/android/gms/internal/play_billing/zzm;->zzj(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v8

    move-object/from16 v11, p1

    goto :goto_54

    :cond_45
    iget-object v8, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    const/4 v9, 0x3

    iget-object v10, v1, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v11, p1

    invoke-interface {v8, v9, v10, v11, v12}, Lcom/google/android/gms/internal/play_billing/zzm;->zzi(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v8
    :try_end_54
    .catch Ljava/lang/Exception; {:try_start_26 .. :try_end_54} :catch_11f

    :goto_54
    const-string v9, "getPurchase()"

    invoke-static {v8, v2, v9}, Lcom/android/billingclient/api/zzcg;->zza(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lcom/android/billingclient/api/zzcf;

    move-result-object v9

    invoke-virtual {v9}, Lcom/android/billingclient/api/zzcf;->zza()Lcom/android/billingclient/api/BillingResult;

    move-result-object v10

    sget-object v12, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    if-eq v10, v12, :cond_76

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-virtual {v9}, Lcom/android/billingclient/api/zzcf;->zzb()I

    move-result v1

    invoke-static {v1, v5, v10}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    new-instance v0, Lcom/android/billingclient/api/zzce;

    invoke-direct {v0, v10, v4}, Lcom/android/billingclient/api/zzce;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    goto/16 :goto_138

    :cond_76
    const-string v9, "INAPP_PURCHASE_ITEM_LIST"

    invoke-virtual {v8, v9}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v9

    const-string v10, "INAPP_PURCHASE_DATA_LIST"

    invoke-virtual {v8, v10}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v10

    const-string v12, "INAPP_DATA_SIGNATURE_LIST"

    invoke-virtual {v8, v12}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v12

    const/4 v13, 0x0

    const/4 v14, 0x0

    :goto_8a
    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v15

    if-ge v13, v15, :cond_e9

    invoke-virtual {v10, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    invoke-virtual {v12, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v16

    move-object/from16 v6, v16

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v9, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/String;

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const-string v4, "Sku is owned: "

    invoke-virtual {v4, v7}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_b1
    new-instance v4, Lcom/android/billingclient/api/Purchase;

    invoke-direct {v4, v15, v6}, Lcom/android/billingclient/api/Purchase;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_b6
    .catch Lorg/json/JSONException; {:try_start_b1 .. :try_end_b6} :catch_cf

    invoke-virtual {v4}, Lcom/android/billingclient/api/Purchase;->getPurchaseToken()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_c6

    const-string v6, "BUG: empty/null token!"

    invoke-static {v2, v6}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v14, 0x1

    :cond_c6
    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v13, v13, 0x1

    const/4 v4, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    goto :goto_8a

    :catch_cf
    move-exception v0

    const-string v3, "Got an exception trying to decode the purchase!"

    invoke-static {v2, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x33

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v1, v5, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    new-instance v0, Lcom/android/billingclient/api/zzce;

    const/4 v1, 0x0

    invoke-direct {v0, v2, v1}, Lcom/android/billingclient/api/zzce;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    goto :goto_138

    :cond_e9
    if-eqz v14, :cond_f8

    iget-object v4, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v6, 0x1a

    sget-object v7, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v6, v5, v7}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    :cond_f8
    const-string v4, "INAPP_CONTINUATION_TOKEN"

    invoke-virtual {v8, v4}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "Continuation token: "

    invoke-virtual {v5, v4}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_11a

    new-instance v1, Lcom/android/billingclient/api/zzce;

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {v1, v2, v0}, Lcom/android/billingclient/api/zzce;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    move-object v0, v1

    goto :goto_138

    :cond_11a
    const/4 v4, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    goto/16 :goto_24

    :catch_11f
    move-exception v0

    iget-object v1, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v3, 0x34

    sget-object v4, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v3, v5, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v3

    invoke-interface {v1, v3}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    const-string v1, "Got exception trying to get purchasesm try to reconnect"

    invoke-static {v2, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    new-instance v0, Lcom/android/billingclient/api/zzce;

    const/4 v1, 0x0

    invoke-direct {v0, v4, v1}, Lcom/android/billingclient/api/zzce;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    :goto_138
    return-object v0
.end method

.method private final zzY()Landroid/os/Handler;
    .registers 3

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    if-nez v0, :cond_9

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    goto :goto_12

    :cond_9
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    :goto_12
    return-object v0
.end method

.method private final zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;
    .registers 4

    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v0

    if-eqz v0, :cond_7

    return-object p1

    :cond_7
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    new-instance v1, Lcom/android/billingclient/api/zzj;

    invoke-direct {v1, p0, p1}, Lcom/android/billingclient/api/zzj;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingResult;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-object p1
.end method

.method static bridge synthetic zza(Lcom/android/billingclient/api/BillingClientImpl;)I
    .registers 1

    iget p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzk:I

    return p0
.end method

.method private final zzaa()Lcom/android/billingclient/api/BillingResult;
    .registers 3

    iget v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    if-eqz v0, :cond_d

    iget v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_a

    goto :goto_d

    :cond_a
    sget-object v0, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    goto :goto_f

    :cond_d
    :goto_d
    sget-object v0, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    :goto_f
    return-object v0
.end method

.method private static zzab()Ljava/lang/String;
    .registers 2

    :try_start_0
    const-string v0, "com.android.billingclient.ktx.BuildConfig"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-string v1, "VERSION_NAME"

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_13
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_13} :catch_14

    return-object v0

    :catch_14
    const-string v0, "6.1.0"

    return-object v0
.end method

.method private final zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;
    .registers 9

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzA:Ljava/util/concurrent/ExecutorService;

    if-nez v0, :cond_11

    sget v0, Lcom/google/android/gms/internal/play_billing/zzb;->zza:I

    new-instance v1, Lcom/android/billingclient/api/zzag;

    invoke-direct {v1, p0}, Lcom/android/billingclient/api/zzag;-><init>(Lcom/android/billingclient/api/BillingClientImpl;)V

    invoke-static {v0, v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzA:Ljava/util/concurrent/ExecutorService;

    :cond_11
    :try_start_11
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzA:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0, p1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object p1
    :try_end_17
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_17} :catch_29

    long-to-double p2, p2

    new-instance v0, Lcom/android/billingclient/api/zzn;

    invoke-direct {v0, p1, p4}, Lcom/android/billingclient/api/zzn;-><init>(Ljava/util/concurrent/Future;Ljava/lang/Runnable;)V

    const-wide v1, 0x3fee666666666666L    # 0.95

    mul-double p2, p2, v1

    double-to-long p2, p2

    invoke-virtual {p5, v0, p2, p3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-object p1

    :catch_29
    move-exception p1

    const-string p2, "BillingClient"

    const-string p3, "Async task throws exception!"

    invoke-static {p2, p3, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 p1, 0x0

    return-object p1
.end method

.method private final zzad(Ljava/lang/String;Lcom/android/billingclient/api/PurchaseHistoryResponseListener;)V
    .registers 13

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/4 v1, 0x0

    const/16 v2, 0xb

    if-nez v0, :cond_19

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v0, 0x2

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v2, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v3, v1}, Lcom/android/billingclient/api/PurchaseHistoryResponseListener;->onPurchaseHistoryResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_19
    new-instance v5, Lcom/android/billingclient/api/zzai;

    invoke-direct {v5, p0, p1, p2}, Lcom/android/billingclient/api/zzai;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;Lcom/android/billingclient/api/PurchaseHistoryResponseListener;)V

    const-wide/16 v6, 0x7530

    new-instance v8, Lcom/android/billingclient/api/zzy;

    invoke-direct {v8, p0, p2}, Lcom/android/billingclient/api/zzy;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/PurchaseHistoryResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object v9

    move-object v4, p0

    invoke-direct/range {v4 .. v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_42

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v3, 0x19

    invoke-static {v3, v2, p1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, p1, v1}, Lcom/android/billingclient/api/PurchaseHistoryResponseListener;->onPurchaseHistoryResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    :cond_42
    return-void
.end method

.method private final zzae(Ljava/lang/String;Lcom/android/billingclient/api/PurchasesResponseListener;)V
    .registers 12

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/16 v1, 0x9

    if-nez v0, :cond_1c

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v0, 0x2

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzk()Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object p1

    invoke-interface {p2, v2, p1}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_1c
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3e

    const-string p1, "BillingClient"

    const-string v0, "Please provide a valid product type."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v0, 0x32

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzg:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzk()Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object p1

    invoke-interface {p2, v2, p1}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_3e
    new-instance v4, Lcom/android/billingclient/api/zzah;

    invoke-direct {v4, p0, p1, p2}, Lcom/android/billingclient/api/zzah;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;Lcom/android/billingclient/api/PurchasesResponseListener;)V

    const-wide/16 v5, 0x7530

    new-instance v7, Lcom/android/billingclient/api/zzs;

    invoke-direct {v7, p0, p2}, Lcom/android/billingclient/api/zzs;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/PurchasesResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object v8

    move-object v3, p0

    invoke-direct/range {v3 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_6b

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x19

    invoke-static {v2, v1, p1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzk()Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object v0

    invoke-interface {p2, p1, v0}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    :cond_6b
    return-void
.end method

.method private final zzaf(Lcom/android/billingclient/api/BillingResult;II)V
    .registers 12

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v0

    const/4 v1, 0x0

    const-string v2, "Unable to create logging payload"

    const-string v3, "BillingLogger"

    const/4 v4, 0x5

    if-eqz v0, :cond_4d

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    :try_start_e
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhy;->zzv()Lcom/google/android/gms/internal/play_billing/zzhx;

    move-result-object v5

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzii;->zzv()Lcom/google/android/gms/internal/play_billing/zzie;

    move-result-object v6

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v7

    invoke-virtual {v6, v7}, Lcom/google/android/gms/internal/play_billing/zzie;->zzk(I)Lcom/google/android/gms/internal/play_billing/zzie;

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getDebugMessage()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v6, p1}, Lcom/google/android/gms/internal/play_billing/zzie;->zzj(Ljava/lang/String;)Lcom/google/android/gms/internal/play_billing/zzie;

    invoke-virtual {v6, p2}, Lcom/google/android/gms/internal/play_billing/zzie;->zzl(I)Lcom/google/android/gms/internal/play_billing/zzie;

    invoke-virtual {v5, v6}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzi(Lcom/google/android/gms/internal/play_billing/zzie;)Lcom/google/android/gms/internal/play_billing/zzhx;

    invoke-virtual {v5, v4}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzk(I)Lcom/google/android/gms/internal/play_billing/zzhx;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzis;->zzv()Lcom/google/android/gms/internal/play_billing/zziq;

    move-result-object p1

    invoke-virtual {p1, p3}, Lcom/google/android/gms/internal/play_billing/zziq;->zzi(I)Lcom/google/android/gms/internal/play_billing/zziq;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzis;

    invoke-virtual {v5, p1}, Lcom/google/android/gms/internal/play_billing/zzhx;->zzj(Lcom/google/android/gms/internal/play_billing/zzis;)Lcom/google/android/gms/internal/play_billing/zzhx;

    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzhy;
    :try_end_43
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_43} :catch_45

    move-object v1, p1

    goto :goto_49

    :catch_45
    move-exception p1

    invoke-static {v3, v2, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    :goto_49
    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    return-void

    :cond_4d
    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    :try_start_4f
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzic;->zzv()Lcom/google/android/gms/internal/play_billing/zzib;

    move-result-object p2

    invoke-virtual {p2, v4}, Lcom/google/android/gms/internal/play_billing/zzib;->zzj(I)Lcom/google/android/gms/internal/play_billing/zzib;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzis;->zzv()Lcom/google/android/gms/internal/play_billing/zziq;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/google/android/gms/internal/play_billing/zziq;->zzi(I)Lcom/google/android/gms/internal/play_billing/zziq;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p3

    check-cast p3, Lcom/google/android/gms/internal/play_billing/zzis;

    invoke-virtual {p2, p3}, Lcom/google/android/gms/internal/play_billing/zzib;->zzi(Lcom/google/android/gms/internal/play_billing/zzis;)Lcom/google/android/gms/internal/play_billing/zzib;

    invoke-virtual {p2}, Lcom/google/android/gms/internal/play_billing/zzet;->zzc()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p2

    check-cast p2, Lcom/google/android/gms/internal/play_billing/zzic;
    :try_end_6c
    .catch Ljava/lang/Exception; {:try_start_4f .. :try_end_6c} :catch_6e

    move-object v1, p2

    goto :goto_72

    :catch_6e
    move-exception p2

    invoke-static {v3, v2, p2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    :goto_72
    invoke-interface {p1, v1}, Lcom/android/billingclient/api/zzbi;->zzb(Lcom/google/android/gms/internal/play_billing/zzic;)V

    return-void
.end method

.method static bridge synthetic zzb(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/content/Context;
    .registers 1

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    return-object p0
.end method

.method static bridge synthetic zze(Lcom/android/billingclient/api/BillingClientImpl;)Landroid/os/Handler;
    .registers 1

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object p0

    return-object p0
.end method

.method static bridge synthetic zzf(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzh;
    .registers 1

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    return-object p0
.end method

.method static synthetic zzg(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;)Lcom/android/billingclient/api/zzaz;
    .registers 19

    move-object/from16 v1, p0

    invoke-static/range {p1 .. p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "Querying purchase history, item type: "

    invoke-virtual {v2, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "BillingClient"

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget-boolean v3, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    iget-boolean v4, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzv:Z

    iget-object v5, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    const/4 v6, 0x1

    const/4 v7, 0x0

    invoke-static {v3, v4, v6, v7, v5}, Lcom/google/android/gms/internal/play_billing/zzb;->zzd(ZZZZLjava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    const/4 v4, 0x0

    move-object v12, v4

    :goto_24
    iget-boolean v5, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzl:Z

    if-nez v5, :cond_36

    const-string v0, "getPurchaseHistory is not supported on current device"

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/android/billingclient/api/zzaz;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzq:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {v0, v1, v4}, Lcom/android/billingclient/api/zzaz;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    goto/16 :goto_126

    :cond_36
    const/16 v5, 0xb

    :try_start_38
    iget-object v8, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    const/4 v9, 0x6

    iget-object v10, v1, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v11, p1

    move-object v13, v3

    invoke-interface/range {v8 .. v13}, Lcom/google/android/gms/internal/play_billing/zzm;->zzh(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v8
    :try_end_48
    .catch Landroid/os/RemoteException; {:try_start_38 .. :try_end_48} :catch_10e

    const-string v9, "getPurchaseHistory()"

    invoke-static {v8, v2, v9}, Lcom/android/billingclient/api/zzcg;->zza(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lcom/android/billingclient/api/zzcf;

    move-result-object v9

    invoke-virtual {v9}, Lcom/android/billingclient/api/zzcf;->zza()Lcom/android/billingclient/api/BillingResult;

    move-result-object v10

    sget-object v11, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    if-eq v10, v11, :cond_6a

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-virtual {v9}, Lcom/android/billingclient/api/zzcf;->zzb()I

    move-result v1

    invoke-static {v1, v5, v10}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    new-instance v0, Lcom/android/billingclient/api/zzaz;

    invoke-direct {v0, v10, v4}, Lcom/android/billingclient/api/zzaz;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    goto/16 :goto_126

    :cond_6a
    const-string v9, "INAPP_PURCHASE_ITEM_LIST"

    invoke-virtual {v8, v9}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v9

    const-string v10, "INAPP_PURCHASE_DATA_LIST"

    invoke-virtual {v8, v10}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v10

    const-string v11, "INAPP_DATA_SIGNATURE_LIST"

    invoke-virtual {v8, v11}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v11

    const/4 v12, 0x0

    const/4 v13, 0x0

    :goto_7e
    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v14

    if-ge v12, v14, :cond_d9

    invoke-virtual {v10, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    invoke-virtual {v9, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/String;

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "Purchase record found for sku : "

    invoke-virtual {v7, v6}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v2, v6}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_a3
    new-instance v6, Lcom/android/billingclient/api/PurchaseHistoryRecord;

    invoke-direct {v6, v14, v15}, Lcom/android/billingclient/api/PurchaseHistoryRecord;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_a8
    .catch Lorg/json/JSONException; {:try_start_a3 .. :try_end_a8} :catch_c0

    invoke-virtual {v6}, Lcom/android/billingclient/api/PurchaseHistoryRecord;->getPurchaseToken()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_b8

    const-string v7, "BUG: empty/null token!"

    invoke-static {v2, v7}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v13, 0x1

    :cond_b8
    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v12, v12, 0x1

    const/4 v6, 0x1

    const/4 v7, 0x0

    goto :goto_7e

    :catch_c0
    move-exception v0

    const-string v3, "Got an exception trying to decode the purchase!"

    invoke-static {v2, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x33

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v1, v5, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    new-instance v0, Lcom/android/billingclient/api/zzaz;

    invoke-direct {v0, v2, v4}, Lcom/android/billingclient/api/zzaz;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    goto :goto_126

    :cond_d9
    if-eqz v13, :cond_e8

    iget-object v6, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v7, 0x1a

    sget-object v9, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v7, v5, v9}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v5

    invoke-interface {v6, v5}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    :cond_e8
    const-string v5, "INAPP_CONTINUATION_TOKEN"

    invoke-virtual {v8, v5}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "Continuation token: "

    invoke-virtual {v6, v5}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v5}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_10a

    new-instance v1, Lcom/android/billingclient/api/zzaz;

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    invoke-direct {v1, v2, v0}, Lcom/android/billingclient/api/zzaz;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    move-object v0, v1

    goto :goto_126

    :cond_10a
    const/4 v6, 0x1

    const/4 v7, 0x0

    goto/16 :goto_24

    :catch_10e
    move-exception v0

    const-string v3, "Got exception trying to get purchase history, try to reconnect"

    invoke-static {v2, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x3b

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v1, v5, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    new-instance v0, Lcom/android/billingclient/api/zzaz;

    invoke-direct {v0, v2, v4}, Lcom/android/billingclient/api/zzaz;-><init>(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    :goto_126
    return-object v0
.end method

.method static bridge synthetic zzh(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/zzbi;
    .registers 1

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    return-object p0
.end method

.method static bridge synthetic zzi(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/android/billingclient/api/BillingResult;
    .registers 1

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object p0

    return-object p0
.end method

.method static bridge synthetic zzj(Lcom/android/billingclient/api/BillingClientImpl;)Lcom/google/android/gms/internal/play_billing/zzm;
    .registers 1

    iget-object p0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    return-object p0
.end method

.method static bridge synthetic zzt(Lcom/android/billingclient/api/BillingClientImpl;Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;
    .registers 12

    const-wide/16 v2, 0x7530

    move-object v0, p0

    move-object v1, p1

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object p0

    return-object p0
.end method

.method static bridge synthetic zzu(Lcom/android/billingclient/api/BillingClientImpl;I)V
    .registers 2

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    return-void
.end method

.method static bridge synthetic zzv(Lcom/android/billingclient/api/BillingClientImpl;I)V
    .registers 2

    iput p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzk:I

    return-void
.end method

.method static bridge synthetic zzw(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzo:Z

    return-void
.end method

.method static bridge synthetic zzx(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    return-void
.end method

.method static bridge synthetic zzy(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzq:Z

    return-void
.end method

.method static bridge synthetic zzz(Lcom/android/billingclient/api/BillingClientImpl;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzr:Z

    return-void
.end method


# virtual methods
.method public final acknowledgePurchase(Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V
    .registers 12

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/4 v1, 0x3

    if-nez v0, :cond_17

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v0, 0x2

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v2}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_17
    invoke-virtual {p1}, Lcom/android/billingclient/api/AcknowledgePurchaseParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_39

    const-string p1, "BillingClient"

    const-string v0, "Please provide a valid purchase token."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v0, 0x1a

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzi:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v2}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_39
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    if-nez v0, :cond_4e

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v0, 0x1b

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzb:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v2}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_4e
    new-instance v4, Lcom/android/billingclient/api/zzaf;

    invoke-direct {v4, p0, p1, p2}, Lcom/android/billingclient/api/zzaf;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V

    const-wide/16 v5, 0x7530

    new-instance v7, Lcom/android/billingclient/api/zzk;

    invoke-direct {v7, p0, p2}, Lcom/android/billingclient/api/zzk;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object v8

    move-object v3, p0

    invoke-direct/range {v3 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_77

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x19

    invoke-static {v2, v1, p1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, p1}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    :cond_77
    return-void
.end method

.method public final consumeAsync(Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V
    .registers 13

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/4 v1, 0x4

    if-nez v0, :cond_1b

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v2, 0x2

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v1, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-virtual {p1}, Lcom/android/billingclient/api/ConsumeParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, v3, p1}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    return-void

    :cond_1b
    new-instance v5, Lcom/android/billingclient/api/zzw;

    invoke-direct {v5, p0, p1, p2}, Lcom/android/billingclient/api/zzw;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V

    const-wide/16 v6, 0x7530

    new-instance v8, Lcom/android/billingclient/api/zzx;

    invoke-direct {v8, p0, p2, p1}, Lcom/android/billingclient/api/zzx;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ConsumeResponseListener;Lcom/android/billingclient/api/ConsumeParams;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object v9

    move-object v4, p0

    invoke-direct/range {v4 .. v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object v0

    if-nez v0, :cond_48

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v3, 0x19

    invoke-static {v3, v1, v0}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v2, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-virtual {p1}, Lcom/android/billingclient/api/ConsumeParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, v0, p1}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    :cond_48
    return-void
.end method

.method public final createAlternativeBillingOnlyReportingDetailsAsync(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)V
    .registers 13

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/4 v1, 0x0

    const/16 v2, 0xf

    if-nez v0, :cond_19

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v3, 0x2

    sget-object v4, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v3, v2, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v4, v1}, Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;->onAlternativeBillingOnlyTokenResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V

    return-void

    :cond_19
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzx:Z

    if-nez v0, :cond_35

    const-string v0, "BillingClient"

    const-string v3, "Current client doesn\'t support alternative billing only."

    invoke-static {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v3, 0x42

    sget-object v4, Lcom/android/billingclient/api/zzbk;->zzD:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v3, v2, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v4, v1}, Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;->onAlternativeBillingOnlyTokenResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V

    return-void

    :cond_35
    new-instance v6, Lcom/android/billingclient/api/zzo;

    invoke-direct {v6, p0, p1}, Lcom/android/billingclient/api/zzo;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)V

    const-wide/16 v7, 0x7530

    new-instance v9, Lcom/android/billingclient/api/zzp;

    invoke-direct {v9, p0, p1}, Lcom/android/billingclient/api/zzp;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object v10

    move-object v5, p0

    invoke-direct/range {v5 .. v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object v0

    if-nez v0, :cond_5e

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v4, 0x19

    invoke-static {v4, v2, v0}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v3, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v0, v1}, Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;->onAlternativeBillingOnlyTokenResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V

    :cond_5e
    return-void
.end method

.method public final endConnection()V
    .registers 6

    const-string v0, "BillingClient"

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0xc

    invoke-static {v2}, Lcom/android/billingclient/api/zzbh;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzic;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/android/billingclient/api/zzbi;->zzb(Lcom/google/android/gms/internal/play_billing/zzic;)V

    const/4 v1, 0x3

    :try_start_e
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    if-eqz v2, :cond_17

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    invoke-virtual {v2}, Lcom/android/billingclient/api/zzh;->zze()V

    :cond_17
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    if-eqz v2, :cond_20

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    invoke-virtual {v2}, Lcom/android/billingclient/api/zzao;->zzc()V

    :cond_20
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    const/4 v3, 0x0

    if-eqz v2, :cond_37

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    if-eqz v2, :cond_37

    const-string v2, "Unbinding from service."

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    invoke-virtual {v2, v4}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    iput-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    :cond_37
    iput-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzA:Ljava/util/concurrent/ExecutorService;

    if-eqz v2, :cond_4b

    invoke-interface {v2}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    iput-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzA:Ljava/util/concurrent/ExecutorService;
    :try_end_42
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_42} :catch_45
    .catchall {:try_start_e .. :try_end_42} :catchall_43

    goto :goto_4b

    :catchall_43
    move-exception v0

    goto :goto_4e

    :catch_45
    move-exception v2

    :try_start_46
    const-string v3, "There was an exception while ending connection!"

    invoke-static {v0, v3, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4b
    .catchall {:try_start_46 .. :try_end_4b} :catchall_43

    :cond_4b
    :goto_4b
    iput v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    return-void

    :goto_4e
    iput v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    throw v0
.end method

.method public final getBillingConfigAsync(Lcom/android/billingclient/api/GetBillingConfigParams;Lcom/android/billingclient/api/BillingConfigResponseListener;)V
    .registers 13

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result p1

    const-string v0, "BillingClient"

    const/4 v1, 0x0

    const/16 v2, 0xd

    if-nez p1, :cond_20

    const-string p1, "Service disconnected."

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v0, 0x2

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v2, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v3, v1}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void

    :cond_20
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzu:Z

    if-nez p1, :cond_3a

    const-string p1, "Current client doesn\'t support get billing config."

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v0, 0x20

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzz:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v2, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v3, v1}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void

    :cond_3a
    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v3, "playBillingLibraryVersion"

    invoke-virtual {v0, v3, p1}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v5, Lcom/android/billingclient/api/zzl;

    invoke-direct {v5, p0, v0, p2}, Lcom/android/billingclient/api/zzl;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Bundle;Lcom/android/billingclient/api/BillingConfigResponseListener;)V

    const-wide/16 v6, 0x7530

    new-instance v8, Lcom/android/billingclient/api/zzm;

    invoke-direct {v8, p0, p2}, Lcom/android/billingclient/api/zzm;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingConfigResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object v9

    move-object v4, p0

    invoke-direct/range {v4 .. v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_6f

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v3, 0x19

    invoke-static {v3, v2, p1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, p1, v1}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    :cond_6f
    return-void
.end method

.method public final getConnectionState()I
    .registers 2

    iget v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    return v0
.end method

.method public final isAlternativeBillingOnlyAvailableAsync(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)V
    .registers 12

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/16 v1, 0xe

    if-nez v0, :cond_18

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v2, 0x2

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v1, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v3}, Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;->onAlternativeBillingOnlyAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_18
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzx:Z

    if-nez v0, :cond_34

    const-string v0, "BillingClient"

    const-string v2, "Current client doesn\'t support alternative billing only."

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x42

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzD:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v1, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v3}, Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;->onAlternativeBillingOnlyAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_34
    new-instance v5, Lcom/android/billingclient/api/zzt;

    invoke-direct {v5, p0, p1}, Lcom/android/billingclient/api/zzt;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)V

    const-wide/16 v6, 0x7530

    new-instance v8, Lcom/android/billingclient/api/zzv;

    invoke-direct {v8, p0, p1}, Lcom/android/billingclient/api/zzv;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object v9

    move-object v4, p0

    invoke-direct/range {v4 .. v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object v0

    if-nez v0, :cond_5d

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v3, 0x19

    invoke-static {v3, v1, v0}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v2, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;->onAlternativeBillingOnlyAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V

    :cond_5d
    return-void
.end method

.method public final isFeatureSupported(Ljava/lang/String;)Lcom/android/billingclient/api/BillingResult;
    .registers 15

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/4 v1, 0x2

    const/4 v2, 0x5

    if-nez v0, :cond_24

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-virtual {p1}, Lcom/android/billingclient/api/BillingResult;->getResponseCode()I

    move-result v0

    if-eqz v0, :cond_1a

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-static {v1, v2, p1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    goto :goto_23

    :cond_1a
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-static {v2}, Lcom/android/billingclient/api/zzbh;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzic;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zzb(Lcom/google/android/gms/internal/play_billing/zzic;)V

    :goto_23
    return-object p1

    :cond_24
    sget v0, Lcom/android/billingclient/api/zzbk;->zzF:I

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/16 v3, 0xc

    const/16 v4, 0xb

    const/16 v5, 0x8

    const/4 v6, 0x7

    const/4 v7, 0x6

    const/4 v8, 0x3

    const/4 v9, 0x4

    const/4 v10, 0x1

    const/16 v11, 0xa

    const/16 v12, 0x9

    sparse-switch v0, :sswitch_data_1a2

    goto/16 :goto_c8

    :sswitch_3e
    const-string v0, "subscriptions"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/4 v0, 0x0

    goto/16 :goto_c9

    :sswitch_49
    const-string v0, "priceChangeConfirmation"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/4 v0, 0x2

    goto/16 :goto_c9

    :sswitch_54
    const-string v0, "jjj"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/16 v0, 0xc

    goto/16 :goto_c9

    :sswitch_60
    const-string v0, "iii"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/16 v0, 0xb

    goto :goto_c9

    :sswitch_6b
    const-string v0, "hhh"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/16 v0, 0xa

    goto :goto_c9

    :sswitch_76
    const-string v0, "ggg"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/16 v0, 0x9

    goto :goto_c9

    :sswitch_81
    const-string v0, "fff"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/16 v0, 0x8

    goto :goto_c9

    :sswitch_8c
    const-string v0, "eee"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/4 v0, 0x7

    goto :goto_c9

    :sswitch_96
    const-string v0, "ddd"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/4 v0, 0x5

    goto :goto_c9

    :sswitch_a0
    const-string v0, "ccc"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/4 v0, 0x6

    goto :goto_c9

    :sswitch_aa
    const-string v0, "bbb"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/4 v0, 0x3

    goto :goto_c9

    :sswitch_b4
    const-string v0, "aaa"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/4 v0, 0x4

    goto :goto_c9

    :sswitch_be
    const-string v0, "subscriptionsUpdate"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c8

    const/4 v0, 0x1

    goto :goto_c9

    :cond_c8
    :goto_c8
    const/4 v0, -0x1

    :goto_c9
    packed-switch v0, :pswitch_data_1d8

    const-string v0, "Unsupported feature: "

    invoke-virtual {v0, p1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "BillingClient"

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzy:Lcom/android/billingclient/api/BillingResult;

    const/16 v0, 0x22

    invoke-direct {p0, p1, v0, v10}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_df
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzx:Z

    if-eqz p1, :cond_e6

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_e8

    :cond_e6
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzD:Lcom/android/billingclient/api/BillingResult;

    :goto_e8
    const/16 v0, 0x42

    const/16 v1, 0xe

    invoke-direct {p0, p1, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_f0
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzw:Z

    if-eqz p1, :cond_f7

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_f9

    :cond_f7
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzC:Lcom/android/billingclient/api/BillingResult;

    :goto_f9
    const/16 v0, 0x3c

    const/16 v1, 0xd

    invoke-direct {p0, p1, v0, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_101
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzu:Z

    if-eqz p1, :cond_108

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_10a

    :cond_108
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzA:Lcom/android/billingclient/api/BillingResult;

    :goto_10a
    const/16 v0, 0x21

    invoke-direct {p0, p1, v0, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_110
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzu:Z

    if-eqz p1, :cond_117

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_119

    :cond_117
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzz:Lcom/android/billingclient/api/BillingResult;

    :goto_119
    const/16 v0, 0x20

    invoke-direct {p0, p1, v0, v4}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_11f
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzt:Z

    if-eqz p1, :cond_126

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_128

    :cond_126
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzv:Lcom/android/billingclient/api/BillingResult;

    :goto_128
    const/16 v0, 0x14

    invoke-direct {p0, p1, v0, v11}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_12e
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzs:Z

    if-eqz p1, :cond_135

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_137

    :cond_135
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzt:Lcom/android/billingclient/api/BillingResult;

    :goto_137
    const/16 v0, 0x3d

    invoke-direct {p0, p1, v0, v12}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_13d
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzs:Z

    if-eqz p1, :cond_144

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_146

    :cond_144
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzt:Lcom/android/billingclient/api/BillingResult;

    :goto_146
    const/16 v0, 0x13

    invoke-direct {p0, p1, v0, v5}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_14c
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzq:Z

    if-eqz p1, :cond_153

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_155

    :cond_153
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzu:Lcom/android/billingclient/api/BillingResult;

    :goto_155
    const/16 v0, 0x15

    invoke-direct {p0, p1, v0, v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_15b
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzr:Z

    if-eqz p1, :cond_162

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_164

    :cond_162
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzs:Lcom/android/billingclient/api/BillingResult;

    :goto_164
    const/16 v0, 0x1f

    invoke-direct {p0, p1, v0, v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_16a
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    if-eqz p1, :cond_171

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_173

    :cond_171
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzw:Lcom/android/billingclient/api/BillingResult;

    :goto_173
    const/16 v0, 0x1e

    invoke-direct {p0, p1, v0, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_179
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzm:Z

    if-eqz p1, :cond_180

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_182

    :cond_180
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzr:Lcom/android/billingclient/api/BillingResult;

    :goto_182
    const/16 v0, 0x23

    invoke-direct {p0, p1, v0, v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_188
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzj:Z

    if-eqz p1, :cond_18f

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_191

    :cond_18f
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzp:Lcom/android/billingclient/api/BillingResult;

    :goto_191
    invoke-direct {p0, p1, v11, v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :pswitch_195
    iget-boolean p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Z

    if-eqz p1, :cond_19c

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    goto :goto_19e

    :cond_19c
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzo:Lcom/android/billingclient/api/BillingResult;

    :goto_19e
    invoke-direct {p0, p1, v12, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzaf(Lcom/android/billingclient/api/BillingResult;II)V

    return-object p1

    :sswitch_data_1a2
    .sparse-switch
        -0x1928a0a1 -> :sswitch_be
        0x17841 -> :sswitch_b4
        0x17c22 -> :sswitch_aa
        0x18003 -> :sswitch_a0
        0x183e4 -> :sswitch_96
        0x187c5 -> :sswitch_8c
        0x18ba6 -> :sswitch_81
        0x18f87 -> :sswitch_76
        0x19368 -> :sswitch_6b
        0x19749 -> :sswitch_60
        0x19b2a -> :sswitch_54
        0xc5ff92e -> :sswitch_49
        0x7674caf6 -> :sswitch_3e
    .end sparse-switch

    :pswitch_data_1d8
    .packed-switch 0x0
        :pswitch_195
        :pswitch_188
        :pswitch_179
        :pswitch_16a
        :pswitch_15b
        :pswitch_14c
        :pswitch_13d
        :pswitch_12e
        :pswitch_11f
        :pswitch_110
        :pswitch_101
        :pswitch_f0
        :pswitch_df
    .end packed-switch
.end method

.method public final isReady()Z
    .registers 3

    iget v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_f

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    if-eqz v0, :cond_f

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    if-eqz v0, :cond_f

    const/4 v0, 0x1

    return v0

    :cond_f
    const/4 v0, 0x0

    return v0
.end method

.method public final launchBillingFlow(Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)Lcom/android/billingclient/api/BillingResult;
    .registers 34

    move-object/from16 v8, p0

    move-object/from16 v0, p1

    const-string v1, "proxyPackageVersion"

    const-string v9, "BUY_INTENT"

    iget-object v2, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    const/4 v10, 0x2

    if-eqz v2, :cond_504

    iget-object v2, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    invoke-virtual {v2}, Lcom/android/billingclient/api/zzh;->zzd()Lcom/android/billingclient/api/PurchasesUpdatedListener;

    move-result-object v2

    if-eqz v2, :cond_504

    invoke-virtual/range {p0 .. p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v2

    if-nez v2, :cond_2a

    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v10, v10, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    :goto_23
    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {v8, v1}, Lcom/android/billingclient/api/BillingClientImpl;->zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v1

    :cond_2a
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzg()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzh()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v2, v4}, Lcom/google/android/gms/internal/play_billing/zzak;->zza(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/android/billingclient/api/SkuDetails;

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/play_billing/zzak;->zza(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    if-eqz v5, :cond_4a

    invoke-virtual {v5}, Lcom/android/billingclient/api/SkuDetails;->getSku()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5}, Lcom/android/billingclient/api/SkuDetails;->getType()Ljava/lang/String;

    move-result-object v11

    goto :goto_5a

    :cond_4a
    invoke-virtual {v6}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v7

    invoke-virtual {v7}, Lcom/android/billingclient/api/ProductDetails;->getProductId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v11

    invoke-virtual {v11}, Lcom/android/billingclient/api/ProductDetails;->getProductType()Ljava/lang/String;

    move-result-object v11

    :goto_5a
    const-string v12, "subs"

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    const/16 v13, 0x9

    const-string v14, "BillingClient"

    if-eqz v12, :cond_79

    iget-boolean v12, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzi:Z

    if-eqz v12, :cond_6b

    goto :goto_79

    :cond_6b
    const-string v0, "Current client doesn\'t support subscriptions."

    invoke-static {v14, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzo:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v13, v10, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    goto :goto_23

    :cond_79
    :goto_79
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzq()Z

    move-result v12

    if-eqz v12, :cond_9a

    iget-boolean v12, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzl:Z

    if-eqz v12, :cond_84

    goto :goto_9a

    :cond_84
    const-string v0, "Current client doesn\'t support extra params for buy intent."

    invoke-static {v14, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x12

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzh:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v1, v10, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {v8, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v2

    :cond_9a
    :goto_9a
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v12

    const/4 v15, 0x1

    if-le v12, v15, :cond_bc

    iget-boolean v12, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzs:Z

    if-eqz v12, :cond_a6

    goto :goto_bc

    :cond_a6
    const-string v0, "Current client doesn\'t support multi-item purchases."

    invoke-static {v14, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x13

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzt:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v1, v10, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {v8, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v2

    :cond_bc
    :goto_bc
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v12

    if-nez v12, :cond_dd

    iget-boolean v12, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzt:Z

    if-eqz v12, :cond_c7

    goto :goto_dd

    :cond_c7
    const-string v0, "Current client doesn\'t support purchases with ProductDetails."

    invoke-static {v14, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x14

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzv:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v1, v10, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {v8, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v2

    :cond_dd
    :goto_dd
    iget-boolean v12, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzl:Z

    if-eqz v12, :cond_44f

    iget-boolean v12, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    iget-boolean v13, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzz:Z

    iget-object v10, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    const-string v15, "playBillingLibraryVersion"

    invoke-virtual {v4, v15, v10}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzb()I

    move-result v10

    const-string v15, "prorationMode"

    if-eqz v10, :cond_101

    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzb()I

    move-result v10

    :goto_fd
    invoke-virtual {v4, v15, v10}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    goto :goto_10c

    :cond_101
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zza()I

    move-result v10

    if-eqz v10, :cond_10c

    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zza()I

    move-result v10

    goto :goto_fd

    :cond_10c
    :goto_10c
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzc()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_11f

    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzc()Ljava/lang/String;

    move-result-object v10

    const-string v15, "accountId"

    invoke-virtual {v4, v15, v10}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_11f
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzd()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_132

    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzd()Ljava/lang/String;

    move-result-object v10

    const-string v15, "obfuscatedProfileId"

    invoke-virtual {v4, v15, v10}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_132
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzp()Z

    move-result v10

    if-eqz v10, :cond_13e

    const-string v10, "isOfferPersonalizedByDeveloper"

    const/4 v15, 0x1

    invoke-virtual {v4, v10, v15}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    :cond_13e
    const/4 v10, 0x0

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-nez v15, :cond_157

    new-instance v15, Ljava/util/ArrayList;

    filled-new-array {v10}, [Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v10

    invoke-direct {v15, v10}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    const-string v10, "skusToReplace"

    invoke-virtual {v4, v10, v15}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_157
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zze()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_16a

    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zze()Ljava/lang/String;

    move-result-object v10

    const-string v15, "oldSkuPurchaseToken"

    invoke-virtual {v4, v15, v10}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_16a
    const/4 v10, 0x0

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-nez v15, :cond_176

    const-string v15, "oldSkuPurchaseId"

    invoke-virtual {v4, v15, v10}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_176
    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzf()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-nez v15, :cond_18a

    invoke-virtual/range {p2 .. p2}, Lcom/android/billingclient/api/BillingFlowParams;->zzf()Ljava/lang/String;

    move-result-object v15

    const-string v10, "originalExternalTransactionId"

    invoke-virtual {v4, v10, v15}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v10, 0x0

    :cond_18a
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-nez v15, :cond_195

    const-string v15, "paymentsPurchaseParams"

    invoke-virtual {v4, v15, v10}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_195
    if-eqz v12, :cond_19e

    const-string v10, "enablePendingPurchases"

    const/4 v12, 0x1

    invoke-virtual {v4, v10, v12}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_19f

    :cond_19e
    const/4 v12, 0x1

    :goto_19f
    if-eqz v13, :cond_1a6

    const-string v10, "enableAlternativeBilling"

    invoke-virtual {v4, v10, v12}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    :cond_1a6
    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v10

    const-string v12, "additionalSkuTypes"

    const-string v13, "additionalSkus"

    const-string v15, "SKU_SERIALIZED_DOCID_LIST"

    move-object/from16 v17, v9

    const-string v9, "skuDetailsTokens"

    const-string v0, "SKU_OFFER_ID_TOKEN_LIST"

    move-object/from16 v18, v11

    if-nez v10, :cond_2c1

    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v19, v7

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v20, v1

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v21, v14

    new-instance v14, Ljava/util/ArrayList;

    invoke-direct {v14}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    const/16 v23, 0x0

    const/16 v24, 0x0

    const/16 v25, 0x0

    const/16 v26, 0x0

    :goto_1e5
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v27

    if-eqz v27, :cond_252

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Lcom/android/billingclient/api/SkuDetails;

    invoke-virtual/range {v27 .. v27}, Lcom/android/billingclient/api/SkuDetails;->zzf()Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/String;->isEmpty()Z

    move-result v28

    if-nez v28, :cond_205

    move-object/from16 v28, v6

    invoke-virtual/range {v27 .. v27}, Lcom/android/billingclient/api/SkuDetails;->zzf()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v10, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_207

    :cond_205
    move-object/from16 v28, v6

    :goto_207
    invoke-virtual/range {v27 .. v27}, Lcom/android/billingclient/api/SkuDetails;->zzc()Ljava/lang/String;

    move-result-object v6

    move-object/from16 v29, v5

    invoke-virtual/range {v27 .. v27}, Lcom/android/billingclient/api/SkuDetails;->zzb()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {v27 .. v27}, Lcom/android/billingclient/api/SkuDetails;->zza()I

    move-result v30

    invoke-virtual/range {v27 .. v27}, Lcom/android/billingclient/api/SkuDetails;->zze()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v11, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    const/16 v16, 0x1

    xor-int/lit8 v6, v6, 0x1

    or-int v23, v23, v6

    invoke-virtual {v7, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    xor-int/lit8 v5, v5, 0x1

    or-int v24, v24, v5

    invoke-static/range {v30 .. v30}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    if-eqz v30, :cond_23d

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_23e

    :cond_23d
    const/4 v5, 0x0

    :goto_23e
    or-int v25, v25, v5

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    xor-int/lit8 v5, v5, 0x1

    or-int v26, v26, v5

    invoke-virtual {v14, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move-object/from16 v8, p0

    move-object/from16 v6, v28

    move-object/from16 v5, v29

    goto :goto_1e5

    :cond_252
    move-object/from16 v29, v5

    move-object/from16 v28, v6

    invoke-virtual {v10}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_25f

    invoke-virtual {v4, v9, v10}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_25f
    if-eqz v23, :cond_264

    invoke-virtual {v4, v0, v11}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_264
    if-eqz v24, :cond_26b

    const-string v5, "SKU_OFFER_ID_LIST"

    invoke-virtual {v4, v5, v7}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_26b
    if-eqz v25, :cond_272

    const-string v5, "SKU_OFFER_TYPE_LIST"

    invoke-virtual {v4, v5, v1}, Landroid/os/Bundle;->putIntegerArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_272
    if-eqz v26, :cond_277

    invoke-virtual {v4, v15, v14}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_277
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v1

    const/4 v5, 0x1

    const/4 v5, 0x1

    if-le v1, v5, :cond_376

    new-instance v1, Ljava/util/ArrayList;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-direct {v1, v6}, Ljava/util/ArrayList;-><init>(I)V

    new-instance v6, Ljava/util/ArrayList;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    invoke-direct {v6, v7}, Ljava/util/ArrayList;-><init>(I)V

    const/4 v15, 0x1

    :goto_296
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v7

    if-ge v15, v7, :cond_2b9

    invoke-interface {v2, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/billingclient/api/SkuDetails;

    invoke-virtual {v7}, Lcom/android/billingclient/api/SkuDetails;->getSku()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-interface {v2, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/billingclient/api/SkuDetails;

    invoke-virtual {v7}, Lcom/android/billingclient/api/SkuDetails;->getType()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v15, v15, 0x1

    goto :goto_296

    :cond_2b9
    invoke-virtual {v4, v13, v1}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    invoke-virtual {v4, v12, v6}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_376

    :cond_2c1
    move-object/from16 v20, v1

    move-object/from16 v29, v5

    move-object/from16 v28, v6

    move-object/from16 v19, v7

    move-object/from16 v21, v14

    const/4 v5, 0x1

    const/4 v5, 0x1

    new-instance v1, Ljava/util/ArrayList;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-direct {v2, v6}, Ljava/util/ArrayList;-><init>(I)V

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    const/4 v10, 0x0

    :goto_2f3
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v11

    if-ge v10, v11, :cond_355

    invoke-interface {v3, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    invoke-virtual {v11}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v14

    invoke-virtual {v14}, Lcom/android/billingclient/api/ProductDetails;->zzb()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->isEmpty()Z

    move-result v16

    if-nez v16, :cond_314

    invoke-virtual {v14}, Lcom/android/billingclient/api/ProductDetails;->zzb()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_314
    invoke-virtual {v11}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zzb()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v7, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-virtual {v14}, Lcom/android/billingclient/api/ProductDetails;->zzc()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_32c

    invoke-virtual {v14}, Lcom/android/billingclient/api/ProductDetails;->zzc()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v8, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_32c
    if-lez v10, :cond_350

    invoke-interface {v3, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v5

    invoke-virtual {v5}, Lcom/android/billingclient/api/ProductDetails;->getProductId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-interface {v3, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;

    invoke-virtual {v5}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v5

    invoke-virtual {v5}, Lcom/android/billingclient/api/ProductDetails;->getProductType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_350
    add-int/lit8 v10, v10, 0x1

    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_2f3

    :cond_355
    invoke-virtual {v4, v0, v7}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_361

    invoke-virtual {v4, v9, v6}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_361
    invoke-virtual {v8}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_36a

    invoke-virtual {v4, v15, v8}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_36a
    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_376

    invoke-virtual {v4, v13, v1}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    invoke-virtual {v4, v12, v2}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_376
    :goto_376
    invoke-virtual {v4, v0}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    move-object/from16 v8, p0

    if-eqz v0, :cond_395

    iget-boolean v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzq:Z

    if-eqz v0, :cond_383

    goto :goto_395

    :cond_383
    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x15

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzu:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    invoke-static {v1, v3, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {v8, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v2

    :cond_395
    :goto_395
    const-string v0, "skuPackageName"

    if-eqz v29, :cond_3ad

    invoke-virtual/range {v29 .. v29}, Lcom/android/billingclient/api/SkuDetails;->zzd()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3ad

    invoke-virtual/range {v29 .. v29}, Lcom/android/billingclient/api/SkuDetails;->zzd()Ljava/lang/String;

    move-result-object v1

    :goto_3a7
    invoke-virtual {v4, v0, v1}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v15, 0x1

    goto :goto_3c8

    :cond_3ad
    if-eqz v28, :cond_3c6

    invoke-virtual/range {v28 .. v28}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/android/billingclient/api/ProductDetails;->zza()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3c6

    invoke-virtual/range {v28 .. v28}, Lcom/android/billingclient/api/BillingFlowParams$ProductDetailsParams;->zza()Lcom/android/billingclient/api/ProductDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/android/billingclient/api/ProductDetails;->zza()Ljava/lang/String;

    move-result-object v1

    goto :goto_3a7

    :cond_3c6
    const/4 v0, 0x0

    const/4 v15, 0x0

    :goto_3c8
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3d3

    const-string v1, "accountName"

    invoke-virtual {v4, v1, v0}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_3d3
    invoke-virtual/range {p1 .. p1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-nez v0, :cond_3e1

    const-string v0, "Activity\'s intent is null."

    move-object/from16 v9, v21

    invoke-static {v9, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_412

    :cond_3e1
    move-object/from16 v9, v21

    const-string v1, "PROXY_PACKAGE"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_412

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "proxyPackage"

    invoke-virtual {v4, v1, v0}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_3f8
    iget-object v1, v8, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_405
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3f8 .. :try_end_405} :catch_40b

    move-object/from16 v1, v20

    :try_start_407
    invoke-virtual {v4, v1, v0}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_40a
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_407 .. :try_end_40a} :catch_40d

    goto :goto_412

    :catch_40b
    move-object/from16 v1, v20

    :catch_40d
    const-string v0, "package not found"

    invoke-virtual {v4, v1, v0}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_412
    :goto_412
    iget-boolean v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzt:Z

    if-eqz v0, :cond_421

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_421

    const/16 v0, 0x11

    const/16 v3, 0x11

    goto :goto_435

    :cond_421
    iget-boolean v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzr:Z

    if-eqz v0, :cond_42c

    if-eqz v15, :cond_42c

    const/16 v0, 0xf

    const/16 v3, 0xf

    goto :goto_435

    :cond_42c
    iget-boolean v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    if-eqz v0, :cond_433

    const/16 v3, 0x9

    goto :goto_435

    :cond_433
    const/4 v0, 0x6

    const/4 v3, 0x6

    :goto_435
    const/16 v0, 0x4e

    new-instance v10, Lcom/android/billingclient/api/zzab;

    move-object v1, v10

    move-object/from16 v2, p0

    move-object v7, v4

    move-object/from16 v4, v19

    move-object/from16 v5, v18

    move-object/from16 v6, p2

    invoke-direct/range {v1 .. v7}, Lcom/android/billingclient/api/zzab;-><init>(Lcom/android/billingclient/api/BillingClientImpl;ILjava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/BillingFlowParams;Landroid/os/Bundle;)V

    const-wide/16 v3, 0x1388

    const/4 v5, 0x0

    iget-object v6, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    move-object/from16 v1, p0

    move-object v2, v10

    goto :goto_464

    :cond_44f
    move-object/from16 v19, v7

    move-object/from16 v17, v9

    move-object/from16 v18, v11

    move-object v9, v14

    const/16 v0, 0x50

    new-instance v2, Lcom/android/billingclient/api/zzac;

    invoke-direct {v2, v8, v7, v11}, Lcom/android/billingclient/api/zzac;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;Ljava/lang/String;)V

    const-wide/16 v3, 0x1388

    const/4 v5, 0x0

    iget-object v6, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    move-object/from16 v1, p0

    :goto_464
    invoke-direct/range {v1 .. v6}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object v1

    if-nez v1, :cond_47c

    :try_start_46a
    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0x19

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    invoke-static {v1, v3, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {v8, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v2

    :cond_47c
    const-wide/16 v2, 0x1388

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v2, v3, v4}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    invoke-static {v1, v9}, Lcom/google/android/gms/internal/play_billing/zzb;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v2

    invoke-static {v1, v9}, Lcom/google/android/gms/internal/play_billing/zzb;->zzg(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-eqz v2, :cond_4ba

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unable to buy item, Error response code: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v9, v4}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2, v3}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    iget-object v3, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    if-eqz v1, :cond_4ae

    const/16 v0, 0x17

    :cond_4ae
    const/4 v1, 0x2

    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {v3, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {v8, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v2

    :cond_4ba
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/android/billingclient/api/ProxyBillingActivity;

    move-object/from16 v3, p1

    invoke-direct {v0, v3, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v2, v17

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/app/PendingIntent;

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    invoke-virtual {v3, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_4d1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_46a .. :try_end_4d1} :catch_4ed
    .catch Ljava/util/concurrent/CancellationException; {:try_start_46a .. :try_end_4d1} :catch_4eb
    .catch Ljava/lang/Exception; {:try_start_46a .. :try_end_4d1} :catch_4d4

    sget-object v0, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    return-object v0

    :catch_4d4
    move-exception v0

    const-string v1, "Exception while launching billing flow. Try to reconnect"

    invoke-static {v9, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v1, 0x5

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    invoke-static {v1, v3, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {v8, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v2

    :catch_4eb
    move-exception v0

    goto :goto_4ee

    :catch_4ed
    move-exception v0

    :goto_4ee
    const-string v1, "Time out while launching billing flow. Try to reconnect"

    invoke-static {v9, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v1, 0x4

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/4 v3, 0x2

    invoke-static {v1, v3, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-direct {v8, v2}, Lcom/android/billingclient/api/BillingClientImpl;->zzZ(Lcom/android/billingclient/api/BillingResult;)Lcom/android/billingclient/api/BillingResult;

    return-object v2

    :cond_504
    const/4 v3, 0x2

    iget-object v0, v8, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v1, 0xc

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzE:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v1, v3, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    return-object v2
.end method

.method public final queryProductDetailsAsync(Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V
    .registers 12

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/4 v1, 0x7

    if-nez v0, :cond_1c

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v0, 0x2

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p2, v2, p1}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_1c
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzt:Z

    if-nez v0, :cond_3d

    const-string p1, "BillingClient"

    const-string v0, "Querying product details is not supported."

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v0, 0x14

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzv:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p2, v2, p1}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_3d
    new-instance v4, Lcom/android/billingclient/api/zzu;

    invoke-direct {v4, p0, p1, p2}, Lcom/android/billingclient/api/zzu;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V

    const-wide/16 v5, 0x7530

    new-instance v7, Lcom/android/billingclient/api/zzz;

    invoke-direct {v7, p0, p2}, Lcom/android/billingclient/api/zzz;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/ProductDetailsResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object v8

    move-object v3, p0

    invoke-direct/range {v3 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_6b

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x19

    invoke-static {v2, v1, p1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p2, p1, v0}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    :cond_6b
    return-void
.end method

.method public final queryPurchaseHistoryAsync(Lcom/android/billingclient/api/QueryPurchaseHistoryParams;Lcom/android/billingclient/api/PurchaseHistoryResponseListener;)V
    .registers 3

    invoke-virtual {p1}, Lcom/android/billingclient/api/QueryPurchaseHistoryParams;->zza()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzad(Ljava/lang/String;Lcom/android/billingclient/api/PurchaseHistoryResponseListener;)V

    return-void
.end method

.method public final queryPurchaseHistoryAsync(Ljava/lang/String;Lcom/android/billingclient/api/PurchaseHistoryResponseListener;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzad(Ljava/lang/String;Lcom/android/billingclient/api/PurchaseHistoryResponseListener;)V

    return-void
.end method

.method public final queryPurchasesAsync(Lcom/android/billingclient/api/QueryPurchasesParams;Lcom/android/billingclient/api/PurchasesResponseListener;)V
    .registers 3

    invoke-virtual {p1}, Lcom/android/billingclient/api/QueryPurchasesParams;->zza()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzae(Ljava/lang/String;Lcom/android/billingclient/api/PurchasesResponseListener;)V

    return-void
.end method

.method public final queryPurchasesAsync(Ljava/lang/String;Lcom/android/billingclient/api/PurchasesResponseListener;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Lcom/android/billingclient/api/BillingClientImpl;->zzae(Ljava/lang/String;Lcom/android/billingclient/api/PurchasesResponseListener;)V

    return-void
.end method

.method public final querySkuDetailsAsync(Lcom/android/billingclient/api/SkuDetailsParams;Lcom/android/billingclient/api/SkuDetailsResponseListener;)V
    .registers 13

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/4 v1, 0x0

    const/16 v2, 0x8

    if-nez v0, :cond_19

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 v0, 0x2

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v2, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v3, v1}, Lcom/android/billingclient/api/SkuDetailsResponseListener;->onSkuDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_19
    invoke-virtual {p1}, Lcom/android/billingclient/api/SkuDetailsParams;->getSkuType()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Lcom/android/billingclient/api/SkuDetailsParams;->getSkusList()Ljava/util/List;

    move-result-object v7

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    const-string v0, "BillingClient"

    if-eqz p1, :cond_3f

    const-string p1, "Please fix the input params. SKU type can\'t be empty."

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v0, 0x31

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzf:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v2, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v3, v1}, Lcom/android/billingclient/api/SkuDetailsResponseListener;->onSkuDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_3f
    if-nez v7, :cond_57

    const-string p1, "Please fix the input params. The list of SKUs can\'t be empty."

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v0, 0x30

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zze:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v2, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v3, v1}, Lcom/android/billingclient/api/SkuDetailsResponseListener;->onSkuDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_57
    new-instance p1, Lcom/android/billingclient/api/zzq;

    const/4 v8, 0x0

    move-object v4, p1

    move-object v5, p0

    move-object v9, p2

    invoke-direct/range {v4 .. v9}, Lcom/android/billingclient/api/zzq;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/android/billingclient/api/SkuDetailsResponseListener;)V

    const-wide/16 v6, 0x7530

    new-instance v8, Lcom/android/billingclient/api/zzr;

    invoke-direct {v8, p0, p2}, Lcom/android/billingclient/api/zzr;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/SkuDetailsResponseListener;)V

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzY()Landroid/os/Handler;

    move-result-object v9

    move-object v4, p0

    move-object v5, p1

    invoke-direct/range {v4 .. v9}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_85

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v3, 0x19

    invoke-static {v3, v2, p1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, p1, v1}, Lcom/android/billingclient/api/SkuDetailsResponseListener;->onSkuDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    :cond_85
    return-void
.end method

.method public final showAlternativeBillingOnlyInformationDialog(Landroid/app/Activity;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)Lcom/android/billingclient/api/BillingResult;
    .registers 12

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/16 v1, 0x10

    if-nez v0, :cond_15

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/4 p2, 0x2

    sget-object v0, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    :goto_d
    invoke-static {p2, v1, v0}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object p2

    invoke-interface {p1, p2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    return-object v0

    :cond_15
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzx:Z

    if-nez v0, :cond_27

    const-string p1, "BillingClient"

    const-string p2, "Current Play Store version doesn\'t support alternative billing only."

    invoke-static {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 p2, 0x42

    sget-object v0, Lcom/android/billingclient/api/zzbk;->zzD:Lcom/android/billingclient/api/BillingResult;

    goto :goto_d

    :cond_27
    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    new-instance v2, Lcom/android/billingclient/api/zzak;

    invoke-direct {v2, p0, v0, p2}, Lcom/android/billingclient/api/zzak;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Handler;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)V

    new-instance v4, Lcom/android/billingclient/api/zzad;

    invoke-direct {v4, p0, p1, v2, p2}, Lcom/android/billingclient/api/zzad;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/app/Activity;Landroid/os/ResultReceiver;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)V

    const-wide/16 v5, 0x7530

    new-instance v7, Lcom/android/billingclient/api/zzae;

    invoke-direct {v7, p0, p2}, Lcom/android/billingclient/api/zzae;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)V

    iget-object v8, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    move-object v3, p0

    invoke-direct/range {v3 .. v8}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    move-result-object p1

    if-nez p1, :cond_53

    invoke-direct {p0}, Lcom/android/billingclient/api/BillingClientImpl;->zzaa()Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    iget-object p2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v0, 0x19

    invoke-static {v0, v1, p1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    return-object p1

    :cond_53
    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    return-object p1
.end method

.method public final showInAppMessages(Landroid/app/Activity;Lcom/android/billingclient/api/InAppMessageParams;Lcom/android/billingclient/api/InAppMessageResponseListener;)Lcom/android/billingclient/api/BillingResult;
    .registers 12

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const-string v1, "BillingClient"

    if-nez v0, :cond_10

    const-string p1, "Service disconnected."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    return-object p1

    :cond_10
    iget-boolean v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzp:Z

    if-nez v0, :cond_1c

    const-string p1, "Current client doesn\'t support showing in-app messages."

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzw:Lcom/android/billingclient/api/BillingResult;

    return-object p1

    :cond_1c
    const v0, 0x1020002

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    invoke-virtual {v0, v2}, Landroid/view/View;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v3, "KEY_WINDOW_TOKEN"

    invoke-static {v0, v3, v1}, Landroidx/core/app/m;->a(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/IBinder;)V

    iget v1, v2, Landroid/graphics/Rect;->left:I

    const-string v3, "KEY_DIMEN_LEFT"

    invoke-virtual {v0, v3, v1}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    iget v1, v2, Landroid/graphics/Rect;->top:I

    const-string v3, "KEY_DIMEN_TOP"

    invoke-virtual {v0, v3, v1}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    iget v1, v2, Landroid/graphics/Rect;->right:I

    const-string v3, "KEY_DIMEN_RIGHT"

    invoke-virtual {v0, v3, v1}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    iget v1, v2, Landroid/graphics/Rect;->bottom:I

    const-string v2, "KEY_DIMEN_BOTTOM"

    invoke-virtual {v0, v2, v1}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    const-string v2, "playBillingLibraryVersion"

    invoke-virtual {v0, v2, v1}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p2}, Lcom/android/billingclient/api/InAppMessageParams;->zza()Ljava/util/ArrayList;

    move-result-object p2

    const-string v1, "KEY_CATEGORY_IDS"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putIntegerArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    iget-object p2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    new-instance v1, Lcom/android/billingclient/api/zzaj;

    invoke-direct {v1, p0, p2, p3}, Lcom/android/billingclient/api/zzaj;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Handler;Lcom/android/billingclient/api/InAppMessageResponseListener;)V

    new-instance v3, Lcom/android/billingclient/api/zzaa;

    invoke-direct {v3, p0, v0, p1, v1}, Lcom/android/billingclient/api/zzaa;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Landroid/os/Bundle;Landroid/app/Activity;Landroid/os/ResultReceiver;)V

    const-wide/16 v4, 0x1388

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzc:Landroid/os/Handler;

    move-object v2, p0

    invoke-direct/range {v2 .. v7}, Lcom/android/billingclient/api/BillingClientImpl;->zzac(Ljava/util/concurrent/Callable;JLjava/lang/Runnable;Landroid/os/Handler;)Ljava/util/concurrent/Future;

    sget-object p1, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    return-object p1
.end method

.method public final startConnection(Lcom/android/billingclient/api/BillingClientStateListener;)V
    .registers 11

    invoke-virtual {p0}, Lcom/android/billingclient/api/BillingClientImpl;->isReady()Z

    move-result v0

    const/4 v1, 0x6

    const-string v2, "BillingClient"

    if-eqz v0, :cond_1d

    const-string v0, "Service connection is valid. No need to re-initialize."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-static {v1}, Lcom/android/billingclient/api/zzbh;->zzb(I)Lcom/google/android/gms/internal/play_billing/zzic;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zzb(Lcom/google/android/gms/internal/play_billing/zzic;)V

    sget-object v0, Lcom/android/billingclient/api/zzbk;->zzl:Lcom/android/billingclient/api/BillingResult;

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_1d
    iget v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const/4 v3, 0x1

    if-ne v0, v3, :cond_38

    const-string v0, "Client is already in the process of connecting to billing service."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x25

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzd:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v1, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v3}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_38
    iget v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const/4 v4, 0x3

    if-ne v0, v4, :cond_53

    const-string v0, "Client was already closed and can\'t be reused. Please create another instance."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x26

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v1, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v3}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    return-void

    :cond_53
    iput v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const-string v0, "Starting in-app billing setup."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/android/billingclient/api/zzao;

    const/4 v4, 0x0

    invoke-direct {v0, p0, p1, v4}, Lcom/android/billingclient/api/zzao;-><init>(Lcom/android/billingclient/api/BillingClientImpl;Lcom/android/billingclient/api/BillingClientStateListener;Lcom/android/billingclient/api/zzan;)V

    iput-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    new-instance v0, Landroid/content/Intent;

    const-string v4, "com.android.vending.billing.InAppBillingService.BIND"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v4, "com.android.vending"

    invoke-virtual {v0, v4}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v0, v6}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v5

    const/16 v7, 0x29

    if-eqz v5, :cond_cd

    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_cd

    invoke-interface {v5, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ResolveInfo;

    iget-object v5, v5, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    if-eqz v5, :cond_cf

    iget-object v7, v5, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    iget-object v5, v5, Landroid/content/pm/ServiceInfo;->name:Ljava/lang/String;

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_c5

    if-eqz v5, :cond_c5

    new-instance v4, Landroid/content/ComponentName;

    invoke-direct {v4, v7, v5}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v5, Landroid/content/Intent;

    invoke-direct {v5, v0}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    invoke-virtual {v5, v4}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    const-string v4, "playBillingLibraryVersion"

    invoke-virtual {v5, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzh:Lcom/android/billingclient/api/zzao;

    invoke-virtual {v0, v5, v4, v3}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    if-eqz v0, :cond_bd

    const-string p1, "Service was bonded successfully."

    invoke-static {v2, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    :cond_bd
    const-string v0, "Connection to Billing service is blocked."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v3, 0x27

    goto :goto_cf

    :cond_c5
    const-string v0, "The device doesn\'t have valid Play Store."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v3, 0x28

    goto :goto_cf

    :cond_cd
    const/16 v3, 0x29

    :cond_cf
    :goto_cf
    iput v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zza:I

    const-string v0, "Billing service unavailable on device."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzc:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v3, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v2}, Lcom/android/billingclient/api/BillingClientStateListener;->onBillingSetupFinished(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method final synthetic zzM(Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V
    .registers 6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/4 v3, 0x3

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v1}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method final synthetic zzN(Lcom/android/billingclient/api/BillingResult;)V
    .registers 4

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    invoke-virtual {v0}, Lcom/android/billingclient/api/zzh;->zzd()Lcom/android/billingclient/api/PurchasesUpdatedListener;

    move-result-object v0

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    invoke-virtual {v0}, Lcom/android/billingclient/api/zzh;->zzd()Lcom/android/billingclient/api/PurchasesUpdatedListener;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Lcom/android/billingclient/api/PurchasesUpdatedListener;->onPurchasesUpdated(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void

    :cond_13
    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzd:Lcom/android/billingclient/api/zzh;

    invoke-virtual {p1}, Lcom/android/billingclient/api/zzh;->zzc()Lcom/android/billingclient/api/zzbq;

    const-string p1, "BillingClient"

    const-string v0, "No valid listener is set in BroadcastManager"

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method final synthetic zzO(Lcom/android/billingclient/api/ConsumeResponseListener;Lcom/android/billingclient/api/ConsumeParams;)V
    .registers 7

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/4 v3, 0x4

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-virtual {p2}, Lcom/android/billingclient/api/ConsumeParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p2

    invoke-interface {p1, v1, p2}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    return-void
.end method

.method final synthetic zzP(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)V
    .registers 6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/16 v3, 0xf

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    const/4 v0, 0x0

    invoke-interface {p1, v1, v0}, Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;->onAlternativeBillingOnlyTokenResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V

    return-void
.end method

.method final synthetic zzQ(Lcom/android/billingclient/api/BillingConfigResponseListener;)V
    .registers 6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/16 v3, 0xd

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    const/4 v0, 0x0

    invoke-interface {p1, v1, v0}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    return-void
.end method

.method final synthetic zzR(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)V
    .registers 6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/16 v3, 0xe

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v1}, Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;->onAlternativeBillingOnlyAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method final synthetic zzS(Lcom/android/billingclient/api/ProductDetailsResponseListener;)V
    .registers 6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/4 v3, 0x7

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p1, v1, v0}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method

.method final synthetic zzT(Lcom/android/billingclient/api/PurchaseHistoryResponseListener;)V
    .registers 6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/16 v3, 0xb

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    const/4 v0, 0x0

    invoke-interface {p1, v1, v0}, Lcom/android/billingclient/api/PurchaseHistoryResponseListener;->onPurchaseHistoryResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method

.method final synthetic zzU(Lcom/android/billingclient/api/PurchasesResponseListener;)V
    .registers 6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/16 v3, 0x9

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzk()Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Lcom/android/billingclient/api/PurchasesResponseListener;->onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method

.method final synthetic zzV(Lcom/android/billingclient/api/SkuDetailsResponseListener;)V
    .registers 6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/16 v3, 0x8

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    const/4 v0, 0x0

    invoke-interface {p1, v1, v0}, Lcom/android/billingclient/api/SkuDetailsResponseListener;->onSkuDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method

.method final synthetic zzW(Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)V
    .registers 6

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v1, Lcom/android/billingclient/api/zzbk;->zzn:Lcom/android/billingclient/api/BillingResult;

    const/16 v2, 0x18

    const/16 v3, 0x10

    invoke-static {v2, v3, v1}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v1}, Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;->onAlternativeBillingOnlyInformationDialogResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-void
.end method

.method final synthetic zzc(ILjava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/BillingFlowParams;Landroid/os/Bundle;)Landroid/os/Bundle;
    .registers 13

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object p4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {p4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v5, 0x0

    move v1, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, p5

    invoke-interface/range {v0 .. v6}, Lcom/google/android/gms/internal/play_billing/zzm;->zzg(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object p1

    return-object p1
.end method

.method final synthetic zzd(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .registers 9

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v1, 0x3

    const/4 v5, 0x0

    move-object v3, p1

    move-object v4, p2

    invoke-interface/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzm;->zzf(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object p1

    return-object p1
.end method

.method final synthetic zzk(Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)Ljava/lang/Object;
    .registers 10

    const-string v0, "BillingClient"

    const/4 v1, 0x0

    :try_start_3
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/android/billingclient/api/AcknowledgePurchaseParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p1

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    const-string v6, "playBillingLibraryVersion"

    invoke-virtual {v5, v6, v4}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v4, 0x9

    invoke-interface {v2, v4, v3, p1, v5}, Lcom/google/android/gms/internal/play_billing/zzm;->zzd(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object p1
    :try_end_21
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_21} :catch_31

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v2

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzg(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v2, p1}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object p1

    invoke-interface {p2, p1}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-object v1

    :catch_31
    move-exception p1

    const-string v2, "Error acknowledge purchase!"

    invoke-static {v0, v2, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v0, 0x1c

    const/4 v2, 0x3

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v0, v2, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v3}, Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;->onAcknowledgePurchaseResponse(Lcom/android/billingclient/api/BillingResult;)V

    return-object v1
.end method

.method final synthetic zzl(Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)Ljava/lang/Object;
    .registers 10

    const-string v0, "BillingClient"

    invoke-virtual {p1}, Lcom/android/billingclient/api/ConsumeParams;->getPurchaseToken()Ljava/lang/String;

    move-result-object p1

    const/4 v1, 0x4

    :try_start_7
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Consuming purchase with token: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    iget-boolean v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    if-eqz v2, :cond_48

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    iget-boolean v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzn:Z

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    if-eqz v4, :cond_37

    const-string v4, "playBillingLibraryVersion"

    invoke-virtual {v6, v4, v5}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_37
    const/16 v4, 0x9

    invoke-interface {v2, v4, v3, p1, v6}, Lcom/google/android/gms/internal/play_billing/zzm;->zze(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "RESPONSE_CODE"

    invoke-virtual {v2, v3}, Landroid/os/BaseBundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzg(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    goto :goto_57

    :cond_48
    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    const/4 v3, 0x3

    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4, p1}, Lcom/google/android/gms/internal/play_billing/zzm;->zza(ILjava/lang/String;Ljava/lang/String;)I

    move-result v3

    const-string v2, ""

    :goto_57
    invoke-static {v3, v2}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    if-nez v3, :cond_66

    const-string v3, "Successfully consumed purchase."

    invoke-static {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    :goto_62
    invoke-interface {p2, v2, p1}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    goto :goto_9c

    :cond_66
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error consuming purchase with token. Response code: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v3, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v4, 0x17

    invoke-static {v4, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V
    :try_end_85
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_85} :catch_86

    goto :goto_62

    :catch_86
    move-exception v2

    const-string v3, "Error consuming purchase!"

    invoke-static {v0, v3, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x1d

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v1, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v3, p1}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    :goto_9c
    const/4 p1, 0x0

    return-object p1
.end method

.method final synthetic zzm(Landroid/os/Bundle;Lcom/android/billingclient/api/BillingConfigResponseListener;)Ljava/lang/Object;
    .registers 12

    const-string v0, "BillingClient"

    const/16 v1, 0xd

    const/16 v2, 0x3e

    const/4 v3, 0x0

    :try_start_7
    iget-object v4, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v5, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    const/16 v6, 0x12

    new-instance v7, Lcom/android/billingclient/api/zzau;

    iget-object v8, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-direct {v7, p2, v8, v3}, Lcom/android/billingclient/api/zzau;-><init>(Lcom/android/billingclient/api/BillingConfigResponseListener;Lcom/android/billingclient/api/zzbi;Lcom/android/billingclient/api/zzat;)V

    invoke-interface {v4, v6, v5, p1, v7}, Lcom/google/android/gms/internal/play_billing/zzm;->zzo(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzh;)V
    :try_end_1b
    .catch Landroid/os/DeadObjectException; {:try_start_7 .. :try_end_1b} :catch_27
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_1b} :catch_1c

    goto :goto_3b

    :catch_1c
    move-exception p1

    const-string v4, "getBillingConfig got an exception."

    invoke-static {v0, v4, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v0, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    goto :goto_31

    :catch_27
    move-exception p1

    const-string v4, "getBillingConfig got a dead object exception (try to reconnect)."

    invoke-static {v0, v4, p1}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    sget-object v0, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    :goto_31
    invoke-static {v2, v1, v0}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p2, v0, v3}, Lcom/android/billingclient/api/BillingConfigResponseListener;->onBillingConfigResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/BillingConfig;)V

    :goto_3b
    return-object v3
.end method

.method final synthetic zzn(Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/android/billingclient/api/ProductDetailsResponseListener;)Ljava/lang/Object;
    .registers 30

    move-object/from16 v1, p0

    const-string v2, "BillingClient"

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual/range {p1 .. p1}, Lcom/android/billingclient/api/QueryProductDetailsParams;->zzb()Ljava/lang/String;

    move-result-object v0

    invoke-virtual/range {p1 .. p1}, Lcom/android/billingclient/api/QueryProductDetailsParams;->zza()Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object v10

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v11

    const/4 v4, 0x0

    :goto_16
    const-string v13, "Error trying to decode SkuDetails."

    const-string v15, "Item is unavailable for purchase."

    const/4 v8, 0x0

    if-ge v4, v11, :cond_1f4

    add-int/lit8 v7, v4, 0x14

    if-le v7, v11, :cond_23

    move v5, v11

    goto :goto_24

    :cond_23
    move v5, v7

    :goto_24
    new-instance v6, Ljava/util/ArrayList;

    invoke-interface {v10, v4, v5}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v4

    invoke-direct {v6, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v5

    const/4 v9, 0x0

    :goto_37
    if-ge v9, v5, :cond_49

    invoke-interface {v6, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;

    invoke-virtual/range {v16 .. v16}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;->zza()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v4, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v9, v9, 0x1

    goto :goto_37

    :cond_49
    new-instance v9, Landroid/os/Bundle;

    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    const-string v5, "ITEM_ID_LIST"

    invoke-virtual {v9, v5, v4}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    iget-object v4, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    const-string v5, "playBillingLibraryVersion"

    invoke-virtual {v9, v5, v4}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_5a
    iget-object v4, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-boolean v14, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzw:Z

    const/4 v12, 0x1

    if-eq v12, v14, :cond_64

    const/16 v14, 0x11

    goto :goto_66

    :cond_64
    const/16 v14, 0x14

    :goto_66
    iget-object v12, v1, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v12}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v12

    move/from16 v18, v7

    iget-object v7, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v19
    :try_end_74
    .catch Ljava/lang/Exception; {:try_start_5a .. :try_end_74} :catch_1db

    if-eqz v19, :cond_7b

    :try_start_76
    iget-object v8, v1, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    :cond_7b
    new-instance v8, Landroid/os/Bundle;

    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v8, v5, v7}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "enablePendingPurchases"

    const/4 v7, 0x1

    invoke-virtual {v8, v5, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string v5, "SKU_DETAILS_RESPONSE_FORMAT"

    const-string v7, "PRODUCT_DETAILS"

    invoke-virtual {v8, v5, v7}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v20, v10

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v10

    move/from16 v22, v11

    const/4 v11, 0x0

    const/16 v21, 0x0

    const/16 v23, 0x0

    :goto_a7
    if-ge v11, v10, :cond_e2

    invoke-interface {v6, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;
    :try_end_af
    .catch Ljava/lang/Exception; {:try_start_76 .. :try_end_af} :catch_1d8

    move-object/from16 v25, v6

    const/4 v6, 0x0

    :try_start_b2
    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v26
    :try_end_b9
    .catch Ljava/lang/Exception; {:try_start_b2 .. :try_end_b9} :catch_de

    const/4 v6, 0x1

    xor-int/lit8 v17, v26, 0x1

    or-int v23, v23, v17

    :try_start_be
    invoke-virtual/range {v24 .. v24}, Lcom/android/billingclient/api/QueryProductDetailsParams$Product;->zzb()Ljava/lang/String;

    move-result-object v6

    move/from16 v24, v10

    const-string v10, "first_party"

    invoke-virtual {v6, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_d7

    const-string v6, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products."
    :try_end_ce
    .catch Ljava/lang/Exception; {:try_start_be .. :try_end_ce} :catch_1d8

    const/4 v10, 0x0

    :try_start_cf
    invoke-static {v10, v6}, Lcom/google/android/gms/internal/play_billing/zzx;->zzc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v7, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_d5
    .catch Ljava/lang/Exception; {:try_start_cf .. :try_end_d5} :catch_103

    const/16 v21, 0x1

    :cond_d7
    add-int/lit8 v11, v11, 0x1

    move/from16 v10, v24

    move-object/from16 v6, v25

    goto :goto_a7

    :catch_de
    move-exception v0

    move-object v12, v6

    goto/16 :goto_1dd

    :cond_e2
    if-eqz v23, :cond_e9

    :try_start_e4
    const-string v6, "SKU_OFFER_ID_TOKEN_LIST"

    invoke-virtual {v8, v6, v5}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_e9
    invoke-virtual {v7}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_f4

    const-string v5, "SKU_SERIALIZED_DOCID_LIST"

    invoke-virtual {v8, v5, v7}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_f4
    .catch Ljava/lang/Exception; {:try_start_e4 .. :try_end_f4} :catch_1d8

    :cond_f4
    if-eqz v21, :cond_107

    const/4 v10, 0x0

    :try_start_f7
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_108

    const-string v5, "accountName"

    invoke-virtual {v8, v5, v10}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_102
    .catch Ljava/lang/Exception; {:try_start_f7 .. :try_end_102} :catch_103

    goto :goto_108

    :catch_103
    move-exception v0

    move-object v12, v10

    goto/16 :goto_1dd

    :cond_107
    const/4 v10, 0x0

    :cond_108
    :goto_108
    move v5, v14

    move-object v6, v12

    move/from16 v11, v18

    move-object v7, v0

    move-object v12, v10

    move-object v10, v8

    move-object v8, v9

    const/4 v14, 0x6

    move-object v9, v10

    :try_start_112
    invoke-interface/range {v4 .. v9}, Lcom/google/android/gms/internal/play_billing/zzm;->zzl(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v4
    :try_end_116
    .catch Ljava/lang/Exception; {:try_start_112 .. :try_end_116} :catch_1d6

    if-nez v4, :cond_12f

    const-string v0, "queryProductDetailsAsync got empty product details response."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x2c

    sget-object v4, Lcom/android/billingclient/api/zzbk;->zzB:Lcom/android/billingclient/api/BillingResult;

    const/4 v5, 0x7

    invoke-static {v2, v5, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    :goto_128
    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    move-object v13, v15

    const/4 v14, 0x4

    goto/16 :goto_1f8

    :cond_12f
    const-string v5, "DETAILS_LIST"

    invoke-virtual {v4, v5}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_17f

    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v0

    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzg(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    if-eqz v0, :cond_168

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "getSkuDetails() failed for queryProductDetailsAsync. Response code: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v4, 0x17

    invoke-static {v0, v13}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v5

    const/4 v6, 0x7

    invoke-static {v4, v6, v5}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v4

    invoke-interface {v2, v4}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    move v14, v0

    goto/16 :goto_1f8

    :cond_168
    const/4 v6, 0x7

    const-string v0, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync."

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x2d

    invoke-static {v14, v13}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v4

    invoke-static {v2, v6, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    :goto_17a
    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    goto/16 :goto_1f8

    :cond_17f
    const/4 v6, 0x7

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v4

    if-nez v4, :cond_196

    const-string v0, "queryProductDetailsAsync got null response list"

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x2e

    sget-object v4, Lcom/android/billingclient/api/zzbk;->zzB:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v6, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    goto :goto_128

    :cond_196
    const/4 v5, 0x0

    :goto_197
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-ge v5, v6, :cond_1cf

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    :try_start_1a3
    new-instance v7, Lcom/android/billingclient/api/ProductDetails;

    invoke-direct {v7, v6}, Lcom/android/billingclient/api/ProductDetails;-><init>(Ljava/lang/String;)V
    :try_end_1a8
    .catch Lorg/json/JSONException; {:try_start_1a3 .. :try_end_1a8} :catch_1bb

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v8, "Got product details: "

    invoke-virtual {v8, v6}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v2, v6}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v5, v5, 0x1

    goto :goto_197

    :catch_1bb
    move-exception v0

    const-string v4, "Got a JSON exception trying to decode ProductDetails. \n Exception: "

    invoke-static {v2, v4, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x2f

    invoke-static {v14, v13}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v4

    const/4 v5, 0x7

    invoke-static {v2, v5, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    goto :goto_17a

    :cond_1cf
    move v4, v11

    move-object/from16 v10, v20

    move/from16 v11, v22

    goto/16 :goto_16

    :catch_1d6
    move-exception v0

    goto :goto_1de

    :catch_1d8
    move-exception v0

    const/4 v12, 0x0

    goto :goto_1dd

    :catch_1db
    move-exception v0

    move-object v12, v8

    :goto_1dd
    const/4 v14, 0x6

    :goto_1de
    const-string v4, "queryProductDetailsAsync got a remote exception (try to reconnect)."

    invoke-static {v2, v4, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x2b

    sget-object v4, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    const/4 v5, 0x7

    invoke-static {v2, v5, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    const-string v13, "An internal error occurred."

    goto :goto_1f8

    :cond_1f4
    move-object v12, v8

    const-string v13, ""

    const/4 v14, 0x0

    :goto_1f8
    invoke-static {v14, v13}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v0

    move-object/from16 v2, p2

    invoke-interface {v2, v0, v3}, Lcom/android/billingclient/api/ProductDetailsResponseListener;->onProductDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-object v12
.end method

.method final synthetic zzo(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/android/billingclient/api/SkuDetailsResponseListener;)Ljava/lang/Object;
    .registers 26

    move-object/from16 v1, p0

    const-string v2, "BillingClient"

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface/range {p2 .. p2}, Ljava/util/List;->size()I

    move-result v3

    const/4 v5, 0x0

    :goto_e
    const-string v6, "Error trying to decode SkuDetails."

    const-string v8, "Item is unavailable for purchase."

    if-ge v5, v3, :cond_14b

    add-int/lit8 v11, v5, 0x14

    if-le v11, v3, :cond_1a

    move v12, v3

    goto :goto_1b

    :cond_1a
    move v12, v11

    :goto_1b
    new-instance v13, Ljava/util/ArrayList;

    move-object/from16 v14, p2

    invoke-interface {v14, v5, v12}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v5

    invoke-direct {v13, v5}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    const-string v12, "ITEM_ID_LIST"

    invoke-virtual {v5, v12, v13}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    iget-object v12, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    const-string v13, "playBillingLibraryVersion"

    invoke-virtual {v5, v13, v12}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v12, 0x8

    :try_start_39
    iget-boolean v15, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzo:Z

    if-eqz v15, :cond_6c

    iget-object v15, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v4, v1, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v17

    iget v4, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzk:I

    iget-object v7, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzb:Ljava/lang/String;

    new-instance v10, Landroid/os/Bundle;

    invoke-direct {v10}, Landroid/os/Bundle;-><init>()V

    const/16 v9, 0x9

    if-lt v4, v9, :cond_55

    invoke-virtual {v10, v13, v7}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_55
    if-lt v4, v9, :cond_5d

    const-string v4, "enablePendingPurchases"

    const/4 v7, 0x1

    invoke-virtual {v10, v4, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    :cond_5d
    const/16 v16, 0xa

    move-object/from16 v18, p1

    move-object/from16 v19, v5

    move-object/from16 v20, v10

    invoke-interface/range {v15 .. v20}, Lcom/google/android/gms/internal/play_billing/zzm;->zzl(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v4

    move-object/from16 v10, p1

    goto :goto_7b

    :cond_6c
    iget-object v4, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    const/4 v7, 0x3

    iget-object v9, v1, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v9

    move-object/from16 v10, p1

    invoke-interface {v4, v7, v9, v10, v5}, Lcom/google/android/gms/internal/play_billing/zzm;->zzk(ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v4
    :try_end_7b
    .catch Ljava/lang/Exception; {:try_start_39 .. :try_end_7b} :catch_133

    :goto_7b
    if-nez v4, :cond_94

    const-string v0, "querySkuDetailsAsync got null sku details list"

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x2c

    :goto_86
    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzB:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v12, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    move-object v6, v8

    const/4 v0, 0x0

    const/4 v4, 0x4

    goto/16 :goto_14e

    :cond_94
    const-string v5, "DETAILS_LIST"

    invoke-virtual {v4, v5}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_e3

    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzb(Landroid/os/Bundle;Ljava/lang/String;)I

    move-result v3

    invoke-static {v4, v2}, Lcom/google/android/gms/internal/play_billing/zzb;->zzg(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    if-eqz v3, :cond_cc

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "getSkuDetails() failed. Response code: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v4, 0x17

    invoke-static {v3, v6}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v5

    invoke-static {v4, v12, v5}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v4

    invoke-interface {v2, v4}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    move v4, v3

    goto/16 :goto_14e

    :cond_cc
    const-string v3, "getSkuDetails() returned a bundle with neither an error nor a detail list."

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v3, 0x2d

    const/4 v4, 0x6

    invoke-static {v4, v6}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v5

    invoke-static {v3, v12, v5}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    :goto_e1
    const/4 v4, 0x6

    goto :goto_14e

    :cond_e3
    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v4

    if-nez v4, :cond_f3

    const-string v0, "querySkuDetailsAsync got null response list"

    invoke-static {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzk(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x2e

    goto :goto_86

    :cond_f3
    const/4 v5, 0x0

    :goto_f4
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge v5, v7, :cond_130

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    :try_start_100
    new-instance v8, Lcom/android/billingclient/api/SkuDetails;

    invoke-direct {v8, v7}, Lcom/android/billingclient/api/SkuDetails;-><init>(Ljava/lang/String;)V
    :try_end_105
    .catch Lorg/json/JSONException; {:try_start_100 .. :try_end_105} :catch_118

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    const-string v9, "Got sku details: "

    invoke-virtual {v9, v7}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v2, v7}, Lcom/google/android/gms/internal/play_billing/zzb;->zzj(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v5, v5, 0x1

    goto :goto_f4

    :catch_118
    move-exception v0

    const-string v3, "Got a JSON exception trying to decode SkuDetails."

    invoke-static {v2, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x2f

    const/4 v3, 0x6

    invoke-static {v3, v6}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v4

    invoke-static {v2, v12, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    const/4 v0, 0x0

    goto :goto_e1

    :cond_130
    move v5, v11

    goto/16 :goto_e

    :catch_133
    move-exception v0

    const-string v3, "querySkuDetailsAsync got a remote exception (try to reconnect)."

    invoke-static {v2, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzb;->zzl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, v1, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x2b

    sget-object v3, Lcom/android/billingclient/api/zzbk;->zzm:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v12, v3}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    const/4 v4, -0x1

    const-string v6, "Service connection is disconnected."

    const/4 v0, 0x0

    goto :goto_14e

    :cond_14b
    const-string v6, ""

    const/4 v4, 0x0

    :goto_14e
    invoke-static {v4, v6}, Lcom/android/billingclient/api/zzbk;->zza(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;

    move-result-object v2

    move-object/from16 v3, p4

    invoke-interface {v3, v2, v0}, Lcom/android/billingclient/api/SkuDetailsResponseListener;->onSkuDetailsResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    const/4 v2, 0x0

    return-object v2
.end method

.method final synthetic zzp(Landroid/os/Bundle;Landroid/app/Activity;Landroid/os/ResultReceiver;)Ljava/lang/Object;
    .registers 8

    iget-object v0, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/android/billingclient/api/zzay;

    new-instance v3, Ljava/lang/ref/WeakReference;

    invoke-direct {v3, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    const/4 p2, 0x0

    invoke-direct {v2, v3, p3, p2}, Lcom/android/billingclient/api/zzay;-><init>(Ljava/lang/ref/WeakReference;Landroid/os/ResultReceiver;Lcom/android/billingclient/api/zzax;)V

    const/16 p3, 0xc

    invoke-interface {v0, p3, v1, p1, v2}, Lcom/google/android/gms/internal/play_billing/zzm;->zzq(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzo;)V

    return-object p2
.end method

.method final synthetic zzq(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;)Ljava/lang/Void;
    .registers 9

    const/4 v0, 0x0

    :try_start_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    const/16 v4, 0x15

    new-instance v5, Lcom/android/billingclient/api/zzaq;

    iget-object v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-direct {v5, p1, v6, v0}, Lcom/android/billingclient/api/zzaq;-><init>(Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;Lcom/android/billingclient/api/zzbi;Lcom/android/billingclient/api/zzap;)V

    invoke-interface {v1, v4, v2, v3, v5}, Lcom/google/android/gms/internal/play_billing/zzm;->zzm(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzd;)V
    :try_end_1a
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1a} :catch_1b

    goto :goto_2d

    :catch_1b
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x46

    const/16 v3, 0xf

    sget-object v4, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v3, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v4, v0}, Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetailsListener;->onAlternativeBillingOnlyTokenResponse(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V

    :goto_2d
    return-object v0
.end method

.method final synthetic zzr(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;)Ljava/lang/Void;
    .registers 9

    const/4 v0, 0x0

    :try_start_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    const/16 v4, 0x15

    new-instance v5, Lcom/android/billingclient/api/zzaw;

    iget-object v6, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-direct {v5, p1, v6, v0}, Lcom/android/billingclient/api/zzaw;-><init>(Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;Lcom/android/billingclient/api/zzbi;Lcom/android/billingclient/api/zzav;)V

    invoke-interface {v1, v4, v2, v3, v5}, Lcom/google/android/gms/internal/play_billing/zzm;->zzp(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzj;)V
    :try_end_1a
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1a} :catch_1b

    goto :goto_2d

    :catch_1b
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 v2, 0x45

    const/16 v3, 0xe

    sget-object v4, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {v2, v3, v4}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p1, v4}, Lcom/android/billingclient/api/AlternativeBillingOnlyAvailabilityListener;->onAlternativeBillingOnlyAvailabilityResponse(Lcom/android/billingclient/api/BillingResult;)V

    :goto_2d
    return-object v0
.end method

.method final synthetic zzs(Landroid/app/Activity;Landroid/os/ResultReceiver;Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;)Ljava/lang/Void;
    .registers 11

    const/4 v0, 0x0

    :try_start_1
    iget-object v1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzg:Lcom/google/android/gms/internal/play_billing/zzm;

    iget-object v2, p0, Lcom/android/billingclient/api/BillingClientImpl;->zze:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    const/16 v4, 0x15

    new-instance v5, Lcom/android/billingclient/api/zzas;

    new-instance v6, Ljava/lang/ref/WeakReference;

    invoke-direct {v6, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    invoke-direct {v5, v6, p2, p1, v0}, Lcom/android/billingclient/api/zzas;-><init>(Ljava/lang/ref/WeakReference;Landroid/os/ResultReceiver;Lcom/android/billingclient/api/zzbi;Lcom/android/billingclient/api/zzar;)V

    invoke-interface {v1, v4, v2, v3, v5}, Lcom/google/android/gms/internal/play_billing/zzm;->zzn(ILjava/lang/String;Landroid/os/Bundle;Lcom/google/android/gms/internal/play_billing/zzf;)V
    :try_end_1f
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1f} :catch_20

    goto :goto_32

    :catch_20
    iget-object p1, p0, Lcom/android/billingclient/api/BillingClientImpl;->zzf:Lcom/android/billingclient/api/zzbi;

    const/16 p2, 0x4a

    const/16 v1, 0x10

    sget-object v2, Lcom/android/billingclient/api/zzbk;->zzj:Lcom/android/billingclient/api/BillingResult;

    invoke-static {p2, v1, v2}, Lcom/android/billingclient/api/zzbh;->zza(IILcom/android/billingclient/api/BillingResult;)Lcom/google/android/gms/internal/play_billing/zzhy;

    move-result-object p2

    invoke-interface {p1, p2}, Lcom/android/billingclient/api/zzbi;->zza(Lcom/google/android/gms/internal/play_billing/zzhy;)V

    invoke-interface {p3, v2}, Lcom/android/billingclient/api/AlternativeBillingOnlyInformationDialogListener;->onAlternativeBillingOnlyInformationDialogResponse(Lcom/android/billingclient/api/BillingResult;)V

    :goto_32
    return-object v0
.end method
