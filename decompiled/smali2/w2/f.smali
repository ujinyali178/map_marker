.class public final Lw2/f;
.super Lw2/x0;
.source "SourceFile"


# instance fields
.field private final k:Ljava/lang/Thread;


# direct methods
.method public constructor <init>(Ljava/lang/Thread;)V
    .registers 2

    invoke-direct {p0}, Lw2/x0;-><init>()V

    iput-object p1, p0, Lw2/f;->k:Ljava/lang/Thread;

    return-void
.end method


# virtual methods
.method protected F()Ljava/lang/Thread;
    .registers 2

    iget-object v0, p0, Lw2/f;->k:Ljava/lang/Thread;

    return-object v0
.end method
