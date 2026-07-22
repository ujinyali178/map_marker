.class Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$1;
.super Ljava/lang/Thread;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->withRunningThread()Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;


# direct methods
.method constructor <init>(Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;Ljava/lang/String;)V
    .registers 3

    iput-object p1, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$1;->this$0:Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;

    invoke-direct {p0, p2}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    :try_start_0
    iget-object v0, p0, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture$1;->this$0:Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;

    # invokes: Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->internalCalc()V
    invoke-static {v0}, Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;->access$000(Lorg/mapsforge/map/layer/hills/LatchedLazyFuture;)V
    :try_end_5
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_5} :catch_8
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_5} :catch_6

    goto :goto_c

    :catch_6
    move-exception v0

    goto :goto_9

    :catch_8
    move-exception v0

    :goto_9
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    :goto_c
    return-void
.end method
