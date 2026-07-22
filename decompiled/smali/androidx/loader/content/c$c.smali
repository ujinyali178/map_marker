.class Landroidx/loader/content/c$c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/loader/content/c;->i(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic c:Ljava/lang/Object;

.field final synthetic d:Landroidx/loader/content/c;


# direct methods
.method constructor <init>(Landroidx/loader/content/c;Ljava/lang/Object;)V
    .registers 3

    iput-object p1, p0, Landroidx/loader/content/c$c;->d:Landroidx/loader/content/c;

    iput-object p2, p0, Landroidx/loader/content/c$c;->c:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    iget-object v0, p0, Landroidx/loader/content/c$c;->d:Landroidx/loader/content/c;

    iget-object v1, p0, Landroidx/loader/content/c$c;->c:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Landroidx/loader/content/c;->d(Ljava/lang/Object;)V

    return-void
.end method
