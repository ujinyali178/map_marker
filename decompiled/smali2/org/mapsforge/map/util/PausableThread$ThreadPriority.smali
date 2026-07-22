.class public final enum Lorg/mapsforge/map/util/PausableThread$ThreadPriority;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/util/PausableThread;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "ThreadPriority"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/map/util/PausableThread$ThreadPriority;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

.field public static final enum ABOVE_NORMAL:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

.field public static final enum BELOW_NORMAL:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

.field public static final enum HIGHEST:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

.field public static final enum LOWEST:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

.field public static final enum NORMAL:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;


# instance fields
.field final priority:I


# direct methods
.method static constructor <clinit>()V
    .registers 12

    new-instance v0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    const-string v1, "ABOVE_NORMAL"

    const/4 v2, 0x0

    const/4 v3, 0x7

    invoke-direct {v0, v1, v2, v3}, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->ABOVE_NORMAL:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    new-instance v1, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    const-string v3, "BELOW_NORMAL"

    const/4 v4, 0x1

    const/4 v5, 0x3

    invoke-direct {v1, v3, v4, v5}, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;-><init>(Ljava/lang/String;II)V

    sput-object v1, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->BELOW_NORMAL:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    new-instance v3, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    const-string v6, "HIGHEST"

    const/4 v7, 0x2

    const/16 v8, 0xa

    invoke-direct {v3, v6, v7, v8}, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;-><init>(Ljava/lang/String;II)V

    sput-object v3, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->HIGHEST:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    new-instance v6, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    const-string v8, "LOWEST"

    invoke-direct {v6, v8, v5, v4}, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;-><init>(Ljava/lang/String;II)V

    sput-object v6, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->LOWEST:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    new-instance v8, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    const-string v9, "NORMAL"

    const/4 v10, 0x4

    const/4 v11, 0x5

    invoke-direct {v8, v9, v10, v11}, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;-><init>(Ljava/lang/String;II)V

    sput-object v8, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->NORMAL:Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    new-array v9, v11, [Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    aput-object v0, v9, v2

    aput-object v1, v9, v4

    aput-object v3, v9, v7

    aput-object v6, v9, v5

    aput-object v8, v9, v10

    sput-object v9, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->$VALUES:[Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    const/4 p1, 0x1

    if-lt p3, p1, :cond_d

    const/16 p1, 0xa

    if-gt p3, p1, :cond_d

    iput p3, p0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->priority:I

    return-void

    :cond_d
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "invalid priority: "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/map/util/PausableThread$ThreadPriority;
    .registers 2

    const-class v0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/map/util/PausableThread$ThreadPriority;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->$VALUES:[Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    invoke-virtual {v0}, [Lorg/mapsforge/map/util/PausableThread$ThreadPriority;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/map/util/PausableThread$ThreadPriority;

    return-object v0
.end method
