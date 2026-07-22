.class final Lw2/s1$a;
.super Lw2/r1;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lw2/s1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "a"
.end annotation


# instance fields
.field private final h:Lw2/s1;

.field private final i:Lw2/s1$b;

.field private final j:Lw2/r;

.field private final k:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Lw2/s1;Lw2/s1$b;Lw2/r;Ljava/lang/Object;)V
    .registers 5

    invoke-direct {p0}, Lw2/r1;-><init>()V

    iput-object p1, p0, Lw2/s1$a;->h:Lw2/s1;

    iput-object p2, p0, Lw2/s1$a;->i:Lw2/s1$b;

    iput-object p3, p0, Lw2/s1$a;->j:Lw2/r;

    iput-object p4, p0, Lw2/s1$a;->k:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Lw2/s1$a;->x(Ljava/lang/Throwable;)V

    sget-object p1, Lg2/q;->a:Lg2/q;

    return-object p1
.end method

.method public x(Ljava/lang/Throwable;)V
    .registers 5

    iget-object p1, p0, Lw2/s1$a;->h:Lw2/s1;

    iget-object v0, p0, Lw2/s1$a;->i:Lw2/s1$b;

    iget-object v1, p0, Lw2/s1$a;->j:Lw2/r;

    iget-object v2, p0, Lw2/s1$a;->k:Ljava/lang/Object;

    invoke-static {p1, v0, v1, v2}, Lw2/s1;->z(Lw2/s1;Lw2/s1$b;Lw2/r;Ljava/lang/Object;)V

    return-void
.end method
