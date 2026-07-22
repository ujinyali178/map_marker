.class public final synthetic Lc2/c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/b$d;


# instance fields
.field public final synthetic a:Lc2/a$b;


# direct methods
.method public synthetic constructor <init>(Lc2/a$b;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lc2/c;->a:Lc2/a$b;

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    iget-object v0, p0, Lc2/c;->a:Lc2/a$b;

    invoke-static {v0, p1, p2}, Lc2/j;->c(Lc2/a$b;Ljava/lang/Object;Lu1/b$e;)V

    return-void
.end method
