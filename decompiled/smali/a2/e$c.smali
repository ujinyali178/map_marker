.class La2/e$c;
.super Lu1/o;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "c"
.end annotation


# static fields
.field public static final d:La2/e$c;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, La2/e$c;

    invoke-direct {v0}, La2/e$c;-><init>()V

    sput-object v0, La2/e$c;->d:La2/e$c;

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

    packed-switch p1, :pswitch_data_ae

    invoke-super {p0, p1, p2}, Lu1/o;->g(BLjava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :pswitch_8
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$x;->a(Ljava/util/ArrayList;)La2/e$x;

    move-result-object p1

    return-object p1

    :pswitch_13
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$v;->a(Ljava/util/ArrayList;)La2/e$v;

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

    invoke-static {p1}, La2/e$s;->a(Ljava/util/ArrayList;)La2/e$s;

    move-result-object p1

    return-object p1

    :pswitch_34
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$r;->a(Ljava/util/ArrayList;)La2/e$r;

    move-result-object p1

    return-object p1

    :pswitch_3f
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$q;->a(Ljava/util/ArrayList;)La2/e$q;

    move-result-object p1

    return-object p1

    :pswitch_4a
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$o;->a(Ljava/util/ArrayList;)La2/e$o;

    move-result-object p1

    return-object p1

    :pswitch_55
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$n;->a(Ljava/util/ArrayList;)La2/e$n;

    move-result-object p1

    return-object p1

    :pswitch_60
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$m;->a(Ljava/util/ArrayList;)La2/e$m;

    move-result-object p1

    return-object p1

    :pswitch_6b
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$l;->a(Ljava/util/ArrayList;)La2/e$l;

    move-result-object p1

    return-object p1

    :pswitch_76
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$k;->a(Ljava/util/ArrayList;)La2/e$k;

    move-result-object p1

    return-object p1

    :pswitch_81
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$j;->a(Ljava/util/ArrayList;)La2/e$j;

    move-result-object p1

    return-object p1

    :pswitch_8c
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$i;->a(Ljava/util/ArrayList;)La2/e$i;

    move-result-object p1

    return-object p1

    :pswitch_97
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$g;->a(Ljava/util/ArrayList;)La2/e$g;

    move-result-object p1

    return-object p1

    :pswitch_a2
    invoke-virtual {p0, p2}, Lu1/o;->f(Ljava/nio/ByteBuffer;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    invoke-static {p1}, La2/e$f;->a(Ljava/util/ArrayList;)La2/e$f;

    move-result-object p1

    return-object p1

    nop

    :pswitch_data_ae
    .packed-switch -0x80
        :pswitch_a2
        :pswitch_97
        :pswitch_8c
        :pswitch_81
        :pswitch_76
        :pswitch_6b
        :pswitch_60
        :pswitch_55
        :pswitch_4a
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

    if-eqz v0, :cond_14

    const/16 v0, 0x80

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$f;

    invoke-virtual {p2}, La2/e$f;->d()Ljava/util/ArrayList;

    move-result-object p2

    :goto_f
    invoke-virtual {p0, p1, p2}, La2/e$c;->p(Ljava/io/ByteArrayOutputStream;Ljava/lang/Object;)V

    goto/16 :goto_100

    :cond_14
    instance-of v0, p2, La2/e$g;

    if-eqz v0, :cond_24

    const/16 v0, 0x81

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$g;

    invoke-virtual {p2}, La2/e$g;->d()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_24
    instance-of v0, p2, La2/e$i;

    if-eqz v0, :cond_34

    const/16 v0, 0x82

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$i;

    invoke-virtual {p2}, La2/e$i;->d()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_34
    instance-of v0, p2, La2/e$j;

    if-eqz v0, :cond_44

    const/16 v0, 0x83

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$j;

    invoke-virtual {p2}, La2/e$j;->p()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_44
    instance-of v0, p2, La2/e$k;

    if-eqz v0, :cond_54

    const/16 v0, 0x84

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$k;

    invoke-virtual {p2}, La2/e$k;->d()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_54
    instance-of v0, p2, La2/e$l;

    if-eqz v0, :cond_64

    const/16 v0, 0x85

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$l;

    invoke-virtual {p2}, La2/e$l;->e()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_64
    instance-of v0, p2, La2/e$m;

    if-eqz v0, :cond_74

    const/16 v0, 0x86

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$m;

    invoke-virtual {p2}, La2/e$m;->h()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_74
    instance-of v0, p2, La2/e$n;

    if-eqz v0, :cond_84

    const/16 v0, 0x87

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$n;

    invoke-virtual {p2}, La2/e$n;->i()Ljava/util/ArrayList;

    move-result-object p2

    goto :goto_f

    :cond_84
    instance-of v0, p2, La2/e$o;

    if-eqz v0, :cond_95

    const/16 v0, 0x88

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$o;

    invoke-virtual {p2}, La2/e$o;->d()Ljava/util/ArrayList;

    move-result-object p2

    goto/16 :goto_f

    :cond_95
    instance-of v0, p2, La2/e$q;

    if-eqz v0, :cond_a6

    const/16 v0, 0x89

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$q;

    invoke-virtual {p2}, La2/e$q;->o()Ljava/util/ArrayList;

    move-result-object p2

    goto/16 :goto_f

    :cond_a6
    instance-of v0, p2, La2/e$r;

    if-eqz v0, :cond_b7

    const/16 v0, 0x8a

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$r;

    invoke-virtual {p2}, La2/e$r;->i()Ljava/util/ArrayList;

    move-result-object p2

    goto/16 :goto_f

    :cond_b7
    instance-of v0, p2, La2/e$s;

    if-eqz v0, :cond_c8

    const/16 v0, 0x8b

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$s;

    invoke-virtual {p2}, La2/e$s;->d()Ljava/util/ArrayList;

    move-result-object p2

    goto/16 :goto_f

    :cond_c8
    instance-of v0, p2, La2/e$u;

    if-eqz v0, :cond_d9

    const/16 v0, 0x8c

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$u;

    invoke-virtual {p2}, La2/e$u;->d()Ljava/util/ArrayList;

    move-result-object p2

    goto/16 :goto_f

    :cond_d9
    instance-of v0, p2, La2/e$v;

    if-eqz v0, :cond_ea

    const/16 v0, 0x8d

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$v;

    invoke-virtual {p2}, La2/e$v;->f()Ljava/util/ArrayList;

    move-result-object p2

    goto/16 :goto_f

    :cond_ea
    instance-of v0, p2, La2/e$x;

    if-eqz v0, :cond_fd

    const/16 v0, 0x8e

    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    check-cast p2, La2/e$x;

    invoke-virtual {p2}, La2/e$x;->g()Ljava/util/ArrayList;

    move-result-object p2

    :try_start_f9
    invoke-virtual {p0, p1, p2}, La2/e$c;->p(Ljava/io/ByteArrayOutputStream;Ljava/lang/Object;)V
    :try_end_fc
    .catchall {:try_start_f9 .. :try_end_fc} :catchall_101

    goto :goto_100

    :cond_fd
    invoke-super {p0, p1, p2}, Lu1/o;->p(Ljava/io/ByteArrayOutputStream;Ljava/lang/Object;)V

    :goto_100
    return-void

    :catchall_101
    move-exception p1

    throw p1
.end method
