.class La2/e$e;
.super Lu1/o;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "e"
.end annotation


# static fields
.field public static final d:La2/e$e;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, La2/e$e;

    invoke-direct {v0}, La2/e$e;-><init>()V

    sput-object v0, La2/e$e;->d:La2/e$e;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lu1/o;-><init>()V

    return-void
.end method


# virtual methods
.method protected g(BLjava/nio/ByteBuffer;)Ljava/lang/Object;
    .registers 3

    packed-switch p1, :pswitch_data_4a

    invoke-super {p0, p1, p2}, Lu1/o;->g(BLjava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :pswitch_8
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$z;->a(Ljava/util/ArrayList;)La2/e$z;

    move-result-object p1

    return-object p1

    :pswitch_13
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$y;->a(Ljava/util/ArrayList;)La2/e$y;

    move-result-object p1

    return-object p1

    :pswitch_1e
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$u;->a(Ljava/util/ArrayList;)La2/e$u;

    move-result-object p1

    return-object p1

    :pswitch_29
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$q;->a(Ljava/util/ArrayList;)La2/e$q;

    move-result-object p1

    return-object p1

    :pswitch_34
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$k;->a(Ljava/util/ArrayList;)La2/e$k;

    move-result-object p1

    return-object p1

    :pswitch_3f
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$f;->a(Ljava/util/ArrayList;)La2/e$f;

    move-result-object p1

    return-object p1

    :pswitch_data_4a
    .packed-switch -0x80
        :pswitch_3f
        :pswitch_34
        :pswitch_29
        :pswitch_1e
        :pswitch_13
        :pswitch_8
    .end packed-switch
.end method

.method protected p(Ljava/io/ByteArrayOutputStream;Ljava/lang/Object;)V
    .registers 4

    instance-of v0, p2, La2/e$f;

    if-eqz v0, :cond_13

    const/16 v0, 0x80

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$f;

    invoke-virtual {p2}, La2/e$f;->d()Ljava/util/ArrayList;

    move-result-object p2

    :goto_f
    invoke-virtual {p0, p1, p2}, La2/e$e;->p(Ljava/io/ByteArrayOutputStream;Ljava/lang/Object;)V

    goto :goto_69

    :cond_13
    instance-of v0, p2, La2/e$k;

    if-eqz v0, :cond_23

    const/16 v0, 0x81

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$k;

    invoke-virtual {p2}, La2/e$k;->d()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_23
    instance-of v0, p2, La2/e$q;

    if-eqz v0, :cond_33

    const/16 v0, 0x82

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$q;

    invoke-virtual {p2}, La2/e$q;->o()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_33
    instance-of v0, p2, La2/e$u;

    if-eqz v0, :cond_43

    const/16 v0, 0x83

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$u;

    invoke-virtual {p2}, La2/e$u;->d()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_43
    instance-of v0, p2, La2/e$y;

    if-eqz v0, :cond_53

    const/16 v0, 0x84

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$y;

    invoke-virtual {p2}, La2/e$y;->e()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_53
    instance-of v0, p2, La2/e$z;

    if-eqz v0, :cond_66

    const/16 v0, 0x85

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$z;

    invoke-virtual {p2}, La2/e$z;->e()Ljava/util/ArrayList;

    move-result-object p2

    :try_start_62
    invoke-virtual {p0, p1, p2}, La2/e$e;->p(Ljava/io/ByteArrayOutputStream;Ljava/lang/Object;)V
    :try_end_65
    .catchall {:try_start_62 .. :try_end_65} :catchall_6a

    goto :goto_69

    :cond_66
    invoke-super {p0, p1, p2}, Lu1/o;->p(Ljava/io/ByteArrayOutputStream;Ljava/lang/Object;)V

    :goto_69
    return-void

    :catchall_6a
    move-exception p1

    throw p1
.end method
