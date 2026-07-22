.class Lc0/g$f0;
.super Lc0/g$r0;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "f0"
.end annotation


# instance fields
.field q:Lc0/g$p;

.field r:Lc0/g$p;

.field s:Lc0/g$p;

.field t:Lc0/g$p;

.field public u:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$r0;-><init>()V

    return-void
.end method


# virtual methods
.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "svg"

    return-object v0
.end method
