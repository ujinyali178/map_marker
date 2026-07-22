.class public Lc0/e;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lc0/e$b;,
        Lc0/e$a;
    }
.end annotation


# static fields
.field public static final c:Lc0/e;

.field public static final d:Lc0/e;

.field public static final e:Lc0/e;

.field public static final f:Lc0/e;

.field public static final g:Lc0/e;

.field public static final h:Lc0/e;

.field public static final i:Lc0/e;

.field public static final j:Lc0/e;

.field public static final k:Lc0/e;


# instance fields
.field private a:Lc0/e$a;

.field private b:Lc0/e$b;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    new-instance v0, Lc0/e;

    const/4 v1, 0x0

    invoke-direct {v0, v1, v1}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    sput-object v0, Lc0/e;->c:Lc0/e;

    new-instance v0, Lc0/e;

    sget-object v2, Lc0/e$a;->c:Lc0/e$a;

    invoke-direct {v0, v2, v1}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    sput-object v0, Lc0/e;->d:Lc0/e;

    new-instance v0, Lc0/e;

    sget-object v1, Lc0/e$a;->i:Lc0/e$a;

    sget-object v2, Lc0/e$b;->c:Lc0/e$b;

    invoke-direct {v0, v1, v2}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    sput-object v0, Lc0/e;->e:Lc0/e;

    new-instance v0, Lc0/e;

    sget-object v3, Lc0/e$a;->d:Lc0/e$a;

    invoke-direct {v0, v3, v2}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    sput-object v0, Lc0/e;->f:Lc0/e;

    new-instance v0, Lc0/e;

    sget-object v4, Lc0/e$a;->m:Lc0/e$a;

    invoke-direct {v0, v4, v2}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    sput-object v0, Lc0/e;->g:Lc0/e;

    new-instance v0, Lc0/e;

    sget-object v4, Lc0/e$a;->f:Lc0/e$a;

    invoke-direct {v0, v4, v2}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    sput-object v0, Lc0/e;->h:Lc0/e;

    new-instance v0, Lc0/e;

    sget-object v4, Lc0/e$a;->l:Lc0/e$a;

    invoke-direct {v0, v4, v2}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    sput-object v0, Lc0/e;->i:Lc0/e;

    new-instance v0, Lc0/e;

    sget-object v2, Lc0/e$b;->d:Lc0/e$b;

    invoke-direct {v0, v1, v2}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    sput-object v0, Lc0/e;->j:Lc0/e;

    new-instance v0, Lc0/e;

    invoke-direct {v0, v3, v2}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    sput-object v0, Lc0/e;->k:Lc0/e;

    return-void
.end method

.method constructor <init>(Lc0/e$a;Lc0/e$b;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lc0/e;->a:Lc0/e$a;

    iput-object p2, p0, Lc0/e;->b:Lc0/e$b;

    return-void
.end method


# virtual methods
.method public a()Lc0/e$a;
    .registers 2

    iget-object v0, p0, Lc0/e;->a:Lc0/e$a;

    return-object v0
.end method

.method public b()Lc0/e$b;
    .registers 2

    iget-object v0, p0, Lc0/e;->b:Lc0/e$b;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    const/4 v1, 0x0

    if-nez p1, :cond_8

    return v1

    :cond_8
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_13

    return v1

    :cond_13
    check-cast p1, Lc0/e;

    iget-object v2, p0, Lc0/e;->a:Lc0/e$a;

    iget-object v3, p1, Lc0/e;->a:Lc0/e$a;

    if-ne v2, v3, :cond_22

    iget-object v2, p0, Lc0/e;->b:Lc0/e$b;

    iget-object p1, p1, Lc0/e;->b:Lc0/e$b;

    if-ne v2, p1, :cond_22

    goto :goto_23

    :cond_22
    const/4 v0, 0x0

    :goto_23
    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lc0/e;->a:Lc0/e$a;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lc0/e;->b:Lc0/e$b;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
