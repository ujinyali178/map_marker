.class public final synthetic Landroidx/profileinstaller/h;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic c:Landroidx/profileinstaller/i$c;

.field public final synthetic d:I

.field public final synthetic f:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Landroidx/profileinstaller/i$c;ILjava/lang/Object;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/profileinstaller/h;->c:Landroidx/profileinstaller/i$c;

    iput p2, p0, Landroidx/profileinstaller/h;->d:I

    iput-object p3, p0, Landroidx/profileinstaller/h;->f:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 4

    iget-object v0, p0, Landroidx/profileinstaller/h;->c:Landroidx/profileinstaller/i$c;

    iget v1, p0, Landroidx/profileinstaller/h;->d:I

    iget-object v2, p0, Landroidx/profileinstaller/h;->f:Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Landroidx/profileinstaller/i;->a(Landroidx/profileinstaller/i$c;ILjava/lang/Object;)V

    return-void
.end method
