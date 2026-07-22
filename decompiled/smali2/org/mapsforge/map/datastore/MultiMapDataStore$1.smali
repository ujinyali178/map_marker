.class synthetic Lorg/mapsforge/map/datastore/MultiMapDataStore$1;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/datastore/MultiMapDataStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    invoke-static {}, Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;->values()[Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    :try_start_9
    sget-object v1, Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;->RETURN_FIRST:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_12
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_12} :catch_12

    :catch_12
    :try_start_12
    sget-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    sget-object v1, Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;->RETURN_ALL:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_12 .. :try_end_1d} :catch_1d

    :catch_1d
    :try_start_1d
    sget-object v0, Lorg/mapsforge/map/datastore/MultiMapDataStore$1;->$SwitchMap$org$mapsforge$map$datastore$MultiMapDataStore$DataPolicy:[I

    sget-object v1, Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;->DEDUPLICATE:Lorg/mapsforge/map/datastore/MultiMapDataStore$DataPolicy;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_28
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1d .. :try_end_28} :catch_28

    :catch_28
    return-void
.end method
