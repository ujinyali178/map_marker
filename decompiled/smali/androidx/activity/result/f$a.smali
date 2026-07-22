.class public final Landroidx/activity/result/f$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/activity/result/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:Lb/d$f;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lb/d$b;->a:Lb/d$b;

    iput-object v0, p0, Landroidx/activity/result/f$a;->a:Lb/d$f;

    return-void
.end method


# virtual methods
.method public final a()Landroidx/activity/result/f;
    .registers 3

    new-instance v0, Landroidx/activity/result/f;

    invoke-direct {v0}, Landroidx/activity/result/f;-><init>()V

    iget-object v1, p0, Landroidx/activity/result/f$a;->a:Lb/d$f;

    invoke-virtual {v0, v1}, Landroidx/activity/result/f;->b(Lb/d$f;)V

    return-object v0
.end method

.method public final b(Lb/d$f;)Landroidx/activity/result/f$a;
    .registers 3

    const-string v0, "mediaType"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Landroidx/activity/result/f$a;->a:Lb/d$f;

    return-object p0
.end method
