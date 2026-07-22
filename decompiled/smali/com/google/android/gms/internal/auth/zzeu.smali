.class public abstract Lcom/google/android/gms/internal/auth/zzeu;
.super Lcom/google/android/gms/internal/auth/zzev;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/internal/auth/zzfy;


# instance fields
.field protected final zzb:Lcom/google/android/gms/internal/auth/zzeq;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/gms/internal/auth/zzev;-><init>()V

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzeq;->zza()Lcom/google/android/gms/internal/auth/zzeq;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/auth/zzeu;->zzb:Lcom/google/android/gms/internal/auth/zzeq;

    return-void
.end method
