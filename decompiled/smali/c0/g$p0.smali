.class abstract Lc0/g$p0;
.super Lc0/g$h0;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "p0"
.end annotation


# instance fields
.field o:Lc0/e;


# direct methods
.method constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lc0/g$h0;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lc0/g$p0;->o:Lc0/e;

    return-void
.end method
