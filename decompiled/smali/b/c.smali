.class public Lb/c;
.super Lb/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lb/c$a;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lb/a<",
        "Landroidx/activity/result/f;",
        "Ljava/util/List<",
        "Landroid/net/Uri;",
        ">;>;"
    }
.end annotation


# static fields
.field public static final b:Lb/c$a;


# instance fields
.field private final a:I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lb/c$a;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lb/c$a;-><init>(Lkotlin/jvm/internal/g;)V

    sput-object v0, Lb/c;->b:Lb/c$a;

    return-void
.end method

.method public constructor <init>()V
    .registers 4

    const/4 v0, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lb/c;-><init>(IILkotlin/jvm/internal/g;)V

    return-void
.end method

.method public constructor <init>(I)V
    .registers 3

    invoke-direct {p0}, Lb/a;-><init>()V

    iput p1, p0, Lb/c;->a:I

    const/4 v0, 0x1

    if-le p1, v0, :cond_9

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    if-eqz v0, :cond_d

    return-void

    :cond_d
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "Max items must be higher than 1"

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public synthetic constructor <init>(IILkotlin/jvm/internal/g;)V
    .registers 4

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_a

    sget-object p1, Lb/c;->b:Lb/c$a;

    invoke-virtual {p1}, Lb/c$a;->a()I

    move-result p1

    :cond_a
    invoke-direct {p0, p1}, Lb/c;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic a(Landroid/content/Context;Ljava/lang/Object;)Landroid/content/Intent;
    .registers 3

    check-cast p2, Landroidx/activity/result/f;

    invoke-virtual {p0, p1, p2}, Lb/c;->d(Landroid/content/Context;Landroidx/activity/result/f;)Landroid/content/Intent;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic b(Landroid/content/Context;Ljava/lang/Object;)Lb/a$a;
    .registers 3

    check-cast p2, Landroidx/activity/result/f;

    invoke-virtual {p0, p1, p2}, Lb/c;->e(Landroid/content/Context;Landroidx/activity/result/f;)Lb/a$a;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic c(ILandroid/content/Intent;)Ljava/lang/Object;
    .registers 3

    invoke-virtual {p0, p1, p2}, Lb/c;->f(ILandroid/content/Intent;)Ljava/util/List;

    move-result-object p1

    return-object p1
.end method

.method public d(Landroid/content/Context;Landroidx/activity/result/f;)Landroid/content/Intent;
    .registers 8

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "input"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v0, Lb/d;->a:Lb/d$a;

    invoke-virtual {v0}, Lb/d$a;->f()Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_46

    new-instance p1, Landroid/content/Intent;

    const-string v1, "android.provider.action.PICK_IMAGES"

    invoke-direct {p1, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroidx/activity/result/f;->a()Lb/d$f;

    move-result-object p2

    invoke-virtual {v0, p2}, Lb/d$a;->c(Lb/d$f;)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    iget p2, p0, Lb/c;->a:I

    invoke-static {}, Landroid/provider/MediaStore;->getPickImagesMaxLimit()I

    move-result v0

    if-gt p2, v0, :cond_2e

    goto :goto_2f

    :cond_2e
    const/4 v2, 0x0

    :goto_2f
    if-eqz v2, :cond_3a

    iget p2, p0, Lb/c;->a:I

    const-string v0, "android.provider.extra.PICK_IMAGES_MAX"

    invoke-virtual {p1, v0, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    goto/16 :goto_e2

    :cond_3a
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Max items must be less or equals MediaStore.getPickImagesMaxLimit()"

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_46
    invoke-virtual {v0, p1}, Lb/d$a;->e(Landroid/content/Context;)Z

    move-result v1

    const-string v3, "Required value was null."

    const-string v4, "com.google.android.gms.provider.extra.PICK_IMAGES_MAX"

    if-eqz v1, :cond_84

    invoke-virtual {v0, p1}, Lb/d$a;->b(Landroid/content/Context;)Landroid/content/pm/ResolveInfo;

    move-result-object p1

    if-eqz p1, :cond_7a

    iget-object p1, p1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "androidx.activity.result.contract.action.PICK_IMAGES"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v2, p1, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    iget-object p1, p1, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {v1, v2, p1}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p2}, Landroidx/activity/result/f;->a()Lb/d$f;

    move-result-object p1

    invoke-virtual {v0, p1}, Lb/d$a;->c(Lb/d$f;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    iget p1, p0, Lb/c;->a:I

    invoke-virtual {v1, v4, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    move-object p1, v1

    goto :goto_e2

    :cond_7a
    new-instance p1, Ljava/lang/IllegalStateException;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_84
    invoke-virtual {v0, p1}, Lb/d$a;->d(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_b3

    invoke-virtual {v0, p1}, Lb/d$a;->a(Landroid/content/Context;)Landroid/content/pm/ResolveInfo;

    move-result-object p1

    if-eqz p1, :cond_a9

    iget-object p1, p1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    new-instance p2, Landroid/content/Intent;

    const-string v0, "com.google.android.gms.provider.action.PICK_IMAGES"

    invoke-direct {p2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v0, p1, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v0, v0, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    iget-object p1, p1, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {p2, v0, p1}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    iget p1, p0, Lb/c;->a:I

    invoke-virtual {p2, v4, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    move-object p1, p2

    goto :goto_e2

    :cond_a9
    new-instance p1, Ljava/lang/IllegalStateException;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_b3
    new-instance p1, Landroid/content/Intent;

    const-string v1, "android.intent.action.OPEN_DOCUMENT"

    invoke-direct {p1, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroidx/activity/result/f;->a()Lb/d$f;

    move-result-object p2

    invoke-virtual {v0, p2}, Lb/d$a;->c(Lb/d$f;)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    const-string p2, "android.intent.extra.ALLOW_MULTIPLE"

    invoke-virtual {p1, p2, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    invoke-virtual {p1}, Landroid/content/Intent;->getType()Ljava/lang/String;

    move-result-object p2

    if-nez p2, :cond_e2

    const-string p2, "*/*"

    invoke-virtual {p1, p2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    const-string p2, "image/*"

    const-string v0, "video/*"

    filled-new-array {p2, v0}, [Ljava/lang/String;

    move-result-object p2

    const-string v0, "android.intent.extra.MIME_TYPES"

    invoke-virtual {p1, v0, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    :cond_e2
    :goto_e2
    return-object p1
.end method

.method public final e(Landroid/content/Context;Landroidx/activity/result/f;)Lb/a$a;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroidx/activity/result/f;",
            ")",
            "Lb/a$a<",
            "Ljava/util/List<",
            "Landroid/net/Uri;",
            ">;>;"
        }
    .end annotation

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "input"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p1, 0x0

    return-object p1
.end method

.method public final f(ILandroid/content/Intent;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/content/Intent;",
            ")",
            "Ljava/util/List<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation

    const/4 v0, -0x1

    if-ne p1, v0, :cond_5

    const/4 p1, 0x1

    goto :goto_6

    :cond_5
    const/4 p1, 0x0

    :goto_6
    if-eqz p1, :cond_9

    goto :goto_a

    :cond_9
    const/4 p2, 0x0

    :goto_a
    if-eqz p2, :cond_15

    sget-object p1, Lb/b;->a:Lb/b$a;

    invoke-virtual {p1, p2}, Lb/b$a;->a(Landroid/content/Intent;)Ljava/util/List;

    move-result-object p1

    if-eqz p1, :cond_15

    goto :goto_19

    :cond_15
    invoke-static {}, Lh2/l;->d()Ljava/util/List;

    move-result-object p1

    :goto_19
    return-object p1
.end method
