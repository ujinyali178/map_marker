.class La2/g0$a$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements La2/e$b0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La2/g0$a;->onBillingServiceDisconnected()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:La2/g0$a;


# direct methods
.method constructor <init>(La2/g0$a;)V
    .registers 2

    iput-object p1, p0, La2/g0$a$a;->a:La2/g0$a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .registers 1

    return-void
.end method

.method public b(Ljava/lang/Throwable;)V
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "onBillingServiceDisconnected handler error: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "IN_APP_PURCHASE"

    invoke-static {v0, p1}, Lg1/b;->b(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
