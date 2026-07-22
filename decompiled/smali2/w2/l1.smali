.class public interface abstract Lw2/l1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Li2/g$b;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lw2/l1$b;,
        Lw2/l1$a;
    }
.end annotation


# static fields
.field public static final e:Lw2/l1$b;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget-object v0, Lw2/l1$b;->c:Lw2/l1$b;

    sput-object v0, Lw2/l1;->e:Lw2/l1$b;

    return-void
.end method


# virtual methods
.method public abstract h()Ljava/util/concurrent/CancellationException;
.end method

.method public abstract isActive()Z
.end method

.method public abstract j(ZZLp2/l;)Lw2/u0;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZZ",
            "Lp2/l<",
            "-",
            "Ljava/lang/Throwable;",
            "Lg2/q;",
            ">;)",
            "Lw2/u0;"
        }
    .end annotation
.end method

.method public abstract l(Lw2/s;)Lw2/q;
.end method

.method public abstract start()Z
.end method

.method public abstract t(Ljava/util/concurrent/CancellationException;)V
.end method
