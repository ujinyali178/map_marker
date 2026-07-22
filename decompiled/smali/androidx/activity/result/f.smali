.class public final Landroidx/activity/result/f;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/activity/result/f$a;
    }
.end annotation


# instance fields
.field private a:Lb/d$f;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lb/d$b;->a:Lb/d$b;

    iput-object v0, p0, Landroidx/activity/result/f;->a:Lb/d$f;

    return-void
.end method


# virtual methods
.method public final a()Lb/d$f;
    .registers 2

    iget-object v0, p0, Landroidx/activity/result/f;->a:Lb/d$f;

    return-object v0
.end method

.method public final b(Lb/d$f;)V
    .registers 3

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Landroidx/activity/result/f;->a:Lb/d$f;

    return-void
.end method
