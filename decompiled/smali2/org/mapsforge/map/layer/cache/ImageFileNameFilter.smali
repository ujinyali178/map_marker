.class final Lorg/mapsforge/map/layer/cache/ImageFileNameFilter;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/FilenameFilter;


# static fields
.field static final INSTANCE:Ljava/io/FilenameFilter;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lorg/mapsforge/map/layer/cache/ImageFileNameFilter;

    invoke-direct {v0}, Lorg/mapsforge/map/layer/cache/ImageFileNameFilter;-><init>()V

    sput-object v0, Lorg/mapsforge/map/layer/cache/ImageFileNameFilter;->INSTANCE:Ljava/io/FilenameFilter;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public accept(Ljava/io/File;Ljava/lang/String;)Z
    .registers 3

    const-string p1, ".tile"

    invoke-virtual {p2, p1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result p1

    return p1
.end method
