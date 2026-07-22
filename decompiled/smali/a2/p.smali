.class public final synthetic La2/p;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/b$d;


# instance fields
.field public final synthetic a:La2/e$b;


# direct methods
.method public synthetic constructor <init>(La2/e$b;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, La2/p;->a:La2/e$b;

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    iget-object v0, p0, La2/p;->a:La2/e$b;

    invoke-static {v0, p1, p2}, La2/t;->h(La2/e$b;Ljava/lang/Object;Lu1/b$e;)V

    return-void
.end method
