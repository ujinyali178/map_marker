.class public final Lw2/f1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lw2/g1;


# instance fields
.field private final c:Lw2/w1;


# direct methods
.method public constructor <init>(Lw2/w1;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lw2/f1;->c:Lw2/w1;

    return-void
.end method


# virtual methods
.method public e()Lw2/w1;
    .registers 2

    iget-object v0, p0, Lw2/f1;->c:Lw2/w1;

    return-object v0
.end method

.method public isActive()Z
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
