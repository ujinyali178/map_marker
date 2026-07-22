.class Lc0/k$d;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "d"
.end annotation


# static fields
.field private static final a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lc0/g$p;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 4

    new-instance v0, Ljava/util/HashMap;

    const/16 v1, 0x9

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    sput-object v0, Lc0/k$d;->a:Ljava/util/Map;

    new-instance v1, Lc0/g$p;

    sget-object v2, Lc0/g$d1;->j:Lc0/g$d1;

    const v3, 0x3f31a9fc    # 0.694f

    invoke-direct {v1, v3, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    const-string v3, "xx-small"

    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lc0/g$p;

    const v3, 0x3f553f7d    # 0.833f

    invoke-direct {v1, v3, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    const-string v3, "x-small"

    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lc0/g$p;

    const/high16 v3, 0x41200000    # 10.0f

    invoke-direct {v1, v3, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    const-string v3, "small"

    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lc0/g$p;

    const/high16 v3, 0x41400000    # 12.0f

    invoke-direct {v1, v3, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    const-string v3, "medium"

    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lc0/g$p;

    const v3, 0x41666666    # 14.4f

    invoke-direct {v1, v3, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    const-string v3, "large"

    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lc0/g$p;

    const v3, 0x418a6666    # 17.3f

    invoke-direct {v1, v3, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    const-string v3, "x-large"

    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lc0/g$p;

    const v3, 0x41a5999a    # 20.7f

    invoke-direct {v1, v3, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    const-string v2, "xx-large"

    invoke-interface {v0, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lc0/g$p;

    sget-object v2, Lc0/g$d1;->l:Lc0/g$d1;

    const v3, 0x42a6a8f6    # 83.33f

    invoke-direct {v1, v3, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    const-string v3, "smaller"

    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lc0/g$p;

    const/high16 v3, 0x42f00000    # 120.0f

    invoke-direct {v1, v3, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    const-string v2, "larger"

    invoke-interface {v0, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method static a(Ljava/lang/String;)Lc0/g$p;
    .registers 2

    sget-object v0, Lc0/k$d;->a:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lc0/g$p;

    return-object p0
.end method
