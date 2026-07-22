.class Lc0/b$l;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lc0/b$g;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "l"
.end annotation


# instance fields
.field private a:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lc0/b$l;->a:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public a(Lc0/b$q;Lc0/g$l0;)Z
    .registers 3

    const/4 p1, 0x0

    return p1
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lc0/b$l;->a:Ljava/lang/String;

    return-object v0
.end method
