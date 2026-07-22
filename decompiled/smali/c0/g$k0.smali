.class abstract Lc0/g$k0;
.super Lc0/g$l0;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "k0"
.end annotation


# instance fields
.field h:Lc0/g$b;


# direct methods
.method constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lc0/g$l0;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lc0/g$k0;->h:Lc0/g$b;

    return-void
.end method
