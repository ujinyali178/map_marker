.class Lc0/g$c;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "c"
.end annotation


# instance fields
.field a:Lc0/g$p;

.field b:Lc0/g$p;

.field c:Lc0/g$p;

.field d:Lc0/g$p;


# direct methods
.method constructor <init>(Lc0/g$p;Lc0/g$p;Lc0/g$p;Lc0/g$p;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lc0/g$c;->a:Lc0/g$p;

    iput-object p2, p0, Lc0/g$c;->b:Lc0/g$p;

    iput-object p3, p0, Lc0/g$c;->c:Lc0/g$p;

    iput-object p4, p0, Lc0/g$c;->d:Lc0/g$p;

    return-void
.end method
