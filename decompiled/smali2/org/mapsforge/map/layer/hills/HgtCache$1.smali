.class Lorg/mapsforge/map/layer/hills/HgtCache$1;
.super Lorg/mapsforge/map/layer/hills/LazyFuture;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/mapsforge/map/layer/hills/HgtCache;-><init>(Ljava/io/File;ZLorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/map/layer/hills/ShadingAlgorithm;II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/mapsforge/map/layer/hills/LazyFuture<",
        "Ljava/util/Map<",
        "Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;",
        "Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lorg/mapsforge/map/layer/hills/HgtCache;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/layer/hills/HgtCache;)V
    .registers 2

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/HgtCache$1;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    invoke-direct {p0}, Lorg/mapsforge/map/layer/hills/LazyFuture;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic calculate()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Lorg/mapsforge/map/layer/hills/HgtCache$1;->calculate()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method protected calculate()Ljava/util/Map;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;",
            "Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v1, "([ns])(\\d{1,2})([ew])(\\d{1,3})\\.hgt"

    const/4 v2, 0x2

    invoke-static {v1, v2}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    iget-object v2, p0, Lorg/mapsforge/map/layer/hills/HgtCache$1;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    iget-object v3, v2, Lorg/mapsforge/map/layer/hills/HgtCache;->demFolder:Ljava/io/File;

    # getter for: Lorg/mapsforge/map/layer/hills/HgtCache;->problems:Ljava/util/List;
    invoke-static {v2}, Lorg/mapsforge/map/layer/hills/HgtCache;->access$000(Lorg/mapsforge/map/layer/hills/HgtCache;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p0, v3, v1, v0, v2}, Lorg/mapsforge/map/layer/hills/HgtCache$1;->crawl(Ljava/io/File;Ljava/util/regex/Matcher;Ljava/util/Map;Ljava/util/List;)V

    return-object v0
.end method

.method crawl(Ljava/io/File;Ljava/util/regex/Matcher;Ljava/util/Map;Ljava/util/List;)V
    .registers 27
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/util/regex/Matcher;",
            "Ljava/util/Map<",
            "Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;",
            "Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;",
            ">;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v3, p4

    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_d9

    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->isFile()Z

    move-result v4

    if-eqz v4, :cond_bf

    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/util/regex/Matcher;->reset(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/regex/Matcher;->matches()Z

    move-result v4

    if-eqz v4, :cond_d9

    const/4 v4, 0x2

    invoke-virtual {v1, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    const/4 v5, 0x4

    invoke-virtual {v1, v5}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    const/4 v6, 0x1

    invoke-virtual {v1, v6}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    const-string v8, "n"

    invoke-virtual {v8, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_46

    goto :goto_47

    :cond_46
    neg-int v4, v4

    :goto_47
    const/4 v7, 0x3

    invoke-virtual {v1, v7}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v7, "e"

    invoke-virtual {v7, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_59

    goto :goto_5a

    :cond_59
    neg-int v5, v5

    :goto_5a
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->length()J

    move-result-wide v7

    const-wide/16 v9, 0x2

    div-long v9, v7, v9

    long-to-double v11, v9

    invoke-static {v11, v12}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v11

    double-to-long v11, v11

    mul-long v11, v11, v11

    cmp-long v1, v11, v9

    if-eqz v1, :cond_8f

    if-eqz v3, :cond_d9

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v13, p1

    invoke-virtual {v1, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " length in shorts ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v9, v10}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v2, ") is not a square number"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_d9

    :cond_8f
    move-object/from16 v13, p1

    new-instance v1, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;

    invoke-direct {v1, v4, v5}, Lorg/mapsforge/map/layer/hills/HgtCache$TileKey;-><init>(II)V

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    if-eqz v3, :cond_a4

    iget-wide v9, v3, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;->size:J

    cmp-long v3, v9, v7

    if-gez v3, :cond_d9

    :cond_a4
    new-instance v3, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;

    iget-object v12, v0, Lorg/mapsforge/map/layer/hills/HgtCache$1;->this$0:Lorg/mapsforge/map/layer/hills/HgtCache;

    add-int/lit8 v7, v4, -0x1

    int-to-double v14, v7

    int-to-double v7, v5

    int-to-double v9, v4

    add-int/2addr v5, v6

    int-to-double v4, v5

    move-object v11, v3

    move-object/from16 v13, p1

    move-wide/from16 v16, v7

    move-wide/from16 v18, v9

    move-wide/from16 v20, v4

    invoke-direct/range {v11 .. v21}, Lorg/mapsforge/map/layer/hills/HgtCache$HgtFileInfo;-><init>(Lorg/mapsforge/map/layer/hills/HgtCache;Ljava/io/File;DDDD)V

    invoke-interface {v2, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_d9

    :cond_bf
    move-object/from16 v13, p1

    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_d9

    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v4

    if-eqz v4, :cond_d9

    array-length v5, v4

    const/4 v6, 0x0

    :goto_cf
    if-ge v6, v5, :cond_d9

    aget-object v7, v4, v6

    invoke-virtual {v0, v7, v1, v2, v3}, Lorg/mapsforge/map/layer/hills/HgtCache$1;->crawl(Ljava/io/File;Ljava/util/regex/Matcher;Ljava/util/Map;Ljava/util/List;)V

    add-int/lit8 v6, v6, 0x1

    goto :goto_cf

    :cond_d9
    :goto_d9
    return-void
.end method
