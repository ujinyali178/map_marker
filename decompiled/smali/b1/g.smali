.class public Lb1/g;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Lb1/e;

.field final b:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>(Lb1/e;Ljava/lang/Runnable;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lb1/g;->a:Lb1/e;

    iput-object p2, p0, Lb1/g;->b:Ljava/lang/Runnable;

    return-void
.end method


# virtual methods
.method public a()V
    .registers 2

    iget-object v0, p0, Lb1/g;->b:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    return-void
.end method
