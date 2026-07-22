.class final Lcom/google/android/gms/internal/maps/zzay;
.super Lcom/google/android/gms/internal/maps/zzaz;
.source "SourceFile"


# instance fields
.field final transient zza:I

.field final transient zzb:I

.field final synthetic zzc:Lcom/google/android/gms/internal/maps/zzaz;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/maps/zzaz;II)V
    .registers 4

    iput-object p1, p0, Lcom/google/android/gms/internal/maps/zzay;->zzc:Lcom/google/android/gms/internal/maps/zzaz;

    invoke-direct {p0}, Lcom/google/android/gms/internal/maps/zzaz;-><init>()V

    iput p2, p0, Lcom/google/android/gms/internal/maps/zzay;->zza:I

    iput p3, p0, Lcom/google/android/gms/internal/maps/zzay;->zzb:I

    return-void
.end method


# virtual methods
.method public final get(I)Ljava/lang/Object;
    .registers 4

    iget v0, p0, Lcom/google/android/gms/internal/maps/zzay;->zzb:I

    const-string v1, "index"

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/maps/zzas;->zza(IILjava/lang/String;)I

    iget-object v0, p0, Lcom/google/android/gms/internal/maps/zzay;->zzc:Lcom/google/android/gms/internal/maps/zzaz;

    iget v1, p0, Lcom/google/android/gms/internal/maps/zzay;->zza:I

    add-int/2addr p1, v1

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final size()I
    .registers 2

    iget v0, p0, Lcom/google/android/gms/internal/maps/zzay;->zzb:I

    return v0
.end method

.method public final bridge synthetic subList(II)Ljava/util/List;
    .registers 3

    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/maps/zzaz;->zzf(II)Lcom/google/android/gms/internal/maps/zzaz;

    move-result-object p1

    return-object p1
.end method

.method final zzb()I
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/maps/zzay;->zzc:Lcom/google/android/gms/internal/maps/zzaz;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/maps/zzaw;->zzc()I

    move-result v0

    iget v1, p0, Lcom/google/android/gms/internal/maps/zzay;->zza:I

    add-int/2addr v0, v1

    iget v1, p0, Lcom/google/android/gms/internal/maps/zzay;->zzb:I

    add-int/2addr v0, v1

    return v0
.end method

.method final zzc()I
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/maps/zzay;->zzc:Lcom/google/android/gms/internal/maps/zzaz;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/maps/zzaw;->zzc()I

    move-result v0

    iget v1, p0, Lcom/google/android/gms/internal/maps/zzay;->zza:I

    add-int/2addr v0, v1

    return v0
.end method

.method final zze()[Ljava/lang/Object;
    .registers 2
    .annotation runtime Ljavax/annotation/CheckForNull;
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/maps/zzay;->zzc:Lcom/google/android/gms/internal/maps/zzaz;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/maps/zzaw;->zze()[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final zzf(II)Lcom/google/android/gms/internal/maps/zzaz;
    .registers 5

    iget v0, p0, Lcom/google/android/gms/internal/maps/zzay;->zzb:I

    invoke-static {p1, p2, v0}, Lcom/google/android/gms/internal/maps/zzas;->zzc(III)V

    iget v0, p0, Lcom/google/android/gms/internal/maps/zzay;->zza:I

    iget-object v1, p0, Lcom/google/android/gms/internal/maps/zzay;->zzc:Lcom/google/android/gms/internal/maps/zzaz;

    add-int/2addr p1, v0

    add-int/2addr p2, v0

    invoke-virtual {v1, p1, p2}, Lcom/google/android/gms/internal/maps/zzaz;->zzf(II)Lcom/google/android/gms/internal/maps/zzaz;

    move-result-object p1

    return-object p1
.end method
