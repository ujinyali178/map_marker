.class public final Lcom/google/android/gms/common/moduleinstall/ModuleInstall;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getClient(Landroid/app/Activity;)Lcom/google/android/gms/common/moduleinstall/ModuleInstallClient;
    .registers 2

    new-instance v0, Lcom/google/android/gms/common/moduleinstall/internal/zay;

    invoke-direct {v0, p0}, Lcom/google/android/gms/common/moduleinstall/internal/zay;-><init>(Landroid/app/Activity;)V

    return-object v0
.end method

.method public static getClient(Landroid/content/Context;)Lcom/google/android/gms/common/moduleinstall/ModuleInstallClient;
    .registers 2

    new-instance v0, Lcom/google/android/gms/common/moduleinstall/internal/zay;

    invoke-direct {v0, p0}, Lcom/google/android/gms/common/moduleinstall/internal/zay;-><init>(Landroid/content/Context;)V

    return-object v0
.end method
