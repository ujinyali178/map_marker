.class abstract Lc0/h$j;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "j"
.end annotation


# instance fields
.field final synthetic a:Lc0/h;


# direct methods
.method private constructor <init>(Lc0/h;)V
    .registers 2

    iput-object p1, p0, Lc0/h$j;->a:Lc0/h;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lc0/h;Lc0/h$a;)V
    .registers 3

    invoke-direct {p0, p1}, Lc0/h$j;-><init>(Lc0/h;)V

    return-void
.end method


# virtual methods
.method public a(Lc0/g$y0;)Z
    .registers 2

    const/4 p1, 0x1

    return p1
.end method

.method public abstract b(Ljava/lang/String;)V
.end method
