.class public final enum Lb2/a$c;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lb2/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "c"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lb2/a$c;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum d:Lb2/a$c;

.field public static final enum f:Lb2/a$c;

.field public static final enum g:Lb2/a$c;

.field public static final enum h:Lb2/a$c;

.field public static final enum i:Lb2/a$c;

.field public static final enum j:Lb2/a$c;

.field public static final enum k:Lb2/a$c;

.field public static final enum l:Lb2/a$c;

.field public static final enum m:Lb2/a$c;

.field public static final enum n:Lb2/a$c;

.field public static final enum o:Lb2/a$c;

.field private static final synthetic p:[Lb2/a$c;


# instance fields
.field final c:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    new-instance v0, Lb2/a$c;

    const-string v1, "ROOT"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->d:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "MUSIC"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->f:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "PODCASTS"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->g:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "RINGTONES"

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->h:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "ALARMS"

    const/4 v2, 0x4

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->i:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "NOTIFICATIONS"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->j:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "PICTURES"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->k:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "MOVIES"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->l:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "DOWNLOADS"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->m:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "DCIM"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->n:Lb2/a$c;

    new-instance v0, Lb2/a$c;

    const-string v1, "DOCUMENTS"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2, v2}, Lb2/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lb2/a$c;->o:Lb2/a$c;

    invoke-static {}, Lb2/a$c;->a()[Lb2/a$c;

    move-result-object v0

    sput-object v0, Lb2/a$c;->p:[Lb2/a$c;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput p3, p0, Lb2/a$c;->c:I

    return-void
.end method

.method private static synthetic a()[Lb2/a$c;
    .registers 3

    const/16 v0, 0xb

    new-array v0, v0, [Lb2/a$c;

    sget-object v1, Lb2/a$c;->d:Lb2/a$c;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->f:Lb2/a$c;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->g:Lb2/a$c;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->h:Lb2/a$c;

    const/4 v2, 0x3

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->i:Lb2/a$c;

    const/4 v2, 0x4

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->j:Lb2/a$c;

    const/4 v2, 0x5

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->k:Lb2/a$c;

    const/4 v2, 0x6

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->l:Lb2/a$c;

    const/4 v2, 0x7

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->m:Lb2/a$c;

    const/16 v2, 0x8

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->n:Lb2/a$c;

    const/16 v2, 0x9

    aput-object v1, v0, v2

    sget-object v1, Lb2/a$c;->o:Lb2/a$c;

    const/16 v2, 0xa

    aput-object v1, v0, v2

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lb2/a$c;
    .registers 2

    const-class v0, Lb2/a$c;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lb2/a$c;

    return-object p0
.end method

.method public static values()[Lb2/a$c;
    .registers 1

    sget-object v0, Lb2/a$c;->p:[Lb2/a$c;

    invoke-virtual {v0}, [Lb2/a$c;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lb2/a$c;

    return-object v0
.end method
