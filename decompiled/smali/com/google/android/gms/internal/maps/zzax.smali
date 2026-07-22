.class final Lcom/google/android/gms/internal/maps/zzax;
.super Lcom/google/android/gms/internal/maps/zzau;
.source "SourceFile"


# instance fields
.field private final zza:Lcom/google/android/gms/internal/maps/zzaz;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/maps/zzaz;I)V
    .registers 4

    invoke-virtual {p1}, Ljava/util/AbstractCollection;->size()I

    move-result v0

    invoke-direct {p0, v0, p2}, Lcom/google/android/gms/internal/maps/zzau;-><init>(II)V

    iput-object p1, p0, Lcom/google/android/gms/internal/maps/zzax;->zza:Lcom/google/android/gms/internal/maps/zzaz;

    return-void
.end method


# virtual methods
.method protected final zza(I)Ljava/lang/Object;
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/maps/zzax;->zza:Lcom/google/android/gms/internal/maps/zzaz;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
