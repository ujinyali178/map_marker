.class public final synthetic Landroidx/core/location/g;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic c:Landroidx/core/location/c$d;

.field public final synthetic d:Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(Landroidx/core/location/c$d;Ljava/lang/String;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/core/location/g;->c:Landroidx/core/location/c$d;

    iput-object p2, p0, Landroidx/core/location/g;->d:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 3

    iget-object v0, p0, Landroidx/core/location/g;->c:Landroidx/core/location/c$d;

    iget-object v1, p0, Landroidx/core/location/g;->d:Ljava/lang/String;

    invoke-static {v0, v1}, Landroidx/core/location/c$d;->a(Landroidx/core/location/c$d;Ljava/lang/String;)V

    return-void
.end method
