.class public final Landroidx/activity/result/e$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/activity/result/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private final a:Landroid/content/IntentSender;

.field private b:Landroid/content/Intent;

.field private c:I

.field private d:I


# direct methods
.method public constructor <init>(Landroid/app/PendingIntent;)V
    .registers 3

    const-string v0, "pendingIntent"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/app/PendingIntent;->getIntentSender()Landroid/content/IntentSender;

    move-result-object p1

    const-string v0, "pendingIntent.intentSender"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, p1}, Landroidx/activity/result/e$a;-><init>(Landroid/content/IntentSender;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/IntentSender;)V
    .registers 3

    const-string v0, "intentSender"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/activity/result/e$a;->a:Landroid/content/IntentSender;

    return-void
.end method


# virtual methods
.method public final a()Landroidx/activity/result/e;
    .registers 6

    new-instance v0, Landroidx/activity/result/e;

    iget-object v1, p0, Landroidx/activity/result/e$a;->a:Landroid/content/IntentSender;

    iget-object v2, p0, Landroidx/activity/result/e$a;->b:Landroid/content/Intent;

    iget v3, p0, Landroidx/activity/result/e$a;->c:I

    iget v4, p0, Landroidx/activity/result/e$a;->d:I

    invoke-direct {v0, v1, v2, v3, v4}, Landroidx/activity/result/e;-><init>(Landroid/content/IntentSender;Landroid/content/Intent;II)V

    return-object v0
.end method

.method public final b(Landroid/content/Intent;)Landroidx/activity/result/e$a;
    .registers 2

    iput-object p1, p0, Landroidx/activity/result/e$a;->b:Landroid/content/Intent;

    return-object p0
.end method

.method public final c(II)Landroidx/activity/result/e$a;
    .registers 3

    iput p1, p0, Landroidx/activity/result/e$a;->d:I

    iput p2, p0, Landroidx/activity/result/e$a;->c:I

    return-object p0
.end method
