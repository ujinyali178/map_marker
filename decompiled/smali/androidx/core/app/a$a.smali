.class Landroidx/core/app/a$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/core/app/a;->c(Landroid/app/Activity;[Ljava/lang/String;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic c:[Ljava/lang/String;

.field final synthetic d:Landroid/app/Activity;

.field final synthetic f:I


# direct methods
.method constructor <init>([Ljava/lang/String;Landroid/app/Activity;I)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    iput-object p1, p0, Landroidx/core/app/a$a;->c:[Ljava/lang/String;

    iput-object p2, p0, Landroidx/core/app/a$a;->d:Landroid/app/Activity;

    iput p3, p0, Landroidx/core/app/a$a;->f:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 7

    iget-object v0, p0, Landroidx/core/app/a$a;->c:[Ljava/lang/String;

    array-length v0, v0

    new-array v0, v0, [I

    iget-object v1, p0, Landroidx/core/app/a$a;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    iget-object v2, p0, Landroidx/core/app/a$a;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Landroidx/core/app/a$a;->c:[Ljava/lang/String;

    array-length v3, v3

    const/4 v4, 0x0

    :goto_15
    if-ge v4, v3, :cond_24

    iget-object v5, p0, Landroidx/core/app/a$a;->c:[Ljava/lang/String;

    aget-object v5, v5, v4

    invoke-virtual {v1, v5, v2}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v5

    aput v5, v0, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_15

    :cond_24
    iget-object v1, p0, Landroidx/core/app/a$a;->d:Landroid/app/Activity;

    check-cast v1, Landroidx/core/app/a$g;

    iget v2, p0, Landroidx/core/app/a$a;->f:I

    iget-object v3, p0, Landroidx/core/app/a$a;->c:[Ljava/lang/String;

    invoke-interface {v1, v2, v3, v0}, Landroidx/core/app/a$g;->onRequestPermissionsResult(I[Ljava/lang/String;[I)V

    return-void
.end method
