.class public final synthetic La2/w;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/b$e;


# instance fields
.field public final synthetic a:La2/e$b0;


# direct methods
.method public synthetic constructor <init>(La2/e$b0;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La2/w;->a:La2/e$b0;

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/Object;)V
    .registers 3

    iget-object v0, p0, La2/w;->a:La2/e$b0;

    invoke-static {v0, p1}, La2/e$d;->b(La2/e$b0;Ljava/lang/Object;)V

    return-void
.end method
